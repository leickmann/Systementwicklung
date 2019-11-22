package view;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

import controller.ArtikelTextFieldController;
import model.ArtikelModelInterface;
import model.KundeModel;
import model.Observer;
import javax.swing.JTextField;


public class ArtikelTextFieldView implements Observer{

	private ArtikelTextFieldController a_controller;
	private ArtikelModelInterface a_model;
	private JFrame frame;
	private JLabel artikelbezeichnung;
	private JLabel artikelpreis;
	private JButton preisAendernBtn;
	private JTextField txtPrice;
	
	public ArtikelTextFieldView(ArtikelModelInterface artikelModelInterface){
		a_model = artikelModelInterface;
		a_model.register(this);
		a_controller = new ArtikelTextFieldController(artikelModelInterface, this);
		createComponents();
	}
	
	public void createComponents(){
		
		frame = new JFrame("Artikel");
		
		artikelbezeichnung = new JLabel("Bezeichnung: " + a_model.getBezeichnung());
		artikelpreis = new JLabel("Preis: " + a_model.getPreis() + "€");
		preisAendernBtn = new JButton("Preis \u00C4ndern");
		preisAendernBtn.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e) {
				a_controller.setPreis(Double.valueOf(txtPrice.getText()));
			}
		});
		
		frame.getContentPane().setLayout(new GridLayout(4,1));
		frame.getContentPane().add(artikelbezeichnung);
		frame.getContentPane().add(artikelpreis);
		
		txtPrice = new JTextField();
		frame.getContentPane().add(txtPrice);
		txtPrice.setColumns(10);
		frame.getContentPane().add(preisAendernBtn);
		
		frame.setSize(300, 150);
		
		frame.setVisible(true);

	}
	
	@Override
	public void update() {
		artikelpreis.setText("Preis: " + a_model.getPreis() + "€");
		artikelbezeichnung.setText("Bezeichnung: " + a_model.getBezeichnung());
		frame.setVisible(true);
	}

}
