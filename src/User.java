import javax.swing.*;
import java.sql.*;
import java.util.ArrayList;
import java.util.Date;

/**
 * @author Kenny Campbell, Catherine Merz, Hannah Morgan
 */
public class User {

    /**
     * Constructor for when subscribe list does not matter
     * @param tempU The username
     */
    public User (String tempU) {
        username = tempU;
        subscribedTo = new ArrayList<String>();
        postedChirps = new ArrayList<Message>();
        newsfeed = new ArrayList<Message>();
        receivedChirps = new ArrayList<Message>();
    }

    /**
     * Constructor for when having a subscribe list does matter
     * @param tempU The username
     * @param conn A connection to connect to database and get subscriptions
     */
    public User (String tempU, Connection conn) {
        username = tempU;
        subscribedTo = new ArrayList<String>();
        postedChirps = new ArrayList<Message>();
        newsfeed = new ArrayList<Message>();
        receivedChirps = new ArrayList<Message>();
        try {
            Statement statement = conn.createStatement();
            ResultSet resultSet = statement.executeQuery("SELECT * FROM " + username + "_subscribe");

            while (resultSet.next()) {
                subscribedTo.add(resultSet.getString("users"));
            }
        } catch (SQLException SQLex) {
            handleSQLException(SQLex);
        }
    }

    /**
     * Method to change the bio of the user
     * @param bioString New bio
     */
    public void setBio(String bioString){ bio = bioString; }

    //at the beginning of each login, all the user arrays will be populated with messages stored in database
    //this ALL to be handled with SQL Queries!  Please ignore.

    /**
     * Method to get messages user posted that other user can see
     * @param temp other user
     */
    public void setPostedChirps (User temp) {
        postedChirps.clear();
        for (int i = 0; i < temp.newsfeed.size(); i++) {
            if (temp.newsfeed.get(i).getAuthor().equals(username)) {
                postedChirps.add(temp.newsfeed.get(i));
            }
        }
    }

    /**
     * SQL Query to download all Posted messages
     * @param conn Connection to connect to database
     */
    public void downloadPosted (Connection conn) {
        //search database for all messages with this user as author
        postedChirps.clear();
        try {
            Statement statement = conn.createStatement();
            ResultSet resultSet = statement.executeQuery("SELECT * FROM messages WHERE username LIKE '" + username + "'");

            while (resultSet.next()) {
                String text = resultSet.getString("messageText");
                String recipient = resultSet.getString("recipient");
                String hashtags = resultSet.getString("tags");
                Date time = resultSet.getDate("timeStamp");
                int temp = resultSet.getInt("publicSetting");
                boolean publicSetting = false;
                if (temp == 1) {
                    publicSetting = true;
                }
                Message newMessage = new Message(username, text, recipient, hashtags, time, publicSetting);
                postedChirps.add(newMessage);
            }
        }
        catch (SQLException SQLex) {handleSQLException(SQLex);}
        //convert the message to String
        //add this String to postedChirps
    }

    /**
     * SQL query for download user's newsfeed
     * @param conn Connection to connect to database
     */
    public void downloadNews (Connection conn) {
        //search database for all messages to which this user is subscribed
        //convert the message to String
        //add this String to newsfeed
        newsfeed.clear();
        try {
            Statement statement = conn.createStatement();
            ResultSet resultSet = statement.executeQuery("SELECT * FROM messages");

            while (resultSet.next()) {
                String author = resultSet.getString("username");
                String text = resultSet.getString("messageText");
                String recipient = resultSet.getString("recipient");
                String hashtags = resultSet.getString("tags");
                Date time = resultSet.getDate("timeStamp");
                int temp = resultSet.getInt("publicSetting");
                boolean publicSetting = false;
                if (temp == 1) {
                    publicSetting = true;
                }
                Message newMessage = new Message(author, text, recipient, hashtags, time, publicSetting);
                if (publicSetting || subscribedTo.contains(author) || author.equals(username)) {
                    newsfeed.add(newMessage);
                }
            }
        } catch (SQLException SQLex) {
            handleSQLException(SQLex);
        }
    }

