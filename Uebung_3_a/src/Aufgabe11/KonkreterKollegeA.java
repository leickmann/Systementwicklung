package Aufgabe11;

public class KonkreterKollegeA extends Kollege {

	public KonkreterKollegeA(Vermittler v) {
		super(v);
		System.out.println("KonkreterKollegeA instantiiert");
	}
	
	public void methodeA() {
		System.out.println("KonkreterKollegeA wird in methodeA() geaendert als Folge der Aenderung eines Kollegen");
	}
	
	public void aenderung() {
		System.out.println("KonkreterKollegeA wurde geaendert duch Aufruf der Methode aenderung(). KonkreterKollegeA informiert den Vermittler");
		super.aenderung();
	}
	
	

}
