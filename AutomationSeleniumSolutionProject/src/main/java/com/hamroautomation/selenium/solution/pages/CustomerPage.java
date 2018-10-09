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

import com.hamroautomation.selenium.solution.data.model.Customer;

public class CustomerPage {
	
	WebDriver driver;
	
	public CustomerPage(WebDriver driver) {
		this.driver = driver;
	}
	
	@FindBy(id="comp-jmh581gwinput") WebElement firstName;
	@FindBy(id="comp-jmh581h4input") WebElement lastName;
	@FindBy(id ="comp-jmh581h9input") WebElement dob;
    @FindBy(id="comp-jmjlzdrolabel") WebElement submitBtn;

	public void enterFirstName(Customer customer) {
		firstName.sendKeys(customer.getFirstName());
	}
	
	public void enterLastName(Customer customer) {
		lastName.sendKeys(customer.getLastName());
	}

	
	public void enterDOBName(Customer customer) {
		dob.sendKeys(customer.getDob());
	}

	public void clickSubmitBtn() {
		submitBtn.click();
	}
	
}
