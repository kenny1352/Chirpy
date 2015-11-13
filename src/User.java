import java.util.ArrayList;

/**
 * Created by Kenny on 11/5/2015.
 */
public class User {

    public User (String tempU, String tempP) {
        username = tempU;
        password = tempP;
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    public String getBio() { return bio; }

    private String username;
    private String password;
    private String bio;
    private ArrayList<String> messageList;
    private ArrayList<String> privateList;
    private ArrayList<String> subscriptions;
}
