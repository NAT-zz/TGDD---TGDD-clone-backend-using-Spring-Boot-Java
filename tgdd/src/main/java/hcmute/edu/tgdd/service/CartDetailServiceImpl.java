package hcmute.edu.tgdd.service;

import hcmute.edu.tgdd.model.CartDetail;
import hcmute.edu.tgdd.repository.CartDetailRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CartDetailServiceImpl implements CartDetailService{
	@Autowired
	private CartDetailRepository cartDetailRepository;

	@Override
	public List<CartDetail> getAllCartDetail() {
		return cartDetailRepository.findAll();
	}

	@Override
	public Optional<CartDetail> findById(Integer id) {
		return cartDetailRepository.findById(id);
	}

	@Override
	public CartDetail insertCartDetail(CartDetail newCartDetail) {
		return cartDetailRepository.save(newCartDetail);
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
