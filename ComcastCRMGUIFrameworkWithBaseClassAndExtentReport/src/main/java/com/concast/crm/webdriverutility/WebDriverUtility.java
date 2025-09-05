package com.concast.crm.webdriverutility;

import java.time.Duration;
import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class WebDriverUtility {
	
	public void waitForPageToLoad(WebDriver driver) {
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
	}
	
	public void maximizeWindow(WebDriver driver) {
		driver.manage().window().maximize();
	}
	
	public void waitForElementToBePresent(WebDriver driver, WebElement element) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
		wait.until(ExpectedConditions.visibilityOf(element));
	}
	
	public void switchToTabOnURL(WebDriver driver, String partialUrl) {
		for (String handle : driver.getWindowHandles()) {
			driver.switchTo().window(handle);
			if (driver.getCurrentUrl().contains(partialUrl)) {
				break;
			}
		}
	}
	
	public void switchToTabOnTitle(WebDriver driver, String partialTitle) {
		Set<String> set = driver.getWindowHandles();
		Iterator<String> it = set.iterator();
		
		while(it.hasNext()) {
			String windowID = it.next();
			driver.switchTo().window(windowID);
			String actTitle = driver.getTitle();
			if(actTitle.contains(partialTitle)) {
				break;
			}
		}
	}
	
	public void switchToFrame(WebDriver driver, int index) {
		driver.switchTo().frame(index);
	}
	
	public void switchToFrame(WebDriver driver, String nameID) {
		driver.switchTo().frame(nameID);
	}
	
	public void switchToFrame(WebDriver driver, WebElement element) {
		driver.switchTo().frame(element);
	}
	
	public void selectByIndex(WebElement element, int index) {
		Select select = new Select(element);
		select.selectByIndex(index);
	}
	
	public void selectByText(WebElement element, String text) {
		Select select = new Select(element);
		select.selectByVisibleText(text);
	}
	
	public WebDriver switchBrowser(WebDriver driver, String browserName) {
		if (browserName.equalsIgnoreCase("chrome")) {
			driver = new ChromeDriver(); // Assuming ChromeDriver is imported and initialized
		} else if (browserName.equalsIgnoreCase("firefox")) {
			driver = new FirefoxDriver(); // Assuming FirefoxDriver is imported and initialized
		} else if (browserName.equalsIgnoreCase("edge")) {
			driver = new EdgeDriver(); // Assuming EdgeDriver is imported and initialized
		} else {
			driver = new ChromeDriver();// or initialize a default browser driver
		}
		return driver; 
	}
}
