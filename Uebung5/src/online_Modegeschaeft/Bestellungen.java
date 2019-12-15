package online_Modegeschaeft;

import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.TreeMap;

/**
* Verwaltet die einzelnen Bestellungen indem
* es sie erstellt und in einer ArrayList speichert.
*/
public class Bestellungen {

	 int id = 0;
	 TreeMap<Integer, Bestellung> bestellungen = new TreeMap<Integer, Bestellung>();
	
	/**
	* Erstellt eine neue Bestellung. Die id dient 
	* dazu, durchgängige Bestellungsnummern zu erhalten.
	*
	* @param arrayList ArrayList von Artikeln im Warenkorb
	* 
	* @return Bestellungsnummer der Bestellung
	**/
	public int neueBestellung(ArrayList<Artikel> arrayList, Kunde k, boolean newsletterRabatt) {
		id++;
		Bestellung neuB = new Bestellung(id, k);
		double rabatt = 0;
		double rabattProzent = 0;
		
		for(Artikel a_model: arrayList){
			neuB.hinzufuegenArtikel(a_model);
		}
		
		if(neuB.getGesamtbetrag() >= 50 && newsletterRabatt == true)
			rabatt = rabatt + 10;
		if((neuB.getGesamtbetrag() <= 50 || newsletterRabatt == false) && k.getAnzVergangenerBestellungen() >= 5){
			if(k.getAnzVergangenerBestellungen() >= 20){
				rabattProzent = rabattProzent + 0.1;
			}else if(k.getAnzVergangenerBestellungen() >= 10){
				rabattProzent = rabattProzent + 0.075;
			}else{
				rabattProzent = rabattProzent + 0.05;
			}
		}
		if(k.getAlter() < 18)
			rabattProzent = rabattProzent + 0.05;
		
		neuB.setRabatt(rabatt);
		neuB.setRabattProzent(rabattProzent);
			
		bestellungen.put(id, neuB);
		NumberFormat n = NumberFormat.getInstance();
		n.setMaximumFractionDigits(2);
		System.out.println("Neue Bestellung " + id + " mit Betrag von " + n.format(bestellungen.get(id).getGesamtbetrag()) + "€ eingegangen.");
		return id;
	}
	
	public Bestellung getBestellung(int nr){
		return bestellungen.get(nr);
	}
	
}
