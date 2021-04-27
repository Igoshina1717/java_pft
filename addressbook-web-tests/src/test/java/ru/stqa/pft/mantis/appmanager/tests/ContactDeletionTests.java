package ru.stqa.pft.mantis.appmanager.tests;


import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import ru.stqa.pft.mantis.appmanager.model.ContactData;
import ru.stqa.pft.mantis.appmanager.model.Contacts;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;


public class ContactDeletionTests extends TestBase {

  @BeforeMethod
  public void ensurePreconditions(){
    app.goTo().HomePage();
    if ( app.db().contacts().size() == 0){
      app.contact().create(new ContactData().withName("Иван").withLastName("Иванов").withAddress("Москва").withMobile("79995553535").withEmail("test@mail.ru"));
    }
  }


  @Test
  public void testGroupDeletion() {
    Contacts before = app.db().contacts();
    ContactData deletedContact = before.iterator().next();
    app.contact().delete(deletedContact);
    assertThat(app.contact().count(), equalTo(before.size()-1));
    Contacts after = app.db().contacts();
    assertThat(after, equalTo(before.without(deletedContact)));
    verifyContactListInUI();

  }

}
