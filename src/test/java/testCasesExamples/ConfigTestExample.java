package testCasesExamples;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Reporter;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;
import mainTestExamples.ConfigFileReader;

public class ConfigTestExample {
	
	WebDriver driver;
    String baseUrl;
    String username;
    String password;

	@BeforeClass
    public void setUp() {
    	ConfigFileReader configReader = new ConfigFileReader("C:\\Users\\babar.mumtaz\\git\\repository\\SATW6\\Config File\\config.properties");

        // Read properties
        String browserType = configReader.getPropertyValues("browser.firefox");
        baseUrl = configReader.getPropertyValues("url");
        username = configReader.getPropertyValues("valid.username");
        password = configReader.getPropertyValues("valid.password");

        // Set up WebDriver based on browser
        if (browserType.equalsIgnoreCase("chrome")) {
            //System.setProperty("webdriver.chrome.driver", "/path/to/chromedriver");   
        	 System.out.println("Chrome Browser Open");
    		WebDriverManager.chromedriver().setup();
            driver = new ChromeDriver();
            driver.manage().window().maximize();
        } 
        
        else if (browserType.equalsIgnoreCase("firefox")) {
        	 System.out.println("Firefox Browser Open");
        	WebDriverManager.firefoxdriver().setup();
            driver = new FirefoxDriver();
            driver.manage().window().maximize();
        } 
        
        else {
            throw new IllegalArgumentException("Unsupported browser specified in config.properties");
        }
    }

	@Test
    public void loginTest() throws InterruptedException {
        
		driver.get(baseUrl);
		
        // Perform login using username and password
        // Example: Assuming there are username and password fields and a login button
        // You should replace these with actual login actions for your application
        
        driver.findElement(By.xpath("//input[@id='mui-1']")).sendKeys(username);
        driver.findElement(By.xpath("//input[@id='mui-2']")).sendKeys(password);
        driver.findElement(By.cssSelector("button[type='submit']")).click();
        
        //Thread.sleep(7000);
        
        // Add an explicit wait for a specific element after login
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.className("logout")));

        
        // Verify login success by checking for logout button
		 boolean logoutButtonPresent = driver.findElement(By.className("logout")).isDisplayed();
       
       if (logoutButtonPresent) {
           Reporter.log("Login successful", true);
       } else {
           Reporter.log("Login failed", true);
       }
    }

    @AfterClass
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
}
