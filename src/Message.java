import java.util.ArrayList;
import java.util.Date;

/**
 * Created by Kenny on 11/5/2015.
 */
public class Message {

    public Message (User a, User tempR, Date tempT, String tempC, int tempP) {
        author = a;
        recipient = tempR;
        timestamp = tempT;
        content = tempC;
        publicSetting = tempP;
    }

    private User author;
    private User recipient;
    private Date timestamp;
    private String content;
    private int publicSetting;
    private ArrayList<String> hashtag;
    private String IDcode;
}
