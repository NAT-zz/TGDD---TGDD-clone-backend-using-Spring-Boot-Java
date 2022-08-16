package hcmute.edu.tgdd.repository;

import hcmute.edu.tgdd.model.CartDetail;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface CartDetailRepository extends JpaRepository<CartDetail, Integer> {
	List<CartDetail> findByCartId(int cartId);
	Optional<CartDetail> findByProductIdAndCartId(int productId, int cartId);
}
