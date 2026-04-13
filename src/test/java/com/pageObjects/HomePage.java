package com.pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HomePage extends BasePage{
	
	public HomePage(WebDriver driver)
	{
		super(driver);
		
	}
	
	
	//Locators
	
	@FindBy(xpath="//span[normalize-space()='My Account']")
	WebElement lnkMyaccount;
	@FindBy(xpath = "//a[normalize-space()='Register']") 
	WebElement lnkRegister;
	@FindBy(xpath="//ul[contains(@class,'dropdown-menu dropdown-menu-right')]//a[normalize-space()='Login']")
	WebElement lnkLogin;
	
	
	// actions
	
	
	public void clickMyAccount()
	{
		
		lnkMyaccount.click();
	}
	
	public void clickRegster()
	{
		 
		
		lnkRegister.click();
	}
	
	public void clickLogin()
	{
		lnkLogin.click();
	}

}
