package com.jass.pageobject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

import com.jass.common.CommonMethods;

public class LogOffPage {
	
	public CommonMethods CM;
	
	public void clickLogOff(){
		CM= new CommonMethods();
		
		CM.click("//*[@id='tdb4']/span");
		System.out.println("click log off");
	}
	
	
}
