package wSixPom.SATW6.TESTCASES;

import org.testng.Assert;
import org.testng.annotations.Test;

import wSixPom.SATW6.PAGES.BaseClass;
import wSixPom.SATW6.PAGES.LoginPage;

public class Login_TC2 extends BaseClass{
	
		@Test(description="InValid login")
		 public void loginToApplication2() throws Throwable
		 {
	
		   LoginPage loginPage = new LoginPage(driver);
		   loginPage.enterUsername("INVALID@gmail.com");
		   loginPage.enterPassword("INVALID");
		   loginPage.clickLogin();
		   
		   Thread.sleep(2000);
		   
			// Assert login failure
		   Assert.assertTrue(loginPage.getErrorMessage().contains("These credentials do not match our records."));   
		  
		   Thread.sleep(3000);
		 }

}
