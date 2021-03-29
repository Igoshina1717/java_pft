package ru.stqa.pft.addressbook.appmanager;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import ru.stqa.pft.addressbook.model.ContactData;
import ru.stqa.pft.addressbook.model.Contacts;
import ru.stqa.pft.addressbook.model.Groups;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class ContactHelper extends HelperBase {

  public ContactHelper(WebDriver wd) {
    super(wd);

  }

  public void returnToHomePage() {
    click(By.linkText("home page"));
  }

  public void submitContactCreation() {
    click(By.xpath("(//input[@name='submit'])[2]"));
  }

  public void fillContactForm(ContactData contactData) {
    type(By.name("firstname"), contactData.getName());
    type(By.name("lastname"), contactData.getLastName());
    type(By.name("address"), contactData.getAddress());
    type(By.name("mobile"), contactData.getMobile());
    type(By.name("email"), contactData.getEmail());

  }


  public void gotoAddNewPage() {
    click(By.linkText("add new"));
  }

  public void selectContactById(int id) {
    wd.findElement(By.cssSelector("input[value='"+ id +"']")).click();
  }
  public void delete() {
    click(By.xpath("//input[@value='Delete']"));
  }

  public void accept() {
    wd.switchTo().alert().accept();
  }

  public void modificationContact() {
    click(By.xpath("//img[@alt='Edit']"));
  }

  public void submitContactUpdate() {
    click(By.xpath("//input[@name='update']"));
  }

  private void HomePage() { click(By.linkText("home")); }

  public boolean isThereAContact() {
    return isElementPresent(By.name("selected[]"));
  }

  public void create(ContactData contact) {
    gotoAddNewPage();
    fillContactForm(contact);
    submitContactCreation();
    contactCache = null;
    returnToHomePage();
  }
  public void modify(ContactData contact) {
    selectContactById(contact.getId());
    modificationContact();
    fillContactForm(contact);
    submitContactUpdate();
    contactCache = null;
    returnToHomePage();
  }

  public void delete(ContactData contact) {
    selectContactById(contact.getId());
    delete();
    accept();
    contactCache = null;
    HomePage();
  }


  public int getContactCount() {
    return wd.findElements(By.name("selected[]")).size();
  }

  private Contacts contactCache = null;

  public Contacts all() {
    if (contactCache !=null){
      return new Contacts(contactCache);
    }

    contactCache = new Contacts();
    List<WebElement> elements = wd.findElements(By.name("entry"));
    for (WebElement element : elements){
      String name = element.findElements(By.tagName("td")).get(2).getText();
      String lastName = element.findElements(By.tagName("td")).get(1).getText();
      int id = Integer.parseInt(element.findElement(By.tagName("input")).getAttribute("value"));
      contactCache.add(new ContactData().withId(id).withName(name).withLastName(lastName));
    }
    return contactCache;
  }


}
