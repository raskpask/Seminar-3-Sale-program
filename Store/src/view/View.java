package view;


import controller.Controller;
import integration.SaleDTO;
import model.Customer;
import model.Sale;

public class View {

	private Controller controller;

	public View() {
		controller = new Controller();
	}
	
	public void scanItems() {
		controller.scanningItems(1,1);
	}
	public void newSale() {
		controller.newSale();
	}
	public void requestDiscount() {
		Customer customer= new Customer(450);
		controller.discountRequest(customer);
	}

}
