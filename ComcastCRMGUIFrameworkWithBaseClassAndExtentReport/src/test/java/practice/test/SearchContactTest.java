package practice.test;

import org.testng.annotations.Test;

import com.comcast.crm.basetest.BaseClass;
import com.comcast.crm.objectrepositoryutility.LoginPage;

/**
 * test class for Contact module
 * @author panwar
 */

public class SearchContactTest extends BaseClass{
	/**
	 * Scenario : login()==>navigateContact==>createContact==>verify 
	 */
	
	@Test
	public void searchContactTest() {
		 /*step1 : login to app*/
		LoginPage lp = new LoginPage(driver);
		lp.loginToApp("URL", "USERNAME", "PASSWORD");
	}

}
