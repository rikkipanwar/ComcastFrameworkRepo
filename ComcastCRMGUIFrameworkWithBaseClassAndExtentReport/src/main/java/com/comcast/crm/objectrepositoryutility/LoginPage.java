package com.comcast.crm.objectrepositoryutility;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.concast.crm.webdriverutility.WebDriverUtility;

/**
 * @author panwar
 * 
 * Contains Login page elements & business lib like login()
 */

public class LoginPage extends WebDriverUtility {	//Rule-1 Create a separate java class
	
	WebDriver driver;
	
	//Rule-3 Object Initialization
		public LoginPage(WebDriver driver) {
			this.driver = driver;
			PageFactory.initElements(driver, this);
		}
		
	//Rule-2 Object Creation
	@FindBy(name="user_name")
	private WebElement usernameEdt;
	
	@FindBy(name="user_password")
	private WebElement passwordEdt;
	
	@FindBy(id="submitButton")
	private WebElement loginBtn;
	
	//Rule-4 Object Encapsulation	
	public WebElement getUsernameEdt() {
		return usernameEdt;
	}

	public WebElement getPasswordEdt() {
		return passwordEdt;
	}

	public WebElement getLoginBtn() {
		return loginBtn;
	}
	
	/**
	 * login to application based on username, password, url arguments
	 * @param url
	 * @param username
	 * @param password
	 */
	//Rule-5 Action
	public void loginToApp(String url, String username, String password) {
		waitForPageToLoad(driver);
		driver.get(url);
		//driver.manage().window().maximize();
		usernameEdt.sendKeys(username);
		passwordEdt.sendKeys(password);
		loginBtn.click();
	}
	

}
