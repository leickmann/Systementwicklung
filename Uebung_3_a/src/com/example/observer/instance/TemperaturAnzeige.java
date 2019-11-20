package com.example.observer.instance;

import java.awt.FlowLayout;

import javax.swing.JFrame;
import javax.swing.JLabel;

public class TemperaturAnzeige implements IBeobachter {
	private JLabel tempLabel = new JLabel("Temperatur:");
	private JLabel tempValue = new JLabel("UNDEF");
	private JFrame mainWindow = new JFrame("Temperaturanzeige");
	private FlowLayout flow = new FlowLayout();
	
	
	public TemperaturAnzeige()
	{
		mainWindow.getContentPane().setLayout(flow);
		mainWindow.add(tempLabel);
		mainWindow.add(tempValue);
		mainWindow.pack();
		mainWindow.setVisible(true);
		
	}

	@Override
	public void aktualisieren(ISubjekt subjekt) {
		String tempText = subjekt.gibZustand();
		tempValue.setText(tempText);
	}

}
