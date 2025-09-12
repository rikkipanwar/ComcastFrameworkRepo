package pac2;

import org.testng.annotations.Test;

public class OrgTest {
	
	@Test
	public void createOrgTest() {
		String URL = System.getProperty("url", "https://localhose/8080");
		String BROWSER = System.getProperty("browser", "chrome");
		String USERNAME = System.getProperty("username", "admin");
		String PASSWORD = System.getProperty("password", "admin");
		
		System.out.println(URL);
		System.out.println(BROWSER);
		System.out.println(USERNAME);
		System.out.println(PASSWORD);
		System.out.println("execute CreateOrgTest");
	}
	
	@Test
	public void modifyOrgTest() {
		System.out.println("execute modifyOrgTest");
	}

}
