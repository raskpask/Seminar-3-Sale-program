package integration;


import model.Amount;
import integration.ItemCatalogHandler;


public class Item {

	private  Amount price;

	private int IDNumber;

	private int quantity;

	private ItemCatalogHandler itemCatalogHandler;

	public Item(int itemID, int quantity) {
		this.IDNumber= itemID;
		this.quantity= quantity;
	}

	public Amount getprice() {
		return null;
	}

	public int getIDNumber() {
		return this.IDNumber;
	}
	public void setPrice(Amount price) {
		this.price=price;
	}

}
