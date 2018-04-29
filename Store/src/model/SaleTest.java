package model;


import static org.junit.Assert.assertEquals;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import integration.Change;
import integration.Item;

class SaleTest {
	private Item[] itemList;
	
	private int numberOfItems;

	private boolean discountVaild;

	private Amount price;

	private Change change;

	private Amount totalPriceWithTaxes;

	private Receipt receipt;
	
	private Sale sale;
	
	@BeforeEach
	void setUp() throws Exception {
		this.itemList = new Item[150];
		this.numberOfItems= 0;
		this.price= new Amount(0,"","");
		this.change = new Change(price, price);
		this.totalPriceWithTaxes = new Amount(0,"","");
		this.sale= new Sale(itemList,discountVaild,price,change,totalPriceWithTaxes);
		this.receipt= new Receipt(sale);
		}

	@AfterEach
	void tearDown() throws Exception {
		this.sale=null;
		this.price=null;
		this.change=null;
		this.totalPriceWithTaxes=null;
		this.receipt=null;
	}
	@Test
	void testAddItem() {
		Item expectedItem = new Item(3,1);
		expectedItem.setPrice(new Amount(10.0, "", ""));
		
		sale.addItem(expectedItem);
			
		Item[] items = sale.getItems();
		assertEquals("Item not added", expectedItem, items[0]);
		assertEquals("The price of the sale is not correct", expectedItem.getPrice(), sale.getPrice());
	}
	
	@Test
	void testAddItems() {
		Item expectedItem = new Item(3,3);
		expectedItem.setPrice(new Amount(10.0, "", ""));
		
		sale.addItem(expectedItem);
		expectedItem.setPrice(new Amount(30.0,"",""));
			
		Item[] items = sale.getItems();
		assertEquals("Item not added", expectedItem, items[0]);
		assertEquals("The price of the sale is not correct", expectedItem.getPrice(), sale.getPrice());
	}
	
	@Test
	void testAddDiscount() {
		boolean expectedBoolean =true;
		
		sale.addDiscount();
		
		assertEquals("Discount not added",expectedBoolean,sale.getDiscountValid());
	}
	@Test
	void testTotalPriceWithTaxes() {
		Amount expectedAmount = new Amount(37.5, "","");
		Item item = new Item(3,3);
		item.setPrice(new Amount(10.0, "", ""));
		sale.addItem(item);
		
		sale.getTotalPriceWithTaxes();
		
		assertEquals("Total price is not right",expectedAmount,totalPriceWithTaxes);
		
	}
	

}
