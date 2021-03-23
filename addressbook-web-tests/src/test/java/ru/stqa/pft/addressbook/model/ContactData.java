package ru.stqa.pft.addressbook.model;

import java.util.Objects;

public class ContactData {
  private final String id;
  private final String name;
  private final String lastName;
  private final String address;
  private final String mobile;
  private final String email;



  public String getId() {
    return id;
  }

  public ContactData( String name, String lastName, String address, String mobile, String email) {
    this.id = null;
    this.name = name;
    this.lastName = lastName;
    this.address = address;
    this.mobile = mobile;
    this.email = email;

  }

  public ContactData(String id, String name, String lastName, String address, String mobile, String email) {
    this.id = id;
    this.name = name;
    this.lastName = lastName;
    this.address = address;
    this.mobile = mobile;
    this.email = email;

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

  public String getEmail() {
    return email;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;
    ContactData that = (ContactData) o;
    return Objects.equals(id, that.id) && Objects.equals(name, that.name) && Objects.equals(lastName, that.lastName);
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
