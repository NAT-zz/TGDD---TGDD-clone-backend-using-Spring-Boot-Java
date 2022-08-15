package hcmute.edu.tgdd.model;

import javax.persistence.*;

@Entity
public class Video {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private int id;
  @Column(nullable = false)
  private String url;
  @Column(nullable = false)
  private int productId;

  public Video() {
  }

  public Video(String url, int productId) {
    this.url = url;
    this.productId = productId;
  }

  public int getId() {
    return id;
  }

  public void setId(int id) {
    this.id = id;
  }

  public String getUrl() {
    return url;
  }

  public void setUrl(String url) {
    this.url = url;
  }

  public int getProductId() {
    return productId;
  }

  public void setProductId(int productId) {
    this.productId = productId;
  }

  @Override
  public String toString() {
    return "Video{" +
        "id=" + id +
        ", url='" + url + '\'' +
        ", productId=" + productId +
        '}';
  }
}
