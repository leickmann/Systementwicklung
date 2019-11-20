package Aufgabe7;

public class TestProduktion {
	static ProduktionsMaschine maschine = new ProduktionsMaschine();
	static Schachtel sch1 = new Schachtel(5);
	static Schachtel sch2 = new Schachtel(3);
	
	
	public static void main(String[] args) {
		maschine.setFabrik(new SchraubenFabrikM6());
		maschine.fuelleSchachtel(sch1);
		sch1.zeigeInhalt();
		
		System.out.println();
		
		maschine.setFabrik(new SchraubenFabrikM10());
		maschine.fuelleSchachtel(sch2);
		sch2.zeigeInhalt();

	}

}
