package com.fb.pages;

//import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.fb.Testbase.TestBase;

public class LoginPage extends TestBase{
	
	//Page Factory
	
    @FindBy(xpath="//*[@id='email']")
	WebElement Username;
	
	
	@FindBy(xpath="//*[@id='pass']")
	WebElement Password;
	
	@FindBy(xpath="//*[@id='u_0_2']")
	WebElement Logingbtn;
	
	public LoginPage(){
		
		PageFactory.initElements(driver, this);
	} 
	
	//Actions:

	public Homepage  Verifylogin(String Email, String pswd) throws InterruptedException{

		Username.sendKeys(Email);
		Password.sendKeys(pswd);
		//Password.sendKeys(pswd + Keys.ENTER);
		Logingbtn.click();
		
		return new Homepage();
		
	}
	

}
