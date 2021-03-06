package ru.stqa.pft.addressbook;

public class ContactData {
  private final String name;
  private final String lastName;
  private final String address;
  private final String mobile;
  private final String email;

  public ContactData(String name, String lastName, String address, String mobile, String email) {
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
}
