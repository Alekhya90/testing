package com.jass.pageobject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

import com.jass.common.CommonMethods;

public class WelcomePage {
	
//	    @FindBy(how = How.XPATH, using = "//*[@id='bodyContent']/div/div[1]/a[1]/u")
//	    private WebElement LOGYOURSELFIN;
	    
	    public CommonMethods CM;
	    
	    
	
	public void clickLogyourselfLink(){
		CM=new CommonMethods();
		CM.click("//*[@id='bodyContent']/div/div[1]/a[1]/u");

	}
	
}
