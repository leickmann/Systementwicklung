/*
 * Typ   : Klasse
 * Name  : TableViewController
 * Paket : controller
 */
package controller;

import model.*;
import view.*;

/**
 * Controller für eine TableView. 
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
	 * @param model Referenz auf das zugehörige Model.
	 * @param tableView Referenz auf die zugehörige TableView.
	 */
	public TableViewController (IModelInterface model, TableView tableView)
	{
		m_tableView = tableView;
		m_model = model;
	}
	
	/**
	 * Prüft die eingegebenen Werte für rot, grün und blau und übergibt
	 * sie dem Model.
	 * 
	 * @param red Wert für die rote Partei.
	 * @param green Wert für die grüne Partei.
	 * @param blue Wert für die blaue Partei.
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
