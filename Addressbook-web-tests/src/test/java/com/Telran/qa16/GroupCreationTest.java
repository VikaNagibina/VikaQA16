package com.Telran.qa16;

import org.testng.Assert;
import org.testng.annotations.Test;

public class GroupCreationTest extends TestBase {

    @Test
    public void testCreateGroupTest() {
        goToGroupsPage();
        int before = getGroupsCount();
        initGroupCreation();
        fillGroupsForm(new GroupData()
                .withName("GroupName")
                .withHeader("GroupHeader")
                .withFooter("GroupFooter"));
        submitgroupCreation();
        returnToTheGroupsPage();
        int after = getGroupsCount();
        Assert.assertEquals(after,before +1);
    }


}

