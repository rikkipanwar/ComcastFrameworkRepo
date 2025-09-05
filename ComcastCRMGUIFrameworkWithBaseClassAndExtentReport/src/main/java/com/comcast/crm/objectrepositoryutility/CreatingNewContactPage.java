package com.comcast.crm.objectrepositoryutility;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.concast.crm.webdriverutility.WebDriverUtility;

public class CreatingNewContactPage {
	
	WebDriverUtility wLib = new WebDriverUtility();
	WebDriver driver;
	public CreatingNewContactPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(name = "lastname")
	private WebElement lastNameEdt;
	
	@FindBy(name = "accountname")
	private WebElement orgNameEdt;
	
	@FindBy(xpath = "//input[@name='account_name']/following-sibling::img")
	private WebElement orgLookUpImg;
	
	@FindBy(name = "search_text")
	private WebElement searchEdt;
	
	@FindBy(name = "search")
	private WebElement searchBtn;
	
	@FindBy(name = "support_start_date")
	private WebElement supportStartDateEdt;
	
	@FindBy(name = "support_end_date")
	private WebElement supportEndDateEdt;
	
	@FindBy(xpath = "//input[@title='Save [Alt+S]']")
	private WebElement saveBtn;
	
	public WebElement getLastNameEdt() {
		return lastNameEdt;
	}
	
	public WebElement getOrgNameEdt() {
		return orgNameEdt;
	}
	
	public WebElement getSaveBtn() {
		return saveBtn;
	}
	
	public WebElement getOrgLookUpImg() {
		return orgLookUpImg;
	}
	
	public WebElement getSearchEdt() {
		return searchEdt;
	}
	
	public WebElement getSearchBtn() {
		return searchBtn;
	}
	
	public WebElement getSupportStartDateEdt() {
		return supportStartDateEdt;
	}
	
	public WebElement getSupportEndDateEdt() {
		return supportEndDateEdt;
	}
	
	public void createNewContact(String lastName) {
		lastNameEdt.sendKeys(lastName);
		saveBtn.click();
	}
	
	public void createNewContact(String lastName, String orgName) throws InterruptedException {
		lastNameEdt.sendKeys(lastName);
		orgLookUpImg.click();
		wLib.switchToTabOnURL(driver, "module=Accounts&action");
		searchEdt.sendKeys(orgName);
		searchBtn.click();
		driver.findElement(By.xpath("//a[text()='" + orgName + "']")).click();
		wLib.switchToTabOnURL(driver, "module=Contacts&action");
		saveBtn.click();
	}
	
	public void createNewContactW(String lastName, String startDate, String endDate) {
		lastNameEdt.sendKeys(lastName);
		supportStartDateEdt.clear();
		supportStartDateEdt.sendKeys(startDate);
		supportEndDateEdt.clear();
		supportEndDateEdt.sendKeys(endDate);
		saveBtn.click();
	}

}
