package com.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage {
	
	private WebDriver driver;
	
	//1.By locators: (r) OR means Object Repositories:
	private By emailId = By.xpath("//input[@id='email']");
	private By password = By.xpath("//input[@id='passwd']");
	private By signInButton = By.xpath("//button[@id='SubmitLogin']");
	private By forgotpwdLink = By.linkText("Forgot your password?");  // Xpath = "//p[@class='lost_password form-group']//a"
	
	
	//2.Constructor of the page class:
	public LoginPage(WebDriver  driver) {
		this.driver = driver;
		
	}
	
	
	//3. page actions: features(behavior) of the page the form of methods
	public String getLoginPageTitle() {
		return driver.getTitle();
	}
	
	public Boolean isForogotPwdLinkExist() {
		return driver.findElement(forgotpwdLink).isDisplayed();
	}
	
	public void enterUserName(String username) {
		driver.findElement(emailId).sendKeys(username);
		
	}
	
	public void enterPassword(String pwd) {
		driver.findElement(password).sendKeys(pwd);
		
	}
	
	public void ClickOnLogin() {
		driver.findElement(signInButton).click();
		
	}
	
	public AccountsPage doLogin(String un, String pwd) {
		System.out.println("login with " + un + " and " + pwd);
		driver.findElement(emailId).sendKeys(un);
		driver.findElement(password).sendKeys(pwd);
		driver.findElement(signInButton).click();
		return new AccountsPage(driver);
		
		
	}
	

	
}
