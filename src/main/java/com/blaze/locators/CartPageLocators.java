package com.blaze.locators;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class CartPageLocators {
	
	@FindBy(css = "#cartur")
	public WebElement CartLink;
	
	@FindBy(xpath = "//button[normalize-space()='Place Order']")
	public WebElement btnPlaceOrder;
	
	@FindBy(id = "name")
	public WebElement txtName;
	
	@FindBy(id = "card")
	public WebElement txtCreditCard;
	
	
	@FindBy(xpath = "//button[normalize-space()='Purchase']")
	public WebElement btnPurchase;
	
	
	

}
