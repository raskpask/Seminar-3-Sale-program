package integration;


import model.Amount;
import integration.ItemCatalogHandler;

/**
 * Contains item. Create a item using the scanned ID and the number of items with that ID.
 * @author molin
 *
 */
public class Item {

	private  Amount price;

	private int IDNumber;

	private int quantity;

	private ItemCatalogHandler itemCatalogHandler;
/**
 * Create Item using ID and quantity.
 * @param itemID
 * @param quantity
 */
	public Item(int itemID, int quantity) {
		this.IDNumber= itemID;
		this.quantity= quantity;
	}
/**
 * Sends information about the price
 * @return
 */
	public Amount getPrice() {
		return this.price; 
	}
/**
 * Sends inforamtion about the ID number of the item.
 * @return
 */
	public int getIDNumber() {
		return this.IDNumber;
	}
/**
 * Sends the quantity of the item
 */
	public int getQuantity() {
		return this.quantity;
	}
/**
 * Sets the price of the item, is used in the itemCaltalog Handler
 * @param price
 */
	public void setPrice(Amount price) {
		this.price=price;
	}
/**
 * Takes the info about the item and puts it into a String.
 */
	public String toString() {
		String itemInfo = "Item: "+IDNumber + "\n"+
				"The price is: " +price.getNumber()+"\n"+
				"The quantity of the item is: "+quantity+"\n";
		return itemInfo;
		
	}
@Override
public boolean equals(Object obj) {
	Item other= (Item) obj;
	return other.getIDNumber() == this.IDNumber;
}
	

}
