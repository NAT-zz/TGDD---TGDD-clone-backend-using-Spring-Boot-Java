package hcmute.edu.tgdd.service.impl;

import hcmute.edu.tgdd.model.Cart;
import hcmute.edu.tgdd.model.CartDetail;
import hcmute.edu.tgdd.repository.CartDetailRepository;
import hcmute.edu.tgdd.service.CartDetailService;
import hcmute.edu.tgdd.service.CartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CartDetailServiceImpl implements CartDetailService {
	@Autowired
	private CartDetailRepository cartDetailRepository;
	@Autowired
	private CartService cartService;

	@Override
	public List<CartDetail> getAllCartDetail() {
		return cartDetailRepository.findAll();
	}

	@Override
	public Optional<CartDetail> findById(Integer id) {
		return cartDetailRepository.findById(id);
	}

	@Override
	public Optional<CartDetail> findByProductIdAndCartId(int productId, int cartId) {
		return cartDetailRepository.findByProductIdAndCartId(productId,cartId);
	}

	@Override
	public List<CartDetail> findByCartId(int id) {
		return cartDetailRepository.findByCartId(id);
	}

	@Override
	public CartDetail insertCartDetail(String customerPhone, CartDetail newCartDetail) {
		List<Cart> carts = cartService.findByCustomerPhoneAndStatusId(customerPhone, 1);
		newCartDetail.setCartId(carts.get(0).getId());
		return findByProductIdAndCartId(newCartDetail.getProductId(), newCartDetail.getCartId())
				.map(cartDetail -> {
					cartDetail.setQuantity(cartDetail.getQuantity() + newCartDetail.getQuantity());
					return cartDetailRepository.save(cartDetail);
				})
				.orElseGet(() -> cartDetailRepository.save(newCartDetail));
	}

	@Override
	public CartDetail updateCartDetail(CartDetail newCartDetail, Integer id) {
		return cartDetailRepository.findById(id)
				.map(CartDetail -> {
					CartDetail.setProductId(newCartDetail.getProductId());
					CartDetail.setQuantity(newCartDetail.getQuantity());
					CartDetail.setCartId(newCartDetail.getCartId());
					return cartDetailRepository.save(CartDetail);
				}).orElseGet(() -> {
					newCartDetail.setId(id);
					return cartDetailRepository.save(newCartDetail);
				});
	}

	@Override
	public boolean existsById(Integer id) {
		return cartDetailRepository.existsById(id);
	}

	@Override
	public void deleteCartDetail(Integer id) {
		cartDetailRepository.deleteById(id);;
	}
}
