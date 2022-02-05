package com.blaze.locators;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class SignUpPageLocators {
	
	
	@FindBy(css = "#signin2")
	public WebElement signUpLink;
	
	@FindBy(css = "#sign-username")
	public WebElement txtUserName;
	
	@FindBy(css = "#sign-password")
	public WebElement txtPassword;
	
	@FindBy(xpath = "//button[normalize-space()='Sign up']")
	public WebElement btnSignUp;
	
	
	//@FindBy(xpath = "//div[@id='signInModal']//button[@type='button'][normalize-space()='Close']]")
	@FindBy(xpath = "(//button[text()='Close'])[2]")
	public WebElement btnClose;
}
