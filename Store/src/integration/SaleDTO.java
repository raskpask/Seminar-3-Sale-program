package integration;

import integration.Item;
import model.Amount;
import model.Sale;
//import TotalPriceAfterTaxes;

public class SaleDTO {

	private Item[] itemList;

	private boolean discountVaild;

	//private int recordSaleTime;

	private Amount price;

	private Change change;

	//private Amount totalPriceIWithTaxes;

	public SaleDTO(Item[] itemList,boolean discountVaild, Amount price, Change change) {
		this.itemList = itemList;
		this.discountVaild= discountVaild;
		this.price= price;
		this.change=change;
	}

	public Item[] getItems() {
		return null;
	}

	public boolean isDiscount() {
		return false;
	}

	/*public int getrecordSaleTime() {
		return 0;
	}*/

	public Amount getPrice() {
		return null;
	}

	public Change getChange() {
		return null;
	}

	/*public TotalPriceAfterTaxes getTotalPriceWithTaxes() {
		return null;
	}*/

}
