package Ue2_WetterDaten2.src;

public class FahrenheitAnzeige implements Anzeige {
	private double fTemperatur;
	private double feuchtigkeit;
	private WetterDaten wetterDaten;
	
	public FahrenheitAnzeige(WetterDaten wetterDaten)
	{
		this.wetterDaten = wetterDaten;
		this.wetterDaten.registriereAnzeige(this);
	}
	
	public void aktualisieren(double temp, double feucht, double luftdruck)
	{
		this.fTemperatur = (temp - 32) * (5/9);
		this.feuchtigkeit = feucht;
		anzeigen();
	}

	public void anzeigen() 
	{
		System.out.println("Aktuelle Wetterbedingungen: " + fTemperatur + " Grad Fahrenheit und Luftfeuchtigkeit % " + feuchtigkeit);
	}
}
