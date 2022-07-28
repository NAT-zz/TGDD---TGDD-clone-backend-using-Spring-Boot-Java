package hcmute.edu.tgdd.repository;

import hcmute.edu.tgdd.model.Cart;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Date;
import java.util.List;

public interface CartRepository extends JpaRepository<Cart, Integer> {
	List<Cart> findByCustomerPhone(String customerPhone);
	List<Cart> findByDate(Date date);
	List<Cart> findByStatusId(int statusId);
}
