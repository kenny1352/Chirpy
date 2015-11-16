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
        subscribedTo = new ArrayList<>();
        postedChirps = new ArrayList<>();
        newsfeed = new ArrayList<>();
        receivedChirps = new ArrayList<>();
    }

    public void setBio(String bioString){ bio = bioString; }

    //at the beginning of each login, all the user arrays will be populated with messages stored in database
    //this ALL to be handled with SQL Queries!  Please ignore.

    public void downloadPosted (Connection conn){
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
        catch (SQLException SQLex) {
            System.out.println("SQLException: " + SQLex.getMessage());
            System.out.println("SQLState: " + SQLex.getSQLState());
            System.out.println("VendorError: " + SQLex.getErrorCode());
        }
        //convert the message to String
        //add this String to postedChirps
    }

    public void downloadNews (Connection conn){
        //search database for all messages to which this user is subscribed
        //convert the message to String
        //add this String to newsfeed
    }

    public void receivedChirps(){
        //search database for all messages for which this user is a recipient
        //convert the message to String
        //add this String to newsfeed
    }

    public String getUsername() {
        return username;
    }

    public String getBio() { return bio; }

    public void newSubscrip(String newUsername) { subscribedTo.add(newUsername); }
    public boolean isSubscribedTo(String aUsername) { return subscribedTo.contains(aUsername); }

    private String username;    //stored in database
    private String bio;         //stored in database
    private ArrayList<String> subscribedTo;     //this info stored in database, will be
    private ArrayList<Message> postedChirps;     //reconstructed locally for each login
    private ArrayList<Message> newsfeed;         //reconstructed locally for each login
    private ArrayList<Message> receivedChirps;   //reconstructed locally for each login
}
