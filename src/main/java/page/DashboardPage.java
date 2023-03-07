package page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.testng.Assert;


public class DashboardPage {
	WebDriver driver;
	
	public DashboardPage(WebDriver driver) {
		this.driver= driver;
		
	}
	
	@FindBy(how=How.XPATH,using="//*[@id=\"side-menu\"]/li[2]/a/span")WebElement DASHBOARD_HEADER_ELEMENT;
	@FindBy(how=How.XPATH, using="//*[@id=\"side-menu\"]/li[3]/a/span[1]")WebElement CUSTOMER_MENU_ELEMENT;
	@FindBy(how=How.XPATH, using="//*[@id=\"side-menu\"]/li[3]/ul/li[1]/a")WebElement ADD_CUSTOMER_MENU_ELEMENT;
	@FindBy(how=How.XPATH, using="//*[@id=\"side-menu\"]/li[3]/ul/li[2]/a")WebElement LIST_CUSTOMER_MENU_ELEMENT;
	
	public void varifyDashboardPage(String dashboardText) {
		Assert.assertEquals(DASHBOARD_HEADER_ELEMENT.getText(), dashboardText, "Wrong Page");
	}
	
	public void clickOnCustomer() {
		CUSTOMER_MENU_ELEMENT.click();
		
	}

		public void clickOnAddCustomer() {
			ADD_CUSTOMER_MENU_ELEMENT.click();
		}
		
		public void clickOnListCustomer() throws InterruptedException {
			
			Thread.sleep(2000);
			LIST_CUSTOMER_MENU_ELEMENT.click();
			
		}
}
