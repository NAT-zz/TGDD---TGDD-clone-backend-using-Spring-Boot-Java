package hcmute.edu.tgdd.controller;

import hcmute.edu.tgdd.dto.LaptopDTO;
import hcmute.edu.tgdd.dto.PhoneDTO;
import hcmute.edu.tgdd.dto.SmartWatchDTO;
import hcmute.edu.tgdd.dto.TabletDTO;
import hcmute.edu.tgdd.model.DataResponse;
import hcmute.edu.tgdd.model.Product;
import hcmute.edu.tgdd.model.Video;
import hcmute.edu.tgdd.service.impl.ProductServiceImpl;
import hcmute.edu.tgdd.service.impl.StorageServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(path = "/api/Product")
public class ProductController {
  @Autowired
  private ProductServiceImpl productService;
  @Autowired
  private StorageServiceImpl storageService;

  @GetMapping("")
  DataResponse getAllProduct(
      @RequestParam(defaultValue = "0") Integer pageNo,
      @RequestParam(defaultValue = "10") Integer pageSize,
      @RequestParam(defaultValue = "id") String sortBy) {
    List<Product> listProduct = productService.getAllProduct(pageNo, pageSize, sortBy);
    return new DataResponse(listProduct);
  }

  @GetMapping("/{id}")
  DataResponse findById(@PathVariable Integer id) {
    Optional<Product> foundProduct = productService.findById(id);
    if (foundProduct.isPresent()) return new DataResponse(foundProduct);
    else throw new RuntimeException("Cannot find product with id = " + id);
  }

  @PostMapping("/insert")
  DataResponse insertProduct(@RequestBody Product product) {
    List<Product> listProduct = productService.findByName(product.getName().trim());
    if (listProduct.size() > 0) {
      throw new RuntimeException("Product name already taken");
    }
    return new DataResponse(productService.save(product));
  }

  @GetMapping("/findProductImage/{id}")
  DataResponse findImageByProductId(@PathVariable Integer id) {
    return new DataResponse(storageService.findImageByProductId(id));
  }

  @PostMapping("/uploadImage")
  DataResponse saveImage(
      @RequestParam("id") Integer id,
      @RequestParam("file") MultipartFile file) {
    return new DataResponse(productService.uploadImage(id, file));
  }

  @DeleteMapping("/deleteImage")
  void deleteImage(@RequestParam("filePath") String filePath) {
    storageService.deleteImage(filePath);
  }

  @GetMapping("/findProductVideo/{id}")
  DataResponse findVideoByProductId(@PathVariable Integer id) {
    return new DataResponse(storageService.findVideoByProductId(id));
  }

  @PostMapping("/insertVideo")
  DataResponse saveVideo(@RequestBody Video video) {
    return new DataResponse(storageService.saveVideo(video));
  }

  @PutMapping("/{id}")
  DataResponse updateProduct(@RequestBody Product newProduct, @PathVariable Integer id) {
    Product updateProduct = productService.updateProduct(newProduct, id);
    return new DataResponse(updateProduct);
  }

  @DeleteMapping("/{id}")
  DataResponse deleteProduct(@PathVariable Integer id) {
    boolean exists = productService.existsById(id);
    if (exists) {
      productService.deleteById(id);
      return new DataResponse("");
    }
    throw new RuntimeException("Cannot find product with id = " + id + " to delete");
  }

  @GetMapping("/laptop")
  DataResponse getAllLaptop(
      @RequestParam(defaultValue = "0") Integer pageNo,
      @RequestParam(defaultValue = "10") Integer pageSize,
      @RequestParam(defaultValue = "id") String sortBy,
      @RequestParam(defaultValue = "2") String kindId) {
    List<LaptopDTO> laptopDTOs =
        productService.getAllLaptop(pageNo, pageSize, sortBy, Integer.valueOf(kindId));
    return new DataResponse(laptopDTOs);
  }

  @GetMapping("/phone")
  DataResponse getAllPhone(
      @RequestParam(defaultValue = "0") Integer pageNo,
      @RequestParam(defaultValue = "10") Integer pageSize,
      @RequestParam(defaultValue = "id") String sortBy,
      @RequestParam(defaultValue = "1") String kindId) {
    List<PhoneDTO> phoneDTOS =
        productService.getAllPhone(pageNo, pageSize, sortBy, Integer.valueOf(kindId));
    return new DataResponse(phoneDTOS);
  }

  @GetMapping("/tablet")
  DataResponse getAllTablet(
      @RequestParam(defaultValue = "0") Integer pageNo,
      @RequestParam(defaultValue = "10") Integer pageSize,
      @RequestParam(defaultValue = "id") String sortBy,
      @RequestParam(defaultValue = "3") String kindId) {
    List<TabletDTO> tabletDTOS =
        productService.getAllTablet(pageNo, pageSize, sortBy, Integer.valueOf(kindId));
    return new DataResponse(tabletDTOS);
  }

  @GetMapping("/smartwatch")
  DataResponse getAllSmartWatch(
      @RequestParam(defaultValue = "0") Integer pageNo,
      @RequestParam(defaultValue = "10") Integer pageSize,
      @RequestParam(defaultValue = "id") String sortBy,
      @RequestParam(defaultValue = "4") String kindId) {
    List<SmartWatchDTO> smartWatchDTOS =
        productService.getAllSmartWatch(pageNo, pageSize, sortBy, Integer.valueOf(kindId));
    return new DataResponse(smartWatchDTOS);
  }

  @GetMapping("/filter")
  DataResponse filterByAllProducts(
      @RequestParam(defaultValue = "0") Integer pageNo,
      @RequestParam(defaultValue = "10") Integer pageSize,
      @RequestParam(defaultValue = "0") Integer companyId,
      @RequestParam(defaultValue = "0") Integer nationId,
      @RequestParam(defaultValue = "0") Integer kindId,
      @RequestParam(defaultValue = "null") String os,
      @RequestParam(defaultValue = "null") String ram,
      @RequestParam(defaultValue = "null") String screen,
      @RequestParam(defaultValue = "null") String memory,
      @RequestParam(defaultValue = "null") String battery,
      @RequestParam(defaultValue = "0") Integer minPrice,
      @RequestParam(defaultValue = "2147483647") Integer maxPrice) {

    List<Product> listProduct =
        productService.filterByAllProducts(
            pageNo, pageSize, companyId, nationId, kindId, os, ram, screen, memory, battery, minPrice, maxPrice);
    return new DataResponse(listProduct);
  }
}
