package Aufgabe11;

public class KonkreterKollegeB extends Kollege {

	public KonkreterKollegeB(Vermittler v) {
		super(v);
		System.out.println("KonkreterKollegeB instantiiert");
	}
	
	public void methodeB() {
		System.out.println("KonkreterKollegeB wird in methodeA() geaendert als Folge der Aenderung eines Kollegen");
	}
	
	public void aenderung() {
		System.out.println("KonkreterKollegeB wurde geaendert duch Aufruf der Methode aenderung(). KonkreterKollegeA informiert den Vermittler");
		super.aenderung();
	}
	
	

}
