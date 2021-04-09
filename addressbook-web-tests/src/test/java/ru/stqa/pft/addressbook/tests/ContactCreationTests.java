package ru.stqa.pft.addressbook.tests;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.ContactData;
import ru.stqa.pft.addressbook.model.Contacts;

import java.io.File;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.*;

public class ContactCreationTests extends TestBase{
  @DataProvider
  public Iterator<Object[]> validContacts() {
    List<Object[]> list = new ArrayList<Object[]>();
    list.add(new Object[]{new ContactData().withName("name1").withLastName("lastname1")
            .withAddress("address1").withMobile("mobile1")
            .withEmail("mail1").withPhoto(new File("src\\test\\resources\\stru.png"))});
    list.add(new Object[]{new ContactData().withName("name2").withLastName("lastname2")
            .withAddress("address2").withMobile("mobile2")
            .withEmail("mail2").withPhoto(new File("src\\test\\resources\\stru.png"))});
    list.add(new Object[]{new ContactData().withName("name3").withLastName("lastname3")
            .withAddress("address3").withMobile("mobile3")
            .withEmail("mail3").withPhoto(new File("src\\test\\resources\\stru.png"))});

    return list.iterator();
  }

  @Test(dataProvider = "validContacts")
  public void testContactCreation(ContactData contact) throws Exception {
    String[] names = new String[] {"test", "test2", "test3"};
      app.goTo().HomePage();
      Contacts before = app.contact().all();
      app.contact().create(contact);
      Contacts after = app.contact().all();
      assertThat(app.contact().count(), equalTo(before.size()+1));
      assertThat(after, equalTo(
              before.withAdded(contact.withId(after.stream().mapToInt((c) -> c.getId()).max().getAsInt()))));
    }

  @Test (enabled = false)
  public void testBadContactCreation() throws Exception {
    app.goTo().HomePage();
    Contacts before = app.contact().all();
    ContactData contact = new ContactData().withName("Иван'").withLastName("Иванов").withAddress("Москва").withMobile("79995553535").withEmail("test@mail.ru");
    app.contact().create(contact);
    assertThat(app.contact().count(), equalTo(before.size()));
    Contacts after = app.contact().all();
    assertThat(after, equalTo(before));
  }
  @Test
  public void testCurrentDir(){
    File currentDir = new File(".");
    System.out.println(currentDir.getAbsolutePath());
    File photo = new File("src\\test\\resources\\stru.png");
    System.out.println(photo.getAbsolutePath());
    System.out.println(photo.exists());
  }
}
