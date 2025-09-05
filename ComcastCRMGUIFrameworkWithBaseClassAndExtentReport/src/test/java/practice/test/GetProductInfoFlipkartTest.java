package practice.test;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class GetProductInfoFlipkartTest {
	
	@Test
	public void getProductInfoFlipkartTest() {
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get("https://www.flipkart.in/");
		
		//search for a product
		driver.findElement(By.name("q")).sendKeys("iphone", Keys.ENTER);
		
		//capture product info
		//String x = "//span[text()='Apple iPhone 15 (128 GB) - Blue']/../../../../div[3]/div[1]/div/div[1]/div[1]/div[1]/a/span/span[2]/span[2]";
		String x = "//div[text()='Apple iPhone 13 (Blue, 128 GB)']/ancestor::div[@class='tUxRFH']//div[@class='Nx9bqj _4b5DiR']";
		String price = driver.findElement(By.xpath(x)).getText();
		System.out.println(price);
		driver.quit();
	}

}
