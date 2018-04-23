package model;


import integration.Change;
import integration.ExternalAccountingSystemHandler;
import integration.ExternalInventoryHandler;
import integration.Item;
import integration.Printer;
import integration.SaleDTO;

public class Sale {

	private Item[] itemList;

	private boolean discountVaild;

	private int recordSaleTime;

	private Amount price;

	private Change change;

	private Amount totalPriceWithTaxes;

	//private SaleDTO saleDTO;

	private Receipt receipt;

	//private CashPayment cashPayment;

	private Printer printer;

	private ExternalAccountingSystemHandler externalAccountingSystemHandler;

	private ExternalInventoryHandler externalInventoryHandler;

	public Sale(){
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

	public SaleDTO addItem(Item item) {
		
		SaleDTO saleDTO= new SaleDTO(this.itemList,this.discountVaild,this.);
		return saleDTO;

	}

	public void storeSale(Sale saleinfo) {

	}

	private int recordSaleTime() {
		return 0;
	}

	public void addDiscount() {

	}

}
