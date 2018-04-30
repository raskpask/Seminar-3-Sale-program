package model;

import model.Sale;
import integration.Printer;
/**
 * Handles the infomation abount a completed sale.
 * @author molin
 *
 */
public class Receipt {

	private Sale saleInfo;

	private Printer printer;
/**
 * Constructor of the class
 * @param sale
 */
	public Receipt(Sale sale) {
		this.saleInfo=sale;
	}
/**
 * Returns the sale of the receipt.
 * @return
 */
	public Sale getSale() {
		return this.saleInfo;
	}

}
