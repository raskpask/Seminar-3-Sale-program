package startup;

import controller.Controller;
import integration.ExternalSystemsCreator;
import integration.Printer;
import view.View;

public class Main {
	
public static void main(String[] args) {
	//Printer printer = new Printer();
	View view = new View();
	view.newSale();
	view.scanItems(1, 1);
	view.requestDiscount();
	view.completeSale();
	view.pay(500, "SEK", "Cash");
	
	
	//ExternalSystemsCreator externalSystemsCreator= new ExternalSystemsCreator();
	
}
}
