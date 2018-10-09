package com.hamroautomation.selenium.solution.tests;
/*
 * Author: Kapil Limbu
 * HamroAutomation Selenium Project
 * 10/08/2018
 * 
 */

import org.openqa.selenium.WebDriver;

import com.hamroautomation.selenium.solution.config.Drivers;
import com.hamroautomation.selenium.solution.helper.AddressEntryTestHelper;
import com.hamroautomation.selenium.solution.helper.CustomerEntryTestHelper;
import com.hamroautomation.selenium.solution.helper.UserIdTestHelper;
import com.hamroautomation.selenium.solution.util.PageUtils;

public class Assignment_03_LoginDataHelperTestCase {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		WebDriver driver = Drivers.getChromeDriver(PageUtils.getBaseUrl());

		
		UserIdTestHelper.run(driver);
		
        /*
		    try {
		    	//Delay so that the UI page renders the web elements.
			      Thread.sleep(5000);
			    }catch(Exception e) {
			    	
			    }
	
		    JavascriptExecutor js = (JavascriptExecutor) driver;
	        js.executeScript("window.scrollBy(0,1000)");
        */
        PageUtils.waitAndScrollUp(driver);

        
        CustomerEntryTestHelper.run(driver);
        
        PageUtils.waitAndScrollUp(driver);   

        AddressEntryTestHelper.run(driver);
 
        PageUtils.waitAndScrollUp(driver);   
  
	}

}
