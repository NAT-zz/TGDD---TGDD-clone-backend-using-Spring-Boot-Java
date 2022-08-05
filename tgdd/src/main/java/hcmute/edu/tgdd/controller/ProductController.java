package hcmute.edu.tgdd.controller;

import hcmute.edu.tgdd.model.DataResponse;
import hcmute.edu.tgdd.model.Product;
import hcmute.edu.tgdd.model.ResponseObject;
import hcmute.edu.tgdd.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(path = "/api/Product")
public class ProductController {

    @Autowired
    private ProductService productService;


    @GetMapping("")
        //    List<Product> getAllProduct() { return productService.getAllProduct(); }
    DataResponse getAllProduct()
    {
        List<Product> listProduct = productService.getAllProduct();
        return new DataResponse(listProduct);
    }

    @GetMapping("/{id}")
    DataResponse findById(@PathVariable Integer id) {
        Optional<Product> foundProduct = productService.findById(id);
        if (foundProduct.isPresent())
            return new DataResponse(foundProduct);
        else
            throw new RuntimeException("Cannot find product with id = " + id);

    }
    @PostMapping("/insert")
    DataResponse insertProduct(@RequestBody Product product){
        List<Product> listProduct = productService.findByName(product.getName().trim());
        if(listProduct.size() > 0){
            throw new RuntimeException("Product name already taken ");
        }
        return new DataResponse(productService.save(product));
    }

    @PutMapping("/{id}")
    DataResponse updateProduct(@RequestBody Product newProduct, @PathVariable Integer id){
        Product updateProduct = productService.findById(id)
                .map(product -> {
                    product.setName(newProduct.getName());
                    product.setCompanyId(newProduct.getCompanyId());
                    product.setNationId(newProduct.getNationId());
                    product.setPrice(newProduct.getPrice());
                    product.setQuantity(newProduct.getQuantity());
                    product.setDiscount(newProduct.getDiscount());
                    product.setImages(newProduct.getImages());
                    product.setVideos(newProduct.getVideos());
                    product.setDescription(newProduct.getDescription());

                    return productService.save(product);
                }).orElseGet(() -> {
                    newProduct.setId(id);
                    return productService.save(newProduct);
                });
        return new DataResponse(updateProduct);
    }
    @DeleteMapping("/{id}")
    DataResponse deleteProduct(@PathVariable Integer id){
        boolean exists = productService.existsById(id);
        if (exists) {
            productService.deleteById(id);
            return new DataResponse("");

        }
        throw new RuntimeException("Cannot find product to delete");
    }

}
