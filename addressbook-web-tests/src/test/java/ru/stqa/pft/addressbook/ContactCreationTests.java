package ru.stqa.pft.addressbook;

import org.testng.annotations.Test;

public class ContactCreationTests extends TestBase{

  @Test
  public void testContactCreation() throws Exception {
    gotoAddNewPage();
    fillContactForm(new ContactData("Василий", "Репин", "Москва", "79112324433", "test@mail.ru"));
    submitContactCreation();
    returnToHomePage();
  }

}
