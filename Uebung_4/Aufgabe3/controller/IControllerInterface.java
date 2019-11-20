/*
 * Typ   : Interface
 * Name  : ControllerInterface
 * Paket : controller
 */
package controller;

/**
 * Interface für alle Controller Klassen.
 * 
 * @author Vasilios Filippidis
 */
public interface IControllerInterface
{
	/**
	 * Prüft die eingegebenen Werte für rot, grün und blau und übergibt
	 * sie dem Model.
	 * 
	 * @param red Wert für die rote Partei.
	 * @param green Wert für die grüne Partei.
	 * @param blue Wert für die blaue Partei.
	 */
	public void setValues (String red, String green, String blue);
}
