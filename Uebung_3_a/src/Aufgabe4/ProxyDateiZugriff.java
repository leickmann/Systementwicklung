package Aufgabe4;

import java.io.File;

public class ProxyDateiZugriff implements IDateiZugriff {
	private String name;
	private File file;
	IDateiZugriff realeDatei;
	
	public ProxyDateiZugriff(String name, File file) {
		this.name = name;
		this.file = file;
		System.out.println("Stellvertretendes Objekt instanziiert.");
	}

	@Override
	public String getName() {
		return this.name;
	}

	@Override
	public void getInhalt() {
		if (realeDatei == null) {
			System.out.println("Inhalt liegt lokal nicht vor.");
			realeDatei = new DateiZugriff(this.name, file);
			
		}
		realeDatei.getInhalt();
	}

}
