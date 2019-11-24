package VorlesungsVerzeichnis;

import javax.persistence.EntityManager;

public class Main {
	public static void main(String[] args) {
		EntityManager em = DBConnector.getEM();
		
		Student lucas = new Student("Lucas", "Eickmann");
		Student alex = new Student("Alexander", "Brinkmann");
		Student siggi = new Student("Sebastian", "Siegmann");
		Student dennis = new Student("Dennis", "Ewers");
		
		Adresse adrLucas = new Adresse("Jaegerstraﬂe 107", "33161 Hoevelhof");
		Adresse adrAlex = new Adresse("Habsveresssen 1", "11111 Bielefeld");
		Adresse adrSiggi = new Adresse("ErfundeneStr 2", "67890 Kattenfelde");
		Adresse adrDennis = new Adresse("DennisStraﬂe 22", "34567 Dorf");
		lucas.setAdresse(adrLucas);
		alex.setAdresse(adrAlex);
		siggi.setAdresse(adrSiggi);
		dennis.setAdresse(adrDennis);
		em.persist(lucas);
		em.persist(alex);
		em.persist(siggi);
		em.persist(dennis);

		Professor kuester = new Professor("Prof. Kuester");
		Professor hartel = new Professor("Prof. Hartel");
		Professor schmidtmann = new Professor("Prof. Schmidtmann");
		em.persist(kuester);
		em.persist(hartel);
		em.persist(schmidtmann);
		
		Vorlesung sysEntwicklung = new Vorlesung("Systementwicklung", "Entwurfsmuster etc");
		sysEntwicklung.setProf(kuester);
		sysEntwicklung.addStudent(lucas);
		sysEntwicklung.addStudent(alex);
		sysEntwicklung.addStudent(siggi);
		em.persist(sysEntwicklung);
		
		Vorlesung sysAnalyse = new Vorlesung("System Analyse", "Die im 2. Semester");
		sysAnalyse.setProf(kuester);
		sysAnalyse.addStudent(lucas);
		sysAnalyse.addStudent(siggi);
		em.persist(sysAnalyse);
		
		Vorlesung datenbanken = new Vorlesung("Datenbanken", "SQL Datenbanken");
		datenbanken.setProf(hartel);
		datenbanken.addStudent(alex);
		datenbanken.addStudent(siggi);
		datenbanken.addStudent(lucas);
		em.persist(datenbanken);
		
		Vorlesung erp = new Vorlesung("ERP", "Technologie von ERP Systemen");
		erp.setProf(schmidtmann);
		erp.addStudent(alex);
		erp.addStudent(alex);
		erp.addStudent(siggi);
		em.persist(erp);
		
		Vorlesung mawi = new Vorlesung("MAWI", "MAterialwirtschft und Produktionsplanung");
		mawi.setProf(schmidtmann);
		mawi.addStudent(alex);
		em.persist(mawi);
		
		
		em.getTransaction().begin();
		em.getTransaction().commit();
		em.close();
	}
}
