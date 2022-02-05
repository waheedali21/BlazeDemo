package com.blaze.testcases;

import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.blaze.actions.LoginPageActions;
import com.blaze.base.TestBase;
import com.blaze.locators.LoginPageLocators;

public class LoginPageTestCases extends TestBase {
	
	LoginPageLocators LoginPageLocatorsObj;
	LoginPageActions LoginPageActionsObj;
	

	//class SignUpPageTestCases, loading prop file, excel file etc.
	public LoginPageTestCases() throws Exception {
		super();
	
		log.debug("Loading properties file, excel file from test base class");
		
	}
	
	
	@BeforeSuite
	public void setUp() throws Exception {
		initializeBrowser();
		log.debug("Browser got initialized and launched ");
		LoginPageLocatorsObj = new LoginPageLocators();
		LoginPageActionsObj = new LoginPageActions();
	}
	
	
	
	@Test(priority = 9)
	public void do_loginTest() {
		LoginPageActionsObj.do_login("azal61", "asdf");
		log.debug("Login successfully");
	}
	
	
	@Test(priority = 10)
	public void do_URLVerificationTest() {
		SoftAssert softAssert = new SoftAssert();
		
		String url = LoginPageActionsObj.do_URLVerification();
		System.out.println(url);
		softAssert.assertEquals(url, "https://www.demoblaze.com/index.html");
		log.debug("Home page url got verified");
			
	}

}
