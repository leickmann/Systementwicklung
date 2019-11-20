package Aufgabe6;



public class KoelnerPizzeria extends Pizzeria {

	@Override
	protected Pizza createPizza(String typ) {
		
		Pizza pizza;
		
		if (typ.equals("Salami"))
		{
			pizza = new KoelnerSalamiPizza();
		}
		else if (typ.equals("Schinken"))
		{
			pizza = new KoelnerSchinkenPizza();
		}
		else if (typ.equals("Thunfisch"))
		{
			pizza = new KoelnerThunfischPizza();
		}
		else {
			pizza = null;
		}
		return pizza;
	}

}
