package Ue2_WetterDaten.src;

public class FahrenheitAnzeige {

	private double fTemperatur;
	private double feuchtigkeit;
	
	public FahrenheitAnzeige()
	{
		
	}
	
	public void aktualisieren(double temp, double feucht, double luftdruck)
	{
		this.fTemperatur = (temp -32) * (5/9);
		this.feuchtigkeit = feucht;
		anzeigen();
	}

	public void anzeigen() 
	{
		System.out.println("Aktuelle Wetterbedingungen: " + fTemperatur + " Grad Fahrenheit und Luftfeuchtigkeit % " + feuchtigkeit);
	}

}