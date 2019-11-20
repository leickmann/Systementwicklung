package Aufgabe7;

public class ProduktionsMaschine {
private IAbstrakteFabrik fabrik = null;

public void setFabrik(IAbstrakteFabrik fabrik) {
	this.fabrik = fabrik;
}

public void fuelleSchachtel(Schachtel schachtel) {
	for (int i = 0; i<schachtel.anzahl(); i++) {
		schachtel.legeSchraubeHinein(fabrik.erzeugeSchraube());
		schachtel.legeMutterHinein(fabrik.erzeugeMutter());
	}
	
}

}
