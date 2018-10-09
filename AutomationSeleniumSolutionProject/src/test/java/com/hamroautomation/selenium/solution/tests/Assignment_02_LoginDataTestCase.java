package com.hamroautomation.selenium.solution.tests;

import java.util.List;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

import com.hamroautomation.selenium.solution.config.Drivers;
import com.hamroautomation.selenium.solution.data.model.Customer;
import com.hamroautomation.selenium.solution.data.model.Login;
import com.hamroautomation.selenium.solution.pages.CustomerPage;
import com.hamroautomation.selenium.solution.pages.UserPasswordPage;
import com.javalearning.library.ExcelFileReader;

public class Assignment_02_LoginDataTestCase {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		WebDriver driver = Drivers.getChromeDriver("https://hamroautomation.wixsite.com/hamrofinancials/customer-1");
		
	    ExcelFileReader fileReader = new ExcelFileReader();
		
        String fileName = "loginInfo.xlsx";
        List<Login> loginList = fileReader.getObjectListFor(fileName, "login", Login.class);

		
		Login dataLogin = loginList.get(0);
		
		UserPasswordPage userPasswordPage = PageFactory.initElements(driver, UserPasswordPage.class);
		userPasswordPage.clickLoginLnk();
		userPasswordPage.enterUserId(dataLogin);
		userPasswordPage.enterPassword(dataLogin);
		userPasswordPage.clickLoginBtn();

	    try {
	    	//Delay so that the UI page renders the web elements.
		      Thread.sleep(5000);
		    }catch(Exception e) {
		    	
		    }

	    JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollBy(0,1000)");
        
        fileName = "customer.xlsx";
        List<Customer> customerList = fileReader.getObjectListFor(fileName, "customer", Customer.class);
        Customer customer = customerList.get(0);// read the 1st customer
		CustomerPage customerPage = PageFactory.initElements(driver, CustomerPage.class);

		
		customerPage.enterFirstName(customer);
        customerPage.enterLastName(customer);
		customerPage.enterDOBName(customer);
		
	    try {
		      driver.wait(5000);
		    }catch(Exception e) {
		    	
		    }

	}

}
