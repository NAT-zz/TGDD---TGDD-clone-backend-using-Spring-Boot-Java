package hcmute.edu.tgdd.service;

import hcmute.edu.tgdd.model.Product;

import java.util.List;
import java.util.Optional;

public interface ProductService {
	public List<Product> getAllProduct(Integer pageNo, Integer pageSize, String sortBy);
	public Optional<Product> findById(Integer id);
	public List<Product> findByName(String name);
	public Product save(Product product);
	public boolean existsById(Integer id);
	public void deleteById(Integer id);
}
