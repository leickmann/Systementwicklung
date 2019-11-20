package Aufgabe11;

public class Client {
	public static void main(String[] args) {
		System.out.println("Initialisierung:");
		KonkreterVermittler konkreterVermittler = new KonkreterVermittler();
		KonkreterKollegeA kollegeA = new KonkreterKollegeA(konkreterVermittler);
		konkreterVermittler.setKollegeA(kollegeA);
		KonkreterKollegeB kollegeB = new KonkreterKollegeB(konkreterVermittler);
		konkreterVermittler.setKollegeB(kollegeB);
		
		System.out.println("\nKollegeA aendern");
		kollegeA.aenderung();
		
		System.out.println("\nKollegeA aendern");
		kollegeB.aenderung();
	}

}
