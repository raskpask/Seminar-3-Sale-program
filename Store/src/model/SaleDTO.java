package model;

import integration.Change;
import integration.Item;
/**
 * Stores the information about the sale.
 * @author molin
 *
 */
public class SaleDTO {
private Item[] itemList;
	
	private int numberOfItems=0;

	private boolean discountVaild;

	private Amount price;

	private Change change;

	private Amount totalPriceWithTaxes;

	private Receipt receipt;
	/**
	 * Creates the object saleDTO.
	 * @param sale
	 */
public SaleDTO(Sale sale) {
	this.itemList= sale.getItems();
	this.numberOfItems= sale.getNumberOfItems();
	this.discountVaild= sale.getDiscountValid();
	this.price= sale.getPrice();
	this.change= sale.getValueOfChange();
	this.totalPriceWithTaxes = sale.getValueOfTotalPriceWithTaxes();
	
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
