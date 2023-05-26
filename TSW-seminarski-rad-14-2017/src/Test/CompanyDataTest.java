package Test;

import static org.junit.Assert.*;

import java.io.FileWriter;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;

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

import java.io.BufferedWriter;

public class CompanyDataTest {

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
	public void testCompanyData() throws IOException {
		
		driver.get("https://www.opposite-fashion.com/");
	    driver.manage().window().setSize(new Dimension(1366, 728));
	    driver.findElement(By.cssSelector(".b-close")).click();
	    js.executeScript("window.scrollTo(0,274)");
	    driver.findElement(By.linkText("O nama")).click();
	    driver.get("https://www.opposite-fashion.com/o-nama");
	    driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		
	    driver.findElement(By.linkText("Opposite maloprodaje")).click();
	    driver.get("https://www.opposite-fashion.com/maloprodaje");
	    
	    //Podaci o prodavnicama u Èaèku
	    
	    vars.put("Grad", driver.findElement(By.xpath("//h2[contains(.,'Èaèak')]")).getText());
	    vars.put("Lokacija 1", driver.findElement(By.xpath("//div[23]/h4")).getText());
	    vars.put("Adresa i telefon 1", driver.findElement(By.xpath("//p[contains(.,'Braæe Spasiæ bbtel +381 66 841 88 90')]")).getText());
	    vars.put("Radno vreme", driver.findElement(By.xpath("//div[23]/p[2]")).getText());
	    
	    vars.put("Grad:", driver.findElement(By.xpath("//div[24]/h2")).getText());
	    vars.put("Lokacija 2", driver.findElement(By.xpath("//h4[contains(.,'Stop Shop')]")).getText());
	    vars.put("Adresa i telefon 2", driver.findElement(By.xpath("//p[contains(.,'Ul. Bul. Vuka Karadžiæa 80 – lokal L09, tel: +381668418941')]")).getText());
	    vars.put("Radno vreme:", driver.findElement(By.xpath("//div[24]/p[2]")).getText());
	    
	    //Telefon i e-mail za informacije
	    
	    vars.put("Telefon", driver.findElement(By.xpath("//li[contains(.,'  +381 (0) 11 7858078')]")).getText());
	    vars.put("E-mail", driver.findElement(By.xpath("//li[contains(.,'  webshop@opposite-fashion.com')]")).getText());
	    
	    //Dodatni telefoni kao i mejlovi za posao i marketing
	    vars.put("Dodatni kontakt telefon 1", driver.findElement(By.xpath("//li[contains(.,'  +381 (0) 66 841 88 81')]")).getText());
	    vars.put("Dodatni kontakt telefon 2", driver.findElement(By.xpath("//li[contains(.,'  +381 (0) 66 841 89 06')]")).getText());
	    vars.put("E-mail posao", driver.findElement(By.xpath("//li[contains(.,'  posao@opposite-fashion.com')]")).getText());
	    vars.put("E-mail marketing", driver.findElement(By.xpath("//li[contains(.,'  marketing@opposite-fashion.com')]")).getText());
	    
	    BufferedWriter writer = new BufferedWriter(new FileWriter("Opposite-report.txt", true));
	    
	    writer.append("Grad: " +vars.get("Grad").toString());
	    writer.newLine();
	    writer.append("Lokacija 1: " +vars.get("Lokacija 1").toString());
	    writer.newLine();
	    writer.append("Adresa i telefon 1: " +vars.get("Adresa i telefon 1").toString());
	    writer.newLine();
	    writer.append("" +vars.get("Radno vreme").toString());
	    writer.newLine();
	    
	    writer.newLine();
	    writer.append("Grad: " +vars.get("Grad:").toString());
	    writer.newLine();
	    writer.append("Lokacija 2: " +vars.get("Lokacija 2").toString());
	    writer.newLine();
	    writer.append("Adresa i telefon 2: " +vars.get("Adresa i telefon 2").toString());
	    writer.newLine();
	    writer.append("" +vars.get("Radno vreme:").toString());
	    writer.newLine();
	    
	    writer.newLine();
	    writer.append("Telefon: " +vars.get("Telefon").toString());
	    writer.newLine();
	    writer.append("E-mail: " +vars.get("E-mail").toString());
	    writer.newLine();
	    
	    writer.newLine();
	    writer.append("Dodatni kontakt telefon 1: " +vars.get("Dodatni kontakt telefon 1").toString());
	    writer.newLine();
	    writer.append("Dodatni kontakt telefon 2: " +vars.get("Dodatni kontakt telefon 2").toString());
	    writer.newLine();
	    writer.newLine();
	    writer.append("E-mail posao: " +vars.get("E-mail posao").toString());
	    writer.newLine();
	    writer.append("E-mail marketing: " +vars.get("E-mail marketing").toString());
	    writer.newLine();
	    
	    writer.close();
	}

}
