package com.example.observer.instance;


public class Tester {

	public static void main(String[] args) {
		
		IBeobachter anzeige = new TemperaturAnzeige();
		IBeobachter anzeige2 = new TemperaturAnzeigeFahrenheit();
		TemperaturFuehler fuehler = new TemperaturFuehler();
		
		fuehler.beobachterAnmelden(anzeige);
		fuehler.beobachterAnmelden(anzeige2);
		
		
		for (int i = 1; i<5; i++) {
			fuehler.veraendern();
			sleep();
		}
		
	}
		
	private static void sleep() {
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}


}
