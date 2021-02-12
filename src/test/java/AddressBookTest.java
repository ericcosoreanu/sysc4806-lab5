import org.junit.Test;

import javax.persistence.*;
import java.util.List;

import static org.junit.Assert.*;

/**
 * AddressBook Test
 *
 * @author Eric Cosoreanu - #101041744
 */
public class AddressBookTest {

    @Test
    public void testAddressBookNotNull() {
        AddressBook addressBook = new AddressBook();
        addressBook.addBuddy("Jack", "555-555-5555");
        assertNotNull(addressBook);
    }

    @Test
    public void testAddressBookAdd() {
        AddressBook addressBook = new AddressBook();
        assertEquals(addressBook.getSize(), 0);

        addressBook.addBuddy("Tommy", "121-121-1211");
        assertEquals(addressBook.getSize(), 1);
    }

    @Test
    public void testAddressBookPersistence() {
        BuddyInfo buddyInfo = new BuddyInfo();
        buddyInfo.setId(1);
        buddyInfo.setBuddyName("Ben");
        buddyInfo.setBuddyPhoneNumber("234-345-6757");

        AddressBook addressBook = new AddressBook();
        addressBook.setId(1);
        addressBook.getAddressBook().add(buddyInfo);

        EntityManagerFactory emf = Persistence.createEntityManagerFactory("jpa-test");

        EntityManager em = emf.createEntityManager();

        EntityTransaction tx = em.getTransaction();

        tx.begin();

        em.persist(buddyInfo);
        em.persist(addressBook);

        tx.commit();

        Query q = em.createQuery("SELECT x FROM AddressBook x");

        @SuppressWarnings("unchecked")
        List<AddressBook> addressBooks = q.getResultList();

        System.out.println("List of products\n----------------");

        for (AddressBook x : addressBooks) {

            System.out.println(x.getAddressBook() + " (id=" + x.getId() + ")");
            System.out.println(" List: " );
            x.printAddressBook();
        }

        // Closing connection
        em.close();

        emf.close();
    }

}