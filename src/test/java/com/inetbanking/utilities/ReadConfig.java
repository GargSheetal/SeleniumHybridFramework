package com.inetbanking.utilities;

import java.io.File;
import java.io.FileInputStream;
import java.util.Properties;

public class ReadConfig {

	Properties pro;		// declaring Properties class object
	
	public ReadConfig()		// creating constructor for ReadConfig class
	{
		File src = new File("./Configurations/config.properties");  // making an object of file class to store the config.properties file
		
		// putting the code of reading the config.properties file in try catch block as there is chance of not getting the file at the 
		// specified location
		try
		{
			FileInputStream fis = new FileInputStream(src);	// importing and reading the config file using FileInputStream class
			pro = new Properties();		// initiating the object of Properties class.
			pro.load(fis);		// load method will load the complete config.properties file
		}
		catch(Exception e)
		{
			System.out.println("Exception is " + e);
		}
				
		
	}

	// making different methods for each variable to read their value. So they will have a return type as they will return certain value
	
		public String getApplicationURL()
		{
			String url = pro.getProperty("baseURL");	// getting the baseURL value from config file and storing in the String Variable
			return url;
		}
		
		public String getUserName()
		{
			String username = pro.getProperty("username");
			return username;
		}
		
		public String getPassword()
		{
			String password = pro.getProperty("password");
			return password;
		}
		
		
			
			
		
	}
	
	

