package Blatt_2_5;

import java.util.HashSet;

/**
 * @author lucas
 * @version 1.0
 * @created 24-Okt-2019 14:45:54
 */
public class Artikel {

	private int artikelnummer;
	private String bezeichnung;
	private String marke;
	private double preis;
	private String status;
	public HashSet<Mitarbeiter> m_Mitarbeiter;

	public Artikel(){

	}

	public void finalize() throws Throwable {

	}
}//end Artikel