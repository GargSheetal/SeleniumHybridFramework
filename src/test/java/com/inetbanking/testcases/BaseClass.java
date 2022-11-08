package com.inetbanking.testcases;


import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Date;

import org.apache.commons.io.FileUtils;
import org.apache.commons.lang3.RandomStringUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.*;

import com.inetbanking.utilities.ReadConfig;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseClass {

	ReadConfig readconfig=new ReadConfig();
	
	public String baseURL = readconfig.getApplicationURL();
	public String username = readconfig.getUserName();
	public String password = readconfig.getPassword();
	public static WebDriver driver;
	
	public static Logger logger = LogManager.getLogger(BaseClass.class);
	
	@Parameters("browser")
	@BeforeClass
	public void setup(String browser)
	{
		if(browser.equals("chrome"))
		{
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
		}
		else if(browser.equals("firefox"))
		{
			WebDriverManager.firefoxdriver().setup();
			driver=new FirefoxDriver();
		}
		else if(browser.equals("edge"))
		{
			WebDriverManager.edgedriver().setup();
			driver=new EdgeDriver();
		}
		else if(browser.equals("ie"))
		{
			WebDriverManager.iedriver().setup();
			driver=new InternetExplorerDriver();
		}
		
		new WebDriverWait(driver, Duration.ofSeconds(10));
		driver.get(baseURL);	
	}
	
	@AfterClass
	public void tearDown()
	{
		driver.quit();
	}
	
	public void captureScreenshot(WebDriver driver, String testname) throws IOException
	{
		TakesScreenshot ts = (TakesScreenshot)driver;
		String datename = new SimpleDateFormat("yyyy.MM.dd.hh.mm.ss.SSSS").format(new Date());
		File source = ts.getScreenshotAs(OutputType.FILE);
		File target = new File(System.getProperty("user.dir") + "/Screenshots/" + testname + datename + ".png");
		
		FileUtils.copyFile(source, target);
		
		System.out.println("Screenshot Taken");
		
	}
	
	public String randomString()	// this method generates string of random alphabets
	{
		String generatedString = RandomStringUtils.randomAlphabetic(8);
		return generatedString;
	}
	
	public String randomNumber()	// this method generates string of random numbers
	{
		String generatedString2 = RandomStringUtils.randomNumeric(10);
		return generatedString2;
	}
	
}
