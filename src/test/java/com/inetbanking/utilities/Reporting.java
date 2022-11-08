package com.inetbanking.utilities;

// Listener class used to generate extent reports


import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;
import com.inetbanking.testcases.BaseClass;

public class Reporting extends BaseClass implements ITestListener
{
	public ExtentSparkReporter sparkReporter;
	public ExtentReports extent;
	public ExtentTest test;
	
	public void onStart(ITestContext testContext)
	{
		// create report name with time stamp so that a new report is generated every time and the older is not overridden
		String timeStamp = new SimpleDateFormat("yyyy.MM.dd.HH.mm.ss.SSSS").format(new Date()); // time stamp
		String reportName = "Test-Report-" + timeStamp + ".html";
		
		sparkReporter = new ExtentSparkReporter(System.getProperty("user.dir")+"/test-output/"+reportName);	// specifying the location of reports
		
		try {
			sparkReporter.loadXMLConfig(System.getProperty("user.dir")+"/extent-config.xml");
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		extent = new ExtentReports();	
		extent.attachReporter(sparkReporter);
		
		extent.setSystemInfo("Host Name", "Local Host");
		extent.setSystemInfo("Environment", "QA");
		extent.setSystemInfo("Tester", "Sheetal");
		extent.setSystemInfo("OS", "Windows10");
		
		sparkReporter.config().setDocumentTitle("InetBanking Test Automation Project"); // title of the report
		sparkReporter.config().setReportName("Functional Test Report");	// name of the report
		sparkReporter.config().setTheme(Theme.DARK);
		
	}
	
	public void onTestSuccess(ITestResult result)
	{
		test = extent.createTest(result.getName());	// create new entry in the report
		test.log(Status.PASS, MarkupHelper.createLabel("Test case PASSED is: " +result.getName(), ExtentColor.GREEN));
	}
	
	public void OnTestFailure(ITestResult result)
	{
		test = extent.createTest(result.getName());
		test.log(Status.FAIL, MarkupHelper.createLabel("Test case FAILED is: " + result.getName(), ExtentColor.RED));

		try {
			captureScreenshot(driver, result.getName());
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	public void onTestSkipped(ITestResult result)
	{
		test = extent.createTest(result.getName());	// create new entry in the report
		test.log(Status.SKIP, MarkupHelper.createLabel("Test case SKIPPED is: " +result.getName(), ExtentColor.ORANGE));
	}
	
	public void onFinish(ITestContext context)
	{
		extent.flush();
	}
	
	
}
