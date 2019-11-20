package Aufgabe5;

import java.util.*;

public class ShoppingCart {
	private List<Product> productList = new ArrayList<Product>();
	private PaymentService paymentService;
	
	public ShoppingCart(String paymentType) {
		paymentService = PaymentServiceFactory.getPaymentService(paymentType);
	}
	
	public void addProductToCart(Product product) {
		productList.add(product);
	}
	
	public void buy() {
		productList.stream().forEach(paymentService::pay);
		
	}
}
