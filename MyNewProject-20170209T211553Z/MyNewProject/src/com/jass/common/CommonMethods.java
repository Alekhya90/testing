package com.jass.common;


import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;


public class CommonMethods {
	
	public static WebDriver driver;
	public  Logger logger= Logger.getLogger(CommonMethods.class);
	Wait<WebDriver> wait;

	public void openBrowser(String sBrowser) throws MalformedURLException{
		if (sBrowser.equalsIgnoreCase("Firefox")){
		System.setProperty("webdriver.gecko.driver", "C:\\Selenium\\Batch0117\\SeleniumPractice\\drivers\\geckodriver.exe");
		driver=new FirefoxDriver();
		logger.info("Opening FireFox");
		}else if (sBrowser.equalsIgnoreCase("Remote")){
			System.setProperty("webdriver.gecko.driver", "C:\\Selenium\\Batch0117\\SeleniumPractice\\drivers\\geckodriver.exe");
			DesiredCapabilities capability =DesiredCapabilities.firefox();
			capability.setCapability("marionette", true);
			capability.setBrowserName("firefox");
			driver=new RemoteWebDriver(new URL("http://10.1.10.171:7777/wd/hub"),capability);
			wait = new WebDriverWait(driver, 3000);
			logger.info("Opening FireFox");
		}
		else{
			logger.info("Pleasae open a browser Firefox");
			Assert.fail();
		}	 
	}
	
	public void openURL(String sURL){
		driver.get(sURL);
		logger.info("Opening URL");
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		
	}
	
	public void closeBrowser(){
		driver.quit();
		logger.info("close Browser");
	}
	
	public void verifyText(String expected){
		 try{
			 driver.findElement(By.xpath("//*[contains(text(),'"+ expected.trim() +"')]"));
			 logger.info("On page " + driver.getTitle() + ". Expected Text \""+ expected +"\" verified");
			// return true;
		 }
		 catch(NoSuchElementException e){
			 logger.info("On page " + driver.getTitle() + ". Expected Text \""+ expected +"\" not found");
			 Assert.fail("On page " + driver.getTitle() + ". Expected Text \""+ expected +"\" not found");
		     
		 }
		 
	 }
	
	
	public void click(String sXPATH){
		try{
			driver.findElement(By.xpath(sXPATH)).click();
			logger.info(sXPATH+" clicked");
			 try {
					Thread.sleep(2000);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
		}catch(Exception e){
			logger.info(sXPATH+" not clicked");
			Assert.fail();
		}		
	}
	
	public void click(WebElement slocator){
		try{
			slocator.click();
			logger.info(slocator+" clicked");
			 try {
					Thread.sleep(2000);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
		}catch(Exception e){
			logger.info(slocator+" not clicked");
			Assert.fail();
		}		
	}

	
	
	public void sendValue(String sXPATH, String sValue){
		try{
			driver.findElement(By.xpath(sXPATH)).clear();
			driver.findElement(By.xpath(sXPATH)).sendKeys(sValue);;
			logger.info(sValue+" entered");
		}catch(Exception e){
			logger.info(sValue+" not entered");
			Assert.fail();
		}
	}
	

}
