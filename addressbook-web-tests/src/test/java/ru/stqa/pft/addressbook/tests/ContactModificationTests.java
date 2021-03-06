package ru.stqa.pft.addressbook.tests;

import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.ContactData;

public class ContactModificationTests extends TestBase{
  @Test
  public void testContactModification(){
    app.getNavigationHelper().gotoHomePage();
    if (! app.getContactHelper().isThereAContact()){
      app.getContactHelper().createContact(new ContactData("Василий", "Репин", "Москва", "79112324433", "test@mail.ru"));
    }
    app.getContactHelper().modificationContact();
    app.getContactHelper().fillContactForm(new ContactData("Василий", "Репин", "Москва", "79112324433", "test@mail.ru"));
    app.getContactHelper().submitContactUpdate();
    app.getContactHelper().returnToHomePage();
  }
}
