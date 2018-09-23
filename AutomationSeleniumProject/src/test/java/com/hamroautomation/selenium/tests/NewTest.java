package com.hamroautomation.selenium.tests;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.hamroautomation.selenium.config.Drivers;
 
public class NewTest {
 
 public WebDriver driver;
 
  @Test
  public void openMyBlog() {
      //sdriver.get("https://www.softwaretestingmaterial.com/");
      driver.get("https://hamroautomation.wixsite.com/hamrofinancials");
     
  }
  
  @BeforeClass
  public void beforeClass() {
   
    //For Mac
   //System.setProperty("webdriver.gecko.driver", "/Users/KapilLimbu/Documents/Basic Java Tutorial/Selenium/drivers/firefox/geckodriver");
   //System.setProperty("webdriver.chrome.driver", "/Users/KAPIL/Documents/SeleniumTestDriver/chrome/chromedriver");

   
   //For Winddows
   //System.setProperty("webdriver.gecko.driver", "D://downloads//geckodriver.exe");

   
   //driver = new FirefoxDriver();
   driver = Drivers.setChromeDriver();
   
  }
 
  @AfterClass
  public void afterClass() {
   driver.quit();
  }
 
}
