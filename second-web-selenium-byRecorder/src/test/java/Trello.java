

import java.util.regex.Pattern;
import java.util.concurrent.TimeUnit;
import org.testng.annotations.*;
import static org.testng.Assert.*;
import org.openqa.selenium.*;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;

public class Trello {
  private WebDriver driver;


  @BeforeClass(alwaysRun = true)
  public void setUp() {
    driver = new FirefoxDriver();
    driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
  }

  @Test
  public void testTrello() {
    openSite();
    driver.findElement(By.xpath("//*[@href='/signup']")).click();
    filNameField();
    filEmailField();
    filPasswordField();
    clickOnSignup();

  }

  public void openSite() {

    driver.get("https://trello.com/");
  }

  public void clickOnSignup() {
    driver.findElement(By.id("signup")).click();

  }

  public void filNameField() {
    driver.findElement(By.id("name")).click();
    driver.findElement(By.id("name")).clear();
    driver.findElement(By.id("name")).sendKeys("vika");
  }

  public void filEmailField() {
    driver.findElement(By.id("email")).click();
    driver.findElement(By.id("email")).clear();
    driver.findElement(By.id("email")).sendKeys("vikakhlinova@gmail.com");
  }

  public void filPasswordField() {
    driver.findElement(By.id("password")).click();
    driver.findElement(By.id("password")).clear();
    driver.findElement(By.id("password")).sendKeys("0skar2013");
  }








  @AfterClass(alwaysRun = true)
  public void tearDown() throws Exception {
    Thread.sleep(10000);
    driver.quit();

  }






  private boolean isElementPresent(By by) {
    try {
      driver.findElement(by);
      return true;
    } catch (NoSuchElementException e) {
      return false;
    }
  }

}
