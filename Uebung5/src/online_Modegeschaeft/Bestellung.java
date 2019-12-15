package online_Modegeschaeft;

import java.util.ArrayList;

/**
* Eine vom Kunden ausgelöste Bestellung. Hat mehrere Artikelpositionen
* in denen die einzelnen Artikel hinterlegt sind.
*/
public class Bestellung {
	
	private int bestellNr;
	private Kunde kunde;
	private ArrayList<Artikel> artikelpositionen = new ArrayList<Artikel>();
	private double rabatt;
	private double rabattProzent;
	
	public Bestellung(int n, Kunde k){
		this.bestellNr = n;
		this.kunde = k;
	}
	
	public void hinzufuegenArtikel(Artikel a){
		artikelpositionen.add(a);
	}
	
	public int getBestellNr(){
		return bestellNr;
	}
	
	public double getGesamtbetrag(){
		double betrag = 0;
		
		for(int i = 0; i < artikelpositionen.size(); i++){
			betrag = betrag + artikelpositionen.get(i).getPreis();
		}
		
		betrag = betrag - rabatt;
		double rabattAufBetrag = betrag * rabattProzent;
		betrag = betrag - rabattAufBetrag;
		
		return betrag;
	}
	
	public ArrayList<Artikel> getArtikelpositionen(){
		return artikelpositionen;
	}
	
	public double getRabatt(){
		return rabatt;
	}
	
	public void setRabatt(double rabatt){
		if(rabatt >= 0 && rabatt <= 100){
			this.rabatt = rabatt;
		}else{
			System.out.println("Kein gültiger Rabatt");
		}
	}
	
	public double getRabattProzent(){
		return rabatt;
	}
	
	public void setRabattProzent(double rabatt){
		if(rabatt >= 0 && rabatt <= 100){
			this.rabattProzent = rabatt;
		}else{
			System.out.println("Kein gültiger Rabatt");
		}
	}
	
}
