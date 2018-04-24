package model;

public class CashRegister {
	
	private int balance;
	
	private Cash payment;
	
	public CashRegister() {
		
	}
	public void addPayment(Cash payment) {
		this.payment= payment;
	}
}
