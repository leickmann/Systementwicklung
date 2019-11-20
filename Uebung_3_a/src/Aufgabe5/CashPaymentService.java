package Aufgabe5;

public class CashPaymentService implements PaymentService {

	@Override
	public void pay(Product product) {
		System.out.println("Bezahlt mit Bargeld.");
	}

}
