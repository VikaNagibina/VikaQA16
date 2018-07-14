import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class OpenGoogleTest {

        WebDriver driver;

@BeforeMethod
        public void setUp () {

            driver = new ChromeDriver();
     }
@Test
        public void siteOpeningTest () {

          //  driver.get("https://www.google.com/");  // открывает сайт
            driver.get("https://vk.com/");
driver.findElement(By.id("index_email")).sendKeys("89144409224");
driver.findElement(By.id("index_pass")).sendKeys("oskar2017");
driver.findElement(By.id("index_login_button")).click();

       }
          @AfterMethod //запуск метода
       public void tearDown () throws InterruptedException { //метод закрыватия
Thread.sleep(10000);
            driver.quit();
        }


    }
