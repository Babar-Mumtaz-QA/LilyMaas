package w6PF.TestCases;

import java.time.Duration;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.Test;

import w6PF.Pages.BookedFreightPagePF;
import w6PF.Pages.LoginPagePF;

public class LoginTestPF_2 extends BaseTestPF{
	
	public static Logger log = LogManager.getLogger(LoginTestPF_1.class);
		
		@Test
	    public void InvalidLoginTest() {
	    	             	   
			LoginPagePF loginPage = PageFactory.initElements(driver, LoginPagePF.class);
	        BookedFreightPagePF bookedFreights = PageFactory.initElements(driver, BookedFreightPagePF.class);
	        
	        loginPage.login(invalidUsername, invalidPassword);
	        log.info("Entered Invalid Login/Password and Click Login Button");
	        
	        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
	        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//h2[text()='Booked Freights']")));
	
			//Capture the page heading and print on console
	        String pageHeading = bookedFreights.getHeading();
			
	        if (pageHeading.equals("Booked Freights")) {

				//Reporter.log("Page title " + pageHeading, true);
				
				log.info("Page title " + pageHeading, true);
				
				Assert.assertTrue(true);

				//Reporter.log("Login Test case is passed", true);
				
				log.info("Login Test case is passed", true);
				
				// Add an explicit wait for a specific element after login
		        wait.until(ExpectedConditions.visibilityOfElementLocated(By.className("logout")));
				
				bookedFreights.clickLogout();
				
				log.info("Clicked Logout Button");
	
			} 
			
			else {
				
				Assert.assertTrue(false);
				//Reporter.log("Login Testcase is failed (Reason not confirmed yet)", true);
				log.error("Login Testcase is failed 'Invalid Login/Password'");
			}        
	   }
	}
