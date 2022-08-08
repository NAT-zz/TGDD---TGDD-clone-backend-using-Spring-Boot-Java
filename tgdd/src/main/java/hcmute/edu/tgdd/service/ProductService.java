package hcmute.edu.tgdd.service;

import hcmute.edu.tgdd.model.Product;

import java.util.List;
import java.util.Optional;

public interface ProductService {
  List<Product> getAllProduct(Integer pageNo, Integer pageSize, String sortBy);

  Optional<Product> findById(Integer id);

  List<Product> findByName(String name);

  Product save(Product product);

  boolean existsById(Integer id);

  void deleteById(Integer id);
}
