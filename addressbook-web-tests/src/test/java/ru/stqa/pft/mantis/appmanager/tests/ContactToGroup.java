package ru.stqa.pft.mantis.appmanager.tests;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import ru.stqa.pft.mantis.appmanager.model.ContactData;
import ru.stqa.pft.mantis.appmanager.model.Contacts;
import ru.stqa.pft.mantis.appmanager.model.GroupData;
import ru.stqa.pft.mantis.appmanager.model.Groups;

import java.util.Collection;
import java.util.HashSet;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

public class ContactToGroup extends TestBase{
  @BeforeMethod

  public void ensurePreconditions() {

    if (app.db().groups().size() == 0) {
      app.goTo().GroupPage();
      app.group().create(new GroupData()
              .withName("name")
              .withFooter("footer"));
    }
    app.goTo().HomePage();
      if ( app.db().contacts().size() == 0){
        app.contact().create(new ContactData()
                .withName("Иван")
                .withLastName("Иванов")
                .withAddress("Москва").withMobile("79995553535").withEmail("test@mail.ru"));
      }
    }



  @Test
  public void testContactToGroup() {

    app.goTo().HomePage();
    ContactData addContact = selectContact();
    GroupData groupToAddTo = selectGroup(addContact);
    Groups before = addContact.getGroups();
    app.goTo().HomePage();
    app.contact().addContactToGroup(addContact, groupToAddTo);
    app.goTo().HomePage();
    ContactData addUserAfter = selectUserById(addContact);
    Groups after = addUserAfter.getGroups();
    assertThat(after, equalTo(before.withAdded(groupToAddTo)));
  }

  private ContactData selectUserById(ContactData addContact) {
    Contacts usersById = app.db().contacts();
    return usersById.iterator().next().withId(addContact.getId());

  }

  private GroupData selectGroup(ContactData contact) {
    Groups allGroups = app.db().groups();
    Groups usersInGroups = contact.getGroups();

    Collection<GroupData> userGroups = new HashSet<>(usersInGroups);
    Collection<GroupData> availableGroups = new HashSet<>(allGroups);
    availableGroups.removeAll(userGroups);
    return availableGroups.iterator().next();
  }


  private ContactData selectContact() {

    Contacts allUsers = app.db().contacts();
    Groups allGroups = app.db().groups();
    for (ContactData contact : allUsers) {
      if (contact.getGroups().size() < allGroups.size()) {
        return contact;
      }
    }
    app.goTo().GroupPage();
    app.group().create(new GroupData().withName("group").withHeader("header"));
    return allUsers.iterator().next();
  }


}