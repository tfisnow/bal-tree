package com.web.pages;

import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverException;
import com.generic.page.base.PageBase;
import com.web.locators.WeathersbysHomePageLocators;

public class WeathersbysFoalRegistrationTCPage extends PageBase implements WeathersbysHomePageLocators{

	public WeathersbysFoalRegistrationTCPage(WebDriver driver) throws WebDriverException, InterruptedException {
		super(driver);
		Thread.sleep(3000);
		// TODO Auto-generated constructor stub
	}
	
	public String getURL() throws Exception{

		try {
			System.out.println("CURRENT URL  : " + driver.getCurrentUrl());

			return driver.getCurrentUrl();


		} catch (TimeoutException e) {
			System.out.println(e.getStackTrace());
		}
		return null;
	}

}
