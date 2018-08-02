package com.Telran.qa16;

import org.testng.Assert;
import org.testng.annotations.Test;

public class GroupDeleteTest extends TestBase{


    @Test
    public void testDeleteGroups(){
        app.getGroupHelper().goToGroupsPage();
       if(!app.getGroupHelper().isGroupPresent()){
           app.getGroupHelper().createGroup();
       }
        int before = app.getGroupHelper().getGroupsCount();
        app.getGroupHelper().selectGroupByIndex(before-1);
        app.getGroupHelper().groupDeletion();
        app.getGroupHelper().returnToTheGroupsPage();
        int after = app.getGroupHelper().getGroupsCount();

        Assert.assertEquals(after,before-1);
}

}