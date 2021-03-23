package ru.stqa.pft.addressbook.model;

import java.util.Objects;

public class ContactData {
  private int id;

  public void setId(int id) {
    this.id = id;
  }

  private final String name;
  private final String lastName;
  private final String address;
  private final String mobile;
  private final String email;



  public int getId() {
    return id;
  }



  public ContactData(String name, String lastName, String address, String mobile, String email) {
    this.id = 0;
    this.name = name;
    this.lastName = lastName;
    this.address = address;
    this.mobile = mobile;
    this.email = email;

  }

  public ContactData(int id, String name, String lastName, String address, String mobile, String email) {
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
  public String toString() {
    return "ContactData{" +
            "id='" + id + '\'' +
            ", name='" + name + '\'' +
            ", lastName='" + lastName + '\'' +
            '}';
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
}
