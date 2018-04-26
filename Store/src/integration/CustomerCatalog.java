package integration;

import model.Customer;
/**
 * External database that handles the customers and tells the program if a customer should have a discount.
 * @author molin
 *
 */
public class CustomerCatalog {
	
	public CustomerCatalog() {

	}
/**
 * Checks if the customer has IDNumber under 500 and gives a discount that is true.
 * @param customer
 * @return
 */
	public Customer vaildateDiscount(Customer customer) {
		if((customer.getIDNumber())<500){
			customer.setDiscount(true);
		}
		else {
			customer.setDiscount(false);
		}
		return customer;
	}

	

}