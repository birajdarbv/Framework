package com.learnautomation.Utilities;

import java.io.File;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.io.FileHandler;

public class Helper 
{
	
	//Screenshots, Alerts, Multiple windows, frames, Sync issue, JavaSrcipt executor 
	
	public static String captureScreenShot(WebDriver driver)
	{
		File src=((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		String screenshotpath=System.getProperty("user.dir")+"/Snapshots/WebmailLogin_"+getCurrentDateTime()+".png";
		
		try 
		{
			FileHandler.copy(src, new File("./Snapshots/WebmailLogin_"+getCurrentDateTime()+".png"));
			
			System.out.println("Screenshot Captured");
		}
		catch (Exception e) 
		{
		System.out.println("Unable to capture screenshot "+e.getMessage());	
		}
		return screenshotpath;
	}
	
	public static String getCurrentDateTime()
	{
		DateFormat customFormat=new SimpleDateFormat("MM_dd_yyyy_HH_mm_ss");
		
		Date currentDate=new Date();
		
		return customFormat.format(currentDate);
		
		
	}
}
