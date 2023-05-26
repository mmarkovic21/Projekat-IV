package Test;

import static org.junit.Assert.*;

import java.util.HashMap;
import java.util.Map;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class UrlTest {

	private WebDriver driver;
	  private Map<String, Object> vars;
	  JavascriptExecutor js;
	  
	  @Before
	  public void setUp() {
	    
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\Marija Markovic\\Downloads\\chromedriver.exe");  
		driver = new ChromeDriver();
	    js = (JavascriptExecutor) driver;
	    vars = new HashMap<String, Object>();
	  
	  }
	  
	  @After
	  public void tearDown() {
	    driver.quit();
	  
	  }
		
	// Provera URL-a stranice  
	@Test
	public void testURL() {
		
		String stranica = "https://www.opposite-fashion.com/";
		driver.get(stranica);
	    driver.manage().window().setSize(new Dimension(1366, 728));
	    driver.findElement(By.cssSelector(".b-close")).click();
		
		assertEquals("https://www.opposite-fashion.com/", driver.getCurrentUrl());
	}

}
