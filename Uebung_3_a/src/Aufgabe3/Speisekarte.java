package Aufgabe3;

import java.util.ArrayList;
import java.util.List;

public class Speisekarte extends SpeisekartenKomponente {
	private ArrayList<SpeisekartenKomponente> speisekartenKomponenten = new ArrayList<SpeisekartenKomponente>();
//	public SpeisekartenKomponente m_SpeisekartenKomponente;

	public Speisekarte(String name, String beschreibung){
		super(name, beschreibung);
	}

	public void ausgeben(){
		System.out.println();
			System.out.println("SpeisekartenName: " + super.getName());
			
			for (SpeisekartenKomponente komp : speisekartenKomponenten) {
				komp.ausgeben();
			}
	}


	public SpeisekartenKomponente getKind(int index){
		return this.speisekartenKomponenten.get(index);
	}


	public void hinzufuegen(SpeisekartenKomponente komponente){
		speisekartenKomponenten.add(komponente);
	}
	
	public void entfernen(SpeisekartenKomponente komponente){
		speisekartenKomponenten.remove(komponente);
	}
}