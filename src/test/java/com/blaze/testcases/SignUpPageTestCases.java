package com.blaze.testcases;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.blaze.actions.SignUpPageActions;
import com.blaze.base.TestBase;
import com.blaze.locators.SignUpPageLocators;

public class SignUpPageTestCases extends TestBase{

	SignUpPageLocators signUpPageLocatorsObj;
	SignUpPageActions signUpPageActionsObj;


	
	
	// class SignUpPageTestCases, loading prop file, excel file etc.
	public SignUpPageTestCases() throws Exception {
		super();

	}
	
	
	@BeforeTest
	public void setUp() throws Exception {
		initializeBrowser();
		signUpPageLocatorsObj = new SignUpPageLocators();
		signUpPageActionsObj = new SignUpPageActions();
	}

	
	@Test(priority = 1)
	public void do_HomePageURLVerificationTest() {
		SoftAssert softAssert = new SoftAssert();
		String homePageURL = signUpPageActionsObj.do_HomePageURLVerification();
		softAssert.assertEquals(homePageURL, "https://www.demoblaze.com/index.html");
		System.out.println(homePageURL);
		softAssert.assertAll();
	}
	
	
	@Test(priority = 2)
	public void do_HomePageTitleVerificationTest() {
		SoftAssert softAssert = new SoftAssert();
		String title = signUpPageActionsObj.do_HomePageTitleVerification();
		softAssert.assertEquals(title, "STORE");
		System.out.println(title);
		softAssert.assertAll();
	}
	
	@Test(priority = 3)
	public void do_SignUpLinkVerificationTest() {
		SoftAssert softAssert = new SoftAssert();
		boolean  SignUpLinkIsDisplayed = signUpPageActionsObj.do_SignUpLinkVerification();
		softAssert.assertTrue(SignUpLinkIsDisplayed);
		System.out.println(SignUpLinkIsDisplayed);
		softAssert.assertAll();
		
	}
	
	    // 'DataProvider' for user Sign-up
		@DataProvider(name ="do_SignUp")
		public Object[][] do_EnterOnwerData(){

			int rowCount = excelDataConfigObj.getRowCount(0); // Here 0 is sheet# for getting all Rows
			int columnCount = excelDataConfigObj.getRowColumnCount(0); // Here 0 is sheet# for getting all Columns

			String[][] data = new String[rowCount][columnCount];
			System.out.println("Rows=>" + rowCount + ", Columns=>" + columnCount); 

			// without sheet Heading columns
			for (int x = 0; x < rowCount; x++) {
				for (int y = 0; y < columnCount; y++) {
					data[x][y] = excelDataConfigObj.getData(0, x, y);
				}
			}
			return data;		
		}
	
	@Test(priority = 4, dataProvider = "do_SignUp")
	public void do_SignUpTest(String uName, String Password) {
	
		 signUpPageActionsObj.do_SignUp(uName, Password);
		
		
	}
	
	@Test(priority = 5, dataProvider = "do_SignUp")
	public void do_existingUserSignUpTest(String uName, String Password) {
		signUpPageActionsObj.do_SignUpWithExistingUser(uName, Password);
	}
	
	
	@Test(priority = 6, dataProvider = "do_SignUp")
	public void do_SignUpWithInvalidCredentialsTest(String uName, String Password) {
		signUpPageActionsObj.do_SignUpWithoutCredentials("", "");
		
	}
	
	@Test(priority = 7, dataProvider = "do_SignUp")
	public void do_SignUpWithUserName_WithBlankPasswordTest(String uName, String Password) {
		signUpPageActionsObj.do_SignUpWithUserName_WithBlankPassword(uName, "");
	}
	
	@Test(priority = 8, dataProvider = "do_SignUp")
	public void do_SignUpWithBlankUserName_WitValidPasswordTest(String uName, String Password) {
		signUpPageActionsObj.do_SignUpWithBlankUserName_andValidhPassword("",Password);
	}
	
	
}
