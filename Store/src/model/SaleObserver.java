package model;
/**
 * A interface that receves information about the new sale. The Interface is interested when the sale is updated.
 * @author molin
 *
 */
public interface SaleObserver {
	/**
	 * invoked when the sale is updated.
	 * 
	 * @param saleDTO The sale that was updated.
	 */
	public void update(Amount totalRevenue);
	
	public void addObserver(SaleObserver observer);
	
	public void removeObserver(SaleObserver observer);
	
	public void notifyObservers();
		
}
