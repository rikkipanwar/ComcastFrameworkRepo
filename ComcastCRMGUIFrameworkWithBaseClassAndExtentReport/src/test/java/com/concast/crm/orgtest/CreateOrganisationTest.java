package com.concast.crm.orgtest;

import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.openqa.selenium.By;
import org.testng.annotations.Test;

import com.comcast.crm.basetest.BaseClass;
import com.comcast.crm.objectrepositoryutility.CreatingNewOrganizationPage;
import com.comcast.crm.objectrepositoryutility.HomePage;
import com.comcast.crm.objectrepositoryutility.OrganizationsPage;

public class CreateOrganisationTest extends BaseClass {

	@Test(groups = "smokeTest")
	public void createOrgTest() throws IOException {

		// read test script data from excel file
		String orgName = eLib.getDataFromExcel("org", 1, 2) + jLib.getRandomNumber();

		// navigate to Organization module
		HomePage hp = new HomePage(driver);
		hp.getOrgLink().click();

		// click on "create organization" button
		OrganizationsPage orgPage = new OrganizationsPage(driver);
		orgPage.getCreateOrgBtn().click();

		// enter all the details & create new organization
		CreatingNewOrganizationPage cnop = new CreatingNewOrganizationPage(driver);
		cnop.createOrg(orgName);

		// verify header message expected result
		String headerInfo = driver.findElement(By.xpath("//span[@class='dvHeaderText']")).getText();
		if (headerInfo.contains(orgName)) {
			System.out.println(orgName + " is created == PASS");
		} else {
			System.out.println(orgName + " is not created == FAIL");
		}

		// verify organization name info
		String actOrgName = driver.findElement(By.id("dtlview_Organization Name")).getText();
		if (actOrgName.equals(orgName)) {
			System.out.println(orgName + " information is created == PASS");
		} else {
			System.out.println(orgName + " information is not created == FAIL");
		}

	}

	@Test(groups = {"smokeTest", "regressionTest"})
	public void createOrgWithIndustry() throws EncryptedDocumentException, IOException {

		String orgName = eLib.getDataFromExcel("org", 4, 2) + jLib.getRandomNumber();
		String industry = eLib.getDataFromExcel("org", 4, 3);
		String type = eLib.getDataFromExcel("org", 4, 4);

		// navigate to Organization module
		HomePage hp = new HomePage(driver);
		hp.getOrgLink().click();

		// click on "create organization" button
		OrganizationsPage orgPage = new OrganizationsPage(driver);
		orgPage.getCreateOrgBtn().click();

		// enter all the details & create new organization
		CreatingNewOrganizationPage cnop = new CreatingNewOrganizationPage(driver);
		cnop.createOrg(orgName, industry, type);

		// verify industry and type info
		String actIndustry = driver.findElement(By.id("dtlview_Industry")).getText();
		if (actIndustry.equals(industry)) {
			System.out.println(industry + " is created == PASS");
		} else {
			System.out.println(industry + " is not created == FAIL");
		}

		String actType = driver.findElement(By.id("dtlview_Type")).getText();
		if (actType.equals(type)) {
			System.out.println(type + " information is created == PASS");
		} else {
			System.out.println(type + " information is not created == FAIL");
		}

	}
	
	@Test(groups = "regressionTest")
	public void createOrgWithPhoneNumber() throws EncryptedDocumentException, IOException {

		// read test script data from excel file
		String orgName = eLib.getDataFromExcel("org", 7, 2) + jLib.getRandomNumber();
		String phoneNumber = eLib.getDataFromExcel("org", 7, 3);
		
		//navigate to Organization module
		HomePage hp = new HomePage(driver);
		hp.getOrgLink().click();
		
		//click on "create organization" button
		OrganizationsPage orgPage = new OrganizationsPage(driver);
		orgPage.getCreateOrgBtn().click();
		
		//enter all the details & create new organization
		CreatingNewOrganizationPage cnop = new CreatingNewOrganizationPage(driver);
		cnop.createOrgWithPhNo(orgName, phoneNumber);
		
		// verify header message expected result
		String headerInfo = driver.findElement(By.xpath("//span[@class='dvHeaderText']")).getText();
		if(headerInfo.contains(orgName)) {
			System.out.println(orgName + " is created == PASS");
		} else {
			System.out.println(orgName + " is not created == FAIL");
		}
		
		// verify the phone number info
		String actPhoneNumber = driver.findElement(By.id("dtlview_Phone")).getText();
		if(actPhoneNumber.equals(phoneNumber)) {
			System.out.println(phoneNumber + " information is created == PASS");
		} else {
			System.out.println(phoneNumber + " information is not created == FAIL");
		}
		
	}

}
