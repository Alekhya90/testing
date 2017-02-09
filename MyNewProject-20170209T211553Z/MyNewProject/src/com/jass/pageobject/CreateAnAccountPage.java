package com.jass.pageobject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

public class CreateAnAccountPage {
	private WebDriver driver;
	//private CommonMethods CF;
	
	@FindBy(how = How.XPATH, using ="//*[@id='bodyContent']/div/div[1]/a[1]/u")
	private WebElement LogYourSelfLink;


	
	
	public void CreateAnAccountPage(WebDriver driver){
		this.driver=driver;
		PageFactory.initElements(this.driver, this);
	}
	
	public void clickLogyourselflink(){
		LogYourSelfLink.click();
	}
	
	
	

}
