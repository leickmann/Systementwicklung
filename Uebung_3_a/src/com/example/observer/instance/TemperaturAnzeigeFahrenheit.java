package com.example.observer.instance;

import java.awt.FlowLayout;

import javax.swing.JFrame;
import javax.swing.JLabel;

public class TemperaturAnzeigeFahrenheit implements IBeobachter {
	
	private JLabel tempLabel = new JLabel("Temperatur:");
	private JLabel tempValue = new JLabel("UNDEF");
	private JFrame mainWindow = new JFrame("Temperaturanzeige in Fahrenheit");
	private FlowLayout flow = new FlowLayout();
	
	
	public TemperaturAnzeigeFahrenheit()
	{
		mainWindow.getContentPane().setLayout(flow);
		mainWindow.add(tempLabel);
		mainWindow.add(tempValue);
		mainWindow.pack();
		mainWindow.setVisible(true);
		
	}

	@Override
	public void aktualisieren(ISubjekt subjekt) {
		int temp = Integer.parseInt(subjekt.gibZustand());
		double fahrenheitTemp = temp * 1.8 + 32;
		String tempText = Double.valueOf(fahrenheitTemp).toString();
		
		tempValue.setText(tempText);
	}

}
