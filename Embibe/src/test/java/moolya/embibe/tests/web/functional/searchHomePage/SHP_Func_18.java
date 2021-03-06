package moolya.embibe.tests.web.functional.searchHomePage;

import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.testng.Reporter;
import org.testng.annotations.Test;

import moolya.embibe.pages.web.LandingPage;
import moolya.embibe.pages.web.SearchHomepage;
import moolya.embibe.pages.web.W_BasePage;
import moolya.embibe.tests.web.W_BaseTest;

public class SHP_Func_18 extends W_BaseTest {

	private W_BasePage basepage;
	private LandingPage lp;
	private SearchHomepage shp;
	
	{
		uniqueValue = "Functional_1";
	}
	
	@Test(dataProvider="browserData")
	public void SHP_Func_18_Test(String browser) throws IOException, EncryptedDocumentException, InvalidFormatException, InterruptedException{
		basepage = new W_BasePage(wdriver);
		wdriver = basepage.launchWebApp(browser);
		Reporter.log("Starting Test: Functional : Search Home Page : SHP_Func_18 "+ ", Browser is :" + browser, true);
		lp = new LandingPage(wdriver);
		lp.waitForLandingPageToLoad();
		lp.assertLandingPage();
		Reporter.log("User is navigated to Landing Page successfully", true);
		shp = lp.clickStartNow();
		shp.assertSearchHomepage();
		shp.examLinks(1,"EXAMS","");
		shp.examLinks(1,"JEE Main","");
		shp.examLinks(2,"NEET","");
		shp.examLinks(3,"AIIMS","");
		shp.examLinks(4,"CBSE","");
		shp.examLinks(5,"JEE Advanced","");
		shp.examLinks(6,"BITSAT","");
		shp.examLinks(7,"EAMCET","");
		Reporter.log("Navigation test is completed for 'EXAM' Module ",true);
	}
}
