package integration;

import integration.ItemCatalogHandler;

public class ExternalSystemsCreator {

	private ExternalAccountingSystemHandler externalAccountingSystemHandler;

	private ItemCatalogHandler itemCatalogHandler;

	private ExternalInventoryHandler externalInventoryHandler;

	private CustomerCatalog customerCatalog;

	public ExternalSystemsCreator() {
		this.customerCatalog = new CustomerCatalog();
		this.externalAccountingSystemHandler = new ExternalAccountingSystemHandler();
		this.externalInventoryHandler = new ExternalInventoryHandler();
		this.itemCatalogHandler = new ItemCatalogHandler();
	}

}
