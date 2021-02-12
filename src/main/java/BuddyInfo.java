import javax.persistence.Entity;
import javax.persistence.Id;

/**
 * BuddyInfo class - stores information about each individual buddy
 *
 * @author Eric Cosoreanu - #101041744
 */
@Entity
public class BuddyInfo {

    @Id
    private Integer id;

    private String buddyName;

    private String buddyPhoneNumber;

    public BuddyInfo() {
    }

    public BuddyInfo(String name, String number) {
        this.setBuddyName(name);
        this.setBuddyPhoneNumber(number);
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getBuddyName() {
        return buddyName;
    }

    public void setBuddyName(String buddyName) {
        this.buddyName = buddyName;
    }

    public String getBuddyPhoneNumber() {
        return buddyPhoneNumber;
    }

    public void setBuddyPhoneNumber(String buddyPhoneNumber) {
        this.buddyPhoneNumber = buddyPhoneNumber;
    }
}
