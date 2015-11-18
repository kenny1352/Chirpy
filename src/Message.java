import java.util.ArrayList;
import java.util.Date;

/**
 * Created by Kenny on 11/5/2015.
 */
public class Message {


    public Message (String tempA, String tempC, String tempR, String tempH, Date tempT, Boolean tempP) {
        author = tempA;
        content = tempC;
        recipient = tempR;
        timestamp = tempT;
        publicSetting = tempP;
        hashtag = new ArrayList<>();

        String[] parts = tempH.split("\\s+");
        for (String part : parts) {
            hashtag.add(part);
        }
    }

    /**
     * Constructs message object, determining # and @ along the way.
     * @param tempA User who wrote the Chirp
     * @param tempC String content of the Chirp
     * @param tempP privacy setting; true is the public setting
     */
    public Message (String tempA, String tempC, Boolean tempP) {
        author = tempA;
        timestamp = new Date();
        content = tempC;
        publicSetting = tempP;

        //pull hashtags from content
        ArrayList<String> hashtag = new ArrayList<>();
        //findHashtags(); // see private method below (Hannah's code)

        //pull a single recipient from content
        findRecipient();
    }

    public String toString(){
        String chirpstring = author;
        //if (!recipient.equals(" ")) {
        //    chirpstring = chirpstring + " @" + recipient.getUsername();
        //}
        chirpstring = chirpstring + "\n" + content + "\n" + "\n";

        return chirpstring;
    }

    //BROKEN
    private void findHashtags() {
        //pull hashtags from content
        boolean reading=false;
        String topicstring="";
        for(int i=0; i<content.length(); i++) {
            if (reading) {
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

    //BROKEN
    private void findRecipient(){
        if(content.contains("@")) {
            //int index = content.indexOf("@");boolean reading = true;
            recipient = content.split("@")[1].split(" ")[0];
            //while(reading){i++;if(content.charAt(i)!=' '){recipient=recipient+content.charAt(i);} else{reading=false;}}
        } else{
            recipient = "";
        }
    }

    public boolean containsTopic(String topic){
        return hashtag.contains(topic);
    }

    public boolean checkPublicSetting(){
        return publicSetting;
    }

    public String getAuthor() {
        return author;
    }

    public String getRecipient() {
        return recipient;
    }

    public String getContent() {
        return content;
    }

    public Date getTimestamp() {
        return timestamp;
    }

    public int getPublicSetting() {
        if (publicSetting) {
            return 1;
        }
        else {
            return 0;
        }
    }

    public String getHashtag() {
        return "#test";
    }

    private String author;
    // only one recipient is permitted;
    // second '@' will be ignored as part of the message
    private String recipient;
    private Date timestamp;
    private String content;
    private Boolean publicSetting;
    private ArrayList<String> hashtag;
    //private String IDcode;
}
