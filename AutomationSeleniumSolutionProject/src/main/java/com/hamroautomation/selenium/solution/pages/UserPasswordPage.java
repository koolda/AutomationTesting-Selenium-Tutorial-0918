package com.hamroautomation.selenium.solution.pages;
/*
 * Author: Kapil Limbu
 * HamroAutomation Selenium Project
 * 10/08/2018
 * 
 */

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.hamroautomation.selenium.solution.data.model.Login;

public class UserPasswordPage {
	
	WebDriver driver;
	
	public UserPasswordPage(WebDriver driver) {
		this.driver = driver;
	}
	
	@FindBy(id="memberLoginDialogemailInputinput") WebElement userId;
	@FindBy(id="memberLoginDialogpasswordInputinput") WebElement password;
	@FindBy(id ="signUpDialogswitchDialogLink") public static WebElement loginLink;
	@FindBy(id ="memberLoginDialogoklabel") WebElement loginBtn;

   	
	public void enterUserId(String userIdStr) {
		userId.sendKeys(userIdStr);
	}

	public void enterUserId(Login login) {
		userId.sendKeys(login.getUserId());
	}

	public void enterPassword(String passwordStr) {
		password.sendKeys(passwordStr);
	}

	public void enterPassword(Login login) {
		password.sendKeys(login.getPassword());
	}

	public void clickLoginLnk() {
		loginLink.click();
	}

	public void clickLoginBtn() {
		loginBtn.click();
	}
	

}
