package view;


import controller.Controller;
import integration.SaleDTO;
import model.Sale;

public class View {

	private Controller controller;

	public View() {
		controller = new Controller();
	}
	
	public void scanItems() {
		Sale sale =controller.scanningItems(1,1);
	}


}
