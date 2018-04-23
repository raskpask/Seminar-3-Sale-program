package model;


import integration.Change;
import integration.ExternalAccountingSystemHandler;
import integration.ExternalInventoryHandler;
import integration.Item;
import integration.Printer;
import integration.SaleDTO;

public class Sale {

	private Item[] itemList;

	private boolean discountVaild;

	private int recordSaleTime;

	private Amount price;

	private Change change;

	private Amount totalPriceWithTaxes;

	private static SaleDTO saleDTO;

	private Receipt receipt;

	//private CashPayment cashPayment;

	private Printer printer;

	private ExternalAccountingSystemHandler externalAccountingSystemHandler;

	private ExternalInventoryHandler externalInventoryHandler;

	public Sale(){
	}

	public void payment(int cashPayment) {

	}

	public void printReciept(Printer printer) {

	}

	public static SaleDTO addItem(Item item) {
		return saleDTO;

	}

	public void storeSale(Sale saleinfo) {

	}

	private int recordSaleTime() {
		return 0;
	}

	public void addDiscount() {

	}

	public void getChange() {

	}

	public Amount getTotalPriceWithTaxes() {
		return null;
	}

}
