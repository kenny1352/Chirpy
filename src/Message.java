import java.util.ArrayList;
import java.util.Date;

/**
 * Created by Kenny on 11/5/2015.
 */
public class Message {


    public Message (String tempA, String tempC, String tempR, String tempH, Date tempT, Boolean tempP) {
        author = tempA;
        content = tempC+" ";
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
        hashtag = new ArrayList<>();
        findHashtags();

        //pull a single recipient from content
        findRecipient();
    }

    public String toString(){
        String chirpstring = author;
        if(publicSetting==true){
            chirpstring = chirpstring + " posted on " + timestamp + ":\n" + content + "\n\n";
        }
        else{
            chirpstring = chirpstring + " privately posted on " + timestamp + ":\n" + content + "\n\n";
        }

        return chirpstring;
    }

    //BROKEN
    private void findHashtags() {
        //pull hashtags from content
        //boolean reading=false;String topicstring="";for(int i=0; i<content.length(); i++) {if (reading) {//log this character into memory topicstring=topicstring+content.charAt(i);}if (content.charAt(i)=='#') {topicstring="";reading=true;}if (content.charAt(i)==' ') {reading=false;hashtag.add(topicstring);}}
        if (content.contains("#")) {
            String[] contentArray = content.split(" ");
            for (int i = 0; i < contentArray.length; i++) {
                if (contentArray[i].contains("#")) {
                    hashtag.add(contentArray[i].replace("#", ""));
                }
            }
        } else {
            hashtag.add("");
        }
        //for(int i=0; i<hashtag.size(); i++){
        //    System.out.println(hashtag.get(i));
        //}
    }

    // NOT BROKEN
    private void findRecipient(){
        if(content.contains("@")) {
            recipient = content.split("@")[1].split(" ")[0];
        } else{
            recipient = "";
        }
    }

    /*public boolean containsTopic(String topic){
        return hashtag.contains(topic);
    }*/

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
        String tags = "";
        for (int i = 0; i < hashtag.size(); i++) {
            tags = tags + hashtag.get(i) + " ";
        }
        return tags;
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
