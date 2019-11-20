package Aufgabe9;

public class Accessoir extends Artikel {
	private String material;
	private String gewicht;

	public Accessoir(int aNr, String bez, double pr, String material, String gewicht) {
		super(aNr, bez, pr);
		this.material = material;
		this.gewicht = gewicht;
	}

	public String getMaterial() {
		return material;
	}

	public void setMaterial(String material) {
		this.material = material;
	}

	public String getGewicht() {
		return gewicht;
	}

	public void setGewicht(String gewicht) {
		this.gewicht = gewicht;
	}

}
