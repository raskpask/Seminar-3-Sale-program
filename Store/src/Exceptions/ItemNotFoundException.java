package Exceptions;


import integration.Item;
/**
 * 
 * Thrown when the item can't be found. 
 * @author molin
 *
 */

public class ItemNotFoundException extends Exception {
	
	private Item itemThatCanNotBeFound;
	/**
	 * Creates error message that specifies the error. 
	 * @param itemThatCanNotBeFound The item that could not be found.
	 */
	public ItemNotFoundException(Item itemThatCanNotBeFound ) {
		 super("Unable to find "+ itemThatCanNotBeFound.getIDNumber()+" because is not in the database");
		 this.itemThatCanNotBeFound=itemThatCanNotBeFound;
}
	/**
	 * 
	 * @return item that can not be found.
	 */
	public Item getItemThatCanNotBeFound() {
		return this.itemThatCanNotBeFound;
	}
}
