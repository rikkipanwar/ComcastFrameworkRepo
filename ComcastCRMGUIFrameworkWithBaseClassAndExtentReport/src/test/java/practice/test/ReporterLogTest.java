package practice.test;

import org.testng.Reporter;
import org.testng.annotations.Test;

public class ReporterLogTest {
	
	@Test
	public void reporterLogTest() {
		System.out.println("Step-1");
		System.out.println("Step-2");
		Reporter.log("Report Log Step-3");
		Reporter.log("Report Log Step-4", false);
		System.out.println("Step-5");
		Reporter.log("Report Log Step-6", true);
		Reporter.log("Report Log Step-7", true);
		System.out.println("Step-8");
	}
}
