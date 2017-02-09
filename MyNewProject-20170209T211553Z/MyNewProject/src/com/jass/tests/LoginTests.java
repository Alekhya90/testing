package com.jass.tests;


import java.net.MalformedURLException;

import org.openqa.selenium.By;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import com.jass.common.CommonMethods;
import com.jass.pageobject.LogOffPage;
import com.jass.pageobject.SignInPage;
import com.jass.pageobject.WelcomePage;

public class LoginTests  {
	String sURL="http://107.170.213.234/catalog/";
	String ExpectedText="Welcome to iBusiness";
	public CommonMethods CM;
	WelcomePage WP;
	SignInPage SI;
	LogOffPage LP;
	
	@BeforeMethod
	public void setUp() throws MalformedURLException{
		CM=new CommonMethods();
		CM.openBrowser("Firefox");
		CM.openURL(sURL);
		
	}
	
	@AfterMethod
	public void tearDown(){
		CM.closeBrowser();
	}
	
	@Test
	public void testcase01(){
		WP=new WelcomePage();
		WP.clickLogyourselfLink();
		SI=new SignInPage();
		SI.Login("ecalix@test.com","test123");
		CM.verifyText(ExpectedText);
		LP=new LogOffPage();
		LP.clickLogOff();
	}
	


}
