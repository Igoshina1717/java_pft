package ru.stqa.pft.mantis.appmanager.appmanager;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import ru.stqa.pft.mantis.appmanager.model.ContactData;
import ru.stqa.pft.mantis.appmanager.model.Contacts;
import ru.stqa.pft.mantis.appmanager.model.GroupData;
import ru.stqa.pft.mantis.appmanager.model.Groups;

import java.util.List;

public class DbHelper {
  private final SessionFactory sessionFactory;

  public DbHelper(){
    // A SessionFactory is set up once for an application!
    final StandardServiceRegistry registry = new StandardServiceRegistryBuilder()
            .configure() // configures settings from hibernate.cfg.xml
            .build();

      sessionFactory = new MetadataSources( registry ).buildMetadata().buildSessionFactory();
  }
  public Groups groups(){
    Session session = sessionFactory.openSession();
    session.beginTransaction();
    List<GroupData> result = session.createQuery("from GroupData where deprecated = '0000-00-00'").list();
    session.getTransaction().commit();
    session.close();
    return new Groups(result);

  }
  public Contacts contacts() {
    Session session = sessionFactory.openSession();
    session.beginTransaction();
    List<ContactData> result = session.createQuery("from ContactData where deprecated = '0000-00-00'").list();
    session.getTransaction().commit();
    session.close();
    return new Contacts(result);
  }

  private ContactData selectContactById(int contactId) {
    Session session = sessionFactory.openSession();
    session.beginTransaction();
    ContactData contact = (ContactData) session.createQuery( "from UserData where id="+contactId ).getSingleResult();
    session.getTransaction().commit();
    session.close();
    return contact;
  }
}
