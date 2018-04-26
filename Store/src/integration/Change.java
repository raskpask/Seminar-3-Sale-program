package integration;

import model.Amount;
import model.Sale;

public class Change {

	private double change;

	//private Sale sale;

	public Change(Amount paidAmount,Amount priceWithTaxes) {
		//double paid = paidAmount.getNumber();
		//double price = priceWithTaxes.getNumber();
		//this.change= paid-price;
		this.change= ((double) paidAmount.getNumber()-(double) priceWithTaxes.getNumber());
		}

	public double getChange() {
		return this.change;
	}
}
