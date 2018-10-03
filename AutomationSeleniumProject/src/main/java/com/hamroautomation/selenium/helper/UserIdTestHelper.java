package com.hamroautomation.selenium.helper;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

import com.hamroautomation.selenium.data.model.Login;
import com.hamroautomation.selenium.pages.UserPasswordPage;
import com.javalearning.library.ExcelFileReader;

public class UserIdTestHelper {
	

	public static void run(WebDriver driver) {
		
	    ExcelFileReader fileReader = new ExcelFileReader();
		
        String fileName = "loginInfo.xlsx";
        List<Login> loginList = fileReader.getObjectListFor(fileName, "login", Login.class);

		
		Login dataLogin = loginList.get(0);
		
		UserPasswordPage userPasswordPage = PageFactory.initElements(driver, UserPasswordPage.class);
		userPasswordPage.clickSignUpButton();
		userPasswordPage.enterUserId(dataLogin);
		userPasswordPage.enterPassword(dataLogin);
		userPasswordPage.clickLoginBtn();

	}

}
