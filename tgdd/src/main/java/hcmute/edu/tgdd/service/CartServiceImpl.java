package hcmute.edu.tgdd.service;

import hcmute.edu.tgdd.model.Cart;
import hcmute.edu.tgdd.repository.CartRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CartServiceImpl implements CartService{
	@Autowired
	private CartRepository cartRepository;

	@Override
	public List<Cart> getAllCart() {
		return cartRepository.findAll();
	}

	@Override
	public Optional<Cart> findById(Integer id) {
		return cartRepository.findById(id);
	}

	@Override
	public Cart insertCart(Cart newCart) {
		newCart.setStatusId(0);
		return cartRepository.save(newCart);
	}

	@Override
	public Cart updateCart(Cart newCart, Integer id) {
		return cartRepository.findById(id)
				.map(Cart -> {
					Cart.setCustomerPhone(newCart.getCustomerPhone());
					Cart.setRequest(newCart.getRequest());
					Cart.setCoupon(newCart.getCoupon());
					Cart.setStatusId(newCart.getStatusId());
					return cartRepository.save(Cart);
				}).orElseGet(() -> {
					newCart.setStatusId(0);
					return cartRepository.save(newCart);
				});
	}

	@Override
	public boolean existsById(Integer id) {
		return cartRepository.existsById(id);
	}

	@Override
	public void deleteCart(Integer id) {
		cartRepository.deleteById(id);;
	}
}
