package ru.stqa.pft.addressbook.model;

import java.util.Objects;

public class ContactData {
  private int id = Integer.MAX_VALUE;
  private String name;
  private String lastName;
  private String address;
  private String mobile;
  private String email;
  private String email2;
  private String email3;
  private String home;
  private String work;
  private String allPhones;
  private String allEmail;


  public int getId() {
    return id;
  }


  public String getName() {
    return name;
  }

  public String getLastName() {
    return lastName;
  }

  public String getAddress() {
    return address;
  }

  public String getMobile() {
    return mobile;
  }
  public String getWorkPhone() {
    return work;
  }

  public String getEmail() {
    return email;
  }
  public String getEmail2() {
    return email2;
  }
  public String getEmail3() {
    return email3;
  }
  public String getHomePhone() {
    return home;
  }
  public String getAllPhones() {
    return allPhones;
  }
  public String getAllEmail() {
    return allEmail;
  }
  public ContactData withId(int id) {
    this.id = id;
    return this;
  }

  public ContactData withName(String name) {
    this.name = name;
    return this;
  }

  public ContactData withLastName(String lastName) {
    this.lastName = lastName;
    return this;
  }
  public ContactData withHomePhone(String home) {
    this.home = home;
    return this;
  }
  public ContactData withMobile(String mobile) {
    this.mobile = mobile;
    return this;
  }
  public ContactData withWorkPhone(String work) {
    this.work = work;
    return this;
  }

  public ContactData withAddress(String address) {
    this.address = address;
    return this;
  }


  public ContactData withEmail(String email) {
    this.email = email;
    return this;
  }

  public ContactData withEmail2(String email2) {
    this.email2 = email2;
    return this;
  }

  public ContactData withEmail3(String email3) {
    this.email3 = email3;
    return this;
  }


  public ContactData withAllPhones(String allPhones) {
    this.allPhones = allPhones;
    return this;
  }
  public ContactData withAllEmail(String allEmail) {
    this.allEmail = allEmail;
    return this;
  }
  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;
    ContactData that = (ContactData) o;
    return id == that.id && Objects.equals(name, that.name) && Objects.equals(lastName, that.lastName);
  }

  @Override
  public int hashCode() {
    return Objects.hash(id, name, lastName);
  }

  @Override
  public String toString() {
    return "ContactData{" +
            "id='" + id + '\'' +
            ", name='" + name + '\'' +
            ", lastName='" + lastName + '\'' +
            '}';
  }

}
