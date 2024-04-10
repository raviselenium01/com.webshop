package Utilities;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Date;
import java.util.Random;
import java.util.Timer;

import org.apache.commons.exec.util.StringUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriver.Timeouts;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
//import org.testng.Assert;

public class BrowserActionsDWS {
	//	WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(10));
	public void navigateUrl(WebDriver driver) 
	{
		driver.get("https://demowebshop.tricentis.com/");
		System.out.println("DemoWebShop URL entered successfully");
		String title = driver.getTitle();
		System.out.println(title);
	} 
	public void Click1(WebDriver driver, By locator,String message)  						//To click on the link Register
	{
		try {
			waitForClickable(driver,locator);
			driver.findElement(locator).click();
			//WebElement inputBox1 = driver.findElement(By.name(sRequestButton));
			//			inputBox1.click();
			System.out.println("Successfully Clicked "+ message);
		}catch (Exception e) {
			System.out.println("Failure to Click "+ message);
			//			Assert.fail("Failure to Click "+ message);
			e.printStackTrace();
		}
	}
	public void clearAndEnter(WebDriver driver, By locator, String input, String message) 	//To enter data into text field
	{
		//wait for element
		try {
			driver.findElement(locator).clear();
			driver.findElement(locator).sendKeys(input);
			System.out.println("Successfully entered text "+ message);
		}catch (Exception e) {
			System.out.println("Failure to enter text "+ message);
		}
	}
	public void clickOnButton(WebDriver driver, By locator,String message)  				//To click on the buttons
	{
		try {
			waitForClickable(driver,locator);
			driver.findElement(locator).click();
			System.out.println("Successfully Clicked "+ message);
		}catch (Exception e) {
			System.out.println("Failure to Click "+ message);
		}
	}
	public void MerchantSubmit(WebDriver driver, By locator,String message)  
	{
		try {
			waitForClickable(driver,locator);
			driver.findElement(locator).click();
			//WebElement inputBox1 = driver.findElement(By.name(sRequestButton));
			//			inputBox1.click();
			System.out.println("Successfully Clicked "+ message);
		}catch (Exception e) {
			System.out.println("Failure to Click "+ message);
			//			Assert.fail("Failure to Click "+ message);
			e.printStackTrace();
		}
	}
	public String successpage(WebDriver driver,By locator, String message) {
		//		driver.findElements(By.tagName("h1")).contains(This Worked);
		WebElement ele3 = driver.findElement(locator);
		System.out.println("Text in the page is "+ ele3);
		return message;
	}
	public void Clickjs(WebDriver driver, By locator,String message)  
	{
		try {
			WebElement ele = waitForClickable(driver,locator);
			JavascriptExecutor js =(JavascriptExecutor)driver;
			js.executeScript("arguments[0].click()", ele);
			//driver.findElement(locator).click();
			//WebElement inputBox1 = driver.findElement(By.name(sRequestButton));
			//			inputBox1.click();
			System.out.println("Successfully Clicked "+ message);
		}catch (Exception e) {
			System.out.println("Failure to Click "+ message);
			//			Assert.fail("Failure to Click "+ message);
			e.printStackTrace();
		}
	}
	public String getOrderNumber(WebDriver driver, By locator,String message) throws InterruptedException 
	{
		try {
			WebElement ele = waitForClickable(driver,locator);
			System.out.println("Successfully Got element text "+ message);
			return ele.getText();			
		}catch (Exception e) {
			System.out.println("Failure to Get element text "+ message);
			//			Assert.fail("Failure to Get element text "+ message);
			e.printStackTrace();
			return null;
		}
	}
	public String getElementText(WebDriver driver, By locator,String message) throws InterruptedException 
	{
		try {
			WebElement ele = waitForClickable(driver,locator);
			System.out.println("Successfully Got element text "+ message);
			return ele.getText();			
		}catch (Exception e) {
			System.out.println("Failure to Get element text "+ message);
			//			Assert.fail("Failure to Get element text "+ message);
			e.printStackTrace();
			return null;
		}
	}
	public void ClickEleWithoutWait(WebDriver driver, By locator, String message) throws InterruptedException 
	{
		try {
			Thread.sleep(3000);
			driver.findElement(locator).click();
			//WebElement inputBox1 = driver.findElement(By.name(sRequestButton));
			//			inputBox1.click();
			System.out.println("Successfully Clicked "+message);
		}catch (Exception e) {
			System.out.println("Failure to Click");
			//			Assert.fail("Failure to Click");
			e.printStackTrace();
		}
	}
	public WebElement waitForClickable(WebDriver driver, By locator) 
	{
		try {
			WebDriverWait wait = new WebDriverWait(driver, 60);
			return wait.until(ExpectedConditions.elementToBeClickable(locator));
		}catch (Exception e) {

			return null;
		}
	}

