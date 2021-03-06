package controller;


import java.nio.channels.ShutdownChannelGroupException;
import java.util.*;

import view.*;
import integration.Change;
import integration.CustomerCatalog;
import integration.ExternalAccountingSystemHandler;
import integration.ExternalInventoryHandler;
import integration.Item;
import integration.ItemCatalogHandler;
import integration.Printer;
import model.Amount;
import model.Cash;
import model.CashPayment;
import model.CashRegister;
import model.Customer;
import model.DatabaseNotFound;
import model.ItemNotFoundException;
import model.Sale;
import model.SaleObserver;
import model.TotalRevenue;
import se.kth.ood.daniel.duner.procesSale.view.TotalRevenueView;

/**
 * The class that execute all the commands from the view.
 * @author molin
 *
 */
public class Controller {

	private ExternalInventoryHandler externalInventoryHandler;

	private Sale sale;
	
	private Printer printer;
	
	private CashRegister cashRegister;

	private ItemCatalogHandler itemCatalogHandler;

	private Customer customer;

	private CashPayment cashPayment;

	private CustomerCatalog customerCatalog;
	
	private ExternalAccountingSystemHandler externalAccountingSystemHandler;
	
	private TotalRevenue totalRevenue;
	
	private TotalRevenueView totalRevenueView;
	
	private List<SaleObserver> saleObserver= new ArrayList<>();
/**
 * Makes the controller that starts other classes. Is called in the beginning.
 */
	public  Controller() {
	this.totalRevenue = new TotalRevenue();
	this.totalRevenueView = new TotalRevenueView();
	totalRevenue.addObserver(totalRevenueView);
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
	public model.SaleDTO pay(Amount paidAmount) {
		Cash payment = new Cash();
		cashRegister.addPayment(payment);
		this.cashPayment= new CashPayment(paidAmount);
		sale.printReciept(this.sale,this.printer);
		externalInventoryHandler.storeItems(sale.getItems());
		externalAccountingSystemHandler.storeSale(this.sale);
		sale.getChange(paidAmount);
		Amount newTotalRevenue= new Amount((this.sale.getAmountTotalPriceWithTaxes().getNumber())+ (totalRevenue.getTotalRevenueAmount().getNumber()),"SEK","");
		totalRevenue.setTotalRevenueAmount(newTotalRevenue);
		totalRevenue.notifyObservers();
		return new model.SaleDTO(sale);
	}
/**
 * The process for a new sale. The first 4 rows makes objects to send into the sale. The 5th row creates the object sale.
 */
	public void newSale() {
		Item[] itemList = new Item[150];
		Amount price = new Amount(0,"SEK","Cash");
		Change change = new Change(price, price);// send null instead??
		Amount totalPriceWithTaxes= new Amount(0,"SEK","Cash");
		this.sale= new Sale	(itemList, false, price, change/*send null instead and make object later??*/, totalPriceWithTaxes);
	}
	
/**
 * The process for scanning a item.
 * @param ItemID
 * @param Amount
 * @return
 * @throws DatabaseNotFound 
 */
	public model.SaleDTO scanningItems(int ItemID, int Amount) throws ItemNotFoundException, DatabaseNotFound {
		Item item;
		item= new Item(ItemID,Amount);
		item= ItemCatalogHandler.validateItem(item);
		if(sale.checkIfItemHasBeenAdded(item)) {
			sale.increaseQuantity(item);
			return new model.SaleDTO(sale);
		}
		sale.addItem(item);
		
		return new model.SaleDTO(sale); 
	}

/**
 * The process for requesting a discount
 * @param customer
 * @return
 */
	public model.SaleDTO discountRequest(Customer customer) {
		customerCatalog.vaildateDiscount(customer);
		if (customer.getDiscount()) {
			sale.addDiscount();
		}
		
		return new model.SaleDTO(sale);
	}
/**
 * The process for completing a sale returns a sale to view.
 * @return
 */
	public model.SaleDTO completeingSale() {
		sale.getTotalPriceWithTaxes();
		
		return new model.SaleDTO(sale);
	}
/**
 * Returns the current sale info.
 */
	public model.SaleDTO currentSaleInfo() {
		return new model.SaleDTO(sale);
	}
}
