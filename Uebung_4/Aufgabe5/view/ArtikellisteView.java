package view;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.ListSelectionModel;

import model.ArtikelModelInterface;
import model.ArtikellisteModel;
import model.Observer;
import javax.swing.JButton;
import javax.swing.SwingConstants;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class ArtikellisteView implements Observer{

	private ArtikellisteModel al_model;
	private JFrame frame = new JFrame();
	private JPanel panel = new JPanel();
	private JList liste;
	private JLabel label = new JLabel("Wählen Sie den Artikel:");
	private final JButton btnPreisndern = new JButton("Preis \u00C4ndern");
	
	
	public ArtikellisteView(ArtikellisteModel model){
		al_model = model;
		al_model.register(this);
		createComponents();
	}
	
	public void createComponents(){
		
		frame.setTitle("Artikelliste");
		frame.setSize(400, 200);
		
		panel.add(label);
		
		String[] listeString = new String[al_model.getArtikelliste().size()];
		for(int i = 0; i < al_model.getArtikelliste().size(); i++){
			listeString[i] = (al_model.getArtikelliste().get(i).getBezeichnung());
		}
		
		liste = new JList(listeString);
		liste.addMouseListener(new MouseAdapter() {
		    public void mouseClicked(MouseEvent evt) {
		        JList list = (JList)evt.getSource();
		        if (evt.getClickCount() == 2) {
		            int index = list.locationToIndex(evt.getPoint());
		    		ArtikelLableView a_view = new ArtikelLableView(al_model.getArtikelliste().get(index), al_model.getKunde());
		        } 
		    }
		});
		btnPreisndern.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				int index = liste.getLeadSelectionIndex();
				ArtikelModelInterface artikel = al_model.getArtikelliste().get(index);
				ArtikelTextFieldView tfv = new ArtikelTextFieldView(artikel);
			}
		});
		btnPreisndern.setHorizontalAlignment(SwingConstants.LEFT);
		btnPreisndern.setVerticalAlignment(SwingConstants.TOP);
		
		panel.add(btnPreisndern);
		
		panel.add(liste);
		
		frame.getContentPane().add(panel);
		frame.setVisible(true);
		
	}

	@Override
	public void update() {
		// TODO Auto-generated method stub
		
	}
	
}
