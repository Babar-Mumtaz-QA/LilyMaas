package testCasesExamples;

import java.time.Duration;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class LogExample {

	public static WebDriver driver;
	public static Logger log;
	
	public static void main(String[] args) {

		log= LogManager.getLogger(LogExample.class);

		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		log.info("Driver Initialization");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get("https://dev.lilymaas.appelit.com/");
		
		log.fatal("Fatal message");
		log.error("NO Error for now");
		log.warn("NO Warning message");
		log.info("Logged into LilyMaas");
		log.debug("Debug In case of error");
		log.trace("Trace the error");
		
		try {
			boolean button = driver.findElement(By.cssSelector("button[type='submit']")).isDisplayed();
		}
		catch(Exception e) {
			System.out.print(e.getMessage());
			log.error("Exception occured", new Exception("Element Not Found"));

		}
		
		finally {
			driver.quit();
			log.info("Quitting the driver");
		}
	}	
}