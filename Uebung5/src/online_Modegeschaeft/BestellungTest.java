package online_Modegeschaeft;

import org.junit.*;

public class BestellungTest {
	Kunde kunde;
	Kunde kunde2;
	Bestellungen bestellungen;
	
	@Before
	public void setUp() throws Exception{
		kunde = new Kunde("1;Panzer;Paul;16");
		kunde2 = new Kunde("2;Mueller;Hans;20");
		bestellungen = new Bestellungen();
	}
	
	@After
	public void tearDown() {
	}
	
	@Test
	public void test1Bestellung() {
		kunde.hinzufuegenArtikelInWarenkorb(new Artikel(1, "T-Shirt", 30));
		kunde.setAnzVergangenerBestellungen(2);
		kunde.bestellen(bestellungen, true);
		Bestellung b = bestellungen.getBestellung(1);
		Assert.assertEquals("Falscher Bestellpreis berechnet", 28.5, b.getGesamtbetrag(), 0.05);
	}
	
	@Test
	public void test2Bestellung() {
		kunde2.hinzufuegenArtikelInWarenkorb(new Artikel(2, "Diamanten Kleid", 50000));
		kunde2.setAnzVergangenerBestellungen(7);
		kunde2.bestellen(bestellungen, false);
		Bestellung b = bestellungen.getBestellung(1);
		Assert.assertEquals("Falscher Bestellpreis berechnet", 47500, b.getGesamtbetrag(), 0.05);
	}
	
	@Test(expected = Exception.class)
	public void test3Bestellung(){
		kunde.hinzufuegenArtikelInWarenkorb(new Artikel(1, "Pullover", -10));
	}
}
