package com.hamroautomation.selenium.solution.tests;
/*
 * Author: Kapil Limbu
 * HamroAutomation Selenium Project
 * 10/08/2018
 * 
 */

import java.io.File;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import com.hamroautomation.selenium.solution.helper.CustomerEntryTestHelper;
import com.hamroautomation.selenium.solution.helper.UserIdExceptionTestHelper;
import com.hamroautomation.selenium.solution.util.CaptureScreenUtils;
import com.hamroautomation.selenium.solution.util.PageUtils;


/*
 * This testCase extends BaseTestCase
 * 
 * This testCase generates 2 screen shot by calling the  
 * methods - doReport and doReportUsingUtils
 * The folder location is at ..ToolsQA/Error
 * 
*/

public class Assignment_04_ExceptionTestCase extends BaseTestCase{
	
	
	public static void main (String[] args) {
		Assignment_04_ExceptionTestCase testCase = new Assignment_04_ExceptionTestCase();
		testCase.runMain();
		
	}

	public void runMain() {
		
		//Calls parent class BaseTestCase and initializes the driver
		// This driver variable is an 'inherited' attribute from BaseTestCase
		
        init();
		
        try { 
        	//UserIdTestHelper.run(getDriver());
        	UserIdExceptionTestHelper.run(driver); // Using this helper class to simulates error.
		
        	PageUtils.waitAndScrollUp(driver);   
        
        	CustomerEntryTestHelper.run(driver);
        }catch(Exception ex) {
        	doReport("ExceptionTest");
        	doReportUsingUtils("ExceptionTest");
        	
        }
		
	}
	
	public void doReport(String screenName) {
		//using ITestResult.FAILURE is equals to result.getStatus then it enter into if condition
		
		 //if(ITestResult.FAILURE==result.getStatus()){
			 
			 try{
				 // To create reference of TakesScreenshot
				 TakesScreenshot screenshot=(TakesScreenshot)driver;
				 
				 // Call method to capture screenshot
				 File src=screenshot.getScreenshotAs(OutputType.FILE);
				 
				 // Copy files to specific location 
				 // We are using result.getName() as the screenshot name 
				 // For Windows:  File location will need to be update here
				 
				 FileUtils.copyFile(src, new File("/Users/KAPIL/Documents/ToolsQA/Errors/" + screenName + ".jpg"));
					 
				 
				 System.out.println("Successfully captured a screenshot");
			 }catch (Exception e){
				 System.out.println("Exception while taking screenshot "+e.getMessage());
			 } 
		 //}		
	}
	
	public void doReportUsingUtils(String screenName) {
		/*
		 * Here, we are calling the CaptureScreen utility where we have
		 * move the code of doReport method
		 * 
		 */
		
		//add xxx to differentiate from file capture by doResult()
		String screenShotName = screenName + "xxx";
		
		//using ITestResult.FAILURE is equals to result.getStatus then it enter into if condition
		
		 //if(ITestResult.FAILURE==result.getStatus()){
			 CaptureScreenUtils.captureErrorScreen(driver, screenShotName );
		 //}
		
	}
	

}
