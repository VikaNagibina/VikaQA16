package com.Telran.qa16.tests;
import com.Telran.qa16.model.ContactData;
import org.testng.Assert;
import org.testng.annotations.Test;

public class ContactCreationTest extends TestBase {


    @Test
    public void testContactCreation() {
        app.getContactHelper().isOnContactPage();
        int before = app.getContactHelper().getContactCount();
        app.getContactHelper().goToAddNewPage();
        app.getContactHelper().fillContactForms(
                new ContactData()
                        .setFerstName("Lena")
                        .setLastName("Polikova")
                        .setAddress("shanedrin 20")
                        .setEmail("vikvika632@gmail.com")
                        .setPhone("053954123"));
        app.getContactHelper().submitContactCreation();
        app.getContactHelper().returnToTheHomePage();
      int after = app.getContactHelper().getContactCount();
       Assert.assertEquals(after,before + 1);
    }
}

