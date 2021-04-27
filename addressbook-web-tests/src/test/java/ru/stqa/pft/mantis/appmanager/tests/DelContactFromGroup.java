package ru.stqa.pft.mantis.appmanager.tests;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import ru.stqa.pft.mantis.appmanager.model.ContactData;
import ru.stqa.pft.mantis.appmanager.model.Contacts;
import ru.stqa.pft.mantis.appmanager.model.GroupData;
import ru.stqa.pft.mantis.appmanager.model.Groups;

import java.io.File;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

public class DelContactFromGroup extends TestBase{

  @BeforeMethod

  public void ensurePreconditions() {

    if (app.db().groups().size() == 0) {
      app.goTo().GroupPage();
      app.group().create(new GroupData()
              .withName("name")
              .withFooter("footer"));
    }
    app.goTo().HomePage();

    if (app.db().contacts().size() == 0) {
      app.contact().create(new ContactData()
              .withName("name")
              .withLastName("lastname")
              .withAddress("address")
              .withMobile("mobile")
              .withEmail("mail")
              .withPhoto(new File("src/test/resources/stru.png")));

    }
  }


  @Test
  public void testContactDelFromGroup() {

    app.goTo().HomePage();
    ContactData contact = selectContact();
    GroupData groupToDelFrom = selectGroup(contact);
    Groups before = contact.getGroups();
    app.goTo().HomePage();
    app.contact().selectGroupFromList(groupToDelFrom.getId());
    app.contact().delContactFromGroup(contact, groupToDelFrom);
    ContactData contactsAfter = selectContactById(contact);
    Groups after = contactsAfter.getGroups();
    assertThat(after, equalTo(before.without(groupToDelFrom)));
  }

  private ContactData selectContactById(ContactData contact) {
    Contacts contactsById = app.db().contacts();
    return contactsById.iterator().next().withId(contact.getId());
  }


  private GroupData selectGroup(ContactData delContact) {

    ContactData contact= selectContactById(delContact);
    Groups userToBeRemoved = contact.getGroups();
    return userToBeRemoved.iterator().next();

  }


  private ContactData selectContact() {
    Contacts allContacts = app.db().contacts();
    for (ContactData contact : allContacts) {
      if (contact.getGroups().size() > 0) {
        return contact;
      }
    }

    ContactData addContact = app.db().contacts().iterator().next();
    app.contact().addContactToGroup(addContact, app.db().groups().iterator().next());
    return addContact;
  }



}
