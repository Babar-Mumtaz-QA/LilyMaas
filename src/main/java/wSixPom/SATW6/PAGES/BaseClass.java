package wSixPom.SATW6.PAGES;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Reporter;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseClass {
	
	public WebDriver driver;
	
	 @BeforeClass
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
	
	 @AfterClass
	public void closeApplication()
	{
	  driver.quit();
	  Reporter.log("=====Browser Session End=====", true);
	}
}