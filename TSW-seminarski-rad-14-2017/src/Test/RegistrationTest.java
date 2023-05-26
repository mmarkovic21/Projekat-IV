package Test;
// Generated by Selenium IDE
import org.junit.Test;
import org.junit.Before;
import org.junit.After;
import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.core.IsNot.not;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Alert;
import org.openqa.selenium.Keys;
import java.util.*;
import java.net.MalformedURLException;
import java.net.URL;

public class RegistrationTest 
{

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
  
  public void registration() {
    driver.get("https://www.opposite-fashion.com/");
    driver.manage().window().setSize(new Dimension(1382, 744));
    driver.findElement(By.cssSelector(".b-close")).click();
  
    {
      WebElement element = driver.findElement(By.cssSelector(".menu-dropit"));
      Actions builder = new Actions(driver);
      builder.moveToElement(element).perform();
    }
    
    driver.findElement(By.xpath("//a[contains(text(),'Prijava i registracija')]")).click();
    driver.get("https://www.opposite-fashion.com/customer/account/login/");
    driver.findElement(By.cssSelector(".button:nth-child(1) > span > span")).click();
    driver.get("https://www.opposite-fashion.com/customer/account/create/");
    driver.findElement(By.cssSelector("#firstname")).sendKeys("Marija");
    driver.findElement(By.id("lastname")).click();
    driver.findElement(By.id("lastname")).sendKeys("Markovic");
    driver.findElement(By.id("email_address")).click();
    driver.findElement(By.id("email_address")).sendKeys("marijaamarkovic21@gmail.com");
    driver.findElement(By.id("password")).click();
    driver.findElement(By.id("password")).sendKeys("142017Marija");
    driver.findElement(By.id("confirmation")).click();
    driver.findElement(By.id("confirmation")).sendKeys("142017Marija");
    driver.findElement(By.cssSelector("span > span")).click();
    
    // Provera da li je registracija uspe�na
    
    String ocekivani = driver.findElement(By.xpath("//li[contains(.,'Hvala na prijavi na Opposite shoes.')]")).getText();
    String realni = "Hvala na prijavi na Opposite shoes.";
    
    assertEquals(ocekivani, realni);
  
  }
}