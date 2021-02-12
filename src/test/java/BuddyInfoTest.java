import org.junit.Test;

import javax.persistence.*;

import java.util.List;

import static org.junit.Assert.*;

/**
 *
 * BuddyInfo Test
 *
 * @author Eric Cosoreanu - #101041744
 */
public class BuddyInfoTest {

    @Test
    public void testBuddyInfoNotNull() {
        BuddyInfo buddyInfo = new BuddyInfo("Tom", "222-222-2222");
        assertNotNull(buddyInfo);
    }

    @Test
    public void testBuddyInfoPersistence() {
        BuddyInfo buddyInfo = new BuddyInfo();
        buddyInfo.setId(1);
        buddyInfo.setBuddyName("Tom");
        buddyInfo.setBuddyPhoneNumber("123-456-7890");

        EntityManagerFactory emf = Persistence.createEntityManagerFactory("jpa-test");

        EntityManager em = emf.createEntityManager();

        EntityTransaction tx = em.getTransaction();

        tx.begin();

        em.persist(buddyInfo);

        tx.commit();

        Query q = em.createQuery("SELECT x FROM BuddyInfo x");

        @SuppressWarnings("unchecked")
        List<BuddyInfo> results = q.getResultList();

        System.out.println("List of products\n----------------");

        for (BuddyInfo x : results) {

            System.out.println(x.getBuddyName() + " (id=" + x.getId() + ")");
        }

        // Closing connection
        em.close();

        emf.close();

    }
}