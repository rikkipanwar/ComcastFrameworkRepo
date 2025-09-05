package com.comcast.crm.objectrepositoryutility;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ContactsPage {
	
	WebDriver driver;
	public  ContactsPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(className = "dvHeaderText")
	private WebElement headerMsg;
	
	@FindBy(id="dtlview_Last Name")
	private WebElement lastNameInfo;
	
	@FindBy(xpath = "//img[@title='Create Contact...']")
	private WebElement createContactBtn;
	
	public WebElement getCreateContactBtn() {
		return createContactBtn;
	}
	
	public WebElement getHeaderMsg() {
		return headerMsg;
	}
	
	public WebElement getLastNameInfo() {
		return lastNameInfo;
	}
	

}
