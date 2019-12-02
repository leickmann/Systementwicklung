package OnlineModegeschaeft;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.DiscriminatorColumn;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;

@Entity
@Inheritance(strategy = InheritanceType.JOINED)
@DiscriminatorColumn(name = "Disc")
@DiscriminatorValue("Artikel")
public class Artikel {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	private String bezeichnung;
	@Column(unique = true)
	private int artikelnummer;
	private String status;
	private double preis;
	@ManyToMany(cascade = CascadeType.PERSIST)
	@JoinTable(name = "Artikel_Lieferant")
	private List<Lieferant> lieferanten = new ArrayList<Lieferant>();
	@ManyToMany(cascade = CascadeType.PERSIST)
	@JoinTable(name = "Artikel_Mitarbeiter")
	private List<Mitarbeiter> mitarbeiter = new ArrayList<Mitarbeiter>();

	

	

	public Artikel() {
	}

	public Artikel(String bezeichnung, int artikelnummer) {
		this();
		this.bezeichnung = bezeichnung;
		this.artikelnummer = artikelnummer;
	}

	public String getBezeichnung() {
		return bezeichnung;
	}

	public void setBezeichnung(String bezeichnung) {
		this.bezeichnung = bezeichnung;
	}

	public int getArtikelnummer() {
		return artikelnummer;
	}

	public void setArtikelnummer(int artikelnummer) {
		this.artikelnummer = artikelnummer;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public double getPreis() {
		return preis;
	}

	public void setPreis(double preis) {
		this.preis = preis;
	}
	
	public List<Lieferant> getLieferanten() {
		return lieferanten;
	}

	public void addLieferant(Lieferant lieferant) {
		this.lieferanten.add(lieferant);
	}
	public void removeLieferant(Lieferant lieferant) {
		this.lieferanten.remove(lieferant);
	}
	
	public List<Mitarbeiter> getMitarbeiter() {
		return mitarbeiter;
	}

	public void addMitarbeiter(Mitarbeiter mitarbeiter) {
		this.mitarbeiter.add(mitarbeiter);
	}
	
	public void removeMitarbeiter(Mitarbeiter mitarbeiter) {
		this.mitarbeiter.remove(mitarbeiter);
	}

}
