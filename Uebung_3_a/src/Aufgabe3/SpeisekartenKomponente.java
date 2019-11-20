package Aufgabe3;

import java.util.List;

public abstract class SpeisekartenKomponente {
	private String name;
	private String beschreibung;
	
	
	// Konstruktor:

	public SpeisekartenKomponente(String name, String beschreibung){
		this.name = name;
	}
	
	
	// Direkt hier in der Abstrakten Klasse implementierte Methoden:
	
	public String getName() {
		return this.name;
	}
	
	public String getBeschreibung(){
		return this.beschreibung;
	}
	
	
	// Zwecks Einheitlichkeit bereits hier "implementiert" (Somit auch auf Blatt-Klassen aufrufbar):
	
	
	public void hinzufuegen(SpeisekartenKomponente komponente){
		System.out.println("Kind-Methode ist nicht implementiert!");
	}

	public void entfernen(SpeisekartenKomponente komponente){
		System.out.println("Kind-Methode ist nicht implementiert!");
	}

	public void getKind(){
		System.out.println("Kind-Methode ist nicht implementiert!");
	}
	
	public double getPreis() {
		System.out.println("Kind-Methode ist nicht implementiert!");
		return (Double) null;
	}
	
	public String isVegetartisch(){
		System.out.println("Kind-Methode ist nicht implementiert!");
		return null;
	}
	
	// Methoden, die in allen Sub-Klassen implementiert werden müssen:
	
	public abstract void ausgeben();
}