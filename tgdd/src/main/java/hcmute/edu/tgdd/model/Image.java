package hcmute.edu.tgdd.model;

import javax.persistence.*;

@Entity
public class Image {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private int id;
  @Column(nullable = false, length = 120, unique = true)
  private String filePath;
  @Column(nullable = false)
  private String url;
  @Column(nullable = false)
  private int productId;

  public Image() {
  }

  public Image(String filePath, String url, int productId) {
    this.filePath = filePath;
    this.url = url;
    this.productId = productId;
  }

  public int getId() {
    return id;
  }

  public void setId(int id) {
    this.id = id;
  }

  public String getFilePath() {
    return filePath;
  }

  public void setFilePath(String filePath) {
    this.filePath = filePath;
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
    return "Image{" +
        "id=" + id +
        ", filePath='" + filePath + '\'' +
        ", url='" + url + '\'' +
        ", productId=" + productId +
        '}';
  }
}
