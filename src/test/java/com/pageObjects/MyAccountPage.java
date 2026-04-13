package com.pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class MyAccountPage extends BasePage {
	
	public MyAccountPage (WebDriver driver)
	{
		super(driver);
		
		
	}
	
	
	@FindBy(xpath="//h2[text()='My Account']") // MyAccount page heading
	WebElement msgHeading;
	
	@FindBy(xpath="//a[@class='list-group-item'][normalize-space()='Logout']") //addded in step 6 data driven
	WebElement clkLogout;
	
	
	public boolean isMyAccountPageExists()
	
	{
		try
		{
			return(msgHeading.isDisplayed());
		}
		catch(Exception e)
		{
		return false;
		}
	}
	
	public void clickLogout()
	{
		clkLogout.click();
	}
	
}

