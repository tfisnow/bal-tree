package com.generic.weatherbys;

import java.util.List;

import org.testng.Assert;
import org.testng.ITestContext;
import org.testng.Reporter;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.generic.test.base.TestBase;

import com.web.pages.WeathersbysFoalRegistrationTCPage;
import com.web.pages.WeathersbysHomePage;

/**
 * This is a template page only for testing the code. You may remove this if not required.
 *
 */
public class SmokeTests extends TestBase {

	private WeathersbysHomePage weathersbysHomePage;
	private WeathersbysFoalRegistrationTCPage weathersbysFoalRegistrationTCPage;
	//private WebDriver driver ;
	private String regURL = "http://www.weatherbys.net/studbook/registrations/";


	@BeforeClass
	public void beforeClass(ITestContext context) throws Exception {
		driver = getWebDriverInstance(context);
	}

	
	
	/**This test verifies whether the user is able to navigate to the Terms & Conditions page
	 * @throws Exception
	 */
	@Test
	public void verifyFoalRegistrationTCPage() throws Exception {
		weathersbysHomePage = new WeathersbysHomePage(driver);

		weathersbysHomePage.closeCookiesBar();
		
		weathersbysFoalRegistrationTCPage = weathersbysHomePage.goToFoalRegistrationPage();
		Reporter.log("Verify the user is able to navigate to the Terms & Conditions page");

		Assert.assertTrue(weathersbysFoalRegistrationTCPage.getURL().contains(regURL), "Terms & Conditions page is not loaded !!");

	}	
	

	/**This test verifies whether the text i.e. the title of the books displayed on the home page.
	 * @throws Exception
	 */
	@Test
	public void verifyTopSellersBooks() throws Exception {
		weathersbysHomePage = new WeathersbysHomePage(driver);
		
		List<String> listOfBooks = weathersbysHomePage.GetTopSellersBooksTitle();
		Reporter.log("Verify whether the text i.e. the title of the books displayed on the home page");
		
		Assert.assertEquals(listOfBooks, "", "Verify the list of books");

	}	
	
}
