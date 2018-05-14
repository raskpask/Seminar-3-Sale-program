package
view;

import model.Sale;

/**
 * Shows the running price all the time.
 * @author molin
 *
 */
public class TotalRevenueView {
	/**
	 * shows the running total on the side display.
	 * @param sale
	 */
	public static void showRunningTotalOnSideDisplay(Sale sale) {
		
		System.out.println("This is the side display!:------------------------------------------\n"
	+"The running total is: "+ sale.getPrice().toString()+"\n"
			+ "\nThe side display ends here!--------------------------------------------------- \n");

	}
}
