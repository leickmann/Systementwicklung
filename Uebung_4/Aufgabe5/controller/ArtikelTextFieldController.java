package controller;

import model.ArtikelModelInterface;
import model.KundeModel;
import view.ArtikelTextFieldView;

public class ArtikelTextFieldController implements ArtikelControllerInterface {
	
	private ArtikelModelInterface a_model;
	private ArtikelTextFieldView a_view;
	
	public ArtikelTextFieldController (ArtikelModelInterface model, ArtikelTextFieldView view){
		this.a_model = model;
		this.a_view = view;
	}
	
	public void setPreis(double preis) {
		a_model.setPreis(preis);
	}
	
}
