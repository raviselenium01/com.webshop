package javaclasses;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;

public class Assignment2 {

	public static void main(String[] args) throws InterruptedException {
		String driverPath = ".\\Drivers\\geckodriver.exe";
	 	System.setProperty("webdriver.gecko.driver", driverPath);			
    	WebDriver driver=new FirefoxDriver();		
    	driver.manage().window().maximize();
		
		driver.get("https://demowebshop.tricentis.com/");
        
		//By class name
		driver.findElement(By.className("ico-login")).click();
		
		//By id
		driver.findElement(By.id("Email")).sendKeys("tsrivarshita@gmail.com");
		
		//By name
		driver.findElement(By.name("Password")).sendKeys("Sri@1234");
		 
		//By class name
		driver.findElement(By.className("login-button")).click();
		System.out.println("Login page completed----1");

		//By link text
        driver.findElement(By.linkText("Computers")).click();
//        Thread.sleep(3000);
        //By relative xpath
        driver.findElement(By.xpath("//img[@title='Show products in category Desktops']")).click();
        System.out.println("clicked on a image - Desktops");
//        Thread.sleep(3000);
		//By absolute xpath
        driver.findElement(By.xpath("/html[1]/body[1]/div[4]/div[1]/div[4]/div[2]/div[2]/div[2]/div[3]/div[1]/div[1]/div[1]/a[1]/img[1]")).click();
        System.out.println("clicked on a link - Build your own cheap computer");
//        Thread.sleep(3000);
        //By css - Tag & ID
        driver.findElement(By.cssSelector("input#product_attribute_72_5_18_65")).click();
        System.out.println("Radio button fast");
//        Thread.sleep(3000);
        //By css - Tag & attribute
		driver.findElement(By.cssSelector("input[type='radio'][value='55']")).click();
		System.out.println("Radio button 4 GB");

		//By css - Tag & class
		driver.findElement(By.cssSelector("input.add-to-cart-button")).click();
		System.out.println("clicked on  button ADD To Cart");

		//By xpath single attribute
		driver.findElement(By.xpath("//a[@href='/cart']")).click();
		System.out.println("clicked on  button popup bar");

		//By css - Tag, class and attribute
//		WebElement country = driver.findElement(By.xpath("/html/body/div[4]/div[1]/div[4]/div/div/div[2]/div/form/div[2]/div[1]/div[2]/div/div[3]/div[1]/select/option[2]"));
//		WebElement country = driver.findElement(By.id("CountryId"));
//		System.out.println("choose the country");
		
		Select drpCountry = new Select(driver.findElement(By.id("CountryId")));
		drpCountry.selectByValue("/html/body/div[4]/div[1]/div[4]/div/div/div[2]/div/form/div[2]/div[1]/div[2]/div/div[3]/div[1]/select/option[2]");
//		country.getText().contains("United States");
//		driver.findElement(By.id("CountryId"));
//		if(drpCountry.equals("United States")) {
//			JavascriptExecutor js = (JavascriptExecutor) driver;
//			js.executeScript("arguments[0].scrollIntoView();", Element);
//			System.out.println("click on united states");
//driver.findElement(By.xpath("/html/body/div[4]/div[1]/div[4]/div/div/div[2]/div/form/div[2]/div[1]/div[2]/div/div[3]/div[1]/select/option[2]"));
//		}
//		System.out.println("value not selected");
//		
//		System.out.println("choose the country");
////		country.getCssValue("United States");
//		System.out.println("clicked on  button popup");
//		Thread.sleep(3000);
driver.close();	
		
		
		
		
		
		
		
		
		
		
	}
}
