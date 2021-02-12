import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import java.util.*;

/**
 * AddressBook Class - stores BuddyInfo objects
 *
 * @author Eric Cosoreanu -#101041744
 */
@Entity
public class AddressBook {

    @Id
    private Integer id;

    //Initialize address book list
    @OneToMany(cascade = CascadeType.ALL)
    private List<BuddyInfo> addressBook = new ArrayList<>();

//    public static void main(String args[]) {
//        AddressBook addressBook = new AddressBook(); //Create new address book object
//
//        //Add buddies
//        addressBook.addBuddy("Tom", "123-123-1234");
//        addressBook.addBuddy("John", "234-234-2345");
//        addressBook.addBuddy("Adam", "345-345-3456");
//
//        //Print address book
//        addressBook.printAddressBook();
//    }

    //Adds a new buddy info object to the address book list
    public void addBuddy(String name, String number) {
        this.getAddressBook().add(new BuddyInfo(name, number));
    }

    //Returns the size of the address book list
    public int getSize() {
        return getAddressBook().size();
    }

    //Prints the contents of the address book
    public void printAddressBook() {
        for (int i = 0; i < getAddressBook().size(); i++) {
            System.out.println("Buddy Name: " + getAddressBook().get(i).getBuddyName());
            System.out.println("Buddy Number: " + getAddressBook().get(i).getBuddyPhoneNumber());
        }
    }



    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public List<BuddyInfo> getAddressBook() {
        return addressBook;
    }

    public void setAddressBook(List<BuddyInfo> addressBook) {
        this.addressBook = addressBook;
    }
}
