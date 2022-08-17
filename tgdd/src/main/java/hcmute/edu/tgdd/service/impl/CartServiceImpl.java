package hcmute.edu.tgdd.service.impl;

import hcmute.edu.tgdd.model.Cart;
import hcmute.edu.tgdd.repository.CartRepository;
import hcmute.edu.tgdd.repository.StatusRepository;
import hcmute.edu.tgdd.service.CartService;
import hcmute.edu.tgdd.service.StatusService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.lang.StackWalker.Option;
import java.util.List;
import java.util.Optional;

@Service
public class CartServiceImpl implements CartService {
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
	public List<Cart> findByCustomerPhoneAndStatusId(String customerPhone, int statusId) {
		return cartRepository.findByCustomerPhoneAndStatusId(customerPhone, statusId);
	}

	@Override
	public List<Cart> getCart(String customerPhone) {
		return cartRepository.findByCustomerPhoneAndStatusId(customerPhone, 1);
	}

	@Override
	public List<Cart> getOrderHistory(String customerPhone) {
		List<Cart> carts = cartRepository.findByCustomerPhone(customerPhone);
		for(int i = 0; i < carts.size(); i++) {
			if(carts.get(i).getStatusId() == 1) {
				carts.remove(i);
				i--;
			}
		}
		return carts;
	}

	@Override
	public Cart insertCart(Cart newCart) {
		newCart.setStatusId(1);
		return cartRepository.save(newCart);
	}

	@Override
	public Optional<Cart> order(String customerPhone) {
		List<Cart> carts = cartRepository.findByCustomerPhoneAndStatusId(customerPhone, 1);
		return cartRepository.findById(carts.get(0).getId())
				.map(cart -> {
					cart.setStatusId(2);
					return cartRepository.save(cart);
				});
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
					newCart.setStatusId(1);
					return cartRepository.save(newCart);
				});
	}

	@Override
	public boolean existsById(Integer id) {
		return cartRepository.existsById(id);
	}

	@Override
	public void deleteCart(Integer id) {
		cartRepository.deleteById(id);
	}

	@Override
	public Optional<Cart> updateCartStatus(Integer cartId, Integer status) {
		return findById(cartId).map(Cart -> {
			Cart.setStatusId(status);
			return Cart;
		});
	}
}
