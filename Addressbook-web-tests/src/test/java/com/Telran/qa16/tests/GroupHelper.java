package com.Telran.qa16.tests;

import com.Telran.qa16.appManager.HelperBase;
import com.Telran.qa16.model.GroupData;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class GroupHelper extends HelperBase {

  public GroupHelper(WebDriver wd){

      super(wd);
  }

    //class creation
    public void goToGroupsPage() {
      wd.findElement(By.linkText("groups")).click();
    }


    public void initGroupCreation() {
      click(By.name("new"));
    }

    public void fillGroupsForm(GroupData group) {
        type(By.name("group_name"), group.getGroupName());
        type(By.name("group_header"), group.getGroupHeader());
        type(By.name("group_footer"), group.getGroupFooter());

    }



    public void createGroup(){
         initGroupCreation();
         fillGroupsForm(new GroupData()
                 .withName("GroupName22")
                 .withHeader("GroupHeader")
                 .withFooter("GroupFooter"));
         submitgroupCreation();
         returnToTheGroupsPage();
     }



    public boolean  isGroupPresent() {
        return isElementPresent(By.className("selected[]"));
    }


    public void submitgroupCreation() {
        click(By.name("submit"));
    }

    public void returnToTheGroupsPage() {
        click(By.linkText("group page"));
    }

    //Modification
    public void selectGroup() {

        click(By.name("selected[]"));
    }

    public void selectGroupByIndex(int ind) {
        wd.findElements(By.name("selected[]")).get(ind).click();// находит все элементы (name selected) и дает конкретный
       // wd.findElement(By.name("selected[]")).click();// находит один первый элемент
    }

    public void initGroupModification() {
        click(By.name("edit"));
    }

    public void submitGroupModification() {
        click(By.name("update"));
    }

    //Deletion Group
    public void groupDeletion() {

      click(By.name("delete"));
    }

    //Проверка
    public int getGroupsCount() {
        return wd.findElements(By.name("selected[]")).size();
    }
}
