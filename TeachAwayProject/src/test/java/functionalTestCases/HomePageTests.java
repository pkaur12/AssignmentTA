package functionalTestCases;

import java.io.IOException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import pageObjects.HomePageObjects;
import resources.TestData;
import utils.GenericMethods;

public class HomePageTests extends BaseTest{
	
	private static final Logger LOGGER = LoggerFactory.getLogger(HomePageTests.class);
	
@Test
	public void checkHeaderTabCount() {
		LOGGER.info("Checking Tab Count");
		Assert.assertEquals(homepage.headerTabCount(), 5);
	}
	
	@Test (dataProvider="tabs", dataProviderClass = TestData.class)
	public void testHeader(String tabName) {
		homepage.checkHeaderTabs(tabName);
	}
	

	@Test
	public void testLogoURL(){
		LOGGER.info("Checking LOGO URL");
	Assert.assertEquals(homepage.logoURL(), "https://www.teachaway.com/themes/contrib/tams/logo.svg");
		//LOGGER.info("LOGO URL = "+homepage.logoURL()+"----->Status Code = "+GenericMethods.getStatusCode(homepage.logoURL()));
		//Assert.assertEquals(GenericMethods.getStatusCode(homepage.logoURL()), 200);
	}
	
	@Test (dataProvider="tabs", dataProviderClass = TestData.class)
	public void testContentForJobs(String tab) throws IOException {
		homepage.mouseHover(tab);
		homepage.checkInnerContent(tab);
	}

}
