package Aufgabe8;

public class TestFassade {

	public static void main(String[] args) {
		HeimkinoFassade fassade = new HeimkinoFassade();
		
		try {
			fassade.heimkinoEin();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

}
