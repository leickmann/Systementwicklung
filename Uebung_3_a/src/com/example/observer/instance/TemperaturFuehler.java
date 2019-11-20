package com.example.observer.instance;

import java.util.ArrayList;
import java.util.List;

public class TemperaturFuehler implements ISubjekt {
	
	private int temp;
	private List<IBeobachter> anzeigen = new ArrayList<IBeobachter>();

	@Override
	public void beobachterAnmelden(IBeobachter b) {
		anzeigen.add(b);
	}

	@Override
	public void beobachterAbmelden(IBeobachter b) {
		anzeigen.remove(b);
	}

	@Override
	public String gibZustand() {
		return String.valueOf(temp);
	}
	
	public void veraendern() {
		temp++;	
		
		// Rufe nun alle Beobachter auf, hier ist es nur eine Anzeige
		
		for(IBeobachter anzeige:anzeigen) {
			anzeige.aktualisieren(this);
		}
	}



}
