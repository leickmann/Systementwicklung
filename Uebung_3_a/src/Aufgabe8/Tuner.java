package Aufgabe8;

public class Tuner {
	public void ein() {
		System.out.println("Tuner eingeschaltet");
	}
	
	public void aus() {
		System.out.println("Tuner ausgeschaltet");
	}
	
	public void setAM() {
		System.out.println("Tuner auf AM umgeschaltet");
	}
		
	public void setFM() {
		System.out.println("Tuner auf FM umgeschaltet");
	}
	
	public void setKanal(int kanal) {
		System.out.println("Tuner Kanal gesetz auf: " + kanal);
	}
}
