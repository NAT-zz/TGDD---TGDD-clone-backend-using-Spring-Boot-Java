package hcmute.edu.tgdd.service;

import hcmute.edu.tgdd.model.CartDetail;

import java.util.List;
import java.util.Optional;

public interface CartDetailService {
	public List<CartDetail> getAllCartDetail();
	public Optional<CartDetail> findById(Integer id);
	public CartDetail insertCartDetail(CartDetail newCartDetail);
	public CartDetail updateCartDetail(CartDetail newCartDetail, Integer id);
	public boolean existsById(Integer id);
	public void deleteCartDetail(Integer id);
}
