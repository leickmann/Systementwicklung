package VendingMachine;

public class FullBox implements Box {

	@Override
	public boolean isEmpty() {
		return false;
	}

	@Override
	public int getPrice() {
		return 2;
	}

	@Override
	public void releaseItem() {
		System.out.println("Item ausgeworfen!");
	}

}
