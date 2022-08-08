package hcmute.edu.tgdd.service.impl;

import hcmute.edu.tgdd.model.Product;
import hcmute.edu.tgdd.repository.ProductRepository;
import hcmute.edu.tgdd.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProductServiceImpl implements ProductService {
    @Autowired
    private ProductRepository productRepository;

    @Override
    public List<Product> getAllProduct(Integer pageNo, Integer pageSize, String sortBy) {
        Pageable paging = PageRequest.of(pageNo, pageSize, Sort.by(sortBy));
        Page<Product> pagedResult = productRepository.findAll(paging);
        return pagedResult.getContent();
    }

    @Override
    public Optional<Product> findById(Integer id){
        return productRepository.findById(id);
    }

    @Override
    public List<Product> findByName(String name)
    {
        return productRepository.findByName(name);
    }

    @Override
    public Product save(Product product){
        return productRepository.save(product);
    }

    @Override
    public boolean existsById(Integer id){
        return productRepository.existsById(id);
    }

    @Override
    public void deleteById(Integer id){
        productRepository.deleteById(id);
    }
}
