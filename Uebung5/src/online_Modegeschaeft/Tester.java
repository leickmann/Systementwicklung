package online_Modegeschaeft;

public class Tester {
	
	public static void main(String[] args){
		
		Bestellungen best = new Bestellungen();

		Kunde Meier = new Kunde("1;Meier;Kurt;52");
		Kunde Mueller = new Kunde ("2;Müller;Tom;17");
		
		Artikel NikeFree = new Artikel(1, "Nike Free", 89.99);
		Artikel NewBalanceWi = new Artikel(2, "New Balance Wi", 79.99);
		Artikel AdidasJacke = new Artikel(3, "Adidas Jacke", 59.99);
		Artikel TommyHilfigerShirt = new Artikel(4, "Tommy Hilfiger T-Shirt", 24.99);
		
		Meier.setAnzVergangenerBestellungen(10);
		Meier.hinzufuegenArtikelInWarenkorb(NikeFree);
		Meier.hinzufuegenArtikelInWarenkorb(AdidasJacke);
		Meier.hinzufuegenArtikelInWarenkorb(TommyHilfigerShirt);
		Meier.bestellen(best, false);
		
		Mueller.setAnzVergangenerBestellungen(15);
		Mueller.hinzufuegenArtikelInWarenkorb(NewBalanceWi);
		Mueller.hinzufuegenArtikelInWarenkorb(TommyHilfigerShirt);
		Mueller.bestellen(best, true);
	
	}
	
}
