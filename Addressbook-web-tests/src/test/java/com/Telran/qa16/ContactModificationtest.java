package com.Telran.qa16;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

public class ContactModificationtest extends TestBase{

    @Test
    public void testContactModification(){
        int before = getContactCount();
        selectContact();
        eddContact();
        fillContactForms (new ContactData()
                .setFerstName("Ivan")
                .setLastName("Ivanov")
                .setAddress("shanedrin 20")
                .setEmail("vikvika632@gmail.com")
                .setPhone("053954123"));
        selectUpDateContact();
        int after = getContactCount();
        Assert. assertEquals(after,before );


    }

}
