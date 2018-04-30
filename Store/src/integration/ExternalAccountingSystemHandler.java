package integration;

import integration.SaleDTO;
import model.Sale;
/**
 * Communicates with a external system that stores all the sales when the are completed.
 * @author molin
 *
 */

public class ExternalAccountingSystemHandler {

	public ExternalAccountingSystemHandler() {
	}
/**
 * Stores the sale in external database
 * @param sale
 */
	public void storeSale(Sale sale) {
		// some code for storeing a sale in database
	}

}
