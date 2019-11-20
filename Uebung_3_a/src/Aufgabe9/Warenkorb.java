package Aufgabe9;

import java.util.ArrayList;

/**
* Je ein Objekt pro Kunde vorhanden. In ihm k�nnen Artikel abgelegt werden
* und es kann die Bestellung ausgel�st werden.
*/
public class Warenkorb {

	private ArrayList<Artikel> artikelliste = new ArrayList<Artikel>();
	private IKunde kunde;
	
	public Warenkorb(IKunde k){
		kunde = k;
	}
	
	public void hinzufuegenArtikelZuWarenkorb(Artikel a){
		artikelliste.add(a);
	}
	
	/**
	* L�scht den ersten Artikel in der Artikelliste der mit dem 
	* �bergebenen Artikel �bereinstimmt.
	*
	* @param a Artikel, der aus dem Warenkorb gel�scht werden soll
	**/
	public void loescheArtikelAusWarenkorb(Artikel a){
		boolean geloescht = false;
		
		for(int i = 0; i < artikelliste.size(); i++){
			if(a.getArtikelnummer() == artikelliste.get(i).getArtikelnummer() && geloescht == false){
				artikelliste.remove(i);
				geloescht = true;
			}
		}
		
	}
	
	/**
	* L�st eine Bestellung aus dem Warenkorb aus, wenn in der 
	* Artikelliste des Warenkorbes mindestens ein Artikel
	* vorhanden ist. 
	*
	* @param best Referenz auf ein Objekt Bestellungen von
	* dem aus die einzelne Bestellung erzeugt und verwaltet
	* wird.
	* 
	* @return Gibt den Wert -1 zur�ck wenn keine Bestellung 
	* ausgel�st wird. Gibt die Bestellungsnummer zur�ck 
	* wenn eine Bestellung ausgel�st wird.
	**/
	public int bestellen(Bestellungen best){
		int nr = -1;
		
		if(artikelliste.size() > 0){
			nr = best.neueBestellung(artikelliste, kunde);
			artikelliste.clear();
		}else{
			System.out.println("Keine Artikel im Warenkorb");
		}
		
		return nr;
		
	}
	
}
