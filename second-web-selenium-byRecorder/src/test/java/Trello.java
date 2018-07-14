

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

    filNameField();
    filEmailField();
    filPasswordField();
    clickOnSignup();
  }

  public void clickOnSignup() {
    driver.findElement(By.id("signup")).click();
  }

  public void filPasswordField() {
    driver.findElement(By.id("password")).click();
    driver.findElement(By.id("password")).clear();
    driver.findElement(By.id("password")).sendKeys("0skar2013");
  }

  public void filEmailField() {
    driver.findElement(By.id("email")).click();
    driver.findElement(By.id("email")).clear();
    driver.findElement(By.id("email")).sendKeys("vikakhlinova@gmail.com");
  }

  public void filNameField() {
    driver.findElement(By.xpath("//*[@href='/signup']")).click();
    driver.findElement(By.id("name")).clear();
    driver.findElement(By.id("name")).sendKeys("vika");
  }

  public void openSite() {

    driver.get("https://trello.com/");
  }

  @AfterClass(alwaysRun = true)
  public void tearDown() throws Exception {
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
