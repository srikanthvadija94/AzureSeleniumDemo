package com.qa.factory;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.safari.SafariDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class DriverFactory {

	
	public WebDriver driver;
	
	public static ThreadLocal<WebDriver> tlDriver = new ThreadLocal<>();
	
	
	// this method initialize the ThreadLocal driver on the basis of given browser
	// @param browser
	// @return this will return tldriver
	
	public WebDriver init_driver(String browser) {
		
		System.out.println("browser value is: " + browser);
		
		if(browser.equals("chrome")) {
			
			WebDriverManager.chromedriver().setup();
			tlDriver.set(new ChromeDriver());
		}
		else if(browser.equals("firefox")) {
			
			WebDriverManager.firefoxdriver().setup();
			tlDriver.set(new FirefoxDriver());
		}
		else if(browser.equals("safari")) {
			
			tlDriver.set(new SafariDriver());
		}
		else {
			System.out.println("Please Pass the correct browser value: " + browser);
		}
		
		getDriver().manage().deleteAllCookies();
		getDriver().manage().window().maximize();
		return getDriver();

	}
	//This is used to get the driver with threadlocal	
	//here if we run multiple threads in parllel, like if 5threads to run its call getDriver so we use "synchronized" 
	
	public static synchronized WebDriver getDriver() {
		return tlDriver.get();
	}

	
}
