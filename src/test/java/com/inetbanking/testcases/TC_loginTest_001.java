package com.inetbanking.testcases;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.*;

import com.inetbanking.pageObjects.LoginPage;

public class TC_loginTest_001 extends BaseClass
{
	
	@Test
	public void loginTest() throws IOException
	{
		logger.info("Website URL is opened successfully..");
		
		LoginPage lp = new LoginPage(driver);
		
		lp.setUserName(username);
		logger.info("Entered Username..");
		
		lp.setPassword(password);
		logger.info("Entered Password..");
		
		lp.clickLogin();
		
		System.out.println("Title of the Login Page is: " + driver.getTitle());
		
		if(driver.getTitle().equals("Guru99 Bank Manager HomePage"))
		{
			Assert.assertTrue(true);
			logger.info("Login test - TC_loginTest_001 Passed");
		}
		else
		{
			Assert.assertTrue(false, "TC_loginTest_001 Fails ");
			logger.info("Login test - TC_loginTest_001 Fails");
		}
	}
	
	
}
