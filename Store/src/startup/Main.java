package startup;

import controller.Controller;
import integration.ExternalSystemsCreator;
import integration.Printer;
import view.View;
/**
 * Mains class that is run when the system is started.
 * @author molin
 *
 */
public class Main {
	/**
	 * Main functions that creates view and uses hard coded commands.
	 * @throws ItemNotFoundException 
	 */
public static void main(String[] args) throws Exceptions.ItemNotFoundException {
	//Printer printer = new Printer();
	View view = new View();
	view.newSale();
	view.scanItems(1, 1);
	view.requestDiscount();
	view.scanItems(2, 2);
	view.scanItems(1,3);
	view.completeSale();
	view.pay(500, "SEK", "Cash"); 
	
	
	//ExternalSystemsCreator externalSystemsCreator= new ExternalSystemsCreator();
	
}
}
