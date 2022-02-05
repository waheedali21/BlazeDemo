package com.blaze.locators;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ProductPageLocators {
	
	@FindBy(xpath = "//a[normalize-space()='Samsung galaxy s6']")
					//a[normalize-space()='Samsung galaxy s6']
	public WebElement linkSamsungGalaxyS6;
	
	
	@FindBy(xpath = "//h5[normalize-space()='$360']")
	public WebElement txtSamsungGalaxyS6Price;
	
	@FindBy(xpath = "//a[normalize-space()='Add to cart']")
	public WebElement btnAddToCart;
	

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
	
	
	@FindBy(xpath = "//h2[normalize-space()='Thank you for your purchase!']")
	public WebElement txtSuccessMessage;
	
	@FindBy(xpath ="//button[normalize-space()='OK']")
	public WebElement btnOK;
	
	@FindBy(xpath = "//div[@id='orderModal']//button[@type='button'][normalize-space()='Close']")
	public WebElement btnClose;
	
}
