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

        //pull hashtags from content
        findHashtags(); // see private method below (Hannah's code)

        //also somehow give it IDcode based on database
    }

    /**
     * Constructs a Message object with no recipient.
     * @param tempA the User who wrote the Chirp
     * @param tempC the String content of the Chirp
     * @param tempP the publicity setting (true==public, false==subscribersOnly)
     */
    public Message (User tempA, String tempC, Boolean tempP) {
        author = tempA;
        timestamp = new Date();
        content = tempC;
        publicSetting = tempP;
        findHashtags();
    }

    public String toString(){
        String chirpstring = "";

        return chirpstring;
    }

    private void findHashtags() {
        //pull hashtags from content
        boolean reading=false;
        String topicstring="";
        for(int i=0; i<content.length(); i++) {
            if (reading==true) {
                //log this character into memory
                topicstring=topicstring+content.charAt(i);
            }
            if (content.charAt(i)=='#') {
                topicstring="";
                reading=true;
            }
            if (content.charAt(i)==' ') {
                reading=false;
                hashtag.add(topicstring);
            }
        }
    }

    private User author;
    private User recipient;
    private Date timestamp;
    private String content;
    private Boolean publicSetting;
    private ArrayList<String> hashtag;
    private String IDcode;
}
