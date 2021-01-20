package com.learnautomation.pages;

import java.io.File;
import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.testng.ITestResult;
import org.testng.Reporter;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeSuite;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.learnautomation.Utilities.BrowserFactory;
import com.learnautomation.Utilities.ConfigDataProvider;
import com.learnautomation.Utilities.ExcelDataProvider;
import com.learnautomation.Utilities.Helper;

public class BaseClass 
{
	public WebDriver driver;
	 
	public ExcelDataProvider excel;
	public ConfigDataProvider config;
	public ExtentReports report;
	public ExtentTest logger;
	
	
	@BeforeSuite
	public void setupSuite()
	{
		
		Reporter.log("Setting up log and Test is getting ready "+true);
		
		excel=new ExcelDataProvider();
		config=new ConfigDataProvider();
		
		ExtentHtmlReporter extent=new ExtentHtmlReporter(new File(System.getProperty("user.dir")+"./Reports/FreeCRm_"+Helper.getCurrentDateTime()+".html"));
		report=new ExtentReports();
		report.attachReporter(extent);
		
		Reporter.log("Setting done - Test can be Started "+true);
	}
	
	@BeforeClass
	public void setup()
	{
		Reporter.log("Trying to start Browser and application  getting ready "+true);
		
		driver=BrowserFactory.startApp(driver,config.getBrowser(),config.getStagingUrl());
		
		Reporter.log("Browser and Application are up and running "+true);
	}
	
	@AfterClass
	public void tearDown()
	{
		BrowserFactory.quiteApp(driver);
	}
	
	@AfterMethod
	public void tearDownMethod(ITestResult result)
	{
		Reporter.log("Test is about to end "+true);
		
		if(result.getStatus()==ITestResult.FAILURE)
		{
			//Helper.captureScreenShot(driver);
			
			try 
			{
				logger.fail("Test Failed", MediaEntityBuilder.createScreenCaptureFromPath(Helper.captureScreenShot(driver)).build());
			} 
			catch (Exception e) 
			{
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		else if(result.getStatus()==ITestResult.SUCCESS)
		{
			try 
			{
				logger.fail("Test Passed", MediaEntityBuilder.createScreenCaptureFromPath(Helper.captureScreenShot(driver)).build());
			} 
			catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		report.flush();
		
		Reporter.log("Test Completed >>> Reports generated.."+true);
	}
	
}
