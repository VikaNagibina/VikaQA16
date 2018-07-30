package com.Telran.qa16;

import org.testng.Assert;
import org.testng.annotations.Test;

public class GroupCreationTest extends TestBase {

    @Test
    public void testCreateGroupTest() {
        goToGroupsPage();
       /* if(!isGroupPresent()){
            createGroup();
        }*/
        int before = getGroupsCount();
        initGroupCreation();
        fillGroupsForm(new GroupData()
                .withName("GroupName22")
                .withHeader("GroupHeader")
                .withFooter("GroupFooter"));
        submitgroupCreation();
        returnToTheGroupsPage();
        int after = getGroupsCount();
        Assert.assertEquals(after,before +1);
    }


}

