import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class RegistrEbay {
   WebDriver wd;

   @BeforeMethod
   public void setUp(){

       wd = new FirefoxDriver();
       wd.manage().window().maximize();
   }

   @Test
   public void testEbay(){
      openSite();
      clickRegister();
      firstName();
      lastName();
      emailAddress();
      Password();
      register();

   }
   public void openSite(){
      wd.get("https://reg.ebay.com/");
   }
public void clickRegister(){
      wd.findElement(By.linkText("register")).click();
}

public void firstName(){
      wd.findElement(By.id("firstname")).click();
      wd.findElement(By.id("firstname")).clear();
      wd.findElement(By.id("firstname")).sendKeys("telran16");

   }
public void lastName(){
      wd.findElement(By.id("lastname")).click();
      wd.findElement(By.id("lastname")).clear();
      wd.findElement(By.id("lastname")).sendKeys("telranQA16");
}
public void emailAddress(){
      wd.findElement(By.id("email")).click();
   wd.findElement(By.id("email")).clear();
   wd.findElement(By.id("email")).sendKeys("vikvika632@gmail.com");

}
public void Password(){
   wd.findElement(By.id("PASSWORD")).click();
   wd.findElement(By.id("PASSWORD")).clear();
   wd.findElement(By.id("PASSWORD")).sendKeys("telranQA16");

}
public void register(){
   wd.findElement(By.id("ppaFormSbtBtn")).click();

   }

   @AfterMethod
   public void tearDown() throws InterruptedException {
      Thread.sleep(10000);
      wd.quit();
   }
}