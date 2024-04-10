package testNGtestcases;

import java.util.Arrays;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import Utilities.BrowserActionsDWS;
import Utilities.BrowserFactory;
//import repositories.HPPpage;
import ExcelConnect.ExcelUtils;
//import basefunctions.ExcelUtils1;
//import basefunctions.RefNumber;
import repository.RegsiterPage;

public class TC01RegisterUser {
	WebDriver driver ;
	ExcelUtils excelUtils = new ExcelUtils();
	//	RefNumber RetrefNumber = new RefNumber();
	String ref1;
	/*Launch browser method*/
	@BeforeMethod
	public void beforeMethod() {
		BrowserFactory factory1 	= new BrowserFactory();
		driver 						= factory1.launchBrowser();
		BrowserActionsDWS actions 	= new BrowserActionsDWS();
//		System.out.println("Step01*****DemoWebShopURL is entered successfull****");
		actions.navigateUrl(driver);
		driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
	}

	@DataProvider
	public Object[][] dataProvi(){

		int i=1;
		String FirstName 		= excelUtils.readDataBasedOnRowAndCell(".\\DWSData\\DemoWebShop.xlsx","RegUser",i,0);
		String LastName 		= excelUtils.readDataBasedOnRowAndCell(".\\DWSData\\DemoWebShop.xlsx","RegUser",i,1);
		String Email 			= excelUtils.readDataBasedOnRowAndCell(".\\DWSData\\DemoWebShop.xlsx","RegUser",i,2);
		String Password 		= excelUtils.readDataBasedOnRowAndCell(".\\DWSData\\DemoWebShop.xlsx","RegUser",i,3);
		String ConfirmPassword 	= excelUtils.readDataBasedOnRowAndCell(".\\DWSData\\DemoWebShop.xlsx","RegUser",i,4);

		Object data[][]={{FirstName,LastName,Email,Password,ConfirmPassword}};
		//			System.out.println("This is the Getting Data from Xcel :: "+Arrays.toString(data));
		return data;
	}
	@Test (dataProvider = "dataProvi")
	public void SBSAMarkoffTest(String FirstName,String LastName,String Email,String Password,String ConfirmPassword) throws InterruptedException
	{
		BrowserActionsDWS actions = new BrowserActionsDWS();
		actions.Click1(driver, RegsiterPage.lk_Register,"Register");								//click on link Register
		System.out.println("Step02");
		actions.Click1(driver, RegsiterPage.rbtn_Male,"Male");
		System.out.println("Step03");
		actions.clearAndEnter(driver, RegsiterPage.txt_FirstName, FirstName,"FirstName");
		System.out.println("Step04");
		actions.clearAndEnter(driver, RegsiterPage.txt_LastName, LastName,"LastName");
		System.out.println("Step05");
		actions.clearAndEnter(driver, RegsiterPage.txt_Email, Email,"Email");
		System.out.println("Step06");
		actions.clearAndEnter(driver, RegsiterPage.txt_Password, Password,"Password");
		System.out.println("Step07");
		actions.clearAndEnter(driver, RegsiterPage.txt_ConfirmPassword, Password,"Confirm Password");
		System.out.println("Step08");
		actions.Click1(driver, RegsiterPage.btn_Register,"ButtonRegister");
		ref1= actions.getElementText(driver, RegsiterPage.txt_RegisteredMsg,"Registered Message");
		System.out.println("Message after successful registration: "+ref1);
		System.out.println("Step09");
		driver.quit();
	}
	//	    @AfterMethod
	//		public void afterMethod(ITestResult result) {
	//			if(result.getStatus() == ITestResult.SUCCESS) {
	//				System.out.println("Step24");
	//				excelUtils.writeDataBasedOnRowAndCell(".\\TestData\\MarkoffTest.xlsx","SBSAMer",1,10,ref1);
	//			}else if(result.getStatus() == ITestResult.FAILURE) {
	//				excelUtils.writeDataBasedOnRowAndCell(".\\TestData\\MarkoffTest.xlsx","SBSAMer",1,10,ref1);
	//			}
	//			driver.quit();
	//	    }
}
