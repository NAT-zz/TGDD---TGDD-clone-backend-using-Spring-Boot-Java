package hcmute.edu.tgdd.service;

import hcmute.edu.tgdd.model.Product;
import hcmute.edu.tgdd.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.criteria.CriteriaBuilder;
import java.util.List;
import java.util.Optional;

@Service
public class ProductService {
    @Autowired
    private ProductRepository productRepository;

    public ProductService() {
    }

    public ProductRepository getProductRepository() {
        return productRepository;
    }

    public void setProductRepository(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    public List<Product> getAllProduct() {
        return productRepository.findAll();
    }
    public Optional<Product> findById(Integer id){
        return productRepository.findById(id);
    }
    public List<Product> findByName(String name)
    {
        return productRepository.findByName(name);
    }
    public Product save(Product product){
        return productRepository.save(product);
    }
    public boolean existsById(Integer id){
        return productRepository.existsById(id);
    }
    public void deleteById(Integer id){
        productRepository.deleteById(id);
    }

}
