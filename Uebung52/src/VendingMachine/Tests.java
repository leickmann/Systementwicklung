package VendingMachine;

import java.util.ArrayList;

import org.junit.*;
import org.mockito.*;




public class Tests {
	
	@Test
	public void simpleCashTest() throws Exception {
		
		
		CashBox cashBox = new SimpleCashBox();
		ArrayList<Box> boxes = new ArrayList<Box>();
		boxes.add(new FullBox());
		
		Display display = new DisplayImpl();
		
		VendingMachineImpl machine = new VendingMachineImpl(cashBox, boxes, display);
		
		machine.insertCoin(Coin.ONEEURO);
		
		Assert.assertEquals("Ein Euro Test", machine.getAmount(), Coin.ONEEURO.getDenomination(), 0.1);
	}
	
	
	@Test
	public void simpleCashTestmitMockito() throws Exception {
		
		CashBox cashBox = Mockito.mock(CashBox.class);
		Mockito.when(cashBox.getCurrentAmount()).thenReturn(Coin.ONEEURO.getDenomination());
		
		Box box = Mockito.mock(Box.class);
		ArrayList<Box> boxes = new ArrayList<Box>();
		boxes.add(box);
		
		Display display = Mockito.mock(Display.class);
		
		
		VendingMachineImpl machine = new VendingMachineImpl(cashBox, boxes, display);
		
		machine.insertCoin(Coin.ONEEURO);
		
		Assert.assertEquals("Ein Euro Test", machine.getAmount(), Coin.ONEEURO.getDenomination(), 0.1);
		
		Mockito.verify(cashBox).insertCoin(Matchers.eq(Coin.ONEEURO));
		Mockito.verify(cashBox).getCurrentAmount();
	}
	
	@Test
	public void fullTest() {
		
		CashBox cashBox = new SimpleCashBox();
		ArrayList<Box> boxes = new ArrayList<Box>();
		boxes.add(new FullBox());
		
		Display display = new DisplayImpl();
		
		VendingMachineImpl machine = new VendingMachineImpl(cashBox, boxes, display);
		
		machine.insertCoin(Coin.TWOEURO);
		Assert.assertEquals("Ein Euro Test", machine.getAmount(), Coin.TWOEURO.getDenomination());
		machine.selectItem(1);
		machine.pressReleaseButton();
		System.out.println(machine.getAmount());
		Assert.assertEquals("Null Euro Test", machine.getAmount(),0);
	}
	
	@Test
	public void fullTestmitMockito() throws Exception {
		
		CashBox cashBox = Mockito.mock(CashBox.class);
		Mockito.when(cashBox.getCurrentAmount()).thenReturn(Coin.TWOEURO.getDenomination());
		
		Box box = Mockito.mock(Box.class);
		Mockito.when(box.getPrice()).thenReturn(2);
		ArrayList<Box> boxes = new ArrayList<Box>();
		boxes.add(box);
		
		Display display = Mockito.mock(Display.class);
		
		
		VendingMachineImpl machine = new VendingMachineImpl(cashBox, boxes, display);
		
		machine.insertCoin(Coin.TWOEURO);
		Assert.assertEquals("Zwei Euro Test", machine.getAmount(), Coin.TWOEURO.getDenomination());
		machine.selectItem(1);
		machine.pressReleaseButton();
		
		
		Mockito.verify(cashBox).insertCoin(Matchers.eq(Coin.TWOEURO));
		Mockito.verify(cashBox, Mockito.times(2)).getCurrentAmount();
		Mockito.verify(box, Mockito.times(2)).getPrice();
		Mockito.verify(box).releaseItem();
	}
	
	
}
