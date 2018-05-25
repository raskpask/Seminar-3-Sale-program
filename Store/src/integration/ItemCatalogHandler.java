package integration;

import model.Amount;
import model.DatabaseNotFound;
import model.ItemNotFoundException;
/**
 * Gives the item a price when comunicating with a external database.
 * @author molin
 *
 */
public class ItemCatalogHandler {

	public ItemCatalogHandler() {
		
	}
/**
 * Takes a item and gives it a price if the item is in the system.
 * @param item
 * @return
 * @throws ItemNotFoundException 
 * @throws DatabaseNotFound 
 */
	
	public static Item validateItem(Item item) throws ItemNotFoundException, DatabaseNotFound {
		int IDNumber =item.getIDNumber();
		Amount price = new Amount(0,"SEK","Cash");
		
		switch(IDNumber) {
		case 0: price.setNumber(23);
			item.setPrice(price);
			return item;
		case 1: 
		price.setNumber(20);  
		item.setPrice(price); 
			return item;
		case 2: price.setNumber(99);
		item.setPrice(price);
			return item;
		case 3: price.setNumber(5);
		item.setPrice(price);
			return item;
		case 600:
			throw new DatabaseNotFound();
		default:
				throw new ItemNotFoundException(item);
		}
	}

}
