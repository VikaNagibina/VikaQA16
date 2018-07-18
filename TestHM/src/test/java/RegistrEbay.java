import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class RegistrEbay {
   WebDriver wb;

   @BeforeMethod
   public void setUp(){

       wb = new ChromeDriver();
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
      wb.get("https://reg.ebay.com/");
   }
public void clickRegister(){
      wb.findElement(By.linkText("register")).click();
}

public void firstName(){
      wb.findElement(By.id("firstname")).click();
      wb.findElement(By.id("firstname")).clear();
      wb.findElement(By.id("firstname")).sendKeys("telran16");

   }
public void lastName(){
      wb.findElement(By.id("lastname")).click();
      wb.findElement(By.id("lastname")).clear();
      wb.findElement(By.id("lastname")).sendKeys("telranQA16");
}
public void emailAddress(){
      wb.findElement(By.id("email")).click();
   wb.findElement(By.id("email")).clear();
   wb.findElement(By.id("email")).sendKeys("vikvika632@gmail.com");

}
public void Password(){
   wb.findElement(By.id("PASSWORD")).click();
   wb.findElement(By.id("PASSWORD")).clear();
   wb.findElement(By.id("PASSWORD")).sendKeys("telranQA16");

}
public void register(){
   wb.findElement(By.id("ppaFormSbtBtn")).click();

   }

   @AfterMethod
   public void tearDown() throws InterruptedException {
      Thread.sleep(10000);
      wb.quit();
   }
}