package OnlineModegeschaeft;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Lieferant {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	private String lieferantID;
	private String name;

	public Lieferant() {
	}
	
	public Lieferant(String lieferantID, String name) {
		this();
		this.name = name;
	}

	public String getLieferantID() {
		return lieferantID;
	}

	public void setLieferantID(String lieferantID) {
		this.lieferantID = lieferantID;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	
	

}
