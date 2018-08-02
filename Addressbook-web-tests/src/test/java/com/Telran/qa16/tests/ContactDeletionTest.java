package com.Telran.qa16.tests;

import org.testng.Assert;
import org.testng.annotations.Test;

public class ContactDeletionTest extends TestBase {

    @Test

    public void testContactDeletion(){
if(!app.getContactHelper().isContactPresent()){
            app.getContactHelper().createContact();
        }
int before = app.getContactHelper().getContactCount();
        app.getContactHelper().selectContact();
        app.getContactHelper().deleteContact();
        app.getContactHelper().confirmAlert();
       int after = app.getContactHelper().getContactCount();

       Assert. assertEquals(after,before - 1);
    }


}
