package integration;

/**
 * Change is a class that handles the change of the sale.
 */
import model.Amount;
import model.Sale;

public class Change {

	private double change;

	
/**
 * Constructor for Change
 * @param paidAmount
 * @param priceWithTaxes
 */
	public Change(Amount paidAmount,Amount priceWithTaxes) {
		this.change= ((double) paidAmount.getNumber()-(double) priceWithTaxes.getNumber());
		}
/**
 * Returns the change
 * @return
 */
	public double getChange() {
		return this.change;
	}
/**
 * Functions that compares the Change objects  
 */
	@Override
	public boolean equals(Object obj) {
		Change other= (Change) obj;
		return this.change == other.getChange();
	}
	
}
