package com.fb.testcase;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.fb.Testbase.TestBase;
import com.fb.pages.Homepage;
import com.fb.pages.LoginPage;

public class LoginTest extends TestBase{

	
	LoginPage loginpage;	
	Homepage homepage;

	
	public LoginTest(){
		 super();	

	}
	

	@BeforeMethod
	public void setup() throws InterruptedException{
		
		initialization();


	}
	
	@Test
	public void logintest() throws InterruptedException {
		loginpage=new LoginPage();
		String s=prop.getProperty("username");
		String s2=prop.getProperty("password");
		homepage= loginpage.Verifylogin(s, s2);
		homepage.Add_New_post();
	}

	
	@AfterMethod
	public void teardown(){
		
	    driver.quit();
	}
	
	
	
}
