package com.Telran.qa16;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

public class ContactCreationTest extends TestBase{


    @Test
    public void testContactCreation() {
        int before = getContactCount();
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
      int after = getContactCount();
       Assert.assertEquals(after,before + 1);
    }


}

