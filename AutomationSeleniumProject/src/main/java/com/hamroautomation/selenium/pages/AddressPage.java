package com.hamroautomation.selenium.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.hamroautomation.selenium.data.model.Address;

public class AddressPage {
	
	WebDriver driver;

	public AddressPage(WebDriver driver) {
		this.driver = driver;
	}
	
	@FindBy(id="comp-jmjmdg81input") WebElement streetAddress;
	@FindBy(id="comp-jmjmdzorinput") WebElement city;
	@FindBy(id="comp-jmjmf08jinput") WebElement state;
	@FindBy(id="comp-jmjmffv4label") WebElement submitBtn;

	public void enterStreetAddress(Address address) {
		streetAddress.sendKeys(address.getState());
	}
	public void enterCity(Address address) {
		city.sendKeys(address.getCity());
	}
	
	public void enterState(Address address) {
		state.sendKeys(address.getState());
	}
	
	public void clickSubmitBtn() {
		submitBtn.click();
	}
}
