package com.comcast.crm.objectrepositoryutility;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class CreatingNewOrganizationPage {
	
	WebDriver driver;
	public CreatingNewOrganizationPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(name = "accountname")
	private WebElement orgNameEdt;
	
	@FindBy(xpath = "//input[@title='Save [Alt+S]']")
	private WebElement saveBtn;
	
	@FindBy(name = "industry")
	private WebElement industryDropdown;
	
	@FindBy(name = "accounttype")
	private WebElement typeDropdown;
	
	@FindBy(id = "phone")
	private WebElement phoneNumberEdt;

	public WebElement getOrgNameEdt() {
		return orgNameEdt;
	}
	
	public WebElement getSaveBtn() {
		return saveBtn;
	}
	
	public WebElement getIndustryDropdown() {
		return industryDropdown;
	}
	
	public WebElement getTypeDropdown() {
		return typeDropdown;
	}
	
	public WebElement getPhoneNumberEdt() {
		return phoneNumberEdt;
	}
	
	public void createOrg(String orgName) {
		orgNameEdt.sendKeys(orgName);
		saveBtn.click();
	}
	
	public void createOrg(String orgName, String industry) {
		orgNameEdt.sendKeys(orgName);
		Select select = new Select(industryDropdown);
		select.selectByVisibleText(industry);
		saveBtn.click();
	}
	
	public void createOrg(String orgName, String industry, String type) {
		orgNameEdt.sendKeys(orgName);
		Select select = new Select(industryDropdown);
		select.selectByVisibleText(industry);
		
		Select select1 = new Select(typeDropdown);
		select1.selectByVisibleText(type);
		saveBtn.click();
	}
	
	public void createOrgWithPhNo(String orgName, String phoneNumber) {
		orgNameEdt.sendKeys(orgName);
		phoneNumberEdt.sendKeys(phoneNumber);
		saveBtn.click();
	}
	
}
