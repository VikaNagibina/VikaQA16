package com.Telran.qa16.tests;

import com.Telran.qa16.appManager.ApplicationManager;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;

public class TestBase {

  public static ApplicationManager app = new ApplicationManager();

    @BeforeSuite
    public void setUp(){
        app.start();

    }

    @AfterSuite
    public void tearDown()  {
        app.stop();
    }


    // CONTACT MODIF


}