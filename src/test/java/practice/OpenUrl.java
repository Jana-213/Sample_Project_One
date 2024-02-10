package practice;

import java.io.FileInputStream;
import java.time.Duration;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class OpenUrl {
	
	static String url;
	
	public static void main(String[] args) throws Exception {
		
		WebDriver driver = new ChromeDriver();
		
		FileInputStream fis = new FileInputStream(".\\src\\test\\resources\\config.properties");
		
		Properties prop = new Properties();
		
		prop.load(fis);
		
		url = prop.getProperty("url");
		
		driver.manage().window().maximize();
		
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
		
		driver.get(url);
		
		Thread.sleep(5000);
		
		driver.quit();
		
	}

}
