package Aufgabe10;

import java.util.ArrayList;
import java.util.List;

public class ShipOwner {

	private ShipMarket market;
	private String name;
	private List<Ship> ownedShips= new ArrayList<Ship>();
	
	
	public ShipOwner(String name){
		this.name = name;
	}

	public void advertiseShipForSale(Ship ship){
		market.advertiseShipForSale(ship, this);
	}

	public String getName(){
		return this.name;
	}

	public void registerInterestForShip(Ship ship){
		market.registerInterestForShip(ship, this);
		
	}
	
	public void addShip(Ship ship) {
		ownedShips.add(ship);
	}
	
	public void delShip(Ship ship) {
		ownedShips.remove(ship);
	}
}