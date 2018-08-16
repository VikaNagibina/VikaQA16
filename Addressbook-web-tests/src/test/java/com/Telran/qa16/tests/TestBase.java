package com.Telran.qa16.tests;

import com.Telran.qa16.appManager.ApplicationManager;
import org.openqa.selenium.remote.BrowserType;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;

public class TestBase {

  public static ApplicationManager app =
          new ApplicationManager (BrowserType.FIREFOX);

    @BeforeSuite
    public void setUp(){
        app.start();

    }

    @AfterSuite
    public void tearDown()  {

        app.stop();
    }





}