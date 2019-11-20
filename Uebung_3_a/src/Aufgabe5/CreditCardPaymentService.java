package Aufgabe5;

public class CreditCardPaymentService implements PaymentService {

	@Override
	public void pay(Product product) {
		System.out.println("Bezahlt mit Kreditkarte.");
	}

}
