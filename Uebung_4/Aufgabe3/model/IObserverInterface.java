/*
 * Typ   : Interface
 * Name  : ObserverInterface
 * Paket : model
 */
package model;

/**
 * Name  : ObserverInterface
 * Paket : model
 * 
 * Interface f�r alle Observer Klassen.
 * 
 * @author Vasilios Filippidis
 */
public interface IObserverInterface
{
	
	/**
	 * Update Methode der Observer, die vom Observable aufgerufen wird.
	 * @param dataModel 
	 *  
	 */
	public void update(IModelInterface dataModel);
}
