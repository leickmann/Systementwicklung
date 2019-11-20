package Aufgabe5;

public class PaymentServiceFactory {

	public static PaymentService getPaymentService(String type) {
		
		PaymentService paymentService;
		
		if (type.equalsIgnoreCase("CASH")) {
			paymentService = new CashPaymentService();
		}
		else if(type.equalsIgnoreCase("CREDIDCARD")){
			paymentService = new CashPaymentService();
		}
		else {
			throw new RuntimeException("kein PaymentService für" + type + "vorhanden.");
		}
		return paymentService;
	}
}
