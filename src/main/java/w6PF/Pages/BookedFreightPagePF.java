package w6PF.Pages;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class BookedFreightPagePF {
	
	WebDriver driver;
	 Actions actions;
	
	//Constructor that will be automatically called as soon as the object of the class is created
	public BookedFreightPagePF(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
        this.actions = new Actions(driver);
    }
	
	 @FindBy(xpath = "//h2[text()='Booked Freights']")
	    WebElement heading;
	 
	 @CacheLookup
	 @FindBy(className = "logout")
	    WebElement logoutButton;
	 
	 @FindBy(xpath = "//button[text()='Create Freight']")
	    WebElement CreateFreight; 
	 
	 @FindBy(xpath = "//input[@name='FNO']")
	    WebElement FNO;
	    
	 @FindBy(xpath = "//input[@name='Loaded']")
	    WebElement ETDdatePicker;
	 
		@CacheLookup
		@FindBy(xpath = "//input[@name='Arrival']")
		WebElement ETAdatePicker;
	 
		@CacheLookup
		@FindBy(xpath = "//button[text()='Save & Return']")
		WebElement SaveReturnFreight;
		
		//---------------------------------------------------------------
	
	//Method to capture the page heading
	public String getHeading() {
		return heading.getText();
	}
	
	//Method to click on Logout button
	public void clickLogout() {
		logoutButton.click();
	}
	
	public void clickCreateFreightBtn() {
		CreateFreight.click();
	}
	
	public void enterFNO(String text) {
        // Click on date picker
        FNO.sendKeys(text);        
	}
	/*
	 * public void sendDate(String text) { // Click on date picker
	 * ETDdatePicker.sendKeys(text); }
	 */
	
	public void enterDate(String day, String month, String year) {

        actions.click(ETDdatePicker)
                .sendKeys(day)
                .sendKeys(month)
                .sendKeys(Keys.TAB)
                .sendKeys(year)
                .perform();
    }
	
	public void enterETADate(String dayEta, String monthEta, String yearEta) {

		actions.click(ETAdatePicker)
		.sendKeys(dayEta)
		.sendKeys(monthEta)
		.sendKeys(Keys.TAB)
		.sendKeys(yearEta).perform();
	}
	
	public void clickSaveReturnFreightBtn() {
		SaveReturnFreight.click();
	}
	
	

}
