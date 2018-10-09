package com.hamroautomation.selenium.solution.helper;
/*
 * Author: Kapil Limbu
 * HamroAutomation Selenium Project
 * 10/08/2018
 * 
 */

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.hamroautomation.selenium.solution.data.model.Login;
import com.hamroautomation.selenium.solution.pages.UserPasswordPage;
import com.javalearning.library.ExcelFileReader;

public class UserIdTestHelper {
	

	public static void run(WebDriver driver) {
		
	    ExcelFileReader fileReader = new ExcelFileReader();
		
        String fileName = "loginInfo.xlsx";
        List<Login> loginList = fileReader.getObjectListFor(fileName, "login", Login.class);

		
		Login dataLogin = loginList.get(0);
		
		UserPasswordPage userPasswordPage = PageFactory.initElements(driver, UserPasswordPage.class);
		
		//WebDriverWait wait = new WebDriverWait(WebDriverRefrence,TimeOut);
		WebDriverWait wait = new WebDriverWait (driver, 20);
		wait.until(ExpectedConditions.elementToBeClickable(userPasswordPage.loginLink));
				
		userPasswordPage.clickLoginLnk();
		userPasswordPage.enterUserId(dataLogin);
		userPasswordPage.enterPassword(dataLogin);
		userPasswordPage.clickLoginBtn();

	}

}
