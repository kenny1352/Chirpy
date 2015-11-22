import java.util.ArrayList;
import java.util.Date;

/**
 * @author Kenny Campbell, Catherine Merz, Hannah Morgan
 * @summary This class stores the data associated with a message such as the author, content, recipient, timestamp, public settings,
 * and hashtags
 */
public class Message {


    /**
     * Creates an instance of the Message class.
     * @param tempA String for the author's username
     * @param tempC String for the Chirp content
     * @param tempR String for the recipient's username, if any
     * @param tempH String of hashtags
     * @param tempT Date referring to the time of posting
     * @param tempP Boolean indicating the publicSetting: true for public, false for subscribers only
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
     * Takes information from a Message and produces a String of important details.
     * @return String containing Message details
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
     * Searches Message content for hashtags and adds to an array.
     */
    private void findHashtags() {
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
     * Searches Message content for recipient username indicated by '@', and stores in data member recipient.
     */
    private void findRecipient(){
        if(content.contains("@")) {
            recipient = content.split("@")[1].split(" ")[0];
        } else{
            recipient = "";
        }
    }

    /**
     * Returns the author of the Message.
     * @return String for the username of author
     */
    public String getAuthor() {
        return author;
    }

    /**
     * Returns the recipient of the Message.
     * @return String for the recipient username
     */
    public String getRecipient() {
        return recipient;
    }

    /**
     * Returns the full content of the Message.
     * @return String of the Message content
     */
    public String getContent() {
        return content;
    }

    /**
     * Returns the timestamp of the Message.
     * @return Date of the Message posting time
     */
    public Date getTimestamp() {
        return timestamp;
    }

    /**
     * Returns the public visibility setting of the Message.
     * @return int indicating public if 1 and subscribers only if 0
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
     * Returns a string of all hashtags contained in the hashtag ArrayList.
     * @return String listing hashtags separated by a space
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
