package com.Telran.qa16.tests;

import com.Telran.qa16.appManager.HelperBase;
import com.Telran.qa16.model.ContactData;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ContactHelper  extends HelperBase {

    public ContactHelper(WebDriver wd) {
        super(wd);
    }

    public void createContact(){
        goToAddNewPage();
        fillContactForms(
                new ContactData()
                        .setFerstName("Lena")
                        .setLastName("Polikova")
                        .setAddress("shanedrin 20")
                        .setEmail("vikvika632@gmail.com")
                        .setPhone("053954123"));
        submitContactCreation();
      returnToTheHomePage();

    }


    public void goToAddNewPage() {
        click(By.linkText("add new"));
    }
    public void fillContactForms(ContactData contact) {
        type(By.name("firstname"), contact.getFerstName());
        type(By.name("lastname"), contact.getLastName());
        type(By.name("address"), contact.getAddress());
        type(By.name("email"), contact.getEmail());
        type(By.name("mobile"), contact.getPhone());
    }

    public void submitContactCreation() {
        click(By.name("submit"));
    }

    public void returnToTheHomePage() {
        click(By.linkText("home"));
    }


    // CONTACT DELETE
    public void confirmAlert() {
        wd.switchTo().alert().accept();
    }

    public void selectContact() {
        click(By.name("selected[]"));
    }

    public void deleteContact() {
        click(By.xpath("//*[@value='Delete']"));

    }

    public void selectUpDateContact() {

        click(By.name("update"));
    }


    public void eddContact() {
        click(By.xpath("//*[@title='Edit']"));

    }

    public int getContactCount() {
        return wd.findElements(By.name("selected[]")).size();
        }




    public boolean  isContactPresent(){
        return isElementPresent(By.name("selected[]"));
    }
}
