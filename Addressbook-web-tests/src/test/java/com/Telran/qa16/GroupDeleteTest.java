package com.Telran.qa16;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

public class GroupDeleteTest extends TestBase{


    @Test
    public void testDeleteGroups(){
        goToGroupsPage();
        int before = getGroupsCount();
        selectGroup();
        groupDeletion();
        returnToTheGroupsPage();
        int after = getGroupsCount();

        Assert.assertEquals(after,before-1);
}

}