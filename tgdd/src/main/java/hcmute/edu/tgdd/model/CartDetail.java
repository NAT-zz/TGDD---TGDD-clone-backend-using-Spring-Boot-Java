package hcmute.edu.tgdd.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class CartDetail {
  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  private int id;

  private int productId;
  private int quantity;
  private int cartId;

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

  public int getQuantity() {
    return quantity;
  }

  public void setQuantity(int quantity) {
    this.quantity = quantity;
  }

  public int getCartId() {
    return cartId;
  }

  public void setCartId(int cartId) {
    this.cartId = cartId;
  }

  public CartDetail() {}

  public CartDetail(int productId, int quantity, int cartId) {
    this.productId = productId;
    this.quantity = quantity;
    this.cartId = cartId;
  }

  @Override
  public String toString() {
    return "CartDetail{"
        + "id="
        + id
        + ", productId="
        + productId
        + ", quantity="
        + quantity
        + ", cartId="
        + cartId
        + '}';
  }
}
