package repository;

import org.openqa.selenium.By;

public class RegsiterPage {				//URL:	https://demowebshop.tricentis.com/
	//URL:	https://demowebshop.tricentis.com/
	public static By txt_title = By.name("merchantId");
	//lk_Register;   
	public static By lk_Register 	= By.xpath("/html/body/div[4]/div[1]/div[1]/div[2]/div[1]/ul/li[1]/a");
	public static By rbtn_Male 		= By.xpath("//input[@id='gender-male'][@name='Gender'][@type='radio'][@value='M']");
	public static By txt_FirstName 	= By.name("FirstName");
	public static By txt_LastName 	= By.name("LastName");
	public static By txt_Email 		= By.name("Email");
	public static By txt_Password 	= By.name("Password");
	public static By txt_ConfirmPassword = By.name("ConfirmPassword");
	public static By btn_Register 	= By.name("register-button");
	public static By txt_RegisteredMsg 	= By.xpath("/html/body/div[4]/div[1]/div[4]/div[2]/div/div[2]/div[1]");
	
	//register-button
	//lk_login
	//lk_shoppingcart
	//motext_lk_shoppingcart
	//lk_Wishlist
	//tbox_search
	//bt_search
	//tMn_BOOKS
	//tMn_CMPUTERS
		//lk_Desktops
		//lk_Notebooks
		//lk_Accessories
	//tMn_ELECTRONICS
		//lk_Camers,Photo
		//lk_Cell phones
	//tab_APPEARL&SHOES
	//tab_DIGITAL DOWNLOADS
	//tab_JEWELERY
	//tab_GIFTCARDS
	//LK_
}