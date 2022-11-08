package com.inetbanking.pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {

	
	WebDriver driver;
	
	public LoginPage(WebDriver d)
	{
		driver = d;
		PageFactory.initElements(d, this);
	}
	
	
	@FindBy(name = "uid")
	@CacheLookup
	WebElement txtUserName;
	
	@FindBy(name = "password")
	@CacheLookup
	WebElement txtPassword;
	
	@FindBy(name = "btnLogin")
	@CacheLookup
	WebElement btnLogin;
	
	@FindBy(name = "btnReset")
	@CacheLookup
	WebElement btnReset;
	
	@FindBy(xpath = "/html/body/div[3]/div/ul/li[15]/a")
	@CacheLookup
	WebElement linkLogout;
	
	public void setUserName(String uname)
	{
		txtUserName.sendKeys(uname);
	}
	
	
	public void setPassword(String pwd)
	{
		txtPassword.sendKeys(pwd);
	}
	
	
	public void clickLogin()
	{
		btnLogin.click();
	}
	
	public void clickLogout()
	{
		linkLogout.click();
	}
	
	
}
