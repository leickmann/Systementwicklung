import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

public class PhoneBook {
	public List<PhoneBookEntry> getAll() {
		Query q = DBConnector.getEM().createQuery("select t from PhoneBookEntry t");
		return q.getResultList();
	}

	public PhoneBookEntry create() {
		return new PhoneBookEntry();
	}

	public void add(PhoneBookEntry newEntry) {
		EntityManager em = DBConnector.getEM();
		em.getTransaction().begin();
		em.persist(newEntry);
		em.flush();
		em.getTransaction().commit();
	}

	public void delete(PhoneBookEntry entry) {
		EntityManager em = DBConnector.getEM();
		em.getTransaction().begin();
		em.remove(entry);
		em.flush();
		em.getTransaction().commit();
	}

	public void change(PhoneBookEntry entry, String name, String phoneNumber, boolean isBusiness) {
		EntityManager em = DBConnector.getEM();
		em.getTransaction().begin();
		entry.setName(name);
		entry.setPhoneNumber(phoneNumber);
		entry.setBusiness(isBusiness);
		em.getTransaction().commit();
	}
}