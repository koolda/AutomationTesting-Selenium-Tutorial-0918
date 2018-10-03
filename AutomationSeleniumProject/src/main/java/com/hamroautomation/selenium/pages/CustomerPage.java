package com.hamroautomation.selenium.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class CustomerPage {
	
	WebDriver driver;
	
	public CustomerPage(WebDriver driver) {
		this.driver = driver;
	}
	
	@FindBy(id="comp-jmh581gwinput") WebElement firstName;
	@FindBy(id="comp-jmh581h4input") WebElement lastName;
	@FindBy(id ="comp-jmh581h9input") WebElement dob;


	public void enterFirstName(com.hamroautomation.selenium.data.model.Customer customer) {
		firstName.sendKeys(customer.getFirstName());
	}
	
	public void enterLastName(com.hamroautomation.selenium.data.model.Customer customer) {
		lastName.sendKeys(customer.getLastName());
	}

	
	public void enterDOBName(com.hamroautomation.selenium.data.model.Customer customer) {
		dob.sendKeys(customer.getDob());
	}

	
}
