package model;

import model.Sale;
import integration.Printer;

public class Receipt {

	private Sale saleInfo;

	private Printer printer;

	public Receipt(Sale sale) {
		this.saleInfo=sale;
	}

	public Sale getSale() {
		return null;
	}

}
