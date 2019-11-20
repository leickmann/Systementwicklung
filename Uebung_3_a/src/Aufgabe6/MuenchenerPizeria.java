package Aufgabe6;


public class MuenchenerPizeria extends Pizzeria {

	@Override
	protected Pizza createPizza(String typ) {
		
		Pizza pizza;
		
		if (typ.equals("Salami"))
		{
			pizza = new MuenchenerSalamiPizza();
		}
		else if (typ.equals("Schinken"))
		{
			pizza = new MuenchenerSchinkenPizza();
		}
		else if (typ.equals("Thunfisch"))
		{
			pizza = new MuenchenerThunfischPizza();
		}
		else {
			pizza = null;
		}
		return pizza;
	}
}
