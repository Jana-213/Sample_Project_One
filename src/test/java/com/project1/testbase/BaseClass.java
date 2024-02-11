package com.project1.testbase;

import java.io.FileInputStream;
import java.time.Duration;
import java.util.Properties;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

import com.project1.pageobject.LoginPage;
import com.project1.utilities.Constants;

public class BaseClass{
	
	protected WebDriver driver;
	
	Properties prop;
	
	protected String url; 
	
	protected String username;
	
	protected String password;
	
	LoginPage lp;
	
	protected WebDriverWait wait;
	
	public static Logger logger;
	
	@BeforeClass
	public void setUp() throws Exception {
		
		loadProperties();
		
		logger = LogManager.getLogger(this.getClass());
		
//		System.out.println(getURL());
//		
//		System.out.println(getUsername());
		
		driver = new ChromeDriver();
		
		wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		
		driver.manage().window().maximize();
		
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
		
		logger.info("*** Session Started ***");
		
	}
	
	@AfterClass
	public void tearDown() {
		
		driver.quit();
		
		logger.info("*** Session Ended ***");
	}
	
public void loadProperties() throws Exception {
		
		FileInputStream fis = new FileInputStream(Constants.configPath);
		
		prop = new Properties();
		
		prop.load(fis);
	}
	
	public String getURL() {
		
		url = prop.getProperty("url");
		
		return url;
	}
	
	public String getUsername() {
		
		username = prop.getProperty("username");
		
		return username;
	}
	
	public String getPassword() {
		
		password = prop.getProperty("password");
		
		return password;
	}
	

	public LoginPage openUrl() {
		
		driver.get(getURL());
		
		return new LoginPage(driver);
	}
	
	public void waitTillElementToBeClickable(WebElement ele) {
		
		wait.until(ExpectedConditions.elementToBeClickable(ele));
	}
	
	public void waitTillElementIsSelected(WebElement ele) {
		
		wait.until(ExpectedConditions.elementToBeSelected(ele));
	}
	
	public void waitTillElementIsVisible(WebElement ele) {
		
		wait.until(ExpectedConditions.visibilityOf(ele));
	}
	
	public void sleep() throws Exception {
		
		Thread.sleep(5000);
	}
	
	public void refreshPage() {
		
		driver.navigate().refresh();
	}

}
