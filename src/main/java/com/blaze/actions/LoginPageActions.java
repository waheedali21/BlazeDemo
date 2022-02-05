package com.blaze.actions;

import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;

import com.blaze.base.TestBase;
import com.blaze.locators.LoginPageLocators;

public class LoginPageActions extends TestBase{
	
	
	LoginPageLocators loginPageLocatorsObj;
	
	// Class constructor -calling the OR objects
	public LoginPageActions() throws Exception {
		this.loginPageLocatorsObj = new LoginPageLocators();
		
		AjaxElementLocatorFactory factory = new AjaxElementLocatorFactory(driver, 10);
		PageFactory.initElements(factory, this.loginPageLocatorsObj); //initialize objects
		
	}
	
	
	public void do_login(String uName, String Password) {

		// click Login link from top menu
		loginPageLocatorsObj.loginLink.click();
		sendKeys(driver, loginPageLocatorsObj.txtUserName, 15, uName);
		sendKeys(driver, loginPageLocatorsObj.txtPassword, 15, Password);
		loginPageLocatorsObj.btnLogin.click();

	}
	
	
	public String do_URLVerification() {
		return driver.getCurrentUrl();
	}
	
	

}
