/*
 * Typ   : Klasse
 * Name  : TableViewController
 * Paket : controller
 */
package controller;

import model.*;
import view.*;

/**
 * Controller f�r eine TableView. 
 * 
 * @author Vasilios Filippidis
 *
 */
public class TableViewController implements IControllerInterface
{
	private IModelInterface m_model;
	private TableView m_tableView;

	/**
	 * Erstellt einen TableViewController.
	 * 
	 * @param model Referenz auf das zugeh�rige Model.
	 * @param tableView Referenz auf die zugeh�rige TableView.
	 */
	public TableViewController (IModelInterface model, TableView tableView)
	{
		m_tableView = tableView;
		m_model = model;
	}
	
	/**
	 * Pr�ft die eingegebenen Werte f�r rot, gr�n und blau und �bergibt
	 * sie dem Model.
	 * 
	 * @param red Wert f�r die rote Partei.
	 * @param green Wert f�r die gr�ne Partei.
	 * @param blue Wert f�r die blaue Partei.
	 */
	public void setValues (String red, String green, String blue)
	{
		int r = 0;
		int b = 0;
		int g = 0;
		boolean error = false;
		m_tableView.clearError();
		
		try
		{
			b = Integer.parseInt (blue);
		} catch(NumberFormatException e){
			m_tableView.setError("Blue number is invalid");
			error = true;
		}

		try{			
			g = Integer.parseInt (green);
		} catch(NumberFormatException e){
			m_tableView.setError("Green number is invalid!");
			error = true;
		}

		try{			
			r = Integer.parseInt (red);
		} catch(NumberFormatException e){
			m_tableView.setError("Red number is invalid!");
			error = true;
		}

		if ( r < 0 || g < 0 || b < 0 )
		{
			m_tableView.setError("No negative numbers allowed");
			error = true;
		}
			
		if ( !error && (r > 0 || g > 0 || b > 0) )
		{
			m_model.setBlueValue(b);
			m_model.setGreenValue(g);
			m_model.setRedValue(r);
		}
	}

}
