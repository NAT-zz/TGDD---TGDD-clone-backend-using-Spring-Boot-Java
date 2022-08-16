package hcmute.edu.tgdd.model;

import hcmute.edu.tgdd.utils.Validate;

import javax.persistence.*;

@Entity
public class Comment {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private int id;
  private int productId;
  private String phoneUser;
  @Column(nullable = false, length = 1000)
  private String review;
  @Column(nullable = false,length = 1)
  private int rate;
  private String image;

  public Comment() {
  }

  public Comment(int productId, String phoneUser, String review, int rate, String image) {
    this.productId = productId;
    this.phoneUser = phoneUser;
    this.review = review;
    this.rate = rate;
    this.image = image;
  }

  public int getId() {
    return id;
  }

  public void setId(int id) {
    this.id = id;
  }

  public int getProductId() {
    return productId;
  }

  public void setProductId(int productId) {
    this.productId = productId;
  }

  public String getPhoneUser() {
    return phoneUser;
  }

  public void setPhoneUser(String phoneUser) {
    if (Validate.isWhatever(Validate.Type.PHONE, phoneUser))
      this.phoneUser = phoneUser;
    else
      throw new RuntimeException("Incorrect phone format");
  }

  public String getReview() {
    return review;
  }

  public void setReview(String review) {
    this.review = review;
  }

  public int getRate() {
    return rate;
  }

  public void setRate(int rate) {
    this.rate = rate;
  }

  public String getImage() {
    return image;
  }

  public void setImage(String image) {
    this.image = image;
  }

  @Override
  public String toString() {
    return "Comment{" +
        "id=" + id +
        ", productId=" + productId +
        ", phoneUser='" + phoneUser + '\'' +
        ", rate=" + rate +
        ", image='" + image + '\'' +
        '}';
  }
}
