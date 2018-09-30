package com.hamroautomation.selenium.config;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Drivers {

	
	public static FirefoxDriver getGeckoDriver() {
		
		   System.setProperty("webdriver.gecko.driver", "/Users/KAPIL/Documents/SeleniumTestDriver/firefox/geckodriver");

		   return new FirefoxDriver();
	}

	public static ChromeDriver getChromeDriver() {
		
		   System.setProperty("webdriver.chrome.driver", "/Users/KAPIL/Documents/SeleniumTestDriver/chrome/chromedriver");

	       return new ChromeDriver();
	}

	public static ChromeDriver getChromeDriver(String url) {
		
		   System.setProperty("webdriver.chrome.driver", "/Users/KAPIL/Documents/SeleniumTestDriver/chrome/chromedriver");

		   ChromeDriver driver = new ChromeDriver();
		   driver.get(url);
		   
	       return driver;
	}
	
}
