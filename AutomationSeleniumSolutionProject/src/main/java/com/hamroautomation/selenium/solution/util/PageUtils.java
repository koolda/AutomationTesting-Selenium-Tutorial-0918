package com.hamroautomation.selenium.solution.util;
/*
 * Author: Kapil Limbu
 * HamroAutomation Selenium Project
 * 10/08/2018
 * 
 */

import java.util.ResourceBundle;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;

public class PageUtils {

	private static ResourceBundle rb = ResourceBundle.getBundle("config");
	
	public static void waitAndScrollUp(WebDriver driver) {
		
	    try {
		      Thread.sleep(5000);
		    }catch(Exception e) {
		    	
		    }

	    JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollBy(0,1000)");

	}
	
	public static String getBaseUrl() {
		return rb.getString("baseUrl");
	}
	
}
