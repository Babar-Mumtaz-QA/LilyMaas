package w6PF.TestCases;

import java.time.Duration;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.github.javafaker.Faker;

import w6PF.Pages.BookedFreightPagePF;
import w6PF.Pages.FreightListingPagePF;
import w6PF.Pages.LoginPagePF;

public class FreightDetailPage extends BaseTestPF {

	public static Logger log = LogManager.getLogger(LoginTestPF_1.class);
	JavascriptExecutor js = ((JavascriptExecutor) driver);
	Faker faker = new Faker();

	@Test
	public void ClickViewIcon() throws InterruptedException {

		LoginPagePF loginPage = PageFactory.initElements(driver, LoginPagePF.class);
		BookedFreightPagePF bookedFreights = PageFactory.initElements(driver, BookedFreightPagePF.class);
		FreightListingPagePF freightListing = PageFactory.initElements(driver, FreightListingPagePF.class);

		loginPage.login(validUsername, validPassword);
		log.info("Entered Valid Login/Password and Click Login Button");

		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[text()='Create Freight']")));

		Assert.assertTrue(bookedFreights.getHeading().contains("Booked Freights"), "Heading not Matched");

		freightListing.ClickOnPaginationLastPageIcon();

		Thread.sleep(5000);

		/*
		 * freightListing.scrollToBottom();
		 * 
		 * Thread.sleep(5000);
		 */

		freightListing.hoverOverLastRecord();
		log.info("Hover over 1st Row");

		Thread.sleep(5000);

		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//img[@alt='View']")));
		freightListing.ClickOnViewFreightIcon();
		log.info("Hover over View Icon and click");

		Thread.sleep(5000);

		bookedFreights.clickLogout();

		// js.executeScript("
		// document.querySelector('input[name=\"Loaded\"]').value='2022-12-12'");

	}
}
