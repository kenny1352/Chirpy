import java.util.ArrayList;

/**
 * Created by Kenny on 11/5/2015.
 */
public class User {

    public User (String tempU/*, String tempP*/) {
        username = tempU;
        /*password = tempP;*/
    }

    public void setBio(String bioString){ bio = bioString; }

    /*//at the beginning of each login, all the user arrays will be populated with messages stored in database
    //this ALL to be handled with SQL Queries!  Please ignore.
    public void downloadPosted(){
        //search database for all messages with this user as author
        //convert the message to String
        //add this String to postedChirps
    }

    public void downloadNews(){
        //search database for all messages to which this user is subscribed
        //convert the message to String
        //add this String to newsfeed
    }

    public void receivedChirps(){
        //search database for all messages for which this user is a recipient
        //convert the message to String
        //add this String to newsfeed
    }*/

    public String getUsername() {
        return username;
    }

    /*public String getPassword() {
        return password;
    }*/

    public String getBio() { return bio; }

    public void newSubscrip(String newUsername) { subscribedTo.add(newUsername); }
    public boolean isSubscribedTo(String aUsername) { return subscribedTo.contains(aUsername); }

    private String username;    //stored in database
    //private String password;    //stored in database -- not sure how this works
    private String bio;         //stored in database
    private ArrayList<String> subscribedTo;     //this info stored in database, will be
    private ArrayList<String> postedChirps;     //reconstructed locally for each login
    private ArrayList<String> newsfeed;         //reconstructed locally for each login
    private ArrayList<String> receivedChirps;   //reconstructed locally for each login
}
