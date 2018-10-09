package com.hamroautomation.selenium.solution.helper;
/*
 * Author: Kapil Limbu
 * HamroAutomation Selenium Project
 * 10/08/2018
 * 
 */

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

import com.hamroautomation.selenium.solution.data.model.Customer;
import com.hamroautomation.selenium.solution.pages.CustomerPage;
import com.javalearning.library.ExcelFileReader;

public class CustomerEntryTestHelper {
	
	
	public static void run(WebDriver driver) {
	       ExcelFileReader fileReader = new ExcelFileReader();
	        
	        String fileName = "customer.xlsx";
	        List<Customer> customerList = fileReader.getObjectListFor(fileName, "customer", Customer.class);
	        Customer customer = customerList.get(0);
	        
			CustomerPage customerPage = PageFactory.initElements(driver, CustomerPage.class);

			customerPage.enterFirstName(customer);
	        customerPage.enterLastName(customer);
			customerPage.enterDOBName(customer);
			customerPage.clickSubmitBtn();

	}

}
