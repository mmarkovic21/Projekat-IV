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
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class PerformanceTest {
	
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

	@Test
	public void testPerformance() {

		driver.get("https://www.opposite-fashion.com/");
	    driver.manage().window().setSize(new Dimension(1366, 728));
	    driver.findElement(By.cssSelector(".b-close")).click();
	    
	    {
	      WebElement element = driver.findElement(By.cssSelector(".menu-dropit"));
	      Actions builder = new Actions(driver);
	      builder.moveToElement(element).perform();
	    }
		
		//Provera koliko je vremena potrebno za otvaranje kategorije: Moj nalog
		
	    driver.findElement(By.xpath("//a[contains(text(),'Prijava i registracija')]")).click();
		long startTime = System.currentTimeMillis();
		
		driver.get("https://www.opposite-fashion.com/customer/account/");
		long endTime = System.currentTimeMillis();
		long time = endTime - startTime;
		
		//Provera koliko je vremena potrebno za otvaranje kategorije: Korpa
		
		driver.findElement(By.cssSelector(".top-cart-title > a")).click();
		long startTime1 = System.currentTimeMillis();
		driver.get("https://www.opposite-fashion.com/checkout/cart/");
		long endTime1 = System.currentTimeMillis();
		long time1 = endTime1 - startTime1;

		//Provera koliko je vremena potrebno za otvaranje kategorije: Ženske torbe
		
		driver.findElement(By.xpath("//div[@id='pt_menu489']/div/a/span")).click();
		long startTime2 = System.currentTimeMillis();
		driver.get("https://www.opposite-fashion.com/zenske-torbe.html");
		long endTime2 = System.currentTimeMillis();
		long time2 = endTime2 - startTime2;

		//Provera koliko je vremena potrebno za otvaranje kategorije: Deèija obuæa
		
		driver.findElement(By.cssSelector("#pt_menu153 > .parentMenu span")).click();
		long startTime3 = System.currentTimeMillis();
		driver.get("https://www.opposite-fashion.com/decija-obuca.html");
		long endTime3 = System.currentTimeMillis();
		long time3 = endTime3 - startTime3;


		//Provera koliko je vremena potrebno za otvaranje kategorije: NEW
		
		driver.findElement(By.cssSelector("#pt_menu499 span")).click();
		long startTime4 = System.currentTimeMillis();
		driver.get("https://www.opposite-fashion.com/nova-kolekcija");
		long endTime4 = System.currentTimeMillis();
		long time4 = endTime4 - startTime4;
		
		System.out.println("Ukupno vreme otvaranja ---> Moj nalog: " +time+ " s.");
		System.out.println("Ukupno vreme otvaranja ---> Korpa: " +time1+ " s.");
		System.out.println("Ukupno vreme otvaranja ---> Ženske torbe: " +time2+ " s.");
		System.out.println("Ukupno vreme otvaranja ---> Deèija obuæa: " +time3+ " s.");
		System.out.println("Ukupno vreme otvaranja ---> NEW: " +time4+ " s.");

		long totalTime = time + time1 + time2 + time3 + time4;
		long totalAverageTime = (time + time1 + time2 + time3 + time4)/5;
		System.out.println("\nProseèno vreme otvaranja navedenih stranica je ----> " +totalAverageTime+ " s.");
		
		assertNotNull(totalAverageTime);
		assertNotNull(totalTime);
		assertNotEquals(totalAverageTime, totalTime);
		
	}

}
