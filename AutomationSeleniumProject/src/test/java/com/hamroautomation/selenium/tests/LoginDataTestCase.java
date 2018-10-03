package com.hamroautomation.selenium.tests;

import java.util.List;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

import com.hamroautomation.selenium.config.Drivers;
import com.hamroautomation.selenium.data.model.Address;
import com.hamroautomation.selenium.data.model.Customer;
import com.hamroautomation.selenium.data.model.Login;
import com.hamroautomation.selenium.helper.CustomerEntryTestHelper;
import com.hamroautomation.selenium.helper.UserIdTestHelper;
import com.hamroautomation.selenium.pages.UserPasswordPage;
import com.hamroautomation.selenium.util.PageUtils;
import com.javalearning.library.ExcelFileReader;

public class LoginDataTestCase {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		WebDriver driver = Drivers.getChromeDriver("https://hamroautomation.wixsite.com/hamrofinancials/customer-1");

		
		UserIdTestHelper.run(driver);
		
        PageUtils.waitAndScrollUp(driver);   
        
        CustomerEntryTestHelper.run(driver);
        
        
  
	}

}
