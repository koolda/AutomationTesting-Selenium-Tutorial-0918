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

import com.hamroautomation.selenium.solution.data.model.Address;
import com.hamroautomation.selenium.solution.data.model.Customer;
import com.hamroautomation.selenium.solution.pages.AddressPage;
import com.javalearning.library.ExcelFileReader;


public class AddressEntryTestHelper {

	public static void run(WebDriver driver) {
	       ExcelFileReader fileReader = new ExcelFileReader();
	        
	        String fileName = "customer.xlsx";
	        List<Customer> customerList = fileReader.getObjectListFor(fileName, "customer", Customer.class);
	        Customer customer = customerList.get(0);
	        List<Address> addressList = customer.getAddressList();
	        Address address = addressList.get(0);
	        
			AddressPage addresssPage = PageFactory.initElements(driver, AddressPage.class);

			addresssPage.enterStreetAddress(address);
			addresssPage.enterCity(address);
			addresssPage.enterState(address);
			addresssPage.clickSubmitBtn();

	}

	
}
