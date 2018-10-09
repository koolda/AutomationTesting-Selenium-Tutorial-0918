package com.hamroautomation.selenium.solution.tests;
/*
 * Author: Kapil Limbu
 * HamroAutomation Selenium Project
 * 10/08/2018
 * 
 */

import org.openqa.selenium.WebDriver;

import com.hamroautomation.selenium.solution.config.Drivers;

public class BaseTestCase {
	
	 protected  WebDriver driver;
	 private    String baseUrl = "https://hamroautomation.wixsite.com/hamrofinancials/customer-1";
     
	 
	 public  void init() {
		 
			driver = Drivers.getChromeDriver(baseUrl);

	 }
	 
	 public  WebDriver getDriver() {
		 return driver;
	 }
	
}
