package com.Telran.qa16.appManager;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.BrowserType;

import java.util.concurrent.TimeUnit;

public class ApplicationManager {
    SessionHelper sessionHelper;
    GroupHelper groupHelper;
    ContactHelper contactHelper;
    private WebDriver wd;
    private String browser;

    public ApplicationManager(String browser) {
        this.browser = browser;
    }


    public void start() {
        if (browser.equals(BrowserType.CHROME)){
            wd = new ChromeDriver();
        }else
            if (browser.equals(BrowserType.FIREFOX)) {
                wd = new FirefoxDriver();
            }

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