    /**
     * SQL query for getting messages user was tagged in
     * @param conn Connection to connect to database
     */
    public void downloadreceivedChirps(Connection conn) {
        //search database for all messages for which this user is a recipient
        //convert the message to String
        //add this String to newsfeed
        receivedChirps.clear();
        try {
            Statement statement = conn.createStatement();
            ResultSet resultSet = statement.executeQuery("SELECT * FROM messages WHERE recipient LIKE '" + username + "'");

            while (resultSet.next()) {
                String author = resultSet.getString("username");
                String text = resultSet.getString("messageText");
                String hashtags = resultSet.getString("tags");
                Date time = resultSet.getDate("timeStamp");
                int temp = resultSet.getInt("publicSetting");
                boolean publicSetting = false;
                if (temp == 1) {
                    publicSetting = true;
                }
                Message newMessage = new Message(author, text, username, hashtags, time, publicSetting);
                receivedChirps.add(newMessage);
            }
        } catch (SQLException SQLex) {
            handleSQLException(SQLex);
        }
    }

    /**
     * Returns the username
     * @return username
     */
    public String getUsername() {
        return username;
    }

    /**
     * Returns the bio of the user
     * @return bio
     */
    public String getBio() { return bio; }

    /**
     * Returns the newsfeed as a String
     * @return String version of newsfeed
     */
    public String getNewsfeed() {
        return displayChirps(newsfeed);
    }

    /**
     * Returns the posted chirps as a String
     * @return String version of posted chirps
     */
    public String getPostedChirps() {
        return displayChirps(postedChirps);
    }

    /**
     * Returns the received chirps as a String
     * @return String version of received chirps
     */
    public String getReceivedChirps() {
        return displayChirps(receivedChirps);
    }

    /**
     * Returns the subscriptions as a string
     * @return String version of subscriptions
     */
    public String getSubscriptions() {
        String subscripString = "";
        for (int i = 0; i < subscribedTo.size(); i++) {
            subscripString = subscripString + subscribedTo.get(i)+"\n";
        }
        return subscripString;
    }

    /**
     * Converts list of messages into String
     * @param list list to be converted to String
     * @return String version of list
     */
    private String displayChirps(ArrayList<Message> list) {
        String printString = "";
        if (list.size()>0) {
            for (int i = list.size()-1; i > -1; i--) {
                printString += list.get(i).toString();
            }
        }
        return printString;
    }

    /**
     * Adds a new subscription
     * @param newUsername new subscription
     */
    public void newSubscrip(String newUsername) { subscribedTo.add(newUsername); }

    /**
     * Deletes subscription
     * @param xUsername subscription to be deleted
     */
    public void unsubscribe(String xUsername) { subscribedTo.remove(xUsername); }

    /**
     * Sees if user is subscribed to certain user
     * @param aUsername other user
     * @return True/False depending if user is subscribed to other user
     */
    public boolean isSubscribedTo(String aUsername) { return subscribedTo.contains(aUsername); }

    /**
     * Searches newsfeed for certain hashtags
     * @param topic hashtag user is looking for
     * @return String version of all messages with that topic
     */
    public String searchNews(String topic){
        String foundTopicsString = "";
        String hashtagString = "#"+topic+" ";
        String hashtagString2 = "#"+topic+"/n";
        for(int i=newsfeed.size()-1; i>-1; i--){
            if(newsfeed.get(i).getContent().contains(hashtagString) || newsfeed.get(i).getContent().contains(hashtagString2)) {
                foundTopicsString += newsfeed.get(i).toString();
            }
        }
        return foundTopicsString;
    }

    /**
     * Method for displaying SQL error message
     * @param e information about SQL error
     */
    private void handleSQLException(SQLException e) {
        JOptionPane.showMessageDialog(null, "SQLException: " + e.getMessage() + "\nSQLState: " + e.getSQLState() + "\nVendorError: " + e.getErrorCode());
    }

    private String username;    //stored in database
    private String bio;         //stored in database
    private ArrayList<String> subscribedTo;     //this info stored in database, will be
    private ArrayList<Message> postedChirps;     //reconstructed locally for each login
    private ArrayList<Message> newsfeed;         //reconstructed locally for each login
    private ArrayList<Message> receivedChirps;   //reconstructed locally for each login
}
