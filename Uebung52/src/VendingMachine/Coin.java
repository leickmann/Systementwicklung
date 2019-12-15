package VendingMachine;

public enum Coin {
	ONEEURO, TWOEURO, FIVEEURO, TENEURO;


	public int getDenomination() {
		if(this == ONEEURO)
			return 1;
		else if(this == TWOEURO)
			return 2;
		else if(this == FIVEEURO)
			return 5;
		else if(this == TENEURO)
			return 1;
		else 
			return 0;
	}
}