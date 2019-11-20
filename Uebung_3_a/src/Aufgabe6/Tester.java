package Aufgabe6;

public class Tester {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		
		Pizzeria berlinerPizzeria = new BerlinerPizzeria();
		Pizza erstePizza =  berlinerPizzeria.bestellePizza("Salami");
		
		Pizza zweitePizza =  berlinerPizzeria.bestellePizza("Thunfisch");
		
		Pizzeria koelnerPizzeria = new KoelnerPizzeria();
		Pizza drittePizza =  koelnerPizzeria.bestellePizza("Salami");
		
		
	}

}
