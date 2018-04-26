package model;

public class Amount {

	private double number;

	private String currency;

	private String typeOfPayment;

	public Amount(double number, String currency, String typeOfPayment) {
		this.number = number;
		this.currency = currency;
		this.typeOfPayment = typeOfPayment;
	}

	public double getNumber() {
		return this.number;
	}

	public String getCurrency() {
		return null;
	}

	public String getTypeOfPayment() {
		return null;
	}
	public void setNumber(double number) {
		this.number= number;
	}
	/*
	 * prints the values of Amount, for debug
	 */
	public String toString() {
		String str = "Number : "+ this.number;
		return str;
	}

}
