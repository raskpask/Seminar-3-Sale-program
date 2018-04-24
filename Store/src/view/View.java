package view;


import controller.Controller;
import integration.SaleDTO;
import model.Amount;
import model.Customer;
import model.Sale;

public class View {

	private Controller controller;

	public View() {
		controller = new Controller();
	}
	
	public void scanItems() {
		Sale sale=controller.scanningItems(1,1);
	}
	public void newSale() {
		controller.newSale();
	}
	public void requestDiscount() {
		Customer customer= new Customer(450);
		Sale sale= controller.discountRequest(customer);
	}
	public void completeSale() {
		Sale sale= controller.completeingSale();
	}
	public void pay(double amountPaid,String currency, String typeOfPayment) {
		Amount paidAmount= new Amount(amountPaid, currency, typeOfPayment);
		Sale sale=controller.pay(paidAmount);
	}

}
