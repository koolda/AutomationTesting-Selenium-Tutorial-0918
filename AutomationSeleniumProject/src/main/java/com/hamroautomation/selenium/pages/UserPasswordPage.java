package com.hamroautomation.selenium.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.hamroautomation.selenium.data.model.Login;

public class UserPasswordPage {
	
	WebDriver driver;
	
	public UserPasswordPage(WebDriver driver) {
		this.driver = driver;
	}
	
	@FindBy(id="memberLoginDialogemailInputinput") WebElement userId;
	@FindBy(id="memberLoginDialogpasswordInputinput") WebElement password;
	@FindBy(id ="memberLoginDialogoklink") WebElement loginBtn;

	
    @FindBy(id ="signUpDialogswitchDialogLink") WebElement signUpBtn;
    
    public void clickSignUpButton() {
    	signUpBtn.click();
    }
	
	
	public void enterUserId(String login) {
		userId.sendKeys(login);
	}

	public void enterUserId(Login login) {
		userId.sendKeys(login.getUserId());
	}


	public void enterPassword(Login login) {
		password.sendKeys(login.getPassword());
	}
	
	public void clickLoginBtn() {
		loginBtn.click();
	}
	

}
