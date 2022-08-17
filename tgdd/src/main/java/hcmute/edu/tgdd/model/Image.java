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
  @Column
  private int productId;
  @Column
  private int commentId;

  public Image() {
  }

  public Image(String filePath, String url, int productId, int commentId) {
    this.filePath = filePath;
    this.url = url;
    this.productId = productId;
    this.commentId = commentId;
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

  public int getCommentId() {
    return commentId;
  }

  public void setCommentId(int commentId) {
    this.commentId = commentId;
  }

  @Override
  public String toString() {
    return "Image{" +
        "id=" + id +
        ", filePath='" + filePath + '\'' +
        ", url='" + url + '\'' +
        ", productId=" + productId + '\'' +
        ", commentId=" + commentId +
        '}';
  }
}
