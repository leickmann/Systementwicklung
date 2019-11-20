/*
 * Typ   : Klasse
 * Name  : BarChartView
 * Paket : view
 */
package view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Toolkit;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map.Entry;
import javax.swing.JFrame;
import javax.swing.JPanel;

import model.IModelInterface;
import model.IObserverInterface;

/**
 * Balkendiagramm der Verteilung
 * 
 * Eine View, die ein Balkendiagramm zu den Verteilungen der Daten
 * anzeigt.
 * 
 * @author Vasilios Filippidis
 * 
 */
public class BarChartView implements IObserverInterface
{
	IModelInterface m_model;
	JFrame m_viewFrame;
	JPanel m_viewPanel;

	/**
	 * Erstellt eine BarChartView.
	 * 
	 * @param model Das zugehörige Daten-Model.
	 */
	public BarChartView(IModelInterface model)
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
		m_viewFrame = new JFrame("Bar Chart View");
		m_viewFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		m_viewPanel = new JPanel();

		m_viewFrame.getContentPane().add(m_viewPanel, BorderLayout.CENTER);
		m_viewFrame.setSize(300, 300);

		// Position setzen
		Dimension d = Toolkit.getDefaultToolkit().getScreenSize();
		m_viewFrame.setLocation(
				((d.width - m_viewFrame.getSize().width) / 2) + 180,
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
	 * Erstellt ein JPanel mit dem Balkendiagramm.
	 * 
	 * @param red Prozentualer Anteil der roten Partei.
	 * @param green Prozentualer Anteil der grünen Partei.
	 * @param blue Prozentualer Anteil der blauen Partei.
	 * @return JPanel mit Balkendiagramm.
	 */
	private JPanel createChartPanel (final double red, final double green,
			final double blue)
	{

		JPanel panel = new JPanel()
		{			
			private static final long serialVersionUID = 1L;

			public void paintComponent(Graphics g)
			{
				super.paintComponent(g);

				// Optimalen Position für Balkendiagramm ermittleln
				// Balkenbreite
				int width = 50;
				int space = 5;
				int x = 0;
				int y = 0;
				x = (int) ((getSize().getWidth() - 3 * width  - 2 * space) / 2);
				y = (int) (getSize().getHeight()-10);
				
				// Speichere Beziehung Farbe->Wert in eine Hasmap
				HashMap<Color, Double> valueMap = new HashMap<Color, Double>();
				valueMap.put(Color.RED, red);
				valueMap.put(Color.GREEN, green);
				valueMap.put(Color.BLUE, blue);

				// Anfangs-x-Wert des Balkendiagramms
				int dx = 0;

				Iterator<Entry<Color,Double>> iterator = valueMap.entrySet().iterator();
				while (iterator.hasNext())
				{
					Entry<Color, Double> entrySet= iterator.next();
					// Setze aktuelle Farbe					
					g.setColor(entrySet.getKey());
					g.fillRect(dx + x, y + 10 - (int)Math.round(y * entrySet.getValue()), width, y + 10);
					dx += width + space;					
				}
				
				g.setColor(Color.BLACK);
				// Kleines Koordinatensystem zeichnen zur Übersicht
				g.drawLine(3, y+10, 3, 10);
				g.drawLine(4, y+10, 4, 10);
				g.drawLine(5, (y+10)/2, 9, (y+10)/2);
				g.drawLine(5, 10, 9, 10);		
			}
		};

		return panel;
	}

}
