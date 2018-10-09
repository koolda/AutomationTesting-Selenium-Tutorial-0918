package com.hamroautomation.selenium.solution.util;
/*
 * Author: Kapil Limbu
 * HamroAutomation Selenium Project
 * 10/08/2018
 * 
 */

import java.io.File;
import java.util.ResourceBundle;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

public class CaptureScreenUtils {

	
	public static void captureErrorScreen(WebDriver driver, String screenName) {
		
		 // ResourceBundle is a Java utility class
		 // that reads from the config file located at
		 // src/main/resources
		 ResourceBundle rb = ResourceBundle.getBundle("config");
		 
		 //For Windows, please update the folder location in config.properties
		 String errorFolderLocation = rb.getString("errorFolder");
		 
		 String format = rb.getString("snapShotFormat");
		 
		 try{
			 // To create reference of TakesScreenshot
			 TakesScreenshot screenshot=(TakesScreenshot)driver;
			 
			 // Call method to capture screenshot
			 File src = screenshot.getScreenshotAs(OutputType.FILE);
			 
			 // Copy files to specific location 
			 // result.getName() will return name of test case so that screenshot name will be same as test case name
			 FileUtils.copyFile(src, new File(errorFolderLocation + screenName + format));
				 			 
			 System.out.println("Successfully captured a screenshot");
			 
			 }catch (Exception e){
			    System.out.println("Exception while taking screenshot "+e.getMessage());
			 } 
	}
}
