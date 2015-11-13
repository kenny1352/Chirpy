import java.util.ArrayList;
import java.util.Date;

/**
 * Created by Kenny on 11/5/2015.
 */
public class Message {

    public Message (User tempA, User tempR, Date tempT, String tempC, int tempP) {
        author = tempA;
        recipient = tempR;
        timestamp = tempT;
        content = tempC;
        publicSetting = tempP;

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

        //also somehow give it IDcode based on database
    }

    public String toString(){
        String chirpstring;
        
        return chirpstring;
    }

    private User author;
    private User recipient;
    private Date timestamp;
    private String content;
    private int publicSetting;
    private ArrayList<String> hashtag;
    private String IDcode;
}
