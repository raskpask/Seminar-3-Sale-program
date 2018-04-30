package model;
/**
 * Contains information of an amount. This class has the information:
 * value, currency and type of payment.
 * @author molin
 *
 */
public class Amount {

	private double number;

	private String currency;

	private String typeOfPayment;
/**
 * Constructor of the class.
 * @param number
 * @param currency
 * @param typeOfPayment
 */
	public Amount(double number, String currency, String typeOfPayment) {
		this.number = number;
		this.currency = currency;
		this.typeOfPayment = typeOfPayment;
	}
/**
 * Returns the number
 * @return
 */
	public double getNumber() {
		return this.number;
	}
/**
 * Returns the currency
 * @return
 */
	public String getCurrency() {
		return this.currency;
	}
/**
 * Returns the type of payment
 * @return
 */
	public String getTypeOfPayment() {
		return this.typeOfPayment;
	}
/**
 * Sets the value of the amount.
 * @param number
 */
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
/**
 * Define when two Amounts are the same.
 */
	@Override
	public boolean equals(Object obj) {
		Amount other = (Amount) obj;
		return this.number == other.getNumber() &&
				this.currency.equals(other.currency) &&
				this.typeOfPayment.equals(other.typeOfPayment);
	}
	
	

}
