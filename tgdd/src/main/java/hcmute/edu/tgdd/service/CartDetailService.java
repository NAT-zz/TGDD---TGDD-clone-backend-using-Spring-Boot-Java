package hcmute.edu.tgdd.service;

import hcmute.edu.tgdd.model.CartDetail;

import java.util.List;
import java.util.Optional;

public interface CartDetailService {
	List<CartDetail> getAllCartDetail();

	Optional<CartDetail> findById(Integer id);

	Optional<CartDetail> findByProductIdAndCartId(int productId, int cartId);

	List<CartDetail> findByCartId(int id);

	CartDetail insertCartDetail(String customerPhone, CartDetail newCartDetail);

	CartDetail updateCartDetail(CartDetail newCartDetail, Integer id);

	boolean existsById(Integer id);

	void deleteCartDetail(Integer id);
}
