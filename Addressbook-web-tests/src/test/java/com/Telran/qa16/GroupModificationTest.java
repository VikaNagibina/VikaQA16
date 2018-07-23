package com.Telran.qa16;

import org.testng.Assert;
import org.testng.annotations.Test;

public class GroupModificationTest extends TestBase {

    @Test
    public void testEditFillGroup() {
        goToGroupsPage();
        int before = getGroupsCount();
        selectGroup();
        initGroupModification();
        fillGroupsForm(new GroupData()
                .withName("EddGroupName")
                .withHeader("AddGroupHeader")
                .withFooter("AddGroupFooter"));
        submitGroupModification();
        returnToTheGroupsPage();

        int after = getGroupsCount();

        Assert.assertEquals(after,before);

    }


}
