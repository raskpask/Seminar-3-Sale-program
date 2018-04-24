package model;



public class Customer {

	private int IDNumber;

	private boolean discount;

	public Customer(int IDNumber) {
		this.IDNumber= IDNumber;
	}

	public int getIDNumber() {
		return this.IDNumber;
	}

	public boolean getDiscount() {
		return this.discount;
	}
	public void setDiscount(boolean discount) {
		this.discount=discount;
	}

}
