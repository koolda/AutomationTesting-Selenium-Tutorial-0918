package com.hamroautomation.selenium.util;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;

public class PageUtils {

	
	public static void waitAndScrollUp(WebDriver driver) {
		
	    try {
		      Thread.sleep(5000);
		    }catch(Exception e) {
		    	
		    }

	    JavascriptExecutor js = (JavascriptExecutor) driver;
      js.executeScript("window.scrollBy(0,1000)");

	}
}
