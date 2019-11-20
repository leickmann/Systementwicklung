/*
 * Typ   : Interface
 * Name  : ControllerInterface
 * Paket : controller
 */
package controller;

/**
 * Interface f�r alle Controller Klassen.
 * 
 * @author Vasilios Filippidis
 */
public interface IControllerInterface
{
	/**
	 * Pr�ft die eingegebenen Werte f�r rot, gr�n und blau und �bergibt
	 * sie dem Model.
	 * 
	 * @param red Wert f�r die rote Partei.
	 * @param green Wert f�r die gr�ne Partei.
	 * @param blue Wert f�r die blaue Partei.
	 */
	public void setValues (String red, String green, String blue);
}
