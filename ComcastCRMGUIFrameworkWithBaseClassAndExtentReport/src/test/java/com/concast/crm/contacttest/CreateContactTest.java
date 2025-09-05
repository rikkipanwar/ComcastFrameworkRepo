package com.concast.crm.contacttest;

import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.aventstack.extentreports.Status;
import com.comcast.crm.basetest.BaseClass;
import com.comcast.crm.objectrepositoryutility.ContactsPage;
import com.comcast.crm.objectrepositoryutility.CreatingNewContactPage;
import com.comcast.crm.objectrepositoryutility.CreatingNewOrganizationPage;
import com.comcast.crm.objectrepositoryutility.HomePage;
import com.comcast.crm.objectrepositoryutility.OrganizationsPage;
import com.concast.crm.webdriverutility.UtilityClassObject;
/**
 * @author panwar
 */
public class CreateContactTest extends BaseClass {

	@Test(groups = "smokeTest")
	public void createContactTest() throws IOException {
		
		UtilityClassObject.getTest().log(Status.INFO, "read data from Excel");

		/* read test script data from excel file*/
		String lastName = eLib.getDataFromExcel("contact", 1, 2) + jLib.getRandomNumber();

		/* navigate to Contacts module*/
		UtilityClassObject.getTest().log(Status.INFO, "navigate to contact page");
		HomePage hp = new HomePage(driver);
		hp.getContactLink().click();

		/* click on "create contact" button*/
		UtilityClassObject.getTest().log(Status.INFO, "navigate to create contact page");
		ContactsPage cp = new ContactsPage(driver);
		cp.getCreateContactBtn().click();

		/* enter all the details & create new contact*/
		UtilityClassObject.getTest().log(Status.INFO, "Create new Contact");
		CreatingNewContactPage cnp = new CreatingNewContactPage(driver);
		cnp.createNewContact(lastName);

		/* verify header and last name*/
		UtilityClassObject.getTest().log(Status.PASS, "Contact has been created");
		String headerInfo = cp.getHeaderMsg().getText();
		boolean status = headerInfo.contains(lastName);
		Assert.assertEquals(status, true);

		String actLastName = cp.getLastNameInfo().getText();
		SoftAssert softAssert = new SoftAssert();
		softAssert.assertEquals(actLastName, lastName);
	}

	@Test(groups = "regressionTest")
	public void createContactWithOrgTest() throws IOException, InterruptedException {

		// read test script data from excel file
		String orgName = eLib.getDataFromExcel("contact", 7, 2).toString() + jLib.getRandomNumber();
		String contactLastName = eLib.getDataFromExcel("contact", 7, 3).toString() + jLib.getRandomNumber();

		// navigate to Organization module
		HomePage hp = new HomePage(driver);
		hp.getOrgLink().click();

		// click on "create organization" button
		OrganizationsPage op = new OrganizationsPage(driver);
		op.getCreateOrgBtn().click();

		// enter all the details & create new organization
		CreatingNewOrganizationPage orgCreatePage = new CreatingNewOrganizationPage(driver);
		orgCreatePage.createOrg(orgName);

		// verify header message of organization details page
		String headerOrgInfo = driver.findElement(By.xpath("//span[@class='dvHeaderText']")).getText();
		if (headerOrgInfo.contains(orgName)) {
			System.out.println(orgName + " is created == PASS");
		} else {
			System.out.println(orgName + " is not created == FAIL");
		}

		// navigate to Contacts module
		HomePage hp1 = new HomePage(driver);
		hp1.getContactLink().click();

		// click on "create contact" button
		ContactsPage cp = new ContactsPage(driver);
		cp.getCreateContactBtn().click();

		// enter all the details & create new contact
		CreatingNewContactPage cnp = new CreatingNewContactPage(driver);
		cnp.createNewContact(contactLastName, orgName);		

		// verify header and last name
		String headerContactInfo = driver.findElement(By.xpath("//span[@class='dvHeaderText']")).getText();
		if (headerContactInfo.contains(contactLastName)) {
			System.out.println(contactLastName + " header is verified == PASS");
		} else {
			System.out.println(contactLastName + " header is not verified == FAIL");
		}

		String actOrgName = driver.findElement(By.id("mouseArea_Organization Name")).getText();
		if (actOrgName.trim().equals(orgName)) {
			System.out.println(orgName + " informatioin is verified == PASS");
		} else {
			System.out.println(orgName + " information is not verfied == FAIL");
		}
	}

	@Test(groups = "regressionTest")
	public void createContactWithSupportDate() throws EncryptedDocumentException, IOException {
		// read test script data from excel file
		String lastName = eLib.getDataFromExcel("contact", 1, 2).toString() + jLib.getRandomNumber();

		// navigate to Contacts module
		HomePage hp = new HomePage(driver);
		hp.getContactLink().click();

		// click on "create contact" button
		ContactsPage cp = new ContactsPage(driver);
		cp.getCreateContactBtn().click();

		// enter all the details & create new contact
		// set support start date and end date
		String startDate = jLib.getSystemDateYYYYMMDD();
		String endDate = jLib.getRequiredDateYYYYMMDD(30);
		
		CreatingNewContactPage cnp = new CreatingNewContactPage(driver);
		cnp.createNewContactW(lastName, startDate, endDate);

		// verify header and last name
		String headerInfo = driver.findElement(By.xpath("//span[@class='dvHeaderText']")).getText();
		if (headerInfo.contains(lastName)) {
			System.out.println(lastName + " is created == PASS");
		} else {
			System.out.println(lastName + " is not created == FAIL");
		}

		String actStartDate = driver.findElement(By.id("dtlview_Support Start Date")).getText();
		if (actStartDate.contains(startDate)) {
			System.out.println(startDate + " information is verified == PASS");
		} else {
			System.out.println(startDate + " information is not verfied == FAIL");
		}

		String actEndDate = driver.findElement(By.id("dtlview_Support End Date")).getText();
		if (actEndDate.contains(endDate)) {
			System.out.println(endDate + " information is verified == PASS");
		} else {
			System.out.println(endDate + " information is not verfied == FAIL");
		}
	}

}
