package view;


import controller.Controller;
import model.Amount;
import model.Customer;
import model.DatabaseNotFound;
import model.ItemNotFoundException;
import model.Sale;
import model.SaleDTO;
import model.SaleObserver;
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
 * @throws ItemNotFoundException 
 * @throws DatabaseNotFound 
 */
	public void scanItems(int itemID, int quantity) throws model.ItemNotFoundException, DatabaseNotFound {
		try{
		System.out.println(controller.scanningItems(itemID,quantity)); 
		}
	 catch(ItemNotFoundException nullItem) {
		view.ErrorMessageHandler.showErrorMessage(nullItem.getMessage());
		view.ErrorLogHandler.makeLogMessage((String) nullItem.getStackTrace().toString());
	} catch(DatabaseNotFound e) {
		view.ErrorMessageHandler.showErrorMessage(e.getMessage());
		view.ErrorLogHandler.makeLogMessage(e.getStackTrace().toString());
	}
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
		model.SaleDTO sale= controller.discountRequest(customer);
		System.out.println(sale);
	}
	/**
	 * Finalize a sale
	 */
	public void completeSale() {
		model.SaleDTO sale= controller.completeingSale();
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
		model.SaleDTO sale=controller.pay(paidAmount);
		System.out.println(sale);
	}
	

}
