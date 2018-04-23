package view;


import controller.Controller;
import integration.SaleDTO;

public class View {

	private Controller controller;

	public View(Controller contr) {
		SaleDTO sale =Controller.scanningItems(1,1);
	}


}
