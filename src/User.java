import java.util.ArrayList;

/**
 * Created by Kenny on 11/5/2015.
 */
public class User {

    public User (String tempU, String tempP) {
        username = tempU;
        password = tempP;
    }

    public void setBio(String bioString){ bio = bioString; }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    public String getBio() { return bio; }

    private String username;    //stored in database
    private String password;    //stored in database
    private String bio;         //stored in database
    private ArrayList<String> messageList;      //reconstructed locally for each login
    private ArrayList<String> privateList;      //reconstructed locally for each login
    private ArrayList<String> subscriptions;    //reconstructed locally for each login
}
