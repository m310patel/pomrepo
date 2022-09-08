package com.amazon.qa.base;


import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.events.EventFiringWebDriver;


import com.amazon.qa.utils.TestUtil;


public class TestBase {

	/* this is my parent class , here i use the concept of INHERITANCE */
	
	public static WebDriver driver;
	public static Properties prop;
	public  static EventFiringWebDriver e_driver;
	
	
	public TestBase(){
		try {
			
			prop = new Properties();
			FileInputStream ip = new FileInputStream("C:\\Selenium_WorkSpace\\PomModel\\src\\main\\java\\com\\amazon\\qa\\config\\config.properties");
			prop.load(ip);
		}
		catch (FileNotFoundException e) {
			e.printStackTrace();
		} 
		catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	
	public static void initialization(){
		String Browsername = prop.getProperty("Browser");
		
		if(Browsername.equals("Firefox")) {
			System.setProperty("webdriver.gecko.driver","C:\\SeleniumJars\\geckodriver.exe");
	 driver = new FirefoxDriver();
	
	    }else if (Browsername.equals("Chrome")) {
			System.setProperty("webdriver.chrome.driver","C:\\SeleniumJars\\chromedriver.exe");
			 driver = new ChromeDriver();
			
		
		}
		
	driver.manage().window().maximize();
	driver.manage().deleteAllCookies();
	driver.manage().timeouts().pageLoadTimeout(TestUtil.PAGE_LOAD_TIMEOUT, TimeUnit.SECONDS);
	driver.manage().timeouts().implicitlyWait(TestUtil.IMPLICIT_WAIT, TimeUnit.SECONDS);
	
	driver.get(prop.getProperty("url"));
	}
}

	
	
	
	
	
	
	

          
		
		
	

