package model;


import integration.Change;
import integration.ExternalAccountingSystemHandler;
import integration.ExternalInventoryHandler;
import integration.Item;
import integration.Printer;
import integration.SaleDTO;

public class Sale {

	private Item[] itemList;
	
	private int numberOfItems;

	private boolean discountVaild;

	//private int recordSaleTime;

	private Amount price;

	private Change change;

	private Amount totalPriceWithTaxes;

	//private SaleDTO saleDTO;

	private Receipt receipt;

	//private CashPayment cashPayment;

	//private Printer printer;

	//private ExternalAccountingSystemHandler externalAccountingSystemHandler;

	//private ExternalInventoryHandler externalInventoryHandler;


	public Sale(Item[] itemList,boolean discountVaild, Amount price, Change change,Amount totalPriceWithTaxes) {
		this.itemList = itemList;
		this.discountVaild= discountVaild;
		this.price= price;
		this.change=change;
		this.totalPriceWithTaxes=totalPriceWithTaxes;
		
	}
	
	public Item[] getItems() {
		return this.itemList;
	}
	public boolean getDiscountValid() {
		return this.discountVaild;
	}
	public Amount getPrice() {
		return this.price;
	}
	public Change getChange() {
		return this.change;
	}
	public Amount getTotalPriceWithTaxes() {
		return this.totalPriceWithTaxes;
	}
	public void payment(int cashPayment) {

	}

	public void printReciept(Printer printer) {

	}

	public Sale addItem(Item item) {
		this.itemList[numberOfItems]=item;
		this.numberOfItems++;
		Sale sale= new Sale(this.itemList,this.discountVaild,this.price, this.change,this.totalPriceWithTaxes);
		return sale;
		

	}

	public void storeSale(Sale saleinfo) {

	}


	public void addDiscount() {
		this.discountVaild= true;
	}

}
