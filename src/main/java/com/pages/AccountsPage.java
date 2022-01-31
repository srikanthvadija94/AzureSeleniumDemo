package com.pages;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class AccountsPage {

	private WebDriver driver;
	private By accountSections = By.xpath("//div[@id='center_column']//span");
	
	
	public AccountsPage(WebDriver driver) {
		this.driver = driver;
		
	}
	
	//3. page actions: features(behavior) of the page the form of methods
	public String getAccountsPageTitle() {
		return driver.getTitle();
		
	}
	
	public int getAccountsSectionCount() {
		return driver.findElements(accountSections).size();
		
	}
	
	public List<String> getAccountsSectionsList() {
		
		List<String> accountsList = new ArrayList<>();
		List<WebElement> accountsHeaderList = driver.findElements(accountSections);
		
		for(WebElement e: accountsHeaderList) {
			String text = e.getText();
			System.out.println(text);
			accountsList.add(text);	
		}
		return accountsList;
		
	}

	
}
