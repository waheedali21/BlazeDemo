package com.blaze.actions;

import org.openqa.selenium.Alert;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;

import com.blaze.base.TestBase;
import com.blaze.locators.SignUpPageLocators;

public class SignUpPageActions extends TestBase {

	SignUpPageLocators signUpPageLocatorsObj;

	// Class constructor -calling the OR objects
	public SignUpPageActions() throws Exception {
		this.signUpPageLocatorsObj = new SignUpPageLocators();

		AjaxElementLocatorFactory factory = new AjaxElementLocatorFactory(driver, 10);
		PageFactory.initElements(factory, this.signUpPageLocatorsObj);

	}

	public String do_HomePageURLVerification() {
		return driver.getCurrentUrl();

	}

	public String do_HomePageTitleVerification() {
		return driver.getTitle();
	}

	public boolean do_SignUpLinkVerification() {
		return signUpPageLocatorsObj.signUpLink.isDisplayed();
	}

	// Sign Up via new user credentials
	public void do_SignUp(String uName, String Password) {
		// click the SignUp link from top main menu
		signUpPageLocatorsObj.signUpLink.click();

		// Using explicit wait in order to enter username value when an alert appear
		sendKeys(driver, signUpPageLocatorsObj.txtUserName, 15, uName);

		// signUpPageLocatorsObj.txtPassword.sendKeys(password);
		sendKeys(driver, signUpPageLocatorsObj.txtPassword, 15, Password);

		signUpPageLocatorsObj.btnSignUp.click();

		// Click Ok when JS alert appear
		onAlertClick(driver, 15);
		Alert signupAlert = driver.switchTo().alert();
		System.out.println(signupAlert.getText());

		signupAlert.accept();

	}

	// Signup via existing user
	public void do_SignUpWithExistingUser(String uName, String Password) {
		// Using explicit wait in order to enter username value when an alert appear
		signUpPageLocatorsObj.txtUserName.clear();
		sendKeys(driver, signUpPageLocatorsObj.txtUserName, 15, uName);

		// signUpPageLocatorsObj.txtPassword.sendKeys(password);
		signUpPageLocatorsObj.txtPassword.clear();
		sendKeys(driver, signUpPageLocatorsObj.txtPassword, 15, Password);

		signUpPageLocatorsObj.btnSignUp.click();

		// Click Ok when JS alert appear
		onAlertClick(driver, 15);
		Alert signupAlert = driver.switchTo().alert();
		System.out.println(signupAlert.getText());

		signupAlert.accept();

	}

	// Sig-up when username or password is missing
	public void do_SignUpWithoutCredentials(String uName, String Password) {

		// Using explicit wait in order to enter username value when an alert appear
		signUpPageLocatorsObj.txtUserName.clear();
		sendKeys(driver, signUpPageLocatorsObj.txtUserName, 15, uName);

		// signUpPageLocatorsObj.txtPassword.sendKeys(password);
		signUpPageLocatorsObj.txtPassword.clear();
		sendKeys(driver, signUpPageLocatorsObj.txtPassword, 15, Password);

		signUpPageLocatorsObj.btnSignUp.click();

		// Click Ok when JS alert appear
		onAlertClick(driver, 15);
		Alert signupAlert = driver.switchTo().alert();
		System.out.println(signupAlert.getText());

		signupAlert.accept();

	}

	public void do_SignUpWithUserName_WithBlankPassword(String uName, String Password) {
		// Using explicit wait in order to enter username value when an alert appear
		signUpPageLocatorsObj.txtUserName.clear();
		sendKeys(driver, signUpPageLocatorsObj.txtUserName, 15, uName);

		// signUpPageLocatorsObj.txtPassword.sendKeys(password);
		signUpPageLocatorsObj.txtPassword.clear();
		sendKeys(driver, signUpPageLocatorsObj.txtPassword, 15, Password);

		signUpPageLocatorsObj.btnSignUp.click();

		// Click Ok when JS alert appear
		onAlertClick(driver, 15);
		Alert signupAlert = driver.switchTo().alert();
		System.out.println(signupAlert.getText());

		signupAlert.accept();
	}

	public void do_SignUpWithBlankUserName_andValidhPassword(String uName, String Password) {
		// Using explicit wait in order to enter username value when an alert appear
		signUpPageLocatorsObj.txtUserName.clear();
		sendKeys(driver, signUpPageLocatorsObj.txtUserName, 15, uName);

		// signUpPageLocatorsObj.txtPassword.sendKeys(password);
		signUpPageLocatorsObj.txtPassword.clear();
		sendKeys(driver, signUpPageLocatorsObj.txtPassword, 15, Password);

		signUpPageLocatorsObj.btnSignUp.click();

		// Click Ok when JS alert appear
		onAlertClick(driver, 15);
		Alert signupAlert = driver.switchTo().alert();
		System.out.println(signupAlert.getText());

		signupAlert.accept();

		linkClick(driver, signUpPageLocatorsObj.btnClose, 20);
		// signUpPageLocatorsObj.btnClose.click();

	}

}
