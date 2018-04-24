package controller;


import integration.Change;
import integration.CustomerCatalog;
import integration.ExternalAccountingSystemHandler;
import integration.ExternalInventoryHandler;
import integration.Item;
import integration.ItemCatalogHandler;
import integration.Printer;
import integration.SaleDTO;
import model.Amount;
import model.Cash;
import model.CashPayment;
import model.CashRegister;
import model.Customer;

import model.Sale;


public class Controller {

	private ExternalInventoryHandler externalInventoryHandler;

	private Sale sale;
	
	private Printer printer;
	
	private Controller controller;

	//private SaleDTO saleDTO;

	private CashRegister cashRegister;

	private Item item;

	private ItemCatalogHandler itemCatalogHandler;

	private Customer customer;

	private CashPayment cashPayment;

	private CustomerCatalog customerCatalog;
	
	private ExternalAccountingSystemHandler externalAccountingSystemHandler;

	public  Controller() {
	this.cashRegister= new CashRegister();
	this.printer = new Printer();
	this.externalInventoryHandler = new ExternalInventoryHandler();
	this.customerCatalog = new CustomerCatalog();
	this.itemCatalogHandler = new ItemCatalogHandler();
	this.externalAccountingSystemHandler = new ExternalAccountingSystemHandler();
	
	}
/**
 * The process were a payment i made.
 * @param paidAmout
 * @return
 */
	public Sale pay(Amount paidAmount) {
		Cash payment = new Cash();
		cashRegister.addPayment(payment);
		this.cashPayment= new CashPayment(paidAmount);
		//cashPayment.calculateTotalCost(sale); // This functions is not used. Price is calculated in sale already
		//sale.payment(cashPayment);
		sale.printReciept(this.sale,this.printer);
		externalInventoryHandler.storeItems(sale.getItems());
		externalAccountingSystemHandler.storeSale(this.sale);
		sale.getChange(paidAmount);
		return this.sale;
	}

	public void newSale() {
		Item[] itemList = new Item[150];
		Amount price = new Amount(0,"SEK","Cash");
		Change change = new Change(price, price);// send null instead??
		Amount totalPriceWithTaxes= new Amount(0,"SEK","Cash");
		this.sale= new Sale	(itemList, false, price, change/*send null instead and make object later??*/, totalPriceWithTaxes);
	}

	public Sale scanningItems(int ItemID, int Amount) {
		Item item= new Item(ItemID,Amount);
		item= ItemCatalogHandler.validateItem(item);
		sale.addItem(item);
		return sale;
	}

	public Sale saleinformation (int ItemID, int Amout) {
		return null;
	}

	public Sale discountRequest(Customer customer) {
		customerCatalog.vaildateDiscount(customer);
		if (customer.getDiscount()) {
			sale.addDiscount();
		}
		return null;
	}

	public Sale completeingSale() {
		sale.getTotalPriceWithTaxes();
		return sale;
	}

	public Sale scannItem(int ItemID) {
		return null;
	}
}
