package com.learnautomation.Testcases;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.learnautomation.Utilities.BrowserFactory;
import com.learnautomation.Utilities.ExcelDataProvider;
import com.learnautomation.Utilities.Helper;
import com.learnautomation.pages.BaseClass;
import com.learnautomation.pages.LoginPage;

public class LogintestCRM extends BaseClass
{
	@Test(priority=1)
	public void loginApp()
	{
		
		
		logger=report.createTest("Login to Webmail");
		
		LoginPage loginpage=PageFactory.initElements(driver,LoginPage.class);
		
		logger.info("Starting Application");
		
		loginpage.LogInWebmail(excel.getStringData("Login",0,0), excel.getStringData("Login",0,1));
		
		//Helper.captureScreenShot(driver);
		
		logger.pass("Login Successful");
	}
		
}
