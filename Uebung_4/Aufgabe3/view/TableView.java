/*
 * Typ   : Klasse
 * Name  : TableView
 * Paket : view
 */
package view; 

import controller.*;
import model.*;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Label;
import java.awt.Toolkit;
import java.awt.event.*;

import javax.swing.*;

/**
 * Tabellarische Ansicht der Daten
 * 
 * Eine View, die die Daten des Models als Tabelle darstellt
 * und Änderungen an die Sitzplatzanzahl der jeweiligen Partei
 * in Form einer Benutzereingabe entgegennehmen kann.
 * 
 * @author Vasilios Filippidis
 *
 */
public class TableView implements IObserverInterface
{
	private IControllerInterface m_controller;
	private IModelInterface m_model;
	
	final String m_aboutText = "Model-View-Controller Example\n(c) Vasilios Filippidis";
	
	JFrame m_viewFrame;
	JPanel m_viewPanel;
	JMenuBar m_menuBar;
	JMenu m_fileMenu;	
	JMenu m_helpMenu;
	JMenuItem m_exitMenuItem;
	JMenuItem m_aboutMenuItem;
	JTextField m_redTextField;
	JTextField m_greenTextField;
	JTextField m_blueTextField;
	JButton m_setButton;
	JLabel m_errorLabel;
	
	/**
	 * Erstellt ein TableView Objekt.
	 * 
	 * @param model Das zugehörige Daten-Model.
	 */
	public TableView (IModelInterface model)
	{		
		createComponents();
		m_model = model;
		model.registerObserver (this);
		m_controller = new TableViewController (model, this);
	}
	
	/**
	 * Initialisierungsmethode, die alle benötigten Komponenten erstellt.
	 *  
	 */
	public void createComponents()
	{                      
		m_viewFrame = new JFrame("Tabel View");		
		m_viewFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		m_menuBar = new JMenuBar();						
		m_viewFrame.setJMenuBar(m_menuBar);
				
		m_fileMenu = new JMenu("File");
		m_fileMenu.getPopupMenu().setLightWeightPopupEnabled(false);
		m_exitMenuItem = new JMenuItem("Exit");
		m_fileMenu.add(m_exitMenuItem);
		
		m_helpMenu = new JMenu("Help");
		m_helpMenu.getPopupMenu().setLightWeightPopupEnabled(false);
		m_aboutMenuItem = new JMenuItem("About");
		m_helpMenu.add(m_aboutMenuItem);
		
		m_menuBar.add(m_fileMenu);
		m_menuBar.add(m_helpMenu);
		
		m_exitMenuItem.addActionListener(new ActionListener(){
		
			public void actionPerformed(ActionEvent e)
			{
				//Anwendung beenden
				System.exit(0);
			}			
		});

		m_aboutMenuItem.addActionListener(new ActionListener(){

			public void actionPerformed(ActionEvent e)
			{
				//About Meldung zeigen
				JOptionPane.showMessageDialog(null, m_aboutText, "About",
						JOptionPane.INFORMATION_MESSAGE);
			}			
		});
										

		JPanel northPanel = new JPanel(new BorderLayout());
		m_viewFrame.getContentPane().add(northPanel,BorderLayout.NORTH);
		
		Box b1 = Box.createVerticalBox();
		Box b2 = Box.createVerticalBox();
		
		b1.add(new Label(""));
		b2.add(new Label("Seats",Label.CENTER));
		
				
		b1.add(new Label("Red: ", Label.RIGHT));
		m_redTextField = new JTextField();
		m_redTextField.setHorizontalAlignment(JTextField.CENTER);
		b2.add(m_redTextField);

		b1.add(new Label("Green: ", Label.RIGHT));
		m_greenTextField = new JTextField();
		m_greenTextField.setHorizontalAlignment(JTextField.CENTER);
		b2.add(m_greenTextField);

		b1.add(new Label("Blue: ", Label.RIGHT));
		m_blueTextField = new JTextField();
		m_blueTextField.setHorizontalAlignment(JTextField.CENTER);
		b2.add(m_blueTextField);

		northPanel.add(b1,BorderLayout.WEST);
		northPanel.add(b2,BorderLayout.CENTER);
		m_errorLabel = new JLabel("",JLabel.CENTER);
		northPanel.add(m_errorLabel, BorderLayout.SOUTH);
		
		m_setButton = new JButton ("Set");
		m_setButton.addActionListener (new ActionListener(){

			public void actionPerformed (ActionEvent e)
			{
				m_controller.setValues (m_redTextField.getText(), m_greenTextField.getText(), m_blueTextField.getText());
			}			
		});
		
		JPanel buttonPanel = new JPanel();
		m_viewFrame.getContentPane().add(buttonPanel,BorderLayout.SOUTH);		
		buttonPanel.add(m_setButton);
				
		// Position setzen
		Dimension d = Toolkit.getDefaultToolkit().getScreenSize();
		m_viewFrame.setLocation((d.width - m_viewFrame.getSize().width) / 2,
				(d.height - m_viewFrame.getSize().height) / 2);
		
	
		m_viewFrame.setSize(200, 200);
		
		// JFrame anzeigen
		m_viewFrame.setVisible(true);		
	}
	
	/**
	 * Callback-Methode für den Controller, womit ein
	 * Fehlertext präsentiert angezeigt werden kann.
	 * 
	 * @param text Error Text der ausgegeben werden soll.
	 */
	public void setError(String text)
	{
		m_errorLabel.setText(text);
	}

	/**
	 * Callback-Methode für den Controller, womit ein
	 * Fehlertext wieder zurückgesetzt wird.
	 * 
	 */
	public void clearError()
	{
		m_errorLabel.setText("");
	}
	
	/* (non-Javadoc)
	 * @see model.ObserverInterface#update()
	 */
	public void update(IModelInterface model)
	{		
	    // Weil das Model nur über die TableView geändert werden 
		// kann, sind beim Update keine Anweisungen notwendig
	}

}
