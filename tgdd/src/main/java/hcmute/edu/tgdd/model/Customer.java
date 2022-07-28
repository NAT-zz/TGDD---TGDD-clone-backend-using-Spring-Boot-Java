package hcmute.edu.tgdd.model;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Customer {
  @Id
  private String phone;
  private String fullName;
  private String address;
  private boolean gender;

  public String getPhone() {
    return phone;
  }

  public void setPhone(String phone) {
    this.phone = phone;
  }

  public String getFullName() {
    return fullName;
  }

  public void setFullName(String fullName) {
    this.fullName = fullName;
  }

  public String getAddress() {
    return address;
  }

  public void setAddress(String address) {
    this.address = address;
  }

  public boolean isGender() {
    return gender;
  }

  public void setGender(boolean gender) {
    this.gender = gender;
  }

  public Customer() {}

  public Customer(String phone, String fullName, String address, boolean gender) {
    this.phone = phone;
    this.fullName = fullName;
    this.address = address;
    this.gender = gender;
  }

  @Override
  public String toString() {
    return "Customer{"
        + "phone='"
        + phone
        + '\''
        + ", fullName='"
        + fullName
        + '\''
        + ", address='"
        + address
        + '\''
        + ", gender="
        + gender
        + '}';
  }
}
