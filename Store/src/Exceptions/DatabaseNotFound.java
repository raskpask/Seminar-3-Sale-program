package Exceptions;

import integration.Item;

/**
 * When the database cannot be reached
 * @author molin
 *
 */
public class DatabaseNotFound extends Exception {
	/**
	 * Message that has information about the error.
	 */

	public DatabaseNotFound() {
		 super("Unable to reach the database, probably because it is disconnected");
	}
}
