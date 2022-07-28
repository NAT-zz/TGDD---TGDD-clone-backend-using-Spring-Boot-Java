package hcmute.edu.tgdd.controller;

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
    ResponseObject getAllProduct()
    {
        List<Product> listProduct = productService.getAllProduct();
        return new ResponseObject("0k","Get all product successfully",listProduct);
    }

    @GetMapping("/{id}")
    ResponseObject findById(@PathVariable Integer id){
        Optional<Product> foundProduct = productService.findById(id);
        return foundProduct.isPresent() ?
                new ResponseObject("Ok","Query product successfully",foundProduct):
                new ResponseObject("Failed","Cannot find product with id = "+id,"");

    }
    @PostMapping("/insert")
    ResponseObject insertProduct(@RequestBody Product product){
        List<Product> listProduct = productService.findByName(product.getName().trim());
        if(listProduct.size() > 0){
            return new ResponseObject("Failed","Product name already taken ","");
        }
        return new ResponseObject("Ok","Insert product successfully",productService.save(product));
    }

    @PutMapping("/{id}")
    ResponseObject updateProduct(@RequestBody Product newProduct, @PathVariable Integer id){
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
        return new ResponseObject("Ok","Update product successfully",updateProduct);
    }
    @DeleteMapping("/{id}")
    ResponseObject deleteProduct(@PathVariable Integer id){
        boolean exists = productService.existsById(id);
        if (exists) {
            productService.deleteById(id);
            return new ResponseObject("Ok","Delete Product successfully","");

        }
        return new ResponseObject("Failed","Cannot find product to delete","");
    }

}
