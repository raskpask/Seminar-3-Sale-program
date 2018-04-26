package model;

/**
 * Hold the information about a customer
 * @author molin
 *
 */

public class Customer {

	private int IDNumber;

	private boolean discount;
/**
 * Create a customer using a id number.
 * @param IDNumber
 */
	public Customer(int IDNumber) {
		this.IDNumber= IDNumber;
	}
/**
 * Method that return the IDNumber of the customer
 * @return
 */
	public int getIDNumber() {
		return this.IDNumber;
	}
/**
 * Method that returns if the customer has a discount or not.
 * @return
 */
	public boolean getDiscount() {
		return this.discount;
	}
/**
 * Sets the discount to true or false.
 * @param discount
 */
	public void setDiscount(boolean discount) {
		this.discount=discount;
	}

}
