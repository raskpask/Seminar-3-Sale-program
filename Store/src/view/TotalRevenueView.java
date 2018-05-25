package view;

import model.Amount;
import model.Observer;
import model.Sale;
import model.SaleObserver;

/**
 * Shows the running price all the time.
 * @author molin
 *
 */
public class TotalRevenueView implements Observer {
	
	private Amount totalRevenue;
	
	public TotalRevenueView() {
		this.totalRevenue= new Amount(0,"SEK","");
	}
	/**
	 * shows the running total on the side display.
	 * @param sale
	 */
	public void showRunningTotalOnSideDisplay() {
		
		System.out.println("This is the side display!:------------------------------------------\n"
	+"The running total is: "+ this.totalRevenue.getNumber() +"\n"
			+ "\nThe side display ends here!--------------------------------------------------- \n");

	}

	@Override
	public void update(Amount totalRevenue) {
		this.totalRevenue = totalRevenue;
		showRunningTotalOnSideDisplay();
	}

	
}
