package integration;

import integration.ItemCatalogHandler;
/**
 * Creates the classes that handles the external databases
 * @author molin
 *
 */
public class ExternalSystemsCreator {

	private ExternalAccountingSystemHandler externalAccountingSystemHandler;

	private ItemCatalogHandler itemCatalogHandler;

	private ExternalInventoryHandler externalInventoryHandler;

	private CustomerCatalog customerCatalog;
/**
 * Constructor classes
 */
	public ExternalSystemsCreator() {
		this.customerCatalog = new CustomerCatalog();
		this.externalAccountingSystemHandler = new ExternalAccountingSystemHandler();
		this.externalInventoryHandler = new ExternalInventoryHandler();
		this.itemCatalogHandler = new ItemCatalogHandler();
	}

}
