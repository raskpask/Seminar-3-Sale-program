package model;

public interface Observer {
/**
 * Send the current total revenue to the observers
 */
	public void update(Amount totalRevenue);
}
