package hcmute.edu.tgdd.service;

import hcmute.edu.tgdd.dto.LaptopDTO;
import hcmute.edu.tgdd.dto.PhoneDTO;
import hcmute.edu.tgdd.dto.SmartWatchDTO;
import hcmute.edu.tgdd.dto.TabletDTO;
import hcmute.edu.tgdd.model.Phone;
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

  List<LaptopDTO> getAllLaptop(Integer pageNo, Integer pageSize, String sortBy, Integer kindId);

  List<PhoneDTO> getAllPhone(Integer pageNo, Integer pageSize, String sortBy, Integer kindId);

  List<TabletDTO> getAllTablet(Integer pageNo, Integer pageSize, String sortBy, Integer kindId);

  List<SmartWatchDTO> getAllSmartWatch(
      Integer pageNo, Integer pageSize, String sortBy, Integer kindId);

  List<Product> filterByCompany(int companyId);
  List<Product> filterByNation(int nationId);
  List<Product> filterByKind(int kindId);

  List<Product> filterByOS(String os);
  List<Product> filterByRAM(String ram);
  List<Product> filterByScreen(String screen);
  List<Product> filterByMemory(String memory);
  List<Product> filterByBattery(String battery);
}
