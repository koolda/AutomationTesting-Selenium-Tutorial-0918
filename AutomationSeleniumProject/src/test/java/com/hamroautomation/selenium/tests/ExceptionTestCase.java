package com.hamroautomation.selenium.tests;

import java.io.File;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.hamroautomation.selenium.helper.CustomerEntryTestHelper;
import com.hamroautomation.selenium.helper.UserIdTestHelper;
import com.hamroautomation.selenium.util.PageUtils;

public class ExceptionTestCase extends BaseTestCase{
	
	
	@BeforeTest
	public void doInit() {
		init();
	}
	
	@Test
	public  void runMain() {
		
		init();
		
		UserIdTestHelper.run(getDriver());
		
        PageUtils.waitAndScrollUp(driver);   
        
        
        CustomerEntryTestHelper.run(driver);

		
	}
	
	@AfterMethod
	public void doReport(ITestResult result) {
		//using ITestResult.FAILURE is equals to result.getStatus then it enter into if condition
		 if(ITestResult.FAILURE==result.getStatus()){
			 try{
			 // To create reference of TakesScreenshot
			 TakesScreenshot screenshot=(TakesScreenshot)driver;
			 
			 // Call method to capture screenshot
			 File src=screenshot.getScreenshotAs(OutputType.FILE);
			 
			 // Copy files to specific location 
			 // result.getName() will return name of test case so that screenshot name will be same as test case name
			 FileUtils.copyFile(src, new File("/Users/KAPIL/Documents/ToolsQA/Errors/"+result.getName()+".jpg"));
				 
			 
			 System.out.println("Successfully captured a screenshot");
			 }catch (Exception e){
			    System.out.println("Exception while taking screenshot "+e.getMessage());
			 } 
		 }		
	}
	

}
