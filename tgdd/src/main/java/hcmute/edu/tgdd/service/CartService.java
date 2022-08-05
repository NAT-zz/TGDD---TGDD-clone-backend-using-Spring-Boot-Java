package hcmute.edu.tgdd.service;

import hcmute.edu.tgdd.model.Cart;

import java.util.List;
import java.util.Optional;

public interface CartService {
	public List<Cart> getAllCart();
	public Optional<Cart> findById(Integer id);
	public Cart insertCart(Cart newCart);
	public Cart updateCart(Cart newCart, Integer id);
	public boolean existsById(Integer id);
	public void deleteCart(Integer id);
}