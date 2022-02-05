package com.blaze.locators;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPageLocators {
	
	
	@FindBy(css = "#login2")
	public WebElement loginLink;
	
	
	@FindBy(css = "#loginusername")
	public WebElement txtUserName;
	
	
	@FindBy(css = "#loginpassword")
	public WebElement txtPassword;
	
	
	
	@FindBy(xpath = "//button[text()='Log in']")
	public WebElement btnLogin;
	
	@FindBy(xpath = "//div[@id='logInModal']//button[@type='button'][normalize-space()='Close']")
	public WebElement btnClose;
	
	

}
