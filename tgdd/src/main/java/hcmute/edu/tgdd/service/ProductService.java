package hcmute.edu.tgdd.service;

import hcmute.edu.tgdd.dto.LaptopDTO;
import hcmute.edu.tgdd.dto.PhoneDTO;
import hcmute.edu.tgdd.dto.SmartWatchDTO;
import hcmute.edu.tgdd.dto.TabletDTO;
import hcmute.edu.tgdd.model.Image;
import hcmute.edu.tgdd.model.Product;
import hcmute.edu.tgdd.model.Video;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;
import java.util.Optional;

public interface ProductService {

  List<Product> getAllProduct(Integer pageNo, Integer pageSize, String sortBy);

  Optional<Product> findById(Integer id);

  List<Product> findByName(String name);

  Product save(Product product);

  Optional<Image> uploadImage(Integer id, MultipartFile file);

  boolean existsById(Integer id);

  void deleteById(Integer id);

  Product updateProduct(Product newProduct, int id);

  List<LaptopDTO> getAllLaptop(Integer pageNo, Integer pageSize, String sortBy, Integer kindId);

  List<PhoneDTO> getAllPhone(Integer pageNo, Integer pageSize, String sortBy, Integer kindId);

  List<TabletDTO> getAllTablet(Integer pageNo, Integer pageSize, String sortBy, Integer kindId);

  List<SmartWatchDTO> getAllSmartWatch(
      Integer pageNo, Integer pageSize, String sortBy, Integer kindId);

  List<Product> filterByAllProducts(
      Integer pageNo,
      Integer pageSize,
      int companyId,
      int nationId,
      int kindId,
      String os,
      String ram,
      String screen,
      String memory,
      String battery,
      Integer minPrice,
      Integer maxPrice);

  List<Product> productSameKindAndCompany(int kindId, int companyId);
}
