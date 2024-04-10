package Utilities;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class BrowserFactory 
{
	public WebDriver launchBrowser() 
	{
//		System.setProperty("webdriver.chrome.driver", "D:\\Venkat Selenium\\com.webshop\\Drivers\\chromedriver.exe");
//		WebDriver driver = new ChromeDriver();
//		driver.manage().window().maximize();
//		return driver;
		
//	2. Firefox driver
			System.setProperty("webdriver.gecko.driver", "D:\\Venkat Selenium\\com.webshop\\Drivers\\geckodriver.exe");
			WebDriver driver = new FirefoxDriver();
			driver.manage().window().maximize();
			return driver;
//3. Edge driver
		//	System.setProperty("webdriver.edge.driver", "D:\\Venkat Selenium\\com.webshop\\Drivers\\msedgedriver.exe");
		//	WebDriver driver = new EdgeDriver();
		//	driver.manage().window().maximize();
		//	return driver;
	}
}