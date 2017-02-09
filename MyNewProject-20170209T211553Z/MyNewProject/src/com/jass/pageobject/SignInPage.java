package com.jass.pageobject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

import com.jass.common.CommonMethods;

public class SignInPage {
	public CommonMethods CM;
//	@FindBy(how = How.NAME, using = "email_address")
//    private WebElement EMAILADDRESS;
//    
//    @FindBy(how = How.NAME, using = "password")
//    private WebElement PASSWORD;
//    
//    @FindBy(how = How.XPATH, using = "//*[@id='tdb5']/span[1]")
//    private WebElement SIGNIN;
	
	
	public void Login(String Username, String PWD){
		CM=new CommonMethods();

		CM.sendValue("//*[@id='bodyContent']/div[2]/div/form/table/tbody/tr[1]/td[2]/input", Username);
		CM.sendValue("//*[@id='bodyContent']/div[2]/div/form/table/tbody/tr[2]/td[2]/input", PWD);
		CM.click("//*[@id='tdb5']/span[2]");
	
	
	}
	
	public void clickSign(){
		CM.click("//*[@id='tdb5']/span[2]");
	}
	
}
