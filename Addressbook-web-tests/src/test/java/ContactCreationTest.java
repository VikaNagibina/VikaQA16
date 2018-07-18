import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class ContactCreationTest {
    WebDriver wd;

    @BeforeMethod
    public void setUp() {
        wd = new ChromeDriver();
        wd.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        openSite();
        login();
    }

    @Test
    public void testContactCreation(){
        goToAddNewPage();
        fillContactForms();
        submitContactCreation();
        returnToTheHomePage();
    }

    @AfterMethod
    public  void tearDoun() throws InterruptedException {
        Thread.sleep(5000);
        wd.quit();
    }



    public void goToAddNewPage() {
        wd.findElement(By.linkText("add new")).click();
    }

    public void login() {
    wd.findElement(By.name("user")).click();
    wd.findElement(By.name("user")).clear();
    wd.findElement(By.name("user")).sendKeys("admin");
    wd.findElement(By.name("pass")).click();
    wd.findElement(By.name("pass")).clear();
    wd.findElement(By.name("pass")).sendKeys("secret");
    wd.findElement(By.xpath("//*[@type = 'submit']")).click();
}

    public void openSite() {
        wd.get("http://localhost/addressbook/");
}public void fillContactForms() {
    wd.findElement(By.name("firstname")).click();
    wd.findElement(By.name("firstname")).clear();
    wd.findElement(By.name("firstname")).sendKeys("Lena");

    wd.findElement(By.name("lastname")).click();
    wd.findElement(By.name("lastname")).clear();
    wd.findElement(By.name("lastname")).sendKeys("Polikova");

    wd.findElement(By.name("address")).click();
    wd.findElement(By.name("address")).clear();
    wd.findElement(By.name("address")).sendKeys("shanedrin 20");

    wd.findElement(By.name("email")).click();
    wd.findElement(By.name("email")).clear();
    wd.findElement(By.name("email")).sendKeys("vikvika632@gmail.com");


    wd.findElement(By.name("mobile")).click();
    wd.findElement(By.name("mobile")).clear();
    wd.findElement(By.name("mobile")).sendKeys("053954123");
}

public void submitContactCreation() {
    wd.findElement(By.name("submit")).click();
}
public void returnToTheHomePage() {
        wd.findElement(By.linkText("home")).click();
    }
}