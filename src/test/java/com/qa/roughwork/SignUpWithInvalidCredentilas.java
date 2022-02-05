package com.qa.roughwork;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class SignUpWithInvalidCredentilas {

	public static   WebDriver driver;
	
	public static void sendKeys(WebDriver driver, WebElement locator, int Time, String value) {
		new WebDriverWait(driver, Time).ignoring(StaleElementReferenceException.class).
		until(ExpectedConditions.elementToBeClickable(locator));
		//locator.click();
		locator.sendKeys(value);
	}
	
		//Explicit wwait - Clicking Alert
		public static void onClick(WebDriver driver, int time) {
			new WebDriverWait(driver, time).ignoring(StaleElementReferenceException.class)
					.until(ExpectedConditions.alertIsPresent());

		}
	
	public static void main(String[] args) {
	
		

		System.setProperty("webdriver.chrome.driver",
				"C:\\MyAutomationProject_2020\\SeleniumFiles\\chrome\\driver1\\chromedriver.exe");
		driver = new ChromeDriver();

		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
		driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);

		driver.get("https://www.demoblaze.com/index.html");

		// **Login
		// click Login-link from top main menu
		driver.findElement(By.cssSelector("#login2")).click();

		
		//Thread.sleep(2000);
		
		// enter username
		//driver.findElement(By.cssSelector("#loginusername")).sendKeys("azal45");
		sendKeys(driver, driver.findElement(By.cssSelector("#loginusername")), 20, "azal12");

		// enter password
		driver.findElement(By.cssSelector("#loginpassword")).sendKeys("");

		// click login
	    driver.findElement(By.xpath("//button[text()='Log in']")).click();
	    
	    onClick(driver, 15);
	    Alert alert = driver.switchTo().alert();
	    System.out.println(alert.getText());
	    alert.accept();
	    
	}
	
	
	
		//Please fill out Username and Password.
		
	


	}


