package com.hamroautomation.selenium.config;

import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Drivers {

	
	public static FirefoxDriver getGeckoDriver() {
		
		   System.setProperty("webdriver.gecko.driver", "/Users/KAPIL/Documents/SeleniumTestDriver/firefox/geckodriver");

		   return new FirefoxDriver();
	}

	public static ChromeDriver setChromeDriver() {
		
		   System.setProperty("webdriver.chrome.driver", "/Users/KAPIL/Documents/SeleniumTestDriver/chrome/chromedriver");

	       return new ChromeDriver();
	}

	
}
