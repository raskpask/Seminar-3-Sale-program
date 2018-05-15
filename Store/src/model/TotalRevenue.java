package
model;

import java.util.*;

import model.Amount;
import model.Sale;
import model.SaleDTO;
import model.SaleObserver;

/**
 * Shows the running price all the time.
 * @author molin
 *
 */
public class TotalRevenue implements SaleObserver{
	
	private Amount totalRevenueAmount;
	
	private List<SaleObserver> observers;
	
	public TotalRevenue() {
		this.totalRevenueAmount = new Amount(0,"SEK","");
		observers = new ArrayList<SaleObserver>();
	}
	/**
	 * shows the running total on the side display.
	 * @param sale
	 */
	public void printDisplay() {
		
		System.out.println("This is the side display!:------------------------------------------\n"
	+"The total Revenue is: "+ totalRevenueAmount.toString()+"\n"
			+ "\nThe side display ends here!--------------------------------------------------- \n");

	}
	@Override
	public void update(Amount totalRevenue) {
		this.totalRevenueAmount = totalRevenue;
		printDisplay();
	}
	
	public Amount getTotalRevenueAmount() {
		return this.totalRevenueAmount;
	}
	@Override
	public void addObserver(SaleObserver observer) {
		observers.add(observer);
		
	}
	@Override
	public void removeObserver(SaleObserver observer) {
		observers.remove(observer);
		
	}
	@Override
	public void notifyObservers() {
		for (SaleObserver observer:observers) {
			observer.update(this.totalRevenueAmount);
		}
	}
	public void setTotalRevenueAmount(Amount totalRevenueAmount) {
		this.totalRevenueAmount = totalRevenueAmount;
	}
}
