package integration;

import model.Customer;

public class CustomerCatalog {

	public Customer vaildateDiscount(Customer customer) {
		if((customer.getIDNumber())<500){
			customer.setDiscount(true);
		}
		else {
			customer.setDiscount(false);
		}
		return customer;
	}

	public CustomerCatalog() {

	}

}