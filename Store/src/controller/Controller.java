package controller;


import integration.Change;
import integration.CustomerCatalog;
import integration.ExternaInventoryHandler;
import integration.ExternalAccountingSystemHandler;
import integration.Item;
import integration.ItemCatalogHandler;
import integration.Printer;
import integration.SaleDTO;
import model.Amount;
import model.CashPayment;
import model.CashRegister;
import model.Customer;
import model.CustomerDTO;
import model.Sale;


public class Controller {

	private ExternaInventoryHandler externalInventoryHandler;

	private Sale sale;
	
	private Printer printer;
	
	private Controller controller;

	//private SaleDTO saleDTO;

	private CashRegister cashRegister;

	private Item item;

	private ItemCatalogHandler itemCatalogHandler;

	private CustomerDTO customerDTO;

	private CashPayment cashPayment;

	private CustomerCatalog customerCatalog;
	
	private ExternalAccountingSystemHandler externalAccountingSystemHandler;

	public  Controller() {
	this.cashRegister= new CashRegister();
	this.printer = new Printer();
	this.externalInventoryHandler = new ExternaInventoryHandler();
	this.customerCatalog = new CustomerCatalog();
	this.itemCatalogHandler = new ItemCatalogHandler();
	this.externalAccountingSystemHandler = new ExternalAccountingSystemHandler();
	
	}

	public Change pay(Amount paidAmout) {
		return null;
	}

	public void newSale() {
		Item[] itemList = new Item[150];
		Amount price = new Amount(0,"SEK","Cash");
		Change change = new Change(0);
		Amount totalPriceWithTaxes= new Amount(0,"SEK","Cash");
		this.sale= new Sale	(itemList, false, price, change, totalPriceWithTaxes);
	}

	public Sale scanningItems(int ItemID, int Amount) {
		Item item= new Item(ItemID,Amount);
		item= ItemCatalogHandler.validateItem(item);
		sale.addItem(item);
		return sale;
	}

	public SaleDTO saleinformation (int ItemID, int Amout) {
		return null;
	}

	public SaleDTO discountRequest(Customer customer) {
		customerCatalog.vaildateDiscount(customer);
		if (customer.getDiscount()) {
			sale.addDiscount();
		}
		return null;
	}

	public SaleDTO completeingSale() {
		return null;
	}

	public SaleDTO scannItem(int ItemID) {
		return null;
	}
}
