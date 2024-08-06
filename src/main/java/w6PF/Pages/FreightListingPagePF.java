package w6PF.Pages;

import java.util.List;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.aventstack.extentreports.model.Log;

public class FreightListingPagePF {
	
	WebDriver driver;
	JavascriptExecutor executor;
	Actions actions;

	// Constructor that will be automatically called as soon as the object of the
	// class is created
	public FreightListingPagePF(WebDriver driver) {
		this.driver = driver;
		this.executor = (JavascriptExecutor) this.driver;
		PageFactory.initElements(driver, this);
		this.actions = new Actions(driver);
	}

//	 ------------------------------------------------------------------------------------------------------------------------------------------------

	
	
	@CacheLookup
	@FindBy(xpath = "//ul[@class=\"MuiPagination-ul css-nhb8h9\"]/li[7]")
	WebElement PaginationLastPageIcon;
	
	@CacheLookup
	@FindBy(xpath = "//table[@id=\"grid\"]/tbody/tr")
	List<WebElement> FreightListRecords;
	
	@CacheLookup
	@FindBy(xpath = "//table[@id=\"grid\"]/tbody/tr[1]/td[8]")
	WebElement ClientCellLV;
	
	@CacheLookup
	@FindBy(xpath = "//img[@alt='View']")
	WebElement ViewFreightIcon;
	
//	 ------------------------------------------------------------------------------------------------------------------------------------------------

	
	public void ClickOnPaginationLastPageIcon() {
		PaginationLastPageIcon.click();
	}
	
	public void scrollToBottom() {
        executor.executeScript("window.scrollTo(0, document.body.scrollHeight);");
        //executor.executeScript("arguments[0].scrollIntoView(true);", element);
    }
	
	
	public void hoverOn1stRowClient() {
		actions.moveToElement(ClientCellLV).perform();
	}
	
	
	 // Method to get all records
    public List<WebElement> getFreightAllRecords() {
        return FreightListRecords;
    }

    // Method to hover over the last record
    public void hoverOverLastRecord() {
    	
    	scrollToBottom();
    	
    	try {
            Thread.sleep(3000); // Adjust the sleep time as necessary
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    	
        // Get the last record
        List<WebElement> records = getFreightAllRecords();
        System.out.println("Size of list:"+records.size());
        WebElement lastRecord = records.get(records.size() - 1);

        // Hover over the last record
        actions.moveToElement(lastRecord).perform();
    }
    
	
	public void ClickOnViewFreightIcon() {
		//actions.moveToElement(ViewFreightIcon).perform();
		ViewFreightIcon.click();
	}


}
