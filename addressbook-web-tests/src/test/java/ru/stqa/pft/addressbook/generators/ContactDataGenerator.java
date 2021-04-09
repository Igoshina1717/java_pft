package ru.stqa.pft.addressbook.generators;

import com.beust.jcommander.JCommander;
import com.beust.jcommander.Parameter;
import com.beust.jcommander.ParameterException;
import ru.stqa.pft.addressbook.model.ContactData;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;
import java.util.ArrayList;
import java.util.List;


public class ContactDataGenerator {


  public static void main(String[] args) throws IOException {
    int count = Integer.parseInt(args[0]);
    File file = new File(args[1]);

    List<ContactData> contacts = generateContacts(count);
    save(contacts, file);

  }

  private static void save(List<ContactData> contacts, File file) throws IOException {
    Writer writer = new FileWriter(file);
    for (ContactData contact : contacts){
      writer.write(String.format("%s;%s;%s;%s;%s;%s\n",
              contact.getName(),contact.getLastName(),contact.getAddress()
              ,contact.getMobile(), contact.getEmail(), contact.getPhoto()));
    }
    writer.close();
  }

  private static List<ContactData> generateContacts(int count) {
    List<ContactData> contacts = new ArrayList<ContactData>();
    for (int i = 0; i< count; i++){
    contacts.add(new ContactData()
            .withName(String.format("name %s", i))
            .withLastName(String.format("lastName %s", i))
            .withAddress(String.format("address %s", i))
            .withMobile(String.format("mobile %s", i))
            .withEmail(String.format("mail %s", i))
            .withPhoto(new File("src/test/resources/stru.png")));

  }
    return contacts;
}
}
