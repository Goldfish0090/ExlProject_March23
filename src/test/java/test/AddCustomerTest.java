package test;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

import page.AddCustomerPage;
import page.DashboardPage;
import page.LoginPage;
import util.BrowserFactory;
import util.ExcelReader;

public class AddCustomerTest {
	WebDriver driver;
	
	ExcelReader exlRead = new ExcelReader("C:\\Users\\Nesar Ahmed\\eclipse-workspace\\ExlProject\\testData\\TF_TestData (7).xlsx");
	String userName=exlRead.getCellData("LoginInfo", "UserName", 2);
	String password= exlRead.getCellData("LoginInfo", "Password", 2);
	String dashboardValidationText= exlRead.getCellData("LoginInfo", "DashboardValidationText", 2);
	String addContactValidationText= exlRead.getCellData("ContactInfo", "AddContactText", 2);
	String fullName= exlRead.getCellData("ContactInfo", "FullName", 2);
	String company= exlRead.getCellData("ContactInfo", "CompanyName", 2);
	String email= exlRead.getCellData("ContactInfo", "Email", 2);
	String phone= exlRead.getCellData("ContactInfo", "Phone", 2);
	String address= exlRead.getCellData("ContactInfo", "Address", 2);
	String city= exlRead.getCellData("ContactInfo", "City", 2);
	String state= exlRead.getCellData("ContactInfo", "State", 2);
	String zip= exlRead.getCellData("ContactInfo", "Zip", 2);
	String tag= exlRead.getCellData("ContactInfo", "Tag", 2);
	
    String country= exlRead.getCellData("ContactInfo", "Country", 2);
    
	//String country= "Albania";
	
	
	
	
	@Test
	public void validCustomerShouldBeAbleToCreateCustomer() throws InterruptedException {
		driver=BrowserFactory.init();
		
		LoginPage loginPage= PageFactory.initElements(driver, LoginPage.class);
	
		loginPage.insertUserName(userName);
		loginPage.insertPassword(password);
		loginPage.clickOnSignInButton();
		
		DashboardPage dashboardPage= PageFactory.initElements(driver, DashboardPage.class);
		dashboardPage.varifyDashboardPage(dashboardValidationText);
		dashboardPage.clickOnCustomer();
		dashboardPage.clickOnAddCustomer();
		
		AddCustomerPage addCustomerPage = PageFactory.initElements(driver, AddCustomerPage.class);
		
		addCustomerPage.varifyAddContactPage(addContactValidationText);
		addCustomerPage.insertFullName(fullName);
		addCustomerPage.selectCompany(company);
		addCustomerPage.insertEmail(email);
		
		addCustomerPage.insertPhone(phone);
		addCustomerPage.insertAddress(address);
		addCustomerPage.insertCity(city);
		addCustomerPage.insertState(state);
		addCustomerPage.insertZipCode(zip);
		
		addCustomerPage.selectCountry(country);
		//addCustomerPage.selectTag(tag);
		addCustomerPage.clickOnSaveInButton();
		
		dashboardPage.clickOnListCustomer();
		
		addCustomerPage.validateAndDeleteAddedNameOnListCustomer();
		}		

	
}