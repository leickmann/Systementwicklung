//import java.util.Scanner;
//
//import javax.persistence.EntityManager;
//
//public class Main {
//	public static void main(String args[]) {
//		EntityManager em = DBConnector.getEM();
//		Scanner scanner = new Scanner(System.in);
//		PhoneBook phoneBook = new PhoneBook();
//		
//		boolean next = true;
//		while (next) {
//			System.out.print("Name: ");
//			String name = scanner.nextLine();
//			System.out.print("Nummer: ");
//			String nummer = scanner.nextLine();
//			boolean isBusiness = false;
//			
//			PhoneBookEntry pbe = new PhoneBookEntry(name, nummer, isBusiness);
//			
//			em.persist(pbe);
//			em.getTransaction().begin();
//			em.getTransaction().commit();
//			
//			System.out.println("Möchten Sie einen weiteren Eintarg anlegen? (j/n): ");
//			String value = scanner.nextLine();
//			if (!value.equals("j")){
//				next = false;
//			}
//		}
//	}
//}
