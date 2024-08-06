package w6PF.TestCases;

import java.time.Duration;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import com.github.javafaker.Faker;

import w6PF.Pages.BookedFreightPagePF;
import w6PF.Pages.LoginPagePF;

public class AddFreightTest extends BaseTestPF {

	public static Logger log = LogManager.getLogger(LoginTestPF_1.class);
	JavascriptExecutor js = ((JavascriptExecutor) driver);
	Faker faker = new Faker();

	@Test
	public void AddFreight() throws InterruptedException {

		LoginPagePF loginPage = PageFactory.initElements(driver, LoginPagePF.class);
		BookedFreightPagePF bookedFreights = PageFactory.initElements(driver, BookedFreightPagePF.class);

		loginPage.login(validUsername, validPassword);
		log.info("Entered Valid Login/Password and Click Login Button");

		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[text()='Create Freight']")));

		bookedFreights.clickCreateFreightBtn();

		String fnoNumber = faker.number().digits(8);

		log.info("Clicked Create Freight Button");
		bookedFreights.enterFNO(fnoNumber);

		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@name='Loaded']")));

		String day = "25";
		String month = "5";
		Thread.sleep(1000);
		String year = "2023";
		bookedFreights.enterDate(day, month, year);

		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@name='Arrival']")));

		String dayEta = "25";
		Thread.sleep(1000);
		String monthEta = "6";
		String yearEta = "2024";
		bookedFreights.enterETADate(dayEta, monthEta, yearEta);
		log.info("Entered ETA DATE");

		Thread.sleep(5000);

		bookedFreights.clickSaveReturnFreightBtn();

		bookedFreights.clickLogout();

		Thread.sleep(5000);

	}
}
