package com.Telran.qa16;

import org.testng.Assert;
import org.testng.annotations.Test;

public class GroupCreationTest extends TestBase {

    @Test
    public void testCreateGroupTest() {
        app.groupHelper.goToGroupsPage();

        int before = app.getGroupHelper().getGroupsCount();
        app.getGroupHelper().initGroupCreation();
        app.getGroupHelper().fillGroupsForm(new GroupData()
                .withName("GroupName22")
                .withHeader("GroupHeader")
                .withFooter("GroupFooter"));
        app.getGroupHelper().submitgroupCreation();
        app.getGroupHelper().returnToTheGroupsPage();
        int after = app.getGroupHelper().getGroupsCount();
        Assert.assertEquals(after,before +1);
    }


}

