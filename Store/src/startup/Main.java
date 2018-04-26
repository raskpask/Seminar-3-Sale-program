package startup;

import controller.Controller;
import integration.ExternalSystemsCreator;
import integration.Printer;
import view.View;

public class Main {
	/**
	 * Main functions that creates view and uses hard coded commands.
	 */
public static void main(String[] args) {
	//Printer printer = new Printer();
	View view = new View();
	view.newSale();
	view.scanItems(1, 1);
	view.requestDiscount();
	view.scanItems(3, 2);
	view.completeSale();
	view.pay(500, "SEK", "Cash");
	
	
	//ExternalSystemsCreator externalSystemsCreator= new ExternalSystemsCreator();
	
}
}
