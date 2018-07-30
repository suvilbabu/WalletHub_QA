package com.fb.Testbase;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;

import com.fb.Util.TestUtil;

public class TestBase {

	public static Properties prop;
	public static WebDriver driver;

	public TestBase() {
		prop = new Properties();

		FileInputStream ip;
		try {
			ip = new FileInputStream("C:\\Eclipse_jun26\\Wallet_hub\\src\\com\\fb\\Testdata\\Configdata");
			prop.load(ip);

		} catch (FileNotFoundException e) {
			e.printStackTrace();

		} catch (IOException e) {
			e.printStackTrace();
		}

	}
	
	public static void initialization(){
	
		String browsername=prop.getProperty("browser");

		if(browsername.equals("chrome")){
			
				 System.setProperty("webdriver.chrome.driver", "E:\\testing\\Testing software\\Selenium-sofware\\chromedriver\\chromedriver.exe");
					ChromeOptions chromeOptions = new ChromeOptions();
					chromeOptions.addArguments("--start-maximized");
					chromeOptions.addArguments("--disable-notifications");
					 driver= new ChromeDriver(chromeOptions);
		}else if(browsername.equals("FF")){
			System.setProperty("webdriver.gecko.driver", "E:\\testing\\Testing software\\Selenium-sofware\\geckodriver-v0.18.0-win64\\geckodriver.exe");
		    driver=new FirefoxDriver();

			 }
		
		
		driver.manage().deleteAllCookies();
		//driver.manage().timeouts().pageLoadTimeout(TestUtil.PAGE_LOAD_TIMEOUT, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(TestUtil.Implicit_Wait, TimeUnit.SECONDS);
		driver.get(prop.getProperty("url"));
		
	}
	
	
	

}
