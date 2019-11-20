package Aufgabe8;

public class Verstaerker {

	public void ein() {
		System.out.println("Verstärker eingeschaltet");
	}
	
	public void aus() {
		System.out.println("Verstärker ausgeschaltet");
	}
	
	public void setCd() {
		System.out.println("Verstärker auf Quelle CD gesetzt");
	}
	
	public void setDvd() {
		System.out.println("Verstärker auf Quelle DVD gesetz");
	}
	
	public void setStereoSound() {
		System.out.println("Verstärker auf Stereo Sound gesetz");
	}
	
	public void setSurroundSound() {
		System.out.println("Verstärker auf Surround Stereo gesetz");
	}
	
	public void setTuner() {
		System.out.println("Verstärker auf Quelle Tuner gesetz");
	}
	
	public void setLautstärke(int lautstärke) {
		if (lautstärke >= 0 && lautstärke <= 10) {
			System.out.println("Verstärker Lautstärke gesetz auf: " + lautstärke);
		}
		else {
			System.out.println("Ungültige Lautstärke");
		}
	}

}
