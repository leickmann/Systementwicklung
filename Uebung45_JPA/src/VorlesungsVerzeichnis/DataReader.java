3package VorlesungsVerzeichnis;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;



public class DataReader {

	public static void main(String[] args) {
		EntityManager em = DBConnector.getEM();
		
		TypedQuery<Vorlesung> q = em.createQuery("select v from Vorlesung v", Vorlesung.class);
		
		List<Vorlesung> vorlesungen = q.getResultList();
		
		for (Vorlesung v : vorlesungen) {
			System.out.println(v.getName());
			for (Student s : v.getStudenten()) {
				System.out.println("\t" + s.getVorname() + " " + s.getNachname());
			}
		}
		
		// Ausgabe aller Studenten die SysAnalyse besuchen
		
		Vorlesung vl = em.createQuery("select v from Vorlesung v where v.name = 'System Analyse'", Vorlesung.class).getSingleResult();
		System.out.println();
		System.out.println("-----------------------");
		System.out.println(vl.getName() + " | " + vl.getBeschreibung());
		
		//Ausgabe der Adresse vom Studenten mit dem Nachnamen Eickmann
		
		System.out.println();
		System.out.println("-----------------------");
		
		List<Student> stud = em.createQuery("select s from Student s where s.nachname = 'Eickmann'", Student.class).getResultList();
		if (stud.size() > 1) {
			System.out.println("Es existiert mehr als ein Student der die Bedingung erfüllt!");
		}else if (stud.size() == 1) {
			System.out.println("Einen Studenten gefunden!");
		}else {
			System.out.println("Keinen Studenten gefunden der die Bedingung erfüllt!");
		}
		for (Student s : stud) {
			System.out.println(s.getVorname() + " | " + s.getNachname() + " | " + s.getAdresse().toString());
		}
	}

}
