import java.util.ArrayList;
import java.util.Date;

/**
 * @author Kenny Campbell, Catherine Merz, Hannah Morgan
 * @summary This class stores the data associated with a message such as the author, content, recipient, timestamp, public settings,
 * and hashtags
 */
public class Message {


    /**
     *
     * @param tempA
     * @param tempC
     * @param tempR
     * @param tempH
     * @param tempT
     * @param tempP
     */
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

    /**
     *
     * @return
     */
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

    /**
     *
     */
    private void findHashtags() {
        //pull hashtags from content
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
    }

    /**
     *
     */
    private void findRecipient(){
        if(content.contains("@")) {
            recipient = content.split("@")[1].split(" ")[0];
        } else{
            recipient = "";
        }
    }

    /**
     *
     * @return
     */
    public String getAuthor() {
        return author;
    }

    /**
     *
     * @return
     */
    public String getRecipient() {
        return recipient;
    }

    /**
     *
     * @return
     */
    public String getContent() {
        return content;
    }

    /**
     *
     * @return
     */
    public Date getTimestamp() {
        return timestamp;
    }

    /**
     *
     * @return
     */
    public int getPublicSetting() {
        if (publicSetting) {
            return 1;
        }
        else {
            return 0;
        }
    }

    /**
     *
     * @return
     */
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
}
