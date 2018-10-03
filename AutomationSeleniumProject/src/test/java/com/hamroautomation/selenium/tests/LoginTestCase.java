package com.hamroautomation.selenium.tests;

import java.util.List;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

import com.hamroautomation.selenium.config.Drivers;
import com.hamroautomation.selenium.data.model.Address;
import com.hamroautomation.selenium.data.model.Customer;
import com.hamroautomation.selenium.data.model.Login;
import com.hamroautomation.selenium.pages.UserPasswordPage;
import com.javalearning.library.ExcelFileReader;

public class LoginTestCase {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		WebDriver driver = Drivers.getChromeDriver("https://hamroautomation.wixsite.com/hamrofinancials/customer-1");
		
	    ExcelFileReader fileReader = new ExcelFileReader();
		
        String fileName = "loginInfo.xlsx";
        List<Login> loginList = fileReader.getObjectListFor(fileName, "login", Login.class);

		
		Login dataLogin = loginList.get(0);
		// populate customer
		//customer = ExcelReader.readData();
		
		
		UserPasswordPage userPasswordPage = PageFactory.initElements(driver, UserPasswordPage.class);
		userPasswordPage.clickSignUpButton();
		userPasswordPage.enterUserId(dataLogin);
		userPasswordPage.enterPassword(dataLogin);
		userPasswordPage.clickLoginBtn();

	    try {
		      Thread.sleep(5000);
		    }catch(Exception e) {
		    	
		    }

	    JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollBy(0,1000)");
        
 //       js.executeScript("while(true) { if(document.readyState === 'complete') { exit;}");
           
        fileName = "customer.xlsx";
        List<Customer> customerList = fileReader.getObjectListFor(fileName, "customer", Customer.class);
        Customer customer = customerList.get(0);
		com.hamroautomation.selenium.pages.CustomerPage customerPage = PageFactory.initElements(driver, com.hamroautomation.selenium.pages.CustomerPage.class);

		
		    
	    
		customerPage.enterFirstName(customer);
        customerPage.enterLastName(customer);
		customerPage.enterDOBName(customer);
		
	    try {
		      driver.wait(5000);
		    }catch(Exception e) {
		    	
		    }

	}

}
