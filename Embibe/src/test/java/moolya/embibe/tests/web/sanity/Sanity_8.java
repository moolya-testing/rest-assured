package moolya.embibe.tests.web.sanity;

import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.testng.Reporter;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import moolya.embibe.pages.web.ChooseMissionPage;
import moolya.embibe.pages.web.LandingPage;
import moolya.embibe.pages.web.MailinatorPage;
import moolya.embibe.pages.web.SearchHomepage;
import moolya.embibe.pages.web.SearchResultsPage;
import moolya.embibe.pages.web.SignUpPage;
import moolya.embibe.pages.web.W_BasePage;
import moolya.embibe.tests.web.sanity.W_BaseTest;
import moolya.embibe.utils.SqliteUtils;

public class Sanity_8 extends W_BaseTest {

	private W_BasePage basepage;
	private LandingPage lp;
	private SearchHomepage shp;
	private SearchResultsPage srp;
	String searchKeyword;
	String searchText;
	String email;
	private SignUpPage sup;
	private MailinatorPage mp;
	private ChooseMissionPage cmp;
	private String count;

	{
		uniqueValue = "Sanity_8";
	}
	
	@Test(dataProvider="browserData")
	public void Sanity_8test(String browser) throws IOException, EncryptedDocumentException, InvalidFormatException, InterruptedException, ClassNotFoundException{
		count = SqliteUtils.updateAndGetCounter();
		email = "embibe.auto"+count+"@mailinator.com";
		basepage = new W_BasePage(wdriver);
		wdriver = basepage.launchWebApp(browser);
		Reporter.log("Starting Test: Sanity_8test", true);
		lp = new LandingPage(wdriver);
		lp.waitForLandingPageToLoad();
		shp = lp.clickStartNow();
		shp.assertSearchHomepage();
		cmp = shp.clickChooseMission();
		cmp.clickRequestMission();
		cmp.requestMission(uniqueValue);
		
	}
}