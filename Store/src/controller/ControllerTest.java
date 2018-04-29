package controller;


import static org.junit.Assert.assertEquals;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import integration.Change;
import integration.CustomerCatalog;
import integration.ExternalAccountingSystemHandler;
import integration.ExternalInventoryHandler;
import integration.Item;
import integration.ItemCatalogHandler;
import integration.Printer;
import model.Amount;
import model.Cash;
import model.CashPayment;
import model.CashRegister;
import model.Customer;
import model.Receipt;
import model.Sale;

class ControllerTest {
	
	private Controller controller;

	private ExternalInventoryHandler externalInventoryHandler;

	private Sale sale;
	
	private Printer printer;
	
	private CashRegister cashRegister;

	private ItemCatalogHandler itemCatalogHandler;

	private Customer customer;

	private CashPayment cashPayment;

	private CustomerCatalog customerCatalog;
	
	private ExternalAccountingSystemHandler externalAccountingSystemHandler;
	
	@BeforeEach
	void setUp() throws Exception {
		this.controller= new Controller();
		controller.newSale();
		Cash payment= new Cash();
	}

	@AfterEach
	void tearDown() throws Exception {
		this.controller=null;
	}

	@Test
	void testPay() {
		controller.scanningItems(3, 3);//Number 3 have the value of 5
		Amount paidAmount= new Amount(500, "", "");
		Amount subtractedAmount = new Amount(15, "", "");
		Change expectedChange= new Change(paidAmount,subtractedAmount);
		
		controller.pay(paidAmount);
		
		Sale sale= controller.currentSaleInfo();
		Change change = sale.getChange(paidAmount);
		assertEquals("The change is not correct",expectedChange,change);
	}

}
