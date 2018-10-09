package com.hamroautomation.selenium.solution.tests;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.hamroautomation.selenium.solution.config.Drivers;
import com.hamroautomation.selenium.solution.pages.UserPasswordPage;

public class Assignment_01_LoginTestCase {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		WebDriver driver = Drivers.getChromeDriver("https://hamroautomation.wixsite.com/hamrofinancials/customer-1");
		
		UserPasswordPage userPasswordPage = PageFactory.initElements(driver, UserPasswordPage.class);
		

		//Using WebDriverWait instead of Thread.sleep() ;
		WebDriverWait wait = new WebDriverWait (driver, 20);
		//Need to make the loginLink attribute of UserPassworPage as public static
		//so that it is visible and available here.
		//WebDriver will wait until that is visible and clickable
		//as defined below.
		wait.until(ExpectedConditions.elementToBeClickable(userPasswordPage.loginLink));
	    
	    
		userPasswordPage.clickLoginLnk();
		userPasswordPage.enterUserId("Andy@gmail.com");
		userPasswordPage.enterPassword("Pass1234");
		userPasswordPage.clickLoginBtn();


	}

}
