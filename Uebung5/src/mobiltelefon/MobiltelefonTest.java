package mobiltelefon;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;



public class MobiltelefonTest {
	
	Mobiltelefon m2;
	
	@Test
	public void test1Konstruktor() {
		Mobiltelefon m1 = new Mobiltelefon("Lucas", "Apple", "schwarz");
	}
	
	@Before
	public void setUp() {
		m2 = new Mobiltelefon("Lucas", "Apple", "schwarz");
	}
	
	@Test
	public void test1GetEingeschaltet(){
		Assert.assertEquals("eingeschaltet nicht false", false, m2.getEingeschaltet());
	}
	
	@Test
	public void test1GetAusgeschaltet() {
		Assert.assertEquals("ausgeschaltet nicht true", true, m2.getAusgeschaltet());
	}
	
	@Test
	public void test1Spielen() {
		int startZustand = m2.getLadezustand();
		m2.spielen();
		Assert.assertEquals("falscher Ladezustand", startZustand-20, m2.getLadezustand());
	}
	
	
	@Test
	public void test1Einschalten() {
		Assert.assertEquals("ausgeschaltet nicht true", true, m2.getAusgeschaltet());
		m2.einschalten();
		Assert.assertEquals("ausgeschaltet nicht false", false, m2.getAusgeschaltet());
	}
	
	@Test
	public void test1Ausschaletn() {
		m2.einschalten();
		Assert.assertEquals("ausgeschaltet nicht true", false, m2.getAusgeschaltet());
		m2.ausschalten();
		Assert.assertEquals("ausgeschaltet nicht false", true, m2.getAusgeschaltet());
	}
	
	@Test
	public void test1Telefonieren() {
		int beginnAkku = m2.getLadezustand();
		m2.telefonieren("123456");
		if (beginnAkku > 50) {
			Assert.assertEquals("falscher Ladezustand", beginnAkku-30, m2.getLadezustand());
		}else {
			Assert.assertEquals("falscher Ladezustand", beginnAkku, m2.getLadezustand());
		}
	}
	
	@Test
	public void test2Telefonieren() {
		while (m2.getLadezustand() >50) {
			m2.spielen();
		}
		
		int beginnAkku = m2.getLadezustand();
		m2.telefonieren("123456");
		if (beginnAkku > 50) {
			Assert.assertEquals("falscher Ladezustand", beginnAkku-30, m2.getLadezustand());
		}else {
			Assert.assertEquals("falscher Ladezustand", beginnAkku, m2.getLadezustand());
		}	
		
			
	}
}
