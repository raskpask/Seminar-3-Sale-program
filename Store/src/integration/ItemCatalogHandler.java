package integration;

import model.Amount;

public class ItemCatalogHandler {

	public ItemCatalogHandler() {
		
	}
/**
 * Takes a item and gives it a price if the item is in the system.
 * @param item
 * @return
 */
	
	public static Item validateItem(Item item) {
		int IDNumber =item.getIDNumber();
		Amount price = new Amount(0,"SEK","Cash");
		
		switch(IDNumber) {
		case 0: price.setNumber(23);
			item.setPrice(price);
			return item;
		case 1: 
		price.setNumber(20); 
		item.setPrice(price); //Problem!!
		System.out.println(item);
		//System.out.println("felllllllllllllll");
			return item;
		case 2: price.setNumber(99);
		item.setPrice(price);
			return item;
		case 3: price.setNumber(5);
		item.setPrice(price);
			return item;
		default:
			item.setPrice(price);
			return item;
		}
	}

}
