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

	@Override
	public boolean equals(Object obj) {
		Amount other = (Amount) obj;
		return this.number == other.getNumber() &&
				this.currency.equals(other.currency) &&
				this.typeOfPayment.equals(other.typeOfPayment);
	}
	
	

}
