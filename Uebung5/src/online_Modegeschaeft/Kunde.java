package online_Modegeschaeft;

import java.util.ArrayList;

/**
* Nutzer des Modegeschäfts. Haben einen Warenkorb in den
* sie Artikel hinzufügen und löschen können. 
*/
public class Kunde {

	private int kundenID;
	private String nachname;
	private String vorname;
	private int alter;
	private ArrayList<Artikel> warenkorb;
	private int anzVergangenerBestellungen;
	
	public Kunde(String s){
		String[] teil = s.split(";");
		this.kundenID = Integer.parseInt(teil[0]);
		this.nachname = teil[1];
		this.vorname = teil[2];	
		this.alter = Integer.parseInt(teil[3]);
		
		warenkorb = new ArrayList<>();
	}
	
	public void hinzufuegenArtikelInWarenkorb(Artikel a){
		warenkorb.add(a);
	}
	
	public void loescheArtikelAusWarenkorb(Artikel a){
		boolean geloescht = false;
		
		for(int i = 0; i < warenkorb.size(); i++){
			if(a.getArtikelnummer() == warenkorb.get(i).getArtikelnummer() && geloescht == false){
				warenkorb.remove(i);
				geloescht = true;
			}
		}
		
		if(geloescht == false){
			System.out.println("Kein passender Artikel gefunden");
		}
		
	}
	
	public void bestellen(Bestellungen best, boolean newsletterRabatt){
		best.neueBestellung(warenkorb, this, newsletterRabatt);
		anzVergangenerBestellungen++;
		warenkorb.clear();
	}
	
	public int getKundenID() {
		return kundenID;
	}

	public String getNachname() {
		return nachname;
	}

	public void setNachname(String nachname) {
		this.nachname = nachname;
	}

	public String getVorname() {
		return vorname;
	}

	public void setVorname(String vorname) {
		this.vorname = vorname;
	}
	
	public int getAlter(){
		return alter;
	}
	
	public int getAnzVergangenerBestellungen(){
		return anzVergangenerBestellungen;
	}
	
	public void setAnzVergangenerBestellungen(int anzahl){
		this.anzVergangenerBestellungen = anzahl;
	}
	
	public ArrayList<Artikel> getWarenkorb(){
		return warenkorb;
	}
	
}
