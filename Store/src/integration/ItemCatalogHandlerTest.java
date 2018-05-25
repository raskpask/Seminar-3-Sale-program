package integration;

import static org.junit.Assert.assertEquals;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import model.Amount;
import model.DatabaseNotFound;
import model.ItemNotFoundException;
/**
 * Tests the catalog class.
 * @author molin
 *
 */
class ItemCatalogHandlerTest {

/**
 * Testing of validateItem method.
 * @throws DatabaseNotFound 
 * @throws ItemNotFoundException 
 */
	@Test
	void testValidateItem() throws ItemNotFoundException, DatabaseNotFound {
		Item expectedItem= new Item(3, 1);
		
		Item item=ItemCatalogHandler.validateItem(expectedItem);
		
		Amount price = new Amount(5.0, "SEK", "Cash");
		expectedItem.setPrice(price);
		assertEquals("Item was not validated",expectedItem,item);
		
		
	}

}
