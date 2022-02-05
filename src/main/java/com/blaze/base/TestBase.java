package com.blaze.base;

import java.io.FileInputStream;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.log4j.Logger;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.blaze.utilities.ExcelDataConfig;

public class TestBase {

	public static WebDriver driver;
	public static Properties prop;
	public static FileInputStream fis;
	public static ExcelDataConfig excelDataConfigObj = null;
	public static JavascriptExecutor js;
	
	public static Logger log = Logger.getLogger(TestBase.class); 

	// class consructor, load property & excel file etc.
	public TestBase() throws Exception {
		prop = new Properties();
		log.debug("Object got created of properties file");
		
		fis = new FileInputStream(
				System.getProperty("user.dir") + "\\src\\main\\java\\com\\blaze\\config\\config.properties");
		prop.load(fis);
		log.debug("FileInputStream path is setup");
		
		excelDataConfigObj = new ExcelDataConfig(
				System.getProperty("user.dir") + "\\src\\main\\java\\com\\blaze\\testdata\\BlazeDemo.xlsx");
		log.debug("Excel file path is setup");
	}

	public static void initializeBrowser() {
		String browerName = prop.getProperty("Browser");
		log.debug("Getting browser name from property file");
	
		System.out.print(browerName);
		log.debug("Browser name printing");

		if (browerName.equals("chrome")) {
			System.setProperty("webdriver.chrome.driver",
					System.getProperty("user.dir") + "\\src\\test\\resources\\drivers\\chromedriver.exe");
			log.debug("Chrome browser path is setup");
			DesiredCapabilities caps = new DesiredCapabilities();
			ChromeOptions options = new ChromeOptions();
			caps.setAcceptInsecureCerts(true);
			options.addArguments("--start-maximized");
			options.addArguments("--disable-extensions");
			options.addArguments("--disable-infobars");
			options.merge(caps);

			driver = new ChromeDriver(options);
			log.debug("Chrome launched");

			driver.manage().window().maximize();
			driver.manage().deleteAllCookies();
			driver.manage().timeouts().pageLoadTimeout(Constants.implicitWait, TimeUnit.SECONDS);
			driver.manage().timeouts().pageLoadTimeout(Constants.pageLoadTime, TimeUnit.SECONDS);

		}

		else if (browerName.equals("firefox")) {
			System.setProperty("webdriver.gecko.driver",
					System.getProperty("user.dir") + "\\src\\test\\resources\\drivers\\geckodriver.exe");
			driver = new FirefoxDriver();

			driver.manage().window().maximize();
			driver.manage().deleteAllCookies();
			driver.manage().timeouts().pageLoadTimeout(Constants.implicitWait, TimeUnit.SECONDS);
			driver.manage().timeouts().pageLoadTimeout(Constants.pageLoadTime, TimeUnit.SECONDS);

		}

		else if (browerName.equals("ie")) {

			System.setProperty("webdriver.ie.driver",
					System.getProperty("user.dir") + "\\src\\test\\resources\\drivers\\IEDriverServer.exe");
			driver = new InternetExplorerDriver();

			driver.manage().window().maximize();
			driver.manage().deleteAllCookies();
			driver.manage().timeouts().pageLoadTimeout(Constants.implicitWait, TimeUnit.SECONDS);
			driver.manage().timeouts().pageLoadTimeout(Constants.pageLoadTime, TimeUnit.SECONDS);
		}

		driver.get(prop.getProperty("TestSiteURL"));
		log.debug("URL launched...");

	}

	// Generic Functions
	// click element method
	public static void clickElement(WebElement element) {
		element.click();
		log.debug("Element got clicked" + element);
	}

	// send-key generic method
	public static void enterValue(WebElement element, String value) {
		if (!element.getText().isEmpty()) {
			element.clear();
		}

		element.sendKeys(value);

	}

	// drop-down field value selection
	public static void selectElement(WebElement element, String value) {
		Select selectObj = new Select(element);
		selectObj.selectByValue(value);

	}

	// Explicit wait in order to click or send keys when login or signup alert/popup
	// showing
	public static void sendKeys(WebDriver driver, WebElement locator, int Time, String value) {
		new WebDriverWait(driver, Time).ignoring(StaleElementReferenceException.class)
				.until(ExpectedConditions.elementToBeClickable(locator));
		locator.sendKeys(value);
	}

	public static void linkClick(WebDriver driver, WebElement locator, int Time) {
		new WebDriverWait(driver, Time).ignoring(StaleElementReferenceException.class)
				.until(ExpectedConditions.elementToBeClickable(locator));
		locator.click();

	}

	// Explicit wwait - Clicking Alert
	public static void onAlertClick(WebDriver driver, int time) {
		new WebDriverWait(driver, time).ignoring(StaleElementReferenceException.class)
				.until(ExpectedConditions.alertIsPresent());

	}
	

	

	//@AfterSuite
	public void tearDown() {
		if (driver != null)
			driver.quit();
	}

}
