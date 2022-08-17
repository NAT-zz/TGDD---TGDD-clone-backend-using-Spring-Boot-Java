package hcmute.edu.tgdd.service;

import hcmute.edu.tgdd.model.Cart;

import java.util.List;
import java.util.Optional;

public interface CartService {
	public List<Cart> getAllCart();
	public Optional<Cart> findById(Integer id);

  List<Cart> findByCustomerPhoneAndStatusId(String customerPhone, int statusId);

  List<Cart> getCart(String customerPhone);

	List<Cart> getOrderHistory(String customerPhone);

	public Cart insertCart(Cart newCart);

  Optional<Cart> order(String customerPhone);

  public Cart updateCart(Cart newCart, Integer id);
  Optional<Cart> updateCartStatus(Integer cartId, Integer status);
  
	public boolean existsById(Integer id);
	public void deleteCart(Integer id);
}
