package Aufgabe11;

public class KonkreterVermittler extends Vermittler {
	
	private KonkreterKollegeA kollegeA;
	private KonkreterKollegeB kollegeB;

	public KonkreterVermittler() {
		System.out.println("KonkreterVermittler: instantiiert");
	}
	
	@Override
	public void aenderungAufgetreten(Kollege kollege) {
		if (kollege == (Kollege)kollegeA) {
			System.out.println("KonkreterVermittler: informiere KollegeB");
			kollegeB.methodeB();
		}
		else if(kollege == (Kollege)kollegeB) {
			System.out.println("KonkreterVermittler: informiere KollegeA");
			kollegeA.methodeA();
		}
	}

	public void setKollegeA(KonkreterKollegeA kollegeA) {
		this.kollegeA = kollegeA;
	}

	public void setKollegeB(KonkreterKollegeB kollegeB) {
		this.kollegeB = kollegeB;
	}

}
