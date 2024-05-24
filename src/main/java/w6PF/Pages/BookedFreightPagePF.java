package w6PF.Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class BookedFreightPagePF {
	
	WebDriver driver;
	
	//Constructor that will be automatically called as soon as the object of the class is created
	public BookedFreightPagePF(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
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
		/*
		 * 
		 * @FindBy(xpath = "//input[@name='FNO']") WebElement ;
		 * 
		 * @FindBy(xpath = "//input[@name='FNO']") WebElement ;
		 * 
		 * @FindBy(xpath = "//input[@name='FNO']") WebElement ;
		 * 
		 * @FindBy(xpath = "//input[@name='FNO']") WebElement ;
		 * 
		 * @FindBy(xpath = "//input[@name='FNO']") WebElement ;
		 * 
		 * @FindBy(xpath = "//input[@name='FNO']") WebElement ;
		 * 
		 * @FindBy(xpath = "//input[@name='FNO']") WebElement ;
		 * 
		 * @FindBy(xpath = "//input[@name='FNO']") WebElement ;
		 * 
		 */
	
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
	
	public void selectDate(String date) {
        // Click on date picker
        ETDdatePicker.click();       
	}
	

}
