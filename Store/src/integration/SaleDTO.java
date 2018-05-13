/*package integration;

import integration.Item;
import model.Amount;
import model.Sale;

/**
 * Store the information about the sale. This class in not used because sale in sent to view instead.
 * @author molin
 *
 *//*
public class SaleDTO {

	private Item[] itemList;

	private boolean discountVaild;

	//private int recordSaleTime;

	private Amount price;

	private Change change;

	private Amount totalPriceIWithTaxes;

	public SaleDTO(Item[] itemList,boolean discountVaild, Amount price, Change change,Amount totalPriceWithTaxes) {
		this.itemList = itemList;
		this.discountVaild= discountVaild;
		this.price= price;
		this.change=change;
		this.totalPriceIWithTaxes=totalPriceWithTaxes;
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

	/*public Amount getPrice() {
		return null;
	}

	public Change getChange() {
		return null;
	}

	/*public TotalPriceAfterTaxes getTotalPriceWithTaxes() {
		return null;
	}*/

//}
