package com.blaze.actions;

import org.openqa.selenium.Alert;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;

import com.blaze.base.TestBase;
import com.blaze.locators.ProductPageLocators;

public class ProductPageActions extends TestBase {

	ProductPageLocators productPageLocatorsObj;

	// Class constructor -calling the OR objects
	public ProductPageActions() throws Exception {
		this.productPageLocatorsObj = new ProductPageLocators();

		AjaxElementLocatorFactory factory = new AjaxElementLocatorFactory(driver, 15);
		PageFactory.initElements(factory, this.productPageLocatorsObj);

	}

	public void do_AddProductToCart() throws Exception {
		// productPageLocatorsObj.txtSamsungGalaxyS6Price.click(); //click the product
		// Galazy S6

		linkClick(driver, productPageLocatorsObj.linkSamsungGalaxyS6, 20);
		linkClick(driver, productPageLocatorsObj.btnAddToCart, 20);

		
		onAlertClick(driver, 20);
		System.out.println("Alert appeapr");
		Alert signupAlert = driver.switchTo().alert();
		System.out.println(signupAlert.getText());
		System.out.println("Alert text fetched");
		signupAlert.accept();
		
		// get the message when alert showing on product add successfully
	/*	
		// Click Ok when JS alert appear
				onAlertClick(driver, 15);
				Alert signupAlert = driver.switchTo().alert();
				System.out.println(signupAlert.getText());

				signupAlert.accept();
		*/

	/*
		try {
		    WebDriverWait wait = new WebDriverWait(driver, 20);
		    wait.until(ExpectedConditions.alertIsPresent());
		    Alert alert = driver.switchTo().alert();
		     alert.accept();
		} catch (Exception e) {
		    System.out.println("Alert not found");
		}

		*/
		//return new CartPageActions();
		

	}
	
	public void do_PlaceOrder() {
		linkClick(driver, productPageLocatorsObj.CartLink, 20);
		//click place order button
		linkClick(driver, productPageLocatorsObj.btnPlaceOrder, 20);
		//enter customer name
		sendKeys(driver, productPageLocatorsObj.txtName, 20, "Ali Waheed");
		//enter credit card number
		sendKeys(driver, productPageLocatorsObj.txtCreditCard, 20, "1234454667890987");
		
		//click purchse button
		linkClick(driver, productPageLocatorsObj.btnPurchase, 20);
		
		//capture the success message
		//String productSuccessMessage = driver.findElement(By.xpath("productPageLocatorsObj.txtSuccessMessage")).getText();
		//System.out.println(productSuccessMessage);
		//Assert.assertEquals(productSuccessMessage, "Thank you for your purchase!");
		
		//click
		clickElement(productPageLocatorsObj.btnOK);
		clickElement(productPageLocatorsObj.btnClose);
		//linkClick(driver, productPageLocatorsObj.btnOK, 10);
		driver.navigate().to("https://www.demoblaze.com/index.html");
		
	}

	
	
	
	
}
