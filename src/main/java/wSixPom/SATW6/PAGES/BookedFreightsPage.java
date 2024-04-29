package wSixPom.SATW6.PAGES;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class BookedFreightsPage {
	
		WebDriver driver;
		
		//Constructor that will be automatically called as soon as the object of the class is created
		public BookedFreightsPage(WebDriver driver) {
			this.driver=driver;
		}
		
		//Locators for the page title and the logout button
		By heading = By.xpath("//h2[text()='Booked Freights']");
		By logoutBtn = By.className("logout");
		
		//Method to capture the page heading
		public String getHeading() {
			String head = driver.findElement(heading).getText();
			return head;
		}
		
		//Method to click on Logout button
		public void clickLogout() {
			driver.findElement(logoutBtn).click();
		}

}
