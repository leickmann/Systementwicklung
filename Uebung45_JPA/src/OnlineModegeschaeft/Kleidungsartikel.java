package OnlineModegeschaeft;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue("Kleidungsartikel")
public class Kleidungsartikel extends Artikel {

	private String material;

	public Kleidungsartikel() {
		super();
	}

	public Kleidungsartikel(String bezeichnung, int artikelnummer, String material) {
		super(bezeichnung, artikelnummer);
		this.material = material;
	}

	public String getMaterial() {
		return material;
	}

	public void setMaterial(String material) {
		this.material = material;
	}
	
	
}
