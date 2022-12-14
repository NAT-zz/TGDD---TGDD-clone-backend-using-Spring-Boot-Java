package hcmute.edu.tgdd.repository;

import hcmute.edu.tgdd.model.Product;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ProductRepository extends JpaRepository<Product, Integer> {
  List<Product> findByName(String name);

  List<Product> findAllByKindId(Integer kindId, Pageable pageable);

  List<Product> findByKindIdAndCompanyId(Integer kindId, Integer companyId);
  
  List<Product> findByNameContainingIgnoreCase(String name);

  List<Product> findAllByDiscountGreaterThan(int discount);
}
