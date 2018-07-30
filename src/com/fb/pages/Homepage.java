package com.fb.pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.fb.Testbase.TestBase;

public class Homepage extends TestBase {

	public Homepage() {

		PageFactory.initElements(driver, this);
	}

	public void Add_New_post() throws InterruptedException {
		Thread.sleep(2000);

		WebDriverWait wait = new WebDriverWait(driver, 100);
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//textarea[contains(@title,'What')]")));
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//textarea[contains(@title,'What')]")));
		driver.findElement(By.xpath("//textarea[contains(@title,'What')]")).click();

		List<WebElement> hiden = driver.findElements(By.xpath("//textarea[contains(@title,'What')]"));

		int count = hiden.size();
		for (int i = 0; i < count; i++) {
			int x = hiden.get(i).getLocation().getX();
			if (x != 0) {
				hiden.get(i).sendKeys("Hello World");
				break;
			}

		}
	
		Thread.sleep(3000);
        WebDriverWait wait2 = new WebDriverWait(driver,30);
        wait2.until(ExpectedConditions.elementToBeClickable(By.xpath("//span[text()='Post']"))).click();
		System.out.println("Post Added Successfully");

	}

}
