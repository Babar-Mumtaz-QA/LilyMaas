package wSixPom.SATW6.TESTCASES;

import org.testng.annotations.Test;
import wSixPom.SATW6.PAGES.BaseClass;
import wSixPom.SATW6.PAGES.BookedFreightsPage;

import wSixPom.SATW6.PAGES.LoginPage;


public class Login_TC1 extends BaseClass{

		 @Test(description="Valid login")
		 public void loginToApplication() throws Throwable
		 {
 
	    LoginPage loginPage = new LoginPage(driver);
	    
	    loginPage.enterUsername("bob@lilymaas.com");
	    loginPage.enterPassword("secret123");
	    loginPage.clickLogin();
	    
	    Thread.sleep(5000);
	    
	    BookedFreightsPage bookedFreights = new BookedFreightsPage(driver);
	    
		//Capture the page heading and print on console
	    String pageHeading = bookedFreights.getHeading();
	    System.out.println("Page Heading: " + pageHeading);
	    
	    bookedFreights.clickLogout();
	    
	    Thread.sleep(5000);
	    
		 }		 				 
		 
}
