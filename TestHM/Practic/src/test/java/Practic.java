import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class Practic {
    WebDriver wd;

   @BeforeMethod
    public void start(){
       wd = new ChromeDriver();
       wd.manage().window().maximize();

   }
   @Test
    public void loginTest(){
       openSait();
       clickEnter();
       type(By.id("user"),"vikvika623@gmail.com" );
       type(By.id("password"), "vika623623");

   }

    public void type( By locator,String text) {
        click(locator);
        wd.findElement(locator).clear();
        wd.findElement(locator).sendKeys(text);
    }

    public void click(By locator) {
        wd.findElement(locator).click();
    }

    public void clickEnter() {
        click(By.xpath("//*[@href='/login']"));
    }

    public void openSait() {
        wd.get("https://trello.com/");
    }

    @AfterSuite
    public  void stop(){
       wd.quit();
   }
}
