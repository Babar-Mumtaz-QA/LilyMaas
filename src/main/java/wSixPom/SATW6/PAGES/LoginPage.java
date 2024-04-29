package wSixPom.SATW6.PAGES;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage {
	
		WebDriver driver;
		
		// Constructor that will be automatically called as soon as the object of the class is created
	    public LoginPage(WebDriver driver) {
	        this.driver = driver;
	    }
	    
		// Locators
	    By usernameField = By.xpath("//input[@id='mui-1']");
	    By passwordField = By.xpath("//input[@id='mui-2']");
	    By loginButton = By.cssSelector("button[type='submit']");
	    By errorMessage = By.xpath("//p[text()='These credentials do not match our records.']");
	    
	    
	    // Actions
	    public void enterUsername(String username) {
	        driver.findElement(usernameField).sendKeys(username);
	    }
	    
	    public void enterPassword(String password) {
	        driver.findElement(passwordField).sendKeys(password);
	    }
	    
	    public void clickLogin() {
	        driver.findElement(loginButton).click();
	    }
	    
	    public String getErrorMessage() {
	        return driver.findElement(errorMessage).getText();
	    }

}
