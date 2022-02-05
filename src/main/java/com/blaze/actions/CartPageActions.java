package com.blaze.actions;

import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;

import com.blaze.base.TestBase;
import com.blaze.locators.CartPageLocators;

public class CartPageActions extends TestBase{
	
	CartPageLocators CartPageLocatorsObj;
	
	//Class constructor -calling the OR objects
	public CartPageActions() throws Exception {
		this.CartPageLocatorsObj = new CartPageLocators();

		AjaxElementLocatorFactory factory = new AjaxElementLocatorFactory(driver, 10);
		PageFactory.initElements(factory, this.CartPageLocatorsObj); // initialize objects
	}
	
	
	
	public void do_PlaceOrder() {
		linkClick(driver, CartPageLocatorsObj.CartLink, 20);
	}

}
