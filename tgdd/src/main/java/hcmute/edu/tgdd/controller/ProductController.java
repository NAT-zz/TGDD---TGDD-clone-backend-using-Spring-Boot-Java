package hcmute.edu.tgdd.controller;

import hcmute.edu.tgdd.dto.LaptopDTO;
import hcmute.edu.tgdd.dto.PhoneDTO;
import hcmute.edu.tgdd.dto.SmartWatchDTO;
import hcmute.edu.tgdd.dto.TabletDTO;
import hcmute.edu.tgdd.model.DataResponse;
import hcmute.edu.tgdd.model.Product;
import hcmute.edu.tgdd.service.impl.ProductServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(path = "/api/Product")
public class ProductController {
    @Autowired
    private ProductServiceImpl productService;

    @GetMapping("")
    DataResponse getAllProduct(@RequestParam(defaultValue = "0") Integer pageNo,
                               @RequestParam(defaultValue = "10") Integer pageSize,
                               @RequestParam(defaultValue = "id") String sortBy) {
        List<Product> listProduct = productService.getAllProduct(pageNo, pageSize, sortBy);
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
            throw new RuntimeException("Product name already taken");
        }
        return new DataResponse(productService.save(product));
    }

    @PutMapping("/{id}")
    DataResponse updateProduct(@RequestBody Product newProduct, @PathVariable Integer id){
        Product updateProduct = productService.updateProduct(newProduct,id);
        return new DataResponse(updateProduct);
    }
    @DeleteMapping("/{id}")
    DataResponse deleteProduct(@PathVariable Integer id){
        boolean exists = productService.existsById(id);
        if (exists) {
            productService.deleteById(id);
            return new DataResponse("");

        }
        throw new RuntimeException("Cannot find product with id = " + id + " to delete");
    }

    @GetMapping("/laptop")
    DataResponse getAllLaptop(@RequestParam(defaultValue = "0") Integer pageNo,
                              @RequestParam(defaultValue = "10") Integer pageSize,
                              @RequestParam(defaultValue = "id") String sortBy,
                              @RequestParam(defaultValue = "2") String kindId){
        List<LaptopDTO> laptopDTOs = productService.getAllLaptop(pageNo,pageSize,sortBy, Integer.valueOf(kindId));
        return new DataResponse(laptopDTOs);
    }
    @GetMapping("/phone")
    DataResponse getAllPhone(@RequestParam(defaultValue = "0") Integer pageNo,
                              @RequestParam(defaultValue = "10") Integer pageSize,
                              @RequestParam(defaultValue = "id") String sortBy,
                              @RequestParam(defaultValue = "1") String kindId){
        List<PhoneDTO> phoneDTOS = productService.getAllPhone(pageNo,pageSize,sortBy, Integer.valueOf(kindId));
        return new DataResponse(phoneDTOS);
    }
    @GetMapping("/tablet")
    DataResponse getAllTablet(@RequestParam(defaultValue = "0") Integer pageNo,
                              @RequestParam(defaultValue = "10") Integer pageSize,
                              @RequestParam(defaultValue = "id") String sortBy,
                              @RequestParam(defaultValue = "3") String kindId){
        List<TabletDTO> tabletDTOS = productService.getAllTablet(pageNo,pageSize,sortBy, Integer.valueOf(kindId));
        return new DataResponse(tabletDTOS);
    }
    @GetMapping("/smartwatch")
    DataResponse getAllSmartWatch(@RequestParam(defaultValue = "0") Integer pageNo,
                              @RequestParam(defaultValue = "10") Integer pageSize,
                              @RequestParam(defaultValue = "id") String sortBy,
                              @RequestParam(defaultValue = "4") String kindId){
        List<SmartWatchDTO> smartWatchDTOS = productService.getAllSmartWatch(pageNo,pageSize,sortBy, Integer.valueOf(kindId));
        return new DataResponse(smartWatchDTOS);
    }

    @GetMapping("/company/{id}")
    DataResponse filterByCompany(@PathVariable Integer id){
        List<Product> products = productService.filterByCompany(id);
        if(products.size() > 0)
            return new DataResponse(products);
        else
            throw  new RuntimeException("Can not find company with id " + id);
    }

    @GetMapping("/nation/{id}")
    DataResponse filterByNation(@PathVariable Integer id){
        List<Product> products = productService.filterByNation(id);
        if(products.size() > 0)
            return new DataResponse(products);
        else
            throw  new RuntimeException("Can not find nation with id " + id);
    }

    @GetMapping("/kind/{id}")
    DataResponse filterByKind(@PathVariable Integer id){
        List<Product> products = productService.filterByKind(id);
        if(products.size() > 0)
            return new DataResponse(products);
        else
            throw  new RuntimeException("Can not find kind with id " + id);
    }

    @GetMapping("/os/{os}")
    DataResponse filterByOS(@PathVariable String os){
        List<Product> products = productService.filterByOS(os);
        if(products.size() > 0)
            return new DataResponse(products);
        else
            throw  new RuntimeException("Can not find os with " + os);
    }

    @GetMapping("/ram/{ram}")
    DataResponse filterByRAM(@PathVariable String ram){
        List<Product> products = productService.filterByRAM(ram);
        if(products.size() > 0)
            return new DataResponse(products);
        else
            throw  new RuntimeException("Can not find ram with " + ram);
    }

    @GetMapping("/screen/{screen}")
    DataResponse filterByScreen(@PathVariable String screen){
        List<Product> products = productService.filterByScreen(screen);
        if(products.size() > 0)
            return new DataResponse(products);
        else
            throw  new RuntimeException("Can not find screen with  " + screen);
    }

    @GetMapping("/memory/{memory}")
    DataResponse filterByMemory(@PathVariable String memory){
        List<Product> products = productService.filterByMemory(memory);
        if(products.size() > 0)
            return new DataResponse(products);
        else
            throw  new RuntimeException("Can not find memory with " + memory);
    }

    @GetMapping("/battery/{battery}")
    DataResponse filterByBattery(@PathVariable String battery){
        List<Product> products = productService.filterByBattery(battery);
        if(products.size() > 0)
            return new DataResponse(products);
        else
            throw  new RuntimeException("Can not find battery with  " + battery);
    }

}
