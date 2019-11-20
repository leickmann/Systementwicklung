package Aufgabe10;


import java.util.HashMap;
import java.util.Map;


public class ShipMarket {

	private static ShipMarket instance;
	private Map<Ship, ShipOwner> ships = new HashMap<Ship, ShipOwner>();
	private Map<Ship, ShipOwner> shipsOfInterest = new HashMap<Ship, ShipOwner>();


	private ShipMarket(){
		System.out.println("ShipMarket erzeugt");

	}


	public void advertiseShipForSale(Ship ship, ShipOwner shipOwner){
		ships.put(ship, shipOwner);
	}


	public void completeTransfer(Ship ship, ShipOwner oldShipOwner, ShipOwner newShipOwner){
		shipsOfInterest.remove(ship);
		oldShipOwner.delShip(ship);
		newShipOwner.addShip(ship);
	}

	public static synchronized ShipMarket getInstance(){
		if (instance == null) {
			instance = new ShipMarket();
		}
		return instance;
	}


	public void registerInterestForShip(Ship ship, ShipOwner shipOwner){
		shipsOfInterest.put(ship, shipOwner);
	}
}