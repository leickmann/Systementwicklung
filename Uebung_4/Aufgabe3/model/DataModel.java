/*
 * Typ   : Klasse
 * Name  : DataModel
 * Paket : model
 */
package model;

import java.util.ArrayList;

/**
 * Model für die Sitzanzahl der Parteien.
 * 
 * Es werden nur die Sitzanzahl der jeweiligen Parteien gespeichert.
 * Der Prozentuale Anteil jeder Partei kann abgefragt werden. 
 * 
 * @author Vasilios Filippidis
 *
 */
public class DataModel implements IModelInterface
{
	private int m_redValue = 0;
	private int m_greenValue = 0;
	private int m_blueValue = 0;	
	private ArrayList<IObserverInterface> m_observers = new ArrayList<IObserverInterface>();

	
	/* (non-Javadoc)
	 * @see model.ModelInterface#getBluePercentage()
	 */
	public double getBluePercentage()
	{		
		double total = m_redValue + m_greenValue + m_blueValue;
		if (total > 0) return m_blueValue / total; 
		return 0;
	}

	/**
	 * @see model.ModelInterface#getGreenPercentage()
	 */
	public double getGreenPercentage()
	{
		double total = m_redValue + m_greenValue + m_blueValue;
		if (total > 0) return m_greenValue / total;
		return 0;
	}

	/* (non-Javadoc)
	 * @see model.ModelInterface#getRedPercentage()
	 */
	public double getRedPercentage()
	{		
		double total = m_redValue + m_greenValue + m_blueValue;
		if (total > 0) return m_redValue / total;
		return 0;
	}

	/* (non-Javadoc)
	 * @see model.ModelInterface#setBlueValue(int)
	 */
	public void setBlueValue (int value)
	{
		m_blueValue = value;
		notifyObservers();
	}

	/* (non-Javadoc)
	 * @see model.ModelInterface#setGreenValue(int)
	 */
	public void setGreenValue (int value)
	{
		m_greenValue = value;
		notifyObservers();
	}

	/* (non-Javadoc)
	 * @see model.ModelInterface#setRedValue(int)
	 */
	public void setRedValue (int value)
	{
		m_redValue = value;
		notifyObservers();
	}

	/* (non-Javadoc)
	 * @see model.ObservableInterface#notifyObservers()
	 */
	public void notifyObservers()
	{		
		for ( int i=0; i < m_observers.size(); ++i)
			m_observers.get(i).update(this);
	}

	/* (non-Javadoc)
	 * @see model.ObservableInterface#registerObserver(model.ObserverInterface)
	 */
	public void registerObserver (IObserverInterface o)
	{
		m_observers.add(o);
	}

	/* (non-Javadoc)
	 * @see model.ObservableInterface#removeObserver(model.ObserverInterface)
	 */
	public void removeObserver (IObserverInterface o)
	{
		if ( m_observers.contains(o))
			m_observers.remove(o);
	}
}
