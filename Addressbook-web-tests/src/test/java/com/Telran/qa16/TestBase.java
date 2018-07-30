package com.Telran.qa16;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import java.util.concurrent.TimeUnit;

public class TestBase {
    WebDriver wd;

    @BeforeMethod
    public void setUp() {
        wd = new ChromeDriver();
        wd.manage().window().maximize();
        wd.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        openSite();
        login("admin", "secret");
    }

    public void openSite() {
        wd.get("http://localhost/addressbook/");
    }

    public void login(String user, String password) {
        wd.findElement(By.name("user")).sendKeys(user);
        wd.findElement(By.name("pass")).click();
        wd.findElement(By.name("pass")).clear();
        wd.findElement(By.name("pass")).sendKeys(password);
        wd.findElement(By.xpath("//*[@value ='Login']")).click();
    }

    @AfterMethod
    public void tearDown() throws InterruptedException {
        Thread.sleep(3000);
        wd.quit();
    }

    //class creation
    public void goToGroupsPage() {
        wd.findElement(By.linkText("groups")).click();
    }

    public void initGroupCreation() {
        wd.findElement(By.name("new")).click();
    }

    public void fillGroupsForm(GroupData group) {
        wd.findElement(By.name("group_name")).click();
        wd.findElement(By.name("group_name")).clear();
        wd.findElement(By.name("group_name")).sendKeys(group.getGroupName());

        wd.findElement(By.name("group_header")).click();
       wd.findElement(By.name("group_header")).clear();
        wd.findElement(By.name("group_header")).sendKeys(group.getGroupHeader());

        wd.findElement(By.name("group_footer")).click();
       wd.findElement(By.name("group_footer")).clear();
        wd.findElement(By.name("group_footer")).sendKeys(group.getGroupFooter());

    }

    public boolean isElementPresent(By locator) { //НАХОДИМ ЭЛЕМЕНТ (ЕСЛИ ЕСТЬ TRUE)
        try {
           wd.findElement(locator);
            return true;
        } catch (NoSuchElementException e) {
            return false;
        }
    }


    public boolean  isGroupPresent(){
        return isElementPresent(By.className("selected[]"));
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
public boolean isElementsPresent(By locator){
        return wd.findElements(locator).size()>0;
}

    public void submitgroupCreation() {
        wd.findElement(By.name("submit")).click();
    }

    public void returnToTheGroupsPage() {
        wd.findElement(By.linkText("group page")).click();
    }


    //Modification
    public void selectGroup() {

       wd.findElement(By.name("selected[]")).click();
    }
    public void selectGroupByIndex(int ind) {
        wd.findElements(By.name("selected[]")).get(ind).click();// находит все элементы (name selected) и дает конкретный
       // wd.findElement(By.name("selected[]")).click();// находит один первый элемент
    }

    public void initGroupModification() {
        wd.findElement(By.name("edit")).click();
    }
    public void submitGroupModification() {
        wd.findElement(By.name("update")).click();
    }

//Deletion Group
    public void groupDeletion() {
        wd.findElement(By.name("delete")).click();
    }
//Проверка
    public int getGroupsCount() {
        return wd.findElements(By.name("selected[]")).size();
    }

// HM Contacts
 // CONTECT CREAT
    public void goToAddNewPage() {
        wd.findElement(By.linkText("add new")).click();
    }


    public void fillContactForms(ContactData contactData) {
        wd.findElement(By.name("firstname")).click();
        wd.findElement(By.name("firstname")).clear();
        wd.findElement(By.name("firstname")).sendKeys(contactData.getFerstName());

        wd.findElement(By.name("lastname")).click();
        wd.findElement(By.name("lastname")).clear();
        wd.findElement(By.name("lastname")).sendKeys(contactData.getLastName());

        wd.findElement(By.name("address")).click();
        wd.findElement(By.name("address")).clear();
        wd.findElement(By.name("address")).sendKeys(contactData.getAddress());

        wd.findElement(By.name("email")).click();
        wd.findElement(By.name("email")).clear();
        wd.findElement(By.name("email")).sendKeys(contactData.getEmail());


        wd.findElement(By.name("mobile")).click();
        wd.findElement(By.name("mobile")).clear();
        wd.findElement(By.name("mobile")).sendKeys(contactData.getPhone());
    }

    public void submitContactCreation() {
        wd.findElement(By.name("submit")).click();
    }

    public void returnToTheHomePage() {
        wd.findElement(By.linkText("home")).click();
    }


// CONTACT DELETE
    protected void confirmAlert() {
        wd.switchTo().alert().accept();
    }

    protected void selectContact() {
        wd.findElement(By.name("selected[]")).click();
    }

    protected void deleteContact() {
        wd.findElement(By.xpath("//*[@value='Delete']")).click();

    }
// CONTACT MODIF

    protected void selectUpDateContact() {
        wd.findElement(By.name("update")).click();
    }

    protected void eddContact() {
        wd.findElement(By.xpath("//*[@title='Edit']")).click();

    }

    public int getContactCount() {
        return wd.findElements(By.name("selected[]")).size();
    }

    public boolean isContactElementPresent(By locator) { //НАХОДИМ ЭЛЕМЕНТ (ЕСЛИ ЕСТЬ TRUE)
        try {
            wd.findElement(locator);
            return true;
        } catch (NoSuchElementException e) {
            return false;
        }
    }


    public boolean  isContactPresent(){
        return isContactElementPresent(By.name("selected[]"));
    }
    public void createContact(){
        goToAddNewPage();
        fillContactForms(
                new ContactData()
                        .setFerstName("Lena")
                        .setLastName("Polikova")
                        .setAddress("shanedrin 20")
                        .setEmail("vikvika632@gmail.com")
                        .setPhone("053954123"));
        submitContactCreation();
        returnToTheHomePage();

    }


}