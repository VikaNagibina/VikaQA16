package com.Telran.qa16;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

public class ContactDeletionTest extends TestBase {

    @Test

    public void testContactDeletion(){
        int before = getContactCount();
        selectContact();
        deleteContact();
        confirmAlert();
        int after = getContactCount();

       Assert. assertEquals(after,before - 1);
    }


}
