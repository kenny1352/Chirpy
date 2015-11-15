import java.util.ArrayList;
import java.util.Date;

/**
 * Created by Kenny on 11/5/2015.
 */
public class Message {

    /**
     * Constructs message object, determining # and @ along the way.
     * @param tempA User who wrote the Chirp
     * @param tempC String content of the Chirp
     * @param tempP privacy setting; true is the public setting
     */
    public Message (User tempA, String tempC, Boolean tempP) {
        author = tempA;
        timestamp = new Date();
        content = tempC;
        publicSetting = tempP;

        //pull hashtags from content
        ArrayList<String> hashtag = new ArrayList<>();
        findHashtags(); // see private method below (Hannah's code)

        //pull a single recipient from content
        findrecipient();
    }

    public String toString(){
        String chirpstring = author.getUsername();
        //if (!recipient.equals(" ")) {
        //    chirpstring = chirpstring + " @" + recipient.getUsername();
        //}
        chirpstring = chirpstring + "\n" + content + "\n" + timestamp.toString() + "\n";

        return chirpstring;
    }

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

    private void findrecipient(){
        if(content.contains("@")) {
            int i=content.indexOf("@");
            boolean reading = true;

            while(reading){
                i++;
                if(content.charAt(i)!=' '){
                    recipient=recipient+content.charAt(i);
                }
                else{
                    reading=false;
                }
            }
        }
        else{
            recipient=" ";
        }
    }

    public boolean containsTopic(String topic){
        return hashtag.contains(topic);
    }

    public boolean checkPublicSetting(){
        return publicSetting;
    }

    private User author;
    // only one recipient is permitted;
    // second '@' will be ignored as part of the message
    private String recipient;
    private Date timestamp;
    private String content;
    private Boolean publicSetting;
    private ArrayList<String> hashtag;
    //private String IDcode;
}
