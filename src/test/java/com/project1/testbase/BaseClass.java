package com.project1.testbase;

import java.io.FileInputStream;
import java.time.Duration;
import java.util.Properties;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;

import com.project1.pageobject.LoginPage;
import com.project1.utilities.Constants;

public class BaseClass {

	protected WebDriver driver;

	Properties prop;

	protected String url;

	protected String username;

	protected String password;

	LoginPage lp;

	protected WebDriverWait wait;

	public static Logger logger;

	public static String browser;

	@BeforeClass()
	@Parameters({"browser"})
	public void setUp(@Optional String browserName) throws Exception {

		loadProperties();

		logger = LogManager.getLogger(this.getClass());

//		System.out.println(getURL());
//		
//		System.out.println(getUsername());
		
		browser = getBrowser()!=null?getBrowser():browserName;
		
//		browser = browser.toLowerCase();		don't use NULL POINTER EXCEPTION

		if(browser==null || browser.isEmpty()){
			
			logger.error("Browser Driver Not Found");
			
		}
		
		else if (browser.equalsIgnoreCase("chrome")) {
			
			driver = new ChromeDriver();
			
			logger.info("Chrome Browser Initialized");
		}

		else if (browser.equalsIgnoreCase("firefox")) {
			
			driver = new FirefoxDriver();
			
			logger.info("FireFox Browser Initialized");
		}

		else if(browser.equalsIgnoreCase("edge")){
			
			driver = new EdgeDriver();
			
			logger.info("Edge Browser Initialized");
		}
		

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

	public String getBrowser() {

		browser = prop.getProperty("browser");

		return browser;
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
