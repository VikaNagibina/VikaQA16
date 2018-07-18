package com.Telran.qa16;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class GroupCreationTest {
    WebDriver wd;

    @BeforeMethod
    public void setUp() {
        wd = new ChromeDriver();
        wd.manage().timeouts().implicitlyWait(30,TimeUnit.SECONDS);
        wd.get("http://localhost/addressbook/");
        login("admin","secret");

    }

    @Test
    public void CreationGroupTest() {
    }


    public void login(String user,String password){
        wd.findElement(By.name("user")).click();
        wd.findElement(By.name("user")).clear();
        wd.findElement(By.name("user")).sendKeys("admin");
        wd.findElement(By.name("pass")).click();
        wd.findElement(By.name("pass")).clear();
        wd.findElement(By.name("pass")).sendKeys("secret");
     wd.findElement(By.xpath("//*[@type = 'submit']")).click();
}

@AfterMethod
    public  void tearDoun() throws InterruptedException {
        Thread.sleep(10000);
        wd.quit();
}

}

