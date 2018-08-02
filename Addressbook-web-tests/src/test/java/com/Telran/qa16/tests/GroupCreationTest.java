package com.Telran.qa16.tests;

import com.Telran.qa16.model.GroupData;
import com.Telran.qa16.tests.TestBase;
import org.testng.Assert;
import org.testng.annotations.Test;

public class GroupCreationTest extends TestBase {

    @Test
    public void testCreateGroupTest() {
        app.getGroupHelper().goToGroupsPage();

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

