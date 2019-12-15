package VendingMachine;

public interface CashBox {
	public int getCurrentAmount();
	public void withdraw(int i);
	public void insertCoin(Coin c);
}
