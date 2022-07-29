package hcmute.edu.tgdd.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class History {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private int id;

  private int cartId;

  public History() {}

  public History(int cartId) {
    this.cartId = cartId;
  }

  public int getId() {
    return id;
  }

  public void setId(int id) {
    this.id = id;
  }

  public int getCartId() {
    return cartId;
  }

  public void setCartId(int cartId) {
    this.cartId = cartId;
  }

  @Override
  public String toString() {
    return "History{" + "id=" + id + ", cartId=" + cartId + '}';
  }
}
