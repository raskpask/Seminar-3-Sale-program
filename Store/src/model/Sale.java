package model;


import java.util.ArrayList;
import java.util.List;

import integration.Change;
import integration.ExternalAccountingSystemHandler;
import integration.ExternalInventoryHandler;
import integration.Item;
import integration.Printer;
/**
 * Handles the sale and contains all the information about it.
 * @author molin
 *
 */
public class Sale {

	private Item[] itemList;
	
	private List<SaleObserver> observers = new ArrayList<>();
	
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
	 * Register observer. Any <code>Observer</code> that is passed to this object will be notified. 
	 * @param observer The observer that will be registered.
	 */
	public void addObserver(SaleObserver observer) {
			observers.add(observer);
	}
	/**
	 * If something is changed notifies user.
	 */
	private void notifyObservers() {
		for(SaleObserver observer : observers) {
			observer.stateHasChanged();
		}
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
	/**
	 * Gets the total price with taxes
	 */
	public Amount getAmountTotalPriceWithTaxes() {
		return this.totalPriceWithTaxes;
	}
	
	/**
	 * Gets the value of TotalPriceWithTaxes
	 */
	public Amount getValueOfTotalPriceWithTaxes() {
		return this.totalPriceWithTaxes;
	}
/**
 * Gets the number of items in the sale.
 */
	public int getNumberOfItems() {
		return this.numberOfItems;
	}
/**
 * Gets the value of change. 
 */
	public Change getValueOfChange() {
		return this.change;
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
 * Checks if the item has been scanned.
 */
	public boolean checkIfItemHasBeenAdded(Item item) {
		for(int i=0;i<numberOfItems;i++){		
			if(itemList[i].getIDNumber()==item.getIDNumber()) {
				return true;
			}
		}
		return false;
	}
	
/**
 * Increase the quantity of an item.
 */
	public void increaseQuantity(Item item) {
		for(int i=0;i<numberOfItems;i++){		
			if(itemList[i].getIDNumber()==item.getIDNumber()) {
				itemList[i].increaseQuantity(item.getQuantity());
				double priceOfItem=item.getPrice().getNumber()*item.getQuantity();
				double currentPrice=this.price.getNumber();
				this.price.setNumber(priceOfItem+currentPrice);
				notifyObservers();
			}
		}
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
		notifyObservers();

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
