package w6PF.TestCases;

import java.time.Duration;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import w6PF.Pages.BookedFreightPagePF;
import w6PF.Pages.LoginPagePF;

public class AddFreightTest extends BaseTestPF {
	
	public static Logger log = LogManager.getLogger(LoginTestPF_1.class);
	
	@Test
    public void AddFreight() throws InterruptedException {
		
    	             	   
		LoginPagePF loginPage = PageFactory.initElements(driver, LoginPagePF.class);
        BookedFreightPagePF bookedFreights = PageFactory.initElements(driver, BookedFreightPagePF.class);
        
        loginPage.login(validUsername, validPassword);
        log.info("Entered Valid Login/Password and Click Login Button");
        
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[text()='Create Freight']")));

        bookedFreights.clickCreateFreightBtn();
        
        log.info("Clicked Create Freight Button");
        bookedFreights.enterFNO("16001");
        
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@name='Loaded']")));
        
        bookedFreights.selectDate("07-MAY-2024");
        
        Thread.sleep(5000);
        
	}
}
