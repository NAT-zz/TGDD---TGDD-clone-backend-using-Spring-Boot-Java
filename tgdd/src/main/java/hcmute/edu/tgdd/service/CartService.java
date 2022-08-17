package hcmute.edu.tgdd.service;

import hcmute.edu.tgdd.model.Cart;

import java.util.List;
import java.util.Optional;

public interface CartService {
	List<Cart> getAllCart();

	Optional<Cart> findById(Integer id);

  List<Cart> findByCustomerPhoneAndStatusId(String customerPhone, int statusId);

  List<Cart> getCart(String customerPhone);

	List<Cart> getOrderHistory(String customerPhone);

	Cart insertCart(Cart newCart);

  Optional<Cart> order(String customerPhone);

  Cart updateCart(Cart newCart, Integer id);

  Optional<Cart> updateCartStatus(Integer cartId, Integer status);

	boolean existsById(Integer id);

	void deleteCart(Integer id);
}
