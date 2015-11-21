import javax.swing.*;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Date;

/**
 * Created by Kenny on 11/5/2015.
 */
public class User {

    public User (String tempU) {
        username = tempU;
        subscribedTo = new ArrayList<String>();
        postedChirps = new ArrayList<Message>();
        newsfeed = new ArrayList<Message>();
        receivedChirps = new ArrayList<Message>();
    }

    public void setBio(String bioString){ bio = bioString; }

    //at the beginning of each login, all the user arrays will be populated with messages stored in database
    //this ALL to be handled with SQL Queries!  Please ignore.

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

    public String getUsername() {
        return username;
    }

    public String getBio() { return bio; }

    public String getNewsfeed() {
        return displayChirps(newsfeed);
    }

    public String getPostedChirps() {
        return displayChirps(postedChirps);
    }

    public String getRecievedChirps() {
        return displayChirps(receivedChirps);
    }

    private String displayChirps(ArrayList<Message> list) {
        String printString = "";
        if (list.size()>0) {
            for (int i = list.size()-1; i > -1; i--) {
                printString += list.get(i).toString();
            }
        }
        return printString;
    }

    public void newSubscrip(String newUsername) { subscribedTo.add(newUsername); }
    public void unsubscribe(String xUsername) { subscribedTo.remove(xUsername); }
    public boolean isSubscribedTo(String aUsername) { return subscribedTo.contains(aUsername); }

    public String searchNews(String topic){
        String foundTopicsString = "";
        String hashtagString = "#"+topic+" ";
        for(int i=newsfeed.size()-1; i>-1; i--){
            if(newsfeed.get(i).getContent().contains(hashtagString))
            foundTopicsString += newsfeed.get(i).toString();
        }
        return foundTopicsString;
    }

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
