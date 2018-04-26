package model;

public class CashRegister {
	
	private int balance;
	
	private Cash payment;
	
	public CashRegister() {
		
	}
	/**
	 * Adds a payment. ( in this program we will only use cash but other payment methods can be easily added here.
	 * @param payment
	 */
	public void addPayment(Cash payment) {
		this.payment= payment;
	}
}
