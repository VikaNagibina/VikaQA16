package com.Telran.qa16.appManager;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;

public class HelperBase {
    public WebDriver wd;

    public HelperBase(WebDriver wd){
        this.wd = wd;
    }



    public void click(By locator) {
        wd.findElement(locator).click();
    }


    public void type(By locator, String text) {
        if(text!=null){
            click(locator);
            wd.findElement(locator).clear();
            wd.findElement(locator).sendKeys(text);
        }

    }



    public boolean isElementPresent(By locator) { //НАХОДИМ ЭЛЕМЕНТ (ЕСЛИ ЕСТЬ TRUE)
        try {
            wd.findElement(locator);
            return true;
        } catch (NoSuchElementException e) {
            return false;
        }
    }

}
