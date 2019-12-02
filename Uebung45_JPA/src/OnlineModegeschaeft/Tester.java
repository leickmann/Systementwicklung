package OnlineModegeschaeft;

import javax.persistence.EntityManager;

import VorlesungsVerzeichnis.DBConnector;

public class Tester {

	public static void main(String[] args) {
		EntityManager em = DBConnector.getEM();
		
		Lieferant l1 = new Lieferant("OTTO", "Otto Vertrieb");
		Lieferant l2 = new Lieferant("HANSEN","Hansen Vertrieb");
		
		Mitarbeiter lucas = new Mitarbeiter("Lucas");
		lucas.setEmail("lucas@me.de");
		lucas.setVorname("Lucas");
		lucas.setNachname("Eickmann");
		
		Schuhartikel vans = new Schuhartikel("Vans", 111, "sneakers");
		vans.setPreis(79.99);
		vans.setStatus("lieferbar");
		vans.addLieferant(l1);
		vans.addMitarbeiter(lucas);
		vans.setInnenmaterial("Stoff");
		vans.setObermaterial("Leder");
		vans.setSohlenmaterial("Gummi");
		
		Kleidungsartikel jeans = new Kleidungsartikel("JJ Jeans", 112, "Jeans Stoff blau");
		jeans.setPreis(39.99);
		jeans.setArtikelnummer(112);
		jeans.setStatus("lieferbar");
		jeans.addLieferant(l2);
		jeans.addMitarbeiter(lucas);
		
		em.persist(vans);
		em.persist(jeans);
		em.getTransaction().begin();
		em.getTransaction().commit();
		em.close();
		
	}

}
