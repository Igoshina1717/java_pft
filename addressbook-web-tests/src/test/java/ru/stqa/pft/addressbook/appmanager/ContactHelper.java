package ru.stqa.pft.addressbook.appmanager;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import ru.stqa.pft.addressbook.model.ContactData;
import ru.stqa.pft.addressbook.model.Contacts;

import java.util.List;

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
    type(By.name("home"), contactData.getHomePhone());
    type(By.name("email"), contactData.getEmail());
    type(By.name("work"), contactData.getWorkPhone());
    type(By.name("email"), contactData.getEmail());
    type(By.name("email2"), contactData.getEmail2());
    type(By.name("email3"), contactData.getEmail3());

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

  public void modificationContact(int id) {

    wd.findElement(By.xpath("//tr["+id+"]/td[8]/a/img")).click();
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

  public void modify(int id, ContactData contact) {
    modificationContact(id);
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


  public int count() {
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
      List<WebElement> cells = element.findElements(By.tagName("td"));
      String name = element.findElements(By.tagName("td")).get(2).getText();
      String lastName = element.findElements(By.tagName("td")).get(1).getText();
      String address = element.findElements(By.tagName("td")).get(3).getText();
      String allPhones = cells.get(5).getText();
      String allEmail = cells.get(4).getText();
      int id = Integer.parseInt(element.findElement(By.tagName("input")).getAttribute("value"));
      contactCache.add(new ContactData().withId(id).withName(name).withLastName(lastName).withAddress(address)
              .withAllPhones(allPhones).withAllEmail(allEmail));
    }
    return contactCache;
  }


  public ContactData contactInfoFromEditForm(int id, ContactData contact) {
    wd.findElement(By.xpath(String.format("//tr[.//input[@value='%s']]/td[8]/a",id))).click();
    String firstname = wd.findElement(By.name("firstname")).getAttribute("value");
    String lastname = wd.findElement(By.name("lastname")).getAttribute("value");
    String home = wd.findElement(By.name("home")).getAttribute("value");
    String mobile = wd.findElement(By.name("mobile")).getAttribute("value");
    String work = wd.findElement(By.name("work")).getAttribute("value");
    String address = wd.findElement(By.name("address")).getAttribute("value");
    String email = wd.findElement(By.name("email")).getAttribute("value");
    String email2 = wd.findElement(By.name("email2")).getAttribute("value");
    String email3 = wd.findElement(By.name("email3")).getAttribute("value");
    wd.navigate().back();
    return new ContactData().withId(contact.getId()).withName(firstname).withLastName(lastname).withAddress(address)
            .withHomePhone(home).withMobile(mobile).withWorkPhone(work)
            .withEmail(email).withEmail2(email2).withEmail3(email3);
  }
}
