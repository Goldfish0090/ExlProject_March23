package page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.ui.ExpectedConditions;

import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
public class AddCustomerPage extends BasePage{

WebDriver driver;

	public AddCustomerPage(WebDriver driver) {
		this.driver= driver;
		
	}
	
	@FindBy(how=How.XPATH,using="//*[@id=\"page-wrapper\"]/div[3]/div[1]/div/div/div/div[1]/h5")WebElement ADD_CONTACT_HEADER_ELEMENT;
	@FindBy(how=How.XPATH, using="//*[@id=\"account\"]")WebElement FULL_NAME_ELEMENT;
	@FindBy(how=How.XPATH, using="//*[@id=\"cid\"]")WebElement COMPANY_ELEMENT;
	@FindBy(how=How.XPATH, using="//*[@id=\"phone\"]")WebElement PHONE_ELEMENT;
	@FindBy(how=How.XPATH, using="//*[@id=\"email\"]")WebElement EMAIL_ELEMENT;
	@FindBy (how= How.XPATH,using= "//*[@id=\"country\"]")WebElement COUNTRY_ELEMENT;
	@FindBy (how= How.XPATH, using="//*[@id=\"address\"]")WebElement ADDRESS_ELEMENT;
	@FindBy (how= How.XPATH, using="//*[@id=\"city\"]")WebElement CITY_ELEMENT;
	@FindBy (how= How.XPATH, using="//*[@id=\"state\"]")WebElement STATE_ELEMENT;
	@FindBy (how= How.XPATH, using="//*[@id=\"zip\"]")WebElement ZIPCODE_ELEMENT;
	@FindBy(how=How.XPATH, using="//*[@id=\"submit\"]")WebElement SAVE_BUTTON_ELEMENT;
	
	
	
	public void varifyAddContactPage(String AddContactHeaderText) {
		WebDriverWait wait = new WebDriverWait(driver,20);
		
		wait.until(ExpectedConditions.visibilityOf(ADD_CONTACT_HEADER_ELEMENT));
			
	Assert.assertEquals(ADD_CONTACT_HEADER_ELEMENT.getText(), AddContactHeaderText, "Wrong Page");
}
	
	
	String insertedName;
	public void insertFullName(String fullName) {
		insertedName=fullName + generateRandomNum(9999);
		FULL_NAME_ELEMENT.sendKeys(insertedName);
	}
	
	public void selectCompany(String company) {
		selectFromDropdown(COMPANY_ELEMENT, company);
		}

	public void insertEmail(String email) {
		 EMAIL_ELEMENT.sendKeys(generateRandomNum(9999) + email);
	}
	
	public void insertPhone(String PhoneNum) {
		PHONE_ELEMENT.sendKeys(PhoneNum + generateRandomNum(999));
	}
	
	public void insertAddress(String Address) {
		ADDRESS_ELEMENT.sendKeys(Address);
	}
	
	public void insertCity(String City) {
		CITY_ELEMENT.sendKeys(City);
	}
	
	public void insertState(String State) {
		STATE_ELEMENT.sendKeys(State);
	}
	
	public void insertZipCode(String Zip) {
		ZIPCODE_ELEMENT.sendKeys(Zip);
	}
	
	public void selectCountry(String country) {
		selectFromDropdown(COUNTRY_ELEMENT, country);
	}
	
	//public void selectTag(String tag) {
	//	selectFromDropdown(TAG_ELEMENT, tag);
	//}
	
	public void clickOnSaveInButton() {
		SAVE_BUTTON_ELEMENT.click();
}
	//tbody/tr[1]/td[3]
	//tbody/tr[2]/td[3]
	//tbody/tr[3]/td[3]
	//tbody/tr[4]/td[3]
	//tbody/tr[1]/td[7]/a[2] delete button
	
	String begining_xpath="//tbody/tr[" ;
	String after_xpath= "]/td[3]";
	String after_xpath_delete="]/td[7]/a[2]";
	
	public void validateAndDeleteAddedNameOnListCustomer() {
		
		for(int i=1; i<=10; i++) {
			
					//driver.findElement(By.xpath("//tbody/tr[" +i+"1]/td[3]" ));
		String nameOnList=driver.findElement(By.xpath(begining_xpath +i+after_xpath)).getText();
		System.out.println(nameOnList);
		
					//Assert.assertEquals(nameOnList, insertedName, "Name does not exist!!!!!!");
					//break;
		
	if(nameOnList.contains(insertedName)) {
	System.out.println("Entered name exists!!!");
	driver.findElement(By.xpath(begining_xpath +i + after_xpath_delete)).click();
	break;
		}
		
	}
	}
}
	
	