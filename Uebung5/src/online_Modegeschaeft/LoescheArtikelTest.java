package online_Modegeschaeft;

import org.junit.*;


public class LoescheArtikelTest {
	Kunde kunde;
	Artikel tshirt;
	Bestellungen bestellungen;
	
	@Before
	public void setUp() throws Exception{
		kunde = new Kunde("1;Panzer;Paul;16");
		tshirt = new Artikel(1, "T-Shirt", 30);
	}
	
	@After
	public void tearDown() {
	}
	
	@Test
	public void test1LoescheArtikel() {
		kunde.loescheArtikelAusWarenkorb(tshirt);
		Assert.assertEquals("Warenkorb nicht leer", 0, kunde.getWarenkorb().size());
	}
	
	@Test
	public void test2LoescheArtikel() {
		kunde.hinzufuegenArtikelInWarenkorb(tshirt);
		kunde.loescheArtikelAusWarenkorb(tshirt);
		Assert.assertEquals("Warenkorb nicht leer", 0, kunde.getWarenkorb().size());
	}
	
	@Test
	public void test3LoescheArtikel() {
		kunde.hinzufuegenArtikelInWarenkorb(tshirt);
		kunde.hinzufuegenArtikelInWarenkorb(tshirt);
		
		kunde.loescheArtikelAusWarenkorb(tshirt);
		Assert.assertEquals("Warenkorb leer", 1, kunde.getWarenkorb().size());
	}

}
