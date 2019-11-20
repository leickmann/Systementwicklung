package Aufgabe6;


public class BerlinerPizzeria extends Pizzeria {

	@Override
	protected Pizza createPizza(String typ) {
		Pizza pizza;
		
		if (typ.equals("Salami"))
		{
			pizza = new BerlinerSalamiPizza();
		}
		else if (typ.equals("Schinken"))
		{
			pizza = new BerlinerSchinkenPizza();
		}
		else if (typ.equals("Thunfisch"))
		{
			pizza = new BerlinerThunfischPizza();
		}
		else {
			pizza = null;
		}
		return pizza;
	}

}
