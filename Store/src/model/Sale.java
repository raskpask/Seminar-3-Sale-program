package model;


import integration.Change;
import integration.ExternalAccountingSystemHandler;
import integration.ExternalInventoryHandler;
import integration.Item;
import integration.Printer;
import integration.SaleDTO;

public class Sale {

	private Item[] itemList;
	
	private int numberOfItems=0;

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
	/**
	 * Makes object change and decide how much the change should be.
	 * @param paidAmount 
	 * @return
	 */
	public Change getChange(Amount paidAmount) {
		 this.change = new Change(paidAmount,this.totalPriceWithTaxes);
		return this.change;
	}
	/**
	 * Sets the taxes of the goods. 25% taxes.
	 * @return
	 */
	public Amount getTotalPriceWithTaxes() {
		this.totalPriceWithTaxes.setNumber(price.getNumber()*1.25);
		return this.totalPriceWithTaxes;
	}
	public void payment(CashPayment cashPayment) {
		//cashPayment.calculateTotalCost());
	}

	public void printReciept(Sale sale,Printer printer) {
		this.receipt = new Receipt(sale);
		printer.printReceipt(receipt);
		
	}

	public void addItem(Item item) {
		this.itemList[this.numberOfItems]=item;
		this.numberOfItems++;
		//Sale sale= new Sale(this.itemList,this.discountVaild,this.price, this.change,this.totalPriceWithTaxes);
		//return sale;
		

	}


	public void addDiscount() {
		this.discountVaild= true;
	}
	/**
	 * prints the sale information in view.
	 * @return 
	 */
	public String toString() {
		String items ="";
		for (int i=0;i<this.numberOfItems; i++) {
			items+= itemList[i].toString();
		}
		String saleinfo = "Number of items: "+ numberOfItems +"\n "
				+ "Items: "+ items + "\n "
				+ "Was there a discount? "+ discountVaild + "\n"+
				"The running total is: "+price.getNumber() + "\n "
				+ "The customer should get: "+change.getChange()+ " SEK back"+"\n"+
				"The total price is: "+ totalPriceWithTaxes.getNumber()+"\n \n";
		return saleinfo;
	}
}
