package com.inetbanking.pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

public class AddCustomerPage {

	WebDriver driver;
	
	public AddCustomerPage(WebDriver d)
	{
		driver = d;
		PageFactory.initElements(d, this);
	}
	
	@FindBy(how = How.XPATH, using = "/html/body/div[3]/div/ul/li[2]/a")
	@CacheLookup
	WebElement linkNewCustomer;
	
	@FindBy(how = How.NAME, using = "name")
	@CacheLookup
	WebElement txtCustomerName;
	
	@FindBy(how = How.NAME, using = "rad1")
	@CacheLookup
	WebElement rbGender;
	
	@FindBy(how = How.ID_OR_NAME, using = "dob")
	@CacheLookup
	WebElement txtDoB;
	
	@FindBy(how = How.NAME, using = "addr")
	@CacheLookup
	WebElement txtAddress;
	
	@FindBy(how = How.NAME, using = "city")
	@CacheLookup
	WebElement txtCity;
	
	@FindBy(how = How.NAME, using = "state")
	@CacheLookup
	WebElement txtState;
	
	@FindBy(how = How.NAME, using = "pinno")
	@CacheLookup
	WebElement txtPinCode;
	
	@FindBy(how = How.NAME, using = "telephoneno")
	@CacheLookup
	WebElement txtMobNum;
	
	@FindBy(how = How.NAME, using = "emailid")
	@CacheLookup
	WebElement txtEmail;
	
	@FindBy(how = How.NAME, using = "password")
	@CacheLookup
	WebElement txtPassword;
	
	@FindBy(how = How.NAME, using = "sub")
	@CacheLookup
	WebElement btnSubmit;
	
	@FindBy(how = How.NAME, using = "sub")
	@CacheLookup
	WebElement btnReset;
	
	
	public void clickNewCustomer()
	{
		linkNewCustomer.click();
	}
	
	public void setCustName(String cname)
	{
		txtCustomerName.sendKeys(cname);
	}
	
	public void setGender(String cgender)
	{
		rbGender.click();
	}
	
	public void setDOB(String mm, String dd, String yyyy)
	{
		txtDoB.sendKeys(mm);
		txtDoB.sendKeys(dd);
		txtDoB.sendKeys(yyyy);
	}
	
	public void setCustAddress(String caddress)
	{
		txtAddress.sendKeys(caddress);
	}
	
	public void setCustCity(String ccity)
	{
		txtCity.sendKeys(ccity);
	}
	
	public void setCustState(String cstate)
	{
		txtState.sendKeys(cstate);
	}
	
	public void setCustPinCode(String cpinNo)
	{
		txtPinCode.sendKeys(String.valueOf(cpinNo));
	}
	
	public void setCustMobNum(String cmobNum)
	{
		txtMobNum.sendKeys(cmobNum);
	}
	
	public void setCustEmailId(String cemailId)
	{
		txtEmail.sendKeys(cemailId);
	}
	
	public void setCustPwd(String cpassword)
	{
		txtPassword.sendKeys(cpassword);
	}
	
	public void clickSubmit()
	{
		btnSubmit.click();
	}
	
	public void clickReset()
	{
		btnReset.click();
	}
	
	
}