	public void switchToFrame(WebDriver driver, By locator, String message)
	{
		try {
			WebElement ele = waitForClickable(driver, locator);
			driver.switchTo().frame(ele);
			System.out.println("Successfully switch iframe "+ message);
		}catch (Exception e) {
			System.out.println("Card is Failing to Enter 3DSecure Frame "+ message);
			//			Assert.fail("Failure to switch frame "+ message);
		}
	}
	public void switchToDefault(WebDriver driver)
	{
		try {
			//			WebElement ele = waitForClickable(driver, locator);
			WebDriver driver1 = driver.switchTo().defaultContent();
			System.out.println("Successfully switched to Default Frame ");
			//return driver1;
		}catch (Exception e) {
			System.out.println("Failed to switch to Default Frame  ");
			//			Assert.fail("Failed to switch to Default Frame  ");
			//return null;
		}
	}
	public void selectValfromDDUsingText(WebDriver driver, By locator,String input, String message)
	{
		try {
			WebElement ele = waitForClickable(driver, locator);
			Select select = new Select(ele);
			select.selectByVisibleText(input);
			System.out.println("Successfully Select vlaue from dropdown "+ message);
		}catch (Exception e) {
			System.out.println("Failure to Select vlaue from dropdown "+ message);
			//			Assert.fail("Failure to Select vlaue from dropdown "+ message);
		}
	}
	/*7-8-2022*/
	public void numofframes(WebDriver driver) {

		try {
			int ele2 =driver.findElements(By.tagName("iframe")).size();
			System.out.println("Number of iframes in the page: "+ ele2);
		}catch (Exception e){
			System.out.println("No Iframes in the page ");

		}
	}
	/*12-8-2022*/
	public void EnterRefNumbers(WebDriver driver,By locator, String input, String message) {

		try {
			Random random = new Random();
			int randomNumber = random.nextInt(1000000000);
			String refNumber = Integer.toString(randomNumber);
			driver.findElement(locator).clear();
			driver.findElement(locator).sendKeys(refNumber);
			System.out.println("Successfully entered text "+ message);
			System.out.println(refNumber);
			/*how to check which data type is that variable belongs*/
			System.out.println(refNumber.getClass().getName());
		}catch (Exception e){
			System.out.println("Failure to enter the Reference number  ");
		}
	}
	public void RefNumbersWithDate(WebDriver driver,By locator, String input, String message) {

		try {
			Date thisDate = new Date();
			SimpleDateFormat randomNumber = new SimpleDateFormat("yyyyMMddhhmmss");
			String refNumber = randomNumber.format(thisDate);
			driver.findElement(locator).clear();
			driver.findElement(locator).sendKeys(refNumber);
			System.out.println("Successfully entered text "+ message);
			System.out.println(refNumber);
			/*how to check which data type is that variable belongs*/
			System.out.println(refNumber.getClass().getName());
		}catch (Exception e){
			System.out.println("Failure to enter the Reference number  ");
		}
	}
	/*13-8-2022*/
	public String getResponseText(WebDriver driver, By locator,String message) throws InterruptedException 
	{
		try {
			WebElement ele = waitForClickable(driver,locator);
			System.out.println("Successfully Got element text "+ message);
			return ele.getText();			
		}catch (Exception e) {
			WebElement ele1 = waitForClickable(driver,locator);
			System.out.println("Either failure on the card or we are not getting response from Acquirer "+ message);
			return ele1.getText();
		}
	}
	/*18-11-2022*/	
	public String getResponseText2(WebDriver driver, By locator,String message) throws InterruptedException 
	{
		try {
			WebElement ele3 = waitForClickable(driver,locator);
			System.out.println("Successfully Got element text "+ message);
			return ele3.getText();			
		}catch (Exception e) {
			WebElement ele4 = waitForClickable(driver,locator);
			System.out.println("Failure to Get element text "+ message);
			return ele4.getText();
		}
	}
	/*19-11-2022*/
	//	public void AutoRefNumbers2(WebDriver driver,By locator, String input, String message) {
	//		
	//		try {
	//			Random random = new Random();
	//			int Num1 = random.nextInt(100000000);
	//			int Num2 = random.nextInt(100000000);
	//			int Num3 = random.nextInt(100000000);
	//			int Num4 = random.nextInt(100000000);
	//			int Num5 = random.nextInt(100000000);
	////			String result =StringUtils.rightPad(str, L, ch)
	////			String refNumber = Integer.toString(randomNumber);
	//			String refNumber = (String.valueOf(Num1)+String.valueOf(Num2)+String.valueOf(Num3)+String.valueOf(Num4)+String.valueOf(Num5));
	////			String refNumber = Number1+Number2;
	////			String refNumber2 = "Rond"+refNumber;
	//			driver.findElement(locator).clear();
	//			driver.findElement(locator).sendKeys(refNumber);
	//			System.out.println("Successfully entered text "+ message);
	//			System.out.println(refNumber);
	///*how to check which data type is that variable belongs*/
	////			System.out.println(refNumber.getClass().getName());
	//		}catch (Exception e){
	//			System.out.println("Failure to enter the Reference number  ");
	//		}
	//	}
	/*15-8-2022*/
	public void AutoRefNumbers(WebDriver driver,By locator, String input, String message) {

		try {
			Random random = new Random();
			int randomNumber = random.nextInt(100000000);
			String refNumber = Integer.toString(randomNumber);
			String refNumber2 = "Rond"+refNumber;
			driver.findElement(locator).clear();
			driver.findElement(locator).sendKeys(refNumber2);
			System.out.println("Successfully entered text "+ message);
			System.out.println(refNumber2);
			/*how to check which data type is that variable belongs*/
			//			System.out.println(refNumber.getClass().getName());
		}catch (Exception e){
			System.out.println("Failure to enter the Reference number  ");
		}
	}
	//=================20-12-2023============
	public void quitBrowser(WebDriver driver) {
		driver.quit();
		//			System.out.println("Successfully closed browser "+ message);	
	}
}

/*All the above functions are called into respective payment method pages by creating an object*/