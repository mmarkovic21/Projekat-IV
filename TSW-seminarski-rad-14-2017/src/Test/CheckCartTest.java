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
public class CheckCartTest 
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
  public void checkCart() {
  
	driver.get("https://www.opposite-fashion.com/");
    driver.manage().window().setSize(new Dimension(1382, 744));
    driver.findElement(By.cssSelector(".b-close")).click();
    
    {
      WebElement element = driver.findElement(By.cssSelector(".menu-dropit"));
      Actions builder = new Actions(driver);
      builder.moveToElement(element).perform();
    }
    
    driver.findElement(By.xpath("//ul[@id='menu_link']/li[5]/a")).click();
    driver.get("https://www.opposite-fashion.com/customer/account/login/");
    driver.findElement(By.id("email")).sendKeys("marijaamarkovic21@gmail.com");
    driver.findElement(By.id("pass")).click();
    driver.findElement(By.id("pass")).sendKeys("142017Marija");
    driver.findElement(By.id("pass")).sendKeys(Keys.ENTER);
    driver.get("https://www.opposite-fashion.com/customer/account/");
    
    {
      WebElement element = driver.findElement(By.cssSelector("#pt_menu152 > .parentMenu span"));
      Actions builder = new Actions(driver);
      builder.moveToElement(element).perform();
    }
    
    driver.findElement(By.xpath("//span[contains(.,'�enske��izme')]")).click();
    driver.get("https://www.opposite-fashion.com/zenska-obuca/zenske-cizme.html");
    driver.findElement(By.cssSelector(".products-grid:nth-child(3) > .col-xl-3:nth-child(1) .products img")).click();
    driver.get("https://www.opposite-fashion.com/zenska-obuca/zenske-cizme/uzun.html");
    js.executeScript("window.scrollTo(0,72)");
    js.executeScript("window.scrollTo(0,119)");
    driver.findElement(By.xpath("//form[@id='product_addtocart_form']/div/div[2]/div/div[5]/div[2]/button/span/span")).click();
    
    //Provera da li su dodate �eljene �enske �izme
    String zenske = driver.findElement(By.xpath("//li[contains(.,'UZUN je dodat u va�u korpu.')]")).getText();
    String zenske1 = "UZUN je dodat u va�u korpu.";
    
    assertEquals(zenske, zenske1);
    
    
    {
      WebElement element = driver.findElement(By.cssSelector("#pt_menu153 > .parentMenu span"));
      Actions builder = new Actions(driver);
      builder.moveToElement(element).perform();
    }
    
    driver.findElement(By.cssSelector("#block1153 .itemMenuName:nth-child(2) > span")).click();
    driver.get("https://www.opposite-fashion.com/decija-obuca/decije-cizme.html");
    js.executeScript("window.scrollTo(0,116)");
    driver.findElement(By.cssSelector(".products-grid:nth-child(2) > .col-xl-3:nth-child(1) .products img")).click();
    driver.get("https://www.opposite-fashion.com/decija-obuca/decije-cizme/zenske-cizme-ch85373.html");
    js.executeScript("window.scrollTo(0,102)");
    driver.findElement(By.xpath("//div[@id='amconf-image-259']")).click();
    js.executeScript("window.scrollTo(0,0)");
    driver.findElement(By.cssSelector(".btn-cart > span > span")).click();
    
    //Provera da li su dodate �eljene de�ije �izme
    String decije = driver.findElement(By.xpath("//li[contains(.,'De�ija �izma - CH85373 je dodat u va�u korpu.')]")).getText();
    String decije1 = "De�ija �izma - CH85373 je dodat u va�u korpu.";
    
    assertEquals(decije, decije1);
    
    {
      WebElement element = driver.findElement(By.cssSelector("#pt_menu489 > .parentMenu span"));
      Actions builder = new Actions(driver);
      builder.moveToElement(element).perform();
    }
    
    driver.findElement(By.cssSelector(".nochild:nth-child(2) > span")).click();
    driver.get("https://www.opposite-fashion.com/zenske-torbe/zenski-rancevi.html");
    js.executeScript("window.scrollTo(0,729)");
    driver.findElement(By.cssSelector(".products-grid:nth-child(5) > .col-xl-3:nth-child(2) .products img")).click();
    driver.get("https://www.opposite-fashion.com/zenske-torbe/zenski-rancevi/zenski-rancevi-t080006.html");
    driver.findElement(By.cssSelector(".btn-cart > span > span")).click();
    
    //Provera da li je dodat �eljeni �enski ranac 
    
    String ranac = driver.findElement(By.xpath("//li[contains(.,'�enski ran�evi - T080006 je dodat u va�u korpu.')]")).getText();
    String ranac1 = "�enski ran�evi - T080006 je dodat u va�u korpu.";
    
    assertEquals(ranac, ranac1);
    
    //Provera da li su razli�ite kategorije
    
    String kategorija1 = driver.findElement(By.xpath("//div[@id='pt_menu152']/div/a/span")).getText();
    String kategorija2 = driver.findElement(By.xpath("//div[@id='pt_menu153']/div/a/span")).getText();
    String kategorija3 = driver.findElement(By.xpath("//div[@id='pt_menu489']/div/a/span")).getText();
    
    assertNotEquals(kategorija1, kategorija2);
    assertNotEquals(kategorija2, kategorija3);
    assertNotEquals(kategorija1, kategorija3);
    
    //Provera da li ima tri proizvoda u korpi
    
    String broj = driver.findElement(By.cssSelector(".top-cart-title > a")).getText();
    String realanBroj = "3";
    
    assertEquals(broj, realanBroj);
    
    
    //Provera cene    
   
    String prviProizvod = driver.findElement(By.xpath("//table[@id='shopping-cart-table']/tbody/tr/td[7]/span/span")).getText();
    String cPrvog = prviProizvod.replace(".", "");
    String cenaPrbogProizvoda = cPrvog.substring(0, 4);
    double cenaPrvog = Double.parseDouble(cenaPrbogProizvoda);
    
    String drugiProizvod = driver.findElement(By.xpath("//table[@id='shopping-cart-table']/tbody/tr[2]/td[7]/span/span")).getText();
    String cDrugog = drugiProizvod.replace(".", "");
    String cenaDrugogProizvoda = cDrugog.substring(0, 4);
    double cenaDrugog = Double.parseDouble(cenaDrugogProizvoda);
    
    String treciProizvod = driver.findElement(By.xpath("//table[@id='shopping-cart-table']/tbody/tr[3]/td[7]/span/span")).getText();
    String cTreceg = treciProizvod.replace(".", "");
    String cenaTrecegProizvoda = cTreceg.substring(0, 4);
    double cenaTreceg = Double.parseDouble(cenaTrecegProizvoda);
    
    String stvarnaCena = driver.findElement(By.xpath("//table[@id='shopping-cart-totals-table']/tfoot/tr/td[2]/strong/span")).getText();
    String sCena = stvarnaCena.replace(".", "");
    String stvarna = sCena.substring(0, 4);
    double realnaUkupnaCena = Double.parseDouble(stvarna);
    
    String popust = driver.findElement(By.xpath("//table[@id='shopping-cart-totals-table']/tbody/tr[3]/td[2]/span")).getText();
    String tacka = popust.replace(".", "");
    String zaokruzi = tacka.substring(1, 4);
    double iznosPopusta = Double.parseDouble(zaokruzi);
    
    double ocekivanaUkupnaCena = cenaPrvog + cenaDrugog + cenaTreceg - iznosPopusta;
    
    assertEquals(ocekivanaUkupnaCena, realnaUkupnaCena, 1.0); 

  }
}
