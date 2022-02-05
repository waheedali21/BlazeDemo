package com.blaze.testcases;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.blaze.actions.ProductPageActions;
import com.blaze.base.TestBase;
import com.blaze.locators.ProductPageLocators;

public class ProductPageTestCases extends TestBase {

	ProductPageLocators productPageLocatorsObj;
	ProductPageActions productPageActions;

	// Class constructor to load prop file, excel file etc.
	public ProductPageTestCases() throws Exception {
		super();

	}

	@BeforeTest
	public void setUp() throws Exception {
		initializeBrowser();
		productPageLocatorsObj = new ProductPageLocators();
		productPageActions = new ProductPageActions();
	}

	@Test(priority = 1)
	public void do_AddProductToCartTest() throws Exception {
		productPageActions.do_AddProductToCart();
	}
	
	
	@Test(priority = 2)
	public void do_PlaceOrderTest() {
		productPageActions.do_PlaceOrder();
	}


	
	

}
