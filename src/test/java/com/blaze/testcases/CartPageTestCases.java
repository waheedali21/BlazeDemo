package com.blaze.testcases;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.blaze.actions.CartPageActions;
import com.blaze.base.TestBase;
import com.blaze.locators.CartPageLocators;

public class CartPageTestCases extends TestBase{

	
	CartPageLocators CartPageLocatorsObj;
	CartPageActions   cartPageActionsObj;
	
	
	//class SignUpPageTestCases, loading prop file, excel file etc.
	public CartPageTestCases() throws Exception {
		super();
		
	}
	
	@BeforeTest
	public void setUp() throws Exception {
		initializeBrowser();
		CartPageLocatorsObj = new CartPageLocators();
		cartPageActionsObj = new CartPageActions();
	}
	
	
	@Test(priority = 2)
	public void do_PlaceOrderTest() {
		cartPageActionsObj.do_PlaceOrder();
	}

}
