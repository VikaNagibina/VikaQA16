package com.Telran.qa16;

import org.testng.Assert;
import org.testng.annotations.Test;

public class GroupModificationTest extends TestBase {

    @Test
    public void testEditFillGroup() {
        app.goToGroupsPage();
        if(!app.getGroupHelper().isGroupPresent()){
            app.getGroupHelper().createGroup();
        }
        int before = app.getGroupHelper().getGroupsCount();
       app.getGroupHelper().selectGroup();
       //selectGroupByIndex(); // в скобках передаем то,что нужно изменить
        app.getGroupHelper().initGroupModification();
        app.getGroupHelper().fillGroupsForm(new GroupData()
                .withName("EddGroupName")
                .withHeader("AddGroupHeader")
                .withFooter("AddGroupFooter"));
        app.getGroupHelper().submitGroupModification();
        app.getGroupHelper().returnToTheGroupsPage();

        int after = app.getGroupHelper().getGroupsCount();

        Assert.assertEquals(after,before);

    }


}
