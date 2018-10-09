package com.hamroautomation.selenium.solution.data.model;
/*
 * Author: Kapil Limbu
 * HamroAutomation Selenium Project
 * 10/08/2018
 * 
 */

import java.util.List;

public class Customer {

	String id;
	String firstName;
    String lastName;
    String dob;
    List<Address> addressList;
    
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public String getDob() {
		return dob;
	}
	public void setDob(String dob) {
		this.dob = dob;
	}
	public List<Address> getAddressList() {
		return addressList;
	}
	public void setAddressList(List<Address> addressList) {
		this.addressList = addressList;
	}
	@Override
	public String toString() {
		return "Customer [id=" + id + ", firstName=" + firstName + ", lastName=" + lastName + ", dob=" + dob
				+ ", addressList=" + addressList + "]";
	}
	
	
	
}
