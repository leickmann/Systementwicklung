package Krieg;

public class Schadensevaluator {
	
	public int abzug(Waffe links, Waffe rechts) {
		int ergebnis = 0;
		if(links == Waffe.Messer && rechts == Waffe.Speer)
			ergebnis += 40;
		else
			ergebnis += 10;
		
		if(links == Waffe.Messer || links == Waffe.Axt)
			ergebnis += 100;
		
		if(links == rechts)
			ergebnis *= 2;
		else
			ergebnis += 10;
		
		return ergebnis;
	}
}
