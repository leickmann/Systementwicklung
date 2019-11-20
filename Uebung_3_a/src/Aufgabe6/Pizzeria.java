package Aufgabe6;

public abstract class Pizzeria {
	
	public Pizzeria()
	{
		
	}
	
	public Pizza bestellePizza(String typ)
	{
		Pizza pizza = null;
		
		pizza = createPizza(typ);
		
		
		pizza.vorbereiten();
		pizza.backen();
		pizza.schneiden();
		pizza.verpacken();
		return pizza;
	}
	
	protected abstract Pizza createPizza(String typ);

}
