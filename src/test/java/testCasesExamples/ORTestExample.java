package testCasesExamples;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Reporter;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;
import mainTestExamples.ObjectRepositoryReader;

public class ORTestExample {
		  
	  WebDriver driver ;
	  
	  // Create an instance of ObjectRepository
      ObjectRepositoryReader objectRepository = new ObjectRepositoryReader("C:\\Users\\babar.mumtaz\\SATW6\\BareGitRepo\\SATW6\\Config File\\ObjectRepo.properties");

		
	  @BeforeMethod
		public void setupApplication()
		{
		  Reporter.log("=====Browser Session Started=====", true);
		  
		  // Set the path to the ChromeDriver executable
		  WebDriverManager.chromedriver().setup();
		  // Initialize ChromeDriver
		  driver=new ChromeDriver();
		  // Maximize the browser window	
		  driver.manage().window().maximize();
		  
		  String PageURL = "https://dev.lilymaas.appelit.com/";
		  driver.get(PageURL);
		  
		  Reporter.log("=====Application Started=====", true);
		}
	  
	  
	  @Test
		public void LoginTest() throws InterruptedException {
		  
		  // getProperty Fetches the value of target key from the properties file 
		  // In this case entering username, password and login button locator Value
		  	WebElement usernameField = driver.findElement(By.xpath(objectRepository.getLocator("usernameField")));
	        WebElement passwordField = driver.findElement(By.xpath(objectRepository.getLocator("passwordField")));
	        WebElement loginButton = driver.findElement(By.cssSelector(objectRepository.getLocator("loginButton")));
	        
	        usernameField.sendKeys("bob@lilymaas.com");
	        passwordField.sendKeys("secret123");
	        loginButton.click();
	        Thread.sleep(5000); 
	        
	}
		
		
		
		@AfterMethod
		public void closeApplication()
		{
		  driver.quit();
		  Reporter.log("=====Browser Session End=====", true);
		}

}
