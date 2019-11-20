/*
 * Typ   : Interface
 * Name  : ModelInterface
 * Paket : model
 */
package model;

/**
 * Interface für alle Model Klassen.
 * 
 * @author Vasilios Filippidis
 *
 */
public interface IModelInterface extends IObservableInterface
{
	/**
	 * Liefert den Prozentualen Anteil der roten Partei zurück.
	 * 
	 * @return Prozentualer Anteil der roten Partei.
	 */
	public double getRedPercentage();

	/**
	 * Liefert den Prozentualen Anteil der blauen Partei zurück.
	 * 
	 * @return Prozentualer Anteil der blauen Partei.
	 */
	public double getBluePercentage();
	
	/**
	 * Liefert den Prozentualen Anteil der grünen Partei zurück.
	 * 
	 * @return Prozentualer Anteil der grünen Partei.
	 */	
	public double getGreenPercentage();
	
	/**
	 * Setzt die Anzahl der roten Sitze.
	 * 
	 * @param value Anzahl der roten Sitze.
	 */
	public void setRedValue (int value);

	/**
	 * Setzt die Anzahl der blauen Sitze.
	 * 
	 * @param value Anzahl der blauen Sitze.
	 */
	public void setBlueValue (int value);

	/**
	 * Setzt die Anzahl der grünen Sitze.
	 * 
	 * @param value Anzahl der grünen Sitze.
	 */
	public void setGreenValue (int value);	
}
