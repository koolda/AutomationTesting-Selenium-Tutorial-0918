package com.hamroautomation.selenium.solution.config;
/*
 * Author: Kapil Limbu
 * HamroAutomation Selenium Project
 * 10/08/2018
 * 
 */

import java.util.ResourceBundle;

import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Drivers {

	
	public static FirefoxDriver getGeckoDriver() {
		  ResourceBundle rb = ResourceBundle.getBundle("config");
		  String geckoDriverLocation = rb.getString("geckoDriverLocation");

		   System.setProperty("webdriver.gecko.driver", geckoDriverLocation);
		   return new FirefoxDriver();
	}

	public static ChromeDriver getChromeDriver() {
		
		  ResourceBundle rb = ResourceBundle.getBundle("config");
		  String chromeDriverLocation = rb.getString("chromeDriverLocation");
		  System.setProperty("webdriver.chrome.driver", chromeDriverLocation);

	       return new ChromeDriver();
	}

	public static ChromeDriver getChromeDriver(String url) {
		
		  ResourceBundle rb = ResourceBundle.getBundle("config");
		  String chromeDriverLocation = rb.getString("chromeDriverLocation");
		  System.setProperty("webdriver.chrome.driver", chromeDriverLocation);

		   ChromeDriver driver = new ChromeDriver();
		   driver.get(url);
		   
	       return driver;
	}
	
}
