package com.learnautomation.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage 
{
	WebDriver driver;
	public LoginPage(WebDriver ldriver)
	{
		this.driver=ldriver;
	}

	//new commit code
	
	@FindBy(name="username") WebElement uname;
	@FindBy(name="password") WebElement pass;
	@FindBy(xpath="//input[@value='Sign In']") WebElement signInButton;
	
	public void LogInWebmail(String username,String password)
	{
		try
		{
			Thread.sleep(2000);
		}
		catch(Exception e)  
		{	
			
		}
		uname.sendKeys(username);
		pass.sendKeys(password);
		signInButton.click();
	}
	
}
