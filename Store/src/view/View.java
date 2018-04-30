package view;


import controller.Controller;
import integration.SaleDTO;
import model.Amount;
import model.Customer;
import model.Sale;
/**
 * Holds the all functions that the user can use and creates the controller.
 * @author molin
 *
 */
public class View {

	private Controller controller;
/**
 * initialize View and creates the controller
 */
	public View() {
		controller = new Controller(); 
	}
	
/**
 * Function for scanning a item	
 * @param itemID
 * @param quantity
 */
	public void scanItems(int itemID, int quantity) {
		System.out.println(controller.scanningItems(itemID,quantity));
		//System.out.println(sale);
	}
	/**
	 * Create a new sale
	 */
	public void newSale() {
		controller.newSale();
		
	}
	/**
	 * Makes a discount request
	 */
	public void requestDiscount() {
		Customer customer= new Customer(450);
		Sale sale= controller.discountRequest(customer);
		System.out.println(sale);
	}
	/**
	 * Finalize a sale
	 */
	public void completeSale() {
		Sale sale= controller.completeingSale();
		System.out.println(sale);
	}
	/**
	 * The command for paying money
	 * @param amountPaid
	 * @param currency
	 * @param typeOfPayment
	 */
	public void pay(double amountPaid,String currency, String typeOfPayment) {
		Amount paidAmount= new Amount(amountPaid, currency, typeOfPayment);
		Sale sale=controller.pay(paidAmount);
		System.out.println(sale);
	}
	

}
