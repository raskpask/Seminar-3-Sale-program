package integration;

import model.Amount;
import model.Sale;

public class Change {

	private double change;

	//private Sale sale;

	public Change(Amount paidAmount,Amount priceWithTaxes) {
		this.change= ((double) paidAmount.getNumber()-(double) priceWithTaxes.getNumber());
		}

	public double getChange() {
		return this.change;
	}

	@Override
	public boolean equals(Object obj) {
		Change other= (Change) obj;
		return this.change == other.getChange();
	}
	
}
