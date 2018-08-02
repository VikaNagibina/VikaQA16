package com.Telran.qa16.tests;

import com.Telran.qa16.model.ContactData;
import org.testng.Assert;
import org.testng.annotations.Test;

public class ContactModificationtest extends TestBase {

    @Test
    public void testContactModification(){
       if(!app.getContactHelper().isContactPresent()){
            app.getContactHelper().createContact();
        }
        int before = app.getContactHelper().getContactCount();
        app.getContactHelper().selectContact();
        app.getContactHelper().eddContact();
        app.getContactHelper().fillContactForms(new ContactData()
                .setFerstName("Ivan")
                .setLastName("Ivanov")
                .setAddress("shanedrin 20")
                .setEmail("vikvika632@gmail.com")
                .setPhone("053954123"));
        app.getContactHelper().selectUpDateContact();
        int after = app.getContactHelper().getContactCount();
        Assert. assertEquals(after,before );


    }

}
