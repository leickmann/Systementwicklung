package Aufgabe4;

import java.io.File;

public class TestProxy {

	public static void main(String[] args) {
		ProxyDateiZugriff pDatei = new ProxyDateiZugriff("TestDatei.dat", new File("/Users/lucas/Desktop/TestDatei.dat"));
		
		System.out.println();
		System.out.println("Name: " + pDatei.getName());
		System.out.println("Inhalt1: ");
		pDatei.getInhalt();
		System.out.println();
		System.out.println("Inhalt2: ");
		pDatei.getInhalt();
	}

}
