package Aufgabe8;

public class HeimkinoFassade {
	
	private Beamer beamer = new Beamer();
	private Beleuchtung beleuchtung = new Beleuchtung();
	private DVDSpieler dvdSpieler = new DVDSpieler();
	private Leinwand leinwand = new Leinwand();
	private Verstaerker verstaerker = new Verstaerker();
	
	
	public void heimkinoEin() throws InterruptedException {
		beleuchtung.dimmen(6);
		Thread.sleep(60);
		leinwand.runter();
		verstaerker.ein();
		beamer.ein();
		dvdSpieler.ein();
		verstaerker.setDvd();
		verstaerker.setSurroundSound();
		dvdSpieler.setSurroundSound();
		dvdSpieler.spielen();
			
		
	}

}
