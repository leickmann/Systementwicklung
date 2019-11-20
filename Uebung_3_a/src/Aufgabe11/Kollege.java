package Aufgabe11;

public abstract class Kollege {
	private Vermittler vermittler;
	
	public Kollege(Vermittler v) {
		this.vermittler = v;
	}
	
	public void aenderung() {
		vermittler.aenderungAufgetreten(this);
	}
}
