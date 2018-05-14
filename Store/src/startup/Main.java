package startup;

import Exceptions.DatabaseNotFound;
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
	 * @throws DatabaseNotFound 
	 */
public static void main(String[] args) throws Exceptions.ItemNotFoundException, DatabaseNotFound {
	//Printer printer = new Printer();
	View view = new View();
	view.newSale();
	view.scanItems(1, 1);
	view.requestDiscount();
	view.scanItems(8, 2);
	view.scanItems(600,3);
	view.scanItems(2,3);
	view.completeSale();
	view.pay(500, "SEK", "Cash"); 
	
	
	//ExternalSystemsCreator externalSystemsCreator= new ExternalSystemsCreator();
	
}
}
