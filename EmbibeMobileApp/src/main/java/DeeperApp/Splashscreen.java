package DeeperApp;

import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

import Screens.BasePageMob;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

public class Splashscreen extends BasePageMob
{

	public Splashscreen(AppiumDriver<MobileElement> driverMob) 
	{
		super(driverMob);
		PageFactory.initElements(new AppiumFieldDecorator(driverMob), this);
	}
	
	
	@FindBy(id="com.embibe.deeper.sample:id/practice_engr")
	MobileElement practiceEngg;
	
	@Test
	 public InstituteLoginScreen splashScreen()
	{
		System.out.println("Launched the App successfully");
		return new InstituteLoginScreen(driverMob);
	}
}
