package com.Telran.qa16.appManager;

import com.Telran.qa16.appManager.HelperBase;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class SessionHelper extends HelperBase {

    public SessionHelper(WebDriver wd) {
        super(wd);
    }

    public void openSite(String url) {
        wd.get(url);
    }

    public void login(String user, String password) {
        wd.findElement(By.name("user")).sendKeys(user);
        wd.findElement(By.name("pass")).click();
        wd.findElement(By.name("pass")).clear();
        wd.findElement(By.name("pass")).sendKeys(password);
        wd.findElement(By.xpath("//*[@value ='Login']")).click();
    }

    public void logout() {
        click(By.xpath("//a[contains(text(),'Logout')]"));
    }
}
