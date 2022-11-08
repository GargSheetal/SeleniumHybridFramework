package com.inetbanking.testcases;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.inetbanking.pageObjects.AddCustomerPage;
import com.inetbanking.pageObjects.LoginPage;

@Test
public class TC_AddNewCustomerTest_003 extends BaseClass
{
	
	@Test
	public void addNewCustomer() throws InterruptedException, IOException
	{
		LoginPage lp = new LoginPage(driver);
		lp.setUserName(username);
		logger.info("Username provided");
		lp.setPassword(password);
		logger.info("Password provided");
		lp.clickLogin();
		
		Thread.sleep(3000);
		
		AddCustomerPage addcust = new AddCustomerPage(driver);
		
		addcust.clickNewCustomer();
		driver.navigate().back();
		addcust.clickNewCustomer();
		
		Thread.sleep(3000);
		
		logger.info("Providing customer details");
		
		addcust.setCustName("Vijay");
		addcust.setGender("male");
		addcust.setDOB("09", "25", "1991");
		Thread.sleep(3000);
		addcust.setCustAddress("234 Joshua Dr");
		addcust.setCustCity("Willow Groove");
		addcust.setCustState("PA");
		addcust.setCustPinCode("199086");
		
		String mobnum = randomNumber();	// generating string of random numbers using randomNumner() method from base class
		addcust.setCustMobNum(mobnum);	// adding the string of random numbers to customer mobile field
		
		String email = randomString() + "@gmail.com";
		addcust.setCustEmailId(email);
		
		addcust.setCustPwd("rdt2345");
		addcust.clickSubmit();
			
		Thread.sleep(5000);
		
		logger.info("Validation Started");
		boolean res = driver.getPageSource().contains("Customer Registered Successfully!!!");
		
		if(res==true)
		{
			logger.info("Test case passed");
			Assert.assertTrue(true);
		}
		else
		{
			logger.info("Test case Failed");
			captureScreenshot(driver, "addNewCustomer");
			Assert.assertTrue(false);
		}
		
		
	}
	
	
}
