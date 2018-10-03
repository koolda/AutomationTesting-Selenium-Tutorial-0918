package com.hamroautomation.selenium.helper;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

import com.hamroautomation.selenium.data.model.Customer;
import com.javalearning.library.ExcelFileReader;

public class CustomerEntryTestHelper {
	
	
	public static void run(WebDriver driver) {
	       ExcelFileReader fileReader = new ExcelFileReader();
	        
	        String fileName = "customer.xlsx";
	        List<Customer> customerList = fileReader.getObjectListFor(fileName, "customer", Customer.class);
	        Customer customer = customerList.get(0);
			com.hamroautomation.selenium.pages.CustomerPage customerPage = PageFactory.initElements(driver, com.hamroautomation.selenium.pages.CustomerPage.class);

			customerPage.enterFirstName(customer);
	        customerPage.enterLastName(customer);
			customerPage.enterDOBName(customer);

	}

}
