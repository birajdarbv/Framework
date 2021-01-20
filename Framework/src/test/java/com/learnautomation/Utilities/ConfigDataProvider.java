package com.learnautomation.Utilities;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class ConfigDataProvider 
{
	Properties pro;
	
	public ConfigDataProvider()
	{
		File src=new File("./Config/config.properties");
		try {
			FileInputStream fin=new FileInputStream(src);
			
			pro=new Properties();
			pro.load(fin);;
		} 
		catch (IOException e) 
		{
		System.out.println("Not able load Config file "+e.getMessage());
		}
	}
	
	public String getDFataFromConfig(String keyToSearch)
	{
		return pro.getProperty("KeyToSearch");
	}
	
	public String getBrowser()
	{
		return pro.getProperty("Browser");
	}
	
	public String getStagingUrl()
	{
		return pro.getProperty("qaUrl");
	}
}
