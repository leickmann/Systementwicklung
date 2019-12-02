package OnlineModegeschaeft;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue("Schuhartikel")
public class Schuhartikel extends Artikel {

	private String schuhart;
	private String obermaterial;
	private String innenmaterial;
	private String Sohlenmaterial;

	public Schuhartikel() {
		super();
	}

	public Schuhartikel(String bezeichnung, int artikelnummer, String schuhart) {
		super(bezeichnung, artikelnummer);
		this.schuhart = schuhart;
	}

	public String getSchuhart() {
		return schuhart;
	}

	public void setSchuhart(String schuhart) {
		this.schuhart = schuhart;
	}

	public String getObermaterial() {
		return obermaterial;
	}

	public void setObermaterial(String obermaterial) {
		this.obermaterial = obermaterial;
	}

	public String getInnenmaterial() {
		return innenmaterial;
	}

	public void setInnenmaterial(String innenmaterial) {
		this.innenmaterial = innenmaterial;
	}

	public String getSohlenmaterial() {
		return Sohlenmaterial;
	}

	public void setSohlenmaterial(String sohlenmaterial) {
		Sohlenmaterial = sohlenmaterial;
	}

}
