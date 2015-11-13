import java.util.ArrayList;
import java.util.Date;

/**
 * Created by Kenny on 11/5/2015.
 */
public class Message {

    public Message (User tempA, User tempR, String tempC, Boolean tempP) {
        author = tempA;
        recipient = tempR;
        timestamp = new Date();
        content = tempC;
        publicSetting = tempP;
    }

    public Message (User tempA, String tempC, Boolean tempP) {
        author = tempA;
        timestamp = new Date();
        content = tempC;
    }

    public String toString() {
        String string = author.getUsername();
        if (recipient.getUsername() != null) {
            string = string + " @" + recipient.getUsername();
        }
        string = string + "\n" ;

        // NOT FINISHED
        return string;
    }

    private String getTimeString() {
        String timeString = "";

        //

        return timeString;
    }

    private User author;
    private User recipient;
    private Date timestamp;
    private String content;
    private Boolean publicSetting;
    private ArrayList<String> hashtag;
    private String IDcode;
}
