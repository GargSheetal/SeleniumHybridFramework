package com.inetbanking.testcases;

import java.io.IOException;

import org.openqa.selenium.NoAlertPresentException;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.inetbanking.pageObjects.LoginPage;
import com.inetbanking.utilities.XLUtils;

public class TC_LoginDDT_002 extends BaseClass
{
	@Test(dataProvider="LoginData")
	public void loginDDT(String user, String pwd) throws InterruptedException
	{
		LoginPage lp = new LoginPage(driver);
		lp.setUserName(user);
		logger.info("Username is provided");
		
		lp.setPassword(pwd);
		logger.info("Password is provided");
		
		lp.clickLogin();
		Thread.sleep(3000);
		
		if(isAlertPresent()==true)
		{
			driver.switchTo().alert().accept(); // close the alert
			driver.switchTo().defaultContent();	// switching back to the default page
			Assert.assertTrue(true, "Login Failed with Invalid Data");	// it means alert is present & login is unsuccessful with invalid data 
			logger.warn("Login Failed with Invalid Data");
			
		}
		else
		{
			Assert.assertTrue(true);
			logger.info("Login Passed with Valid Data");
			lp.clickLogout();
			Thread.sleep(3000);
			driver.switchTo().alert().accept();	// closing logout alert
			driver.switchTo().defaultContent();	// switching back to the default page
		}
		
	}
	
	
	public boolean isAlertPresent()		// user defined method created to check alert is present or not
	{
		try
		{
			driver.switchTo().alert();	
			return true;
		}
		catch(NoAlertPresentException e)
		{
			return false;
		}
	}
	
	
	
	//DataProvider method
	@DataProvider(name="LoginData")
	String [][] getData() throws IOException
	{
		//read the data from excel file and store the data in a 2-dimensional array
		
		String path = "./src/test/resources/com/inetbanking/testData/InetBankingLoginData.xlsx";	// specifying the path of the xls data sheet
		
		int rownum = XLUtils.getRowCount(path, "Sheet1");	// getting the row count
		int colcount = XLUtils.getCellCount(path, "Sheet1", 1); //getting column count by specifying one of the row
		
		String loginData[][] = new String[rownum][colcount];
	
		for(int i=1; i<=rownum; i++)
		{
			for(int j=0; j<colcount; j++)
			{
				loginData[i-1][j] = XLUtils.getCellData(path, "Sheet1", i, j);// 1,0
			}
		}
		
		return loginData;
	}
	
}
