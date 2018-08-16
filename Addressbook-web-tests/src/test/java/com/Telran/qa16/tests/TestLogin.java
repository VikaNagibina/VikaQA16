package com.Telran.qa16.tests;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class TestLogin extends TestBase {

    @BeforeMethod
    public void preconditions(){
        app.getSessionHelper().logout();
    }

    @Test
    public void loginTestnegative() {
        app.getSessionHelper().login("admin","gtew");
        Assert.assertFalse(app.getSessionHelper()
                .isElementPresent(By.xpath("//a[contains(text(),'Logout')]")));
    }
    @Test
    public void loginTest() {
        app.getSessionHelper().login("admin","secret");
        Assert.assertTrue(app.getSessionHelper()
                .isElementPresent(By.xpath("//a[contains(text(),'Logout')]")));
    }
}