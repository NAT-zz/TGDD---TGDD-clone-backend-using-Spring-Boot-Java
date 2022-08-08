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
	public List<Product> getAllProduct(Integer pageNo, Integer pageSize, String sortBy);
	public Optional<Product> findById(Integer id);
	public List<Product> findByName(String name);
	public Product save(Product product);
	public boolean existsById(Integer id);
	public void deleteById(Integer id);
	public List<LaptopDTO> getAllLaptop(Integer pageNo, Integer pageSize, String sortBy, Integer kindId);
	public List<PhoneDTO> getAllPhone(Integer pageNo, Integer pageSize, String sortBy, Integer kindId);
	public List<TabletDTO> getAllTablet(Integer pageNo, Integer pageSize, String sortBy, Integer kindId);
	public List<SmartWatchDTO> getAllSmartWatch(Integer pageNo, Integer pageSize, String sortBy, Integer kindId);
}
