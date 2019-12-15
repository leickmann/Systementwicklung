package VendingMachine;

import java.util.List;

public interface VendingMachine {

	public void selectItem(int item);
	public void insertCoin(Coin coin);
	public int getAmount();
	public void pressReleaseButton();
	
}
