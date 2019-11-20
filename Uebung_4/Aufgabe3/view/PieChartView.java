/*
 * Typ   : Klasse
 * Name  : PieChartView
 * Paket : view
 */
package view;

import model.*;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Toolkit;

import javax.swing.JFrame;
import javax.swing.JPanel;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map.Entry;

/**
 * Kuchendiagramm der Verteilung
 * 
 * Eine View, die ein Kuchendiagramm zu den Verteilungen der Daten
 * anzeigt. 
 * 
 * @author Vasilios Filippidis
 *
 */
public class PieChartView implements IObserverInterface
{
	private IModelInterface m_model;
	private JPanel m_viewPanel;
	private JFrame m_viewFrame;
		
	/**
	 * Erstellt eine PieChartView.
	 * 
	 * @param model Das zugehörige Daten-Model.
	 */
	public PieChartView (IModelInterface model)
	{
		createComponents();
		m_model = model;
		model.registerObserver (this);		
	}
	
	/**
	 * Initialisierungsmethode, die alle benötigten Komponenten erstellt.
	 */
	public void createComponents()
	{
		m_viewFrame = new JFrame("Pie Chart View");
		m_viewFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        m_viewPanel = new JPanel();
        
		m_viewFrame.getContentPane().add(m_viewPanel, BorderLayout.CENTER);
		m_viewFrame.setSize(300, 300);
			
		// Position setzen		
		Dimension d = Toolkit.getDefaultToolkit().getScreenSize();
		m_viewFrame.setLocation(((d.width - m_viewFrame.getSize().width) / 2) - 180,
				((d.height - m_viewFrame.getSize().height) / 2) - 180);		

		m_viewFrame.setVisible(true);
	}
	
	/* (non-Javadoc)
	 * @see model.ObserverInterface#update()
	 */
	public void update(IModelInterface model)
	{
		m_viewFrame.getContentPane().removeAll();
		double red = model.getRedPercentage();
		double green = model.getGreenPercentage();
		double blue = model.getBluePercentage();
		m_viewPanel = createChartPanel (red, green, blue);		
		m_viewFrame.getContentPane().add(m_viewPanel, BorderLayout.CENTER);
		m_viewFrame.getContentPane().validate();
	}

	/**
	 * Erstellt ein JPanel mit dem Kuchendiagramm.
	 * 
	 * @param red Prozentualer Anteil der roten Partei.
	 * @param green Prozentualer Anteil der grünen Partei.
	 * @param blue Prozentualer Anteil der blauen Partei.
	 * @return JPanel mit Kuchendiagramm.
	 */
	private JPanel createChartPanel (final double red, final double green, final double blue)
	{
        
		JPanel panel = new JPanel() {
        	
			private static final long serialVersionUID = 1L;
			
			public void paintComponent(Graphics g) 
            {            	
                super.paintComponent(g);
                
                //Optimalen Durchmesser und Position für Kuchendiagramm ermitteln
                int d = 1;
                int x = 0;
                int y = 0;
                if ( getSize().getWidth() > getSize().getHeight() )
                	d = (int)getSize().getHeight() - 10;
                else
                	d = (int)getSize().getWidth() - 10;                
                x = (int)((getSize().getWidth() - d)/2); 
                y = (int)((getSize().getHeight() - d)/2);

                //Speichere Beziehung Farbe->Wert in eine Hasmap
                HashMap<Color, Double> valueMap = new HashMap<Color, Double>();
                valueMap.put(Color.RED, red);
                valueMap.put(Color.GREEN, green);
                valueMap.put(Color.BLUE, blue);
                //Größe des Kreiswinkels, welcher schon aufgefüllt ist
                int angle = 0;
				Iterator<Entry<Color,Double>> iterator = valueMap.entrySet().iterator();
				while (iterator.hasNext())
				{
					Entry<Color, Double> entrySet= iterator.next();
					// Setze aktuelle Farbe					
					g.setColor(entrySet.getKey());
					//Letzten Wert aus Differenz aller Winkel zu 360 bilden, damit Kreis
					//immer geschlossen wird, auch bei Rundungsfehlern
					if ( iterator.hasNext() )
						g.fillArc(x, y, d, d, angle, (int)Math.round(360*entrySet.getValue()));
					else
						g.fillArc(x, y, d, d, angle, 360 - angle);
					angle += (int)Math.round(360*entrySet.getValue());					
				}
            }
        };
        
        return panel;
	}
}
