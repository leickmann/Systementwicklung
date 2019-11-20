/*
 * Typ   : Interface
 * Name  : ObservableInterface
 * Paket : model
 */
package model;

/**
 * Interface für alle Observable Klassen
 * 
 * @author Vasilios Filippidis
 */
public interface IObservableInterface
{
	/**
	 * Registriert einen Observer.
	 * 
	 * @param o Der einzutragende Observer.
	 */
	public void registerObserver (IObserverInterface o);
	
	/**
	 * Entfernt einen Observer aus der Liste.
	 * 
	 * @param o Der auszutragende Observer.
	 */
	public void removeObserver (IObserverInterface o);
	
	/**
	 * Benachrichtigt alle Observer die eingetragen sind.
	 * 
	 */
	public void notifyObservers();
}
