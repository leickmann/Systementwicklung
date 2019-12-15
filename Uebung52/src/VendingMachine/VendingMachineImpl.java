package VendingMachine;

import java.util.List;

public class VendingMachineImpl implements VendingMachine {
	private CashBox cashBox = null;
	private List<Box> boxes = null;
	private Display display = null;
	private int selectedItem = 0;
	
	public VendingMachineImpl(CashBox cashBox, List<Box> boxes, Display display) {
			this.cashBox = cashBox;
			this.boxes = boxes;
			this.display = display;
	}

	@Override
	public void selectItem(int item) {
		this.selectedItem = item;
	}

	@Override
	public void insertCoin(Coin coin) {
		cashBox.insertCoin(coin);
	}

	@Override
	public int getAmount() {
		return cashBox.getCurrentAmount();
	}
	
	public void pressReleaseButton() {
		if (selectedItem == 0)
			return;
		Box box = boxes.get(selectedItem-1);
		if(cashBox.getCurrentAmount() >= box.getPrice()) {
			cashBox.withdraw(box.getPrice());
			box.releaseItem();
		}
		else
			display.showMessage("Guthaben nicht ausreichend");
		
		
	}

}
