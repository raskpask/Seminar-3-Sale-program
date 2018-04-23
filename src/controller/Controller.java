package controller;


import integration.Change;
import integration.CustomerCatalog;
import integration.ExternaInventoryHandler;
import integration.Item;
import integration.ItemCatalogHandler;
import integration.SaleDTO;
import model.Amount;
import model.CashPayment;
import model.CashRegister;
import model.CustomerDTO;
import model.Sale;


public class Controller {

	private ExternaInventoryHandler externalInventoryHandler;



	private Controller controller;

	private Sale sale;

	private SaleDTO saleDTO;

	private CashRegister cashRegister;

	private Item item;

	private ItemCatalogHandler itemCatalogHandler;

	private CustomerDTO customerDTO;

	private CashPayment cashPayment;

	private CustomerCatalog customerCatalog;

	public  Controller() {
	
	}

	public Change pay(Amount paidAmout) {
		return null;
	}

	public void newSale() {

	}

	public static SaleDTO scanningItems(int ItemID, int Amount) {
		Item item= new Item(ItemID,Amount);
		item= ItemCatalogHandler.validateItem(item);
		SaleDTO sale = Sale.addItem(item);
		return null;
	}

	public SaleDTO saleinformation (int ItemID, int Amout) {
		return null;
	}

	public SaleDTO discountRequest(CustomerDTO Costumer) {
		return null;
	}

	public SaleDTO completeingSale() {
		return null;
	}

	public SaleDTO scannItem(int ItemID) {
		return null;
	}

}
