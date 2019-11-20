/*
 * Typ   : Interface
 * Name  : ModelInterface
 * Paket : model
 */
package model;

/**
 * Interface f�r alle Model Klassen.
 * 
 * @author Vasilios Filippidis
 *
 */
public interface IModelInterface extends IObservableInterface
{
	/**
	 * Liefert den Prozentualen Anteil der roten Partei zur�ck.
	 * 
	 * @return Prozentualer Anteil der roten Partei.
	 */
	public double getRedPercentage();

	/**
	 * Liefert den Prozentualen Anteil der blauen Partei zur�ck.
	 * 
	 * @return Prozentualer Anteil der blauen Partei.
	 */
	public double getBluePercentage();
	
	/**
	 * Liefert den Prozentualen Anteil der gr�nen Partei zur�ck.
	 * 
	 * @return Prozentualer Anteil der gr�nen Partei.
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
	 * Setzt die Anzahl der gr�nen Sitze.
	 * 
	 * @param value Anzahl der gr�nen Sitze.
	 */
	public void setGreenValue (int value);	
}
