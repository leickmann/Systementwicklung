package Aufgabe7;

public class Schachtel {
	private int anzahl;
	private int anzahlSchrauben;
	private int anzahlMuttern;
	private ISchraube[] schrauben;
	private IMutter[] muttern;
	
	public Schachtel(int groesse) {
		anzahl = groesse;
		schrauben = new ISchraube[anzahl];
		muttern = new IMutter[anzahl];
	}
	
	public int anzahl() {
		return this.anzahl;
	}

	public void legeSchraubeHinein (ISchraube schraube) {
		if (anzahlSchrauben == anzahl) {
			return;
		}
		else {
			anzahlSchrauben++;
			schrauben[anzahlSchrauben-1] = schraube;
		}
	}	
		public void legeMutterHinein (IMutter mutter) {
			if (anzahlMuttern == anzahl) {
				return;
			}
			else {
				anzahlMuttern++;
				muttern[anzahlMuttern-1] = mutter;
			}
	}
		
		public void zeigeInhalt() {
			int i;
			for (i = 0; i < anzahlSchrauben; i++) {
				schrauben[i].print();
			}
			for (i = 0; i < anzahlMuttern; i++){
				muttern[i].print();
			}
				
		}
}
