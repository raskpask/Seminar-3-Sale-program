package integration;

import model.Amount;
import model.Sale;

public class Change {

	private double change;

	//private Sale sale;

	public Change(Amount paidAmount,Amount priceWithTaxes) {
		this.change= paidAmount.getNumber()- priceWithTaxes.getNumber();
		}

	public double getChange() {
		return this.change;
	}
}
