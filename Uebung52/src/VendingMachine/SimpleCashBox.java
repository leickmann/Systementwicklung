package VendingMachine;

public class SimpleCashBox implements CashBox{

	int amount;
	
	public SimpleCashBox() {
		amount = 0;
	}
	
	@Override
	public int getCurrentAmount() {
		return amount;
	}

	@Override
	public void withdraw(int amountRequired) {
		amount -= amountRequired;
		
	}

	@Override
	public void insertCoin(Coin coin) {
		amount += coin.getDenomination();
		
	}

}
