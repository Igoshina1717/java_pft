package tests;

import org.testng.annotations.Test;
import model.ContactData;

public class ContactCreationTests extends TestBase{

  @Test
  public void testContactCreation() throws Exception {
    app.gotoAddNewPage();
    app.fillContactForm(new ContactData("Василий", "Репин", "Москва", "79112324433", "test@mail.ru"));
    app.submitContactCreation();
    app.returnToHomePage();
  }

}
