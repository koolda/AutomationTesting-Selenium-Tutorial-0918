package com.hamroautomation.selenium.tests;

import org.openqa.selenium.WebDriver;

import com.hamroautomation.selenium.config.Drivers;

public class BaseTestCase {
	
	 protected static WebDriver driver;

	 public BaseTestCase() {
		 
	 }
	 
	 public static void init() {
		 
			driver = Drivers.getChromeDriver("https://hamroautomation.wixsite.com/hamrofinancials/customer-1");

	 }
	 
	 public static WebDriver getDriver() {
		 return driver;
	 }
	
}
