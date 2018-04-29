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

	private Amount price;

	private Change change;

	private Amount totalPriceWithTaxes;

	private Receipt receipt;

/**
 * creates the sale object this is done every time newSale() is called. Gives the function:
 * @param itemList
 * @param discountVaild
 * @param price
 * @param change
 * @param totalPriceWithTaxes
 */
	public Sale(Item[] itemList,boolean discountVaild, Amount price, Change change,Amount totalPriceWithTaxes) {
		this.itemList = itemList;
		this.discountVaild= discountVaild;
		this.price= price;
		this.change=change;
		this.totalPriceWithTaxes=totalPriceWithTaxes;
		
	}
	/**
	 * Returns all the items in the sale
	 * @return
	 */
	public Item[] getItems() {
		return this.itemList;
	}
	/**
	 * Returns is the sale has a discount or not.
	 * @return
	 */
	public boolean getDiscountValid() {
		return this.discountVaild;
	}
	/**
	 * Returns the running total.
	 * @return
	 */
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
	/*public void payment(CashPayment cashPayment) {
		//cashPayment.calculateTotalCost());
	}*/
	
	/**
	 * Gets the value of TotalPriceWithTaxes
	 */
	public Amount getValueOfTotalPriceWithTaxes() {
		return this.totalPriceWithTaxes;
	}
/**
 * Makes a receipt and then uses the printer to print it.
 * @param sale
 * @param printer
 */
	public void printReciept(Sale sale,Printer printer) {
		this.receipt = new Receipt(sale);
		printer.printReceipt(receipt);
		
	}
/**
 * Adds a item to the item list
 * @param item
 */
	public void addItem(Item item) {
		this.itemList[this.numberOfItems]=item;
		this.numberOfItems++;
		double priceOfItem=item.getPrice().getNumber()*item.getQuantity();
		double currentPrice=this.price.getNumber();
		this.price.setNumber(priceOfItem+currentPrice);
		//Sale sale= new Sale(this.itemList,this.discountVaild,this.price, this.change,this.totalPriceWithTaxes);
		//return sale;
		

	}

/**
 * Makes the discount boolean true.
 */
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
