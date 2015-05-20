package com.generic.test.base;

import java.io.File;
import java.io.IOException;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Properties;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;

import com.generic.drivers.init.Browser;
import com.generic.drivers.init.LocalDriver;
import com.generic.enums.DriverType;
import com.generic.property.PropertyManager;
import org.openqa.selenium.Platform;
import org.openqa.selenium.remote.Augmenter;

public class TestBase {

	protected static String[][] strorage = null;
	private static final String dateAndTimeFormat = "MM-dd-yyyy_hh.mm.ss";
	protected final static Properties APPLICATION_PROPERTIES = PropertyManager
			.loadApplicationPropertyFile();

	protected WebDriver driver = null;
	LocalDriver idriver;

	@BeforeTest
	@Parameters("executionType")
	protected void beforeTest(@Optional("local") String executionType,
			ITestContext context) {
		try {

			Browser browser = new Browser(
					APPLICATION_PROPERTIES.getProperty("browserName"),
					APPLICATION_PROPERTIES.getProperty("browserVersion"),
					Platform.WINDOWS);

			idriver = new LocalDriver();
			driver = idriver.getDriver(browser);
			context.setAttribute(context.getCurrentXmlTest().getName(), driver);
			System.out.println("Current Test : " + context.getCurrentXmlTest().getName());
			
		} catch (Exception e) {
			System.out
					.println("Error occured in Before Test method of the base class"
							+ "Stacktrace : " + e.getStackTrace());
		}
	}

	@AfterTest
	protected void afterTest(ITestContext context) {
		WebDriver webdriver = getWebDriverInstance(context);
		System.out.println("Closing the instance:" + webdriver.toString());
		webdriver.close();
		webdriver.quit();

		context.removeAttribute(context.getCurrentXmlTest().getName());
	}

	protected static WebDriver getWebDriverInstance(ITestContext context) {
		return (WebDriver) context.getAttribute(context.getCurrentXmlTest()
				.getName());
	}

	@AfterMethod
	protected File afterMethod(ITestResult result) throws IOException {
		WebDriver webdriver = getWebDriverInstance(result.getTestContext());
		if (result.isSuccess()) {
			return ((TakesScreenshot) webdriver)
					.getScreenshotAs(OutputType.FILE);
		}
		
		String dateAndTime = new SimpleDateFormat(dateAndTimeFormat)
				.format(new Date());
		File screenshot = ((TakesScreenshot) webdriver)
				.getScreenshotAs(OutputType.FILE);
		String screenShotName = "screenshot_" + dateAndTime + ".png";
		FileUtils.copyFile(screenshot, new File("./screenshots/"
				+ screenShotName));
		return screenshot;
	}
}