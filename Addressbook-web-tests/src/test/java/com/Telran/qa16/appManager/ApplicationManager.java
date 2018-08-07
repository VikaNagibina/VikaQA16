package com.Telran.qa16.appManager;

import com.Telran.qa16.tests.ContactHelper;
import com.Telran.qa16.tests.GroupHelper;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class ApplicationManager {
    SessionHelper sessionHelper;
    GroupHelper groupHelper;
    ContactHelper contactHelper;
    private WebDriver wd;

    public void start() {
        wd = new ChromeDriver();
        //wd.manage().window().maximize();// открфтие на весь экран
        wd.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        sessionHelper = new SessionHelper(wd);
        sessionHelper.openSite("http://localhost/addressbook/");
        sessionHelper.login("admin", "secret");
        groupHelper = new GroupHelper(wd);
        contactHelper = new ContactHelper(wd);
    }


    public void stop() {
        wd.quit();
    }



    public GroupHelper getGroupHelper() {
        return groupHelper;
    }
    public SessionHelper getSessionHelper() {
        return sessionHelper;
    }
    public ContactHelper getContactHelper() {
        return contactHelper;
    }
}
