

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class DBConnector {
	// Singleton Pattern - wir brauchen nur einen Entity Manager
	
	private static EntityManagerFactory EMfactory;
	private static EntityManager em;
	private static final String PERSISTENCE_UNIT_NAME = "test";
	
	private DBConnector() {
	}
	
	public static EntityManager getEM() {
		if( em == null ) {
			EMfactory = Persistence.createEntityManagerFactory(PERSISTENCE_UNIT_NAME);
	        em = EMfactory.createEntityManager();
		}
		return em;
	}
}
