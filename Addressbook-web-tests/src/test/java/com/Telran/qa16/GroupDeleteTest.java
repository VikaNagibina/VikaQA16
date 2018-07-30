package com.Telran.qa16;

import org.testng.Assert;
import org.testng.annotations.Test;

public class GroupDeleteTest extends TestBase{


    @Test
    public void testDeleteGroups(){
        goToGroupsPage();
       if(!isGroupPresent()){
           createGroup();
       }
        int before = getGroupsCount();
        selectGroupByIndex(before-1);
        groupDeletion();
        returnToTheGroupsPage();
        int after = getGroupsCount();

        Assert.assertEquals(after,before-1);
}

}