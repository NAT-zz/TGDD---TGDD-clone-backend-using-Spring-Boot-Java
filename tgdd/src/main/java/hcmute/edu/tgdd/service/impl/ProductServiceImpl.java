package hcmute.edu.tgdd.service.impl;

import hcmute.edu.tgdd.dto.LaptopDTO;
import hcmute.edu.tgdd.dto.PhoneDTO;
import hcmute.edu.tgdd.dto.SmartWatchDTO;
import hcmute.edu.tgdd.dto.TabletDTO;
import hcmute.edu.tgdd.model.Image;
import hcmute.edu.tgdd.model.Product;
import hcmute.edu.tgdd.repository.ProductRepository;
import hcmute.edu.tgdd.service.ProductService;
import hcmute.edu.tgdd.service.StorageService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.util.*;
import java.util.stream.Collectors;

@Service
public class ProductServiceImpl implements ProductService {
  @Autowired
  private ModelMapper modelMapper;

  @Autowired
  private ProductRepository productRepository;

  @Autowired
  private StorageService storageService;

  @Override
  public List<Product> getAllProduct(Integer pageNo, Integer pageSize, String sortBy) {
    Pageable paging = PageRequest.of(pageNo, pageSize, Sort.by(sortBy));
    Page<Product> pagedResult = productRepository.findAll(paging);
    return pagedResult.getContent();
  }

  @Override
  public Optional<Product> findById(Integer id) {
    return productRepository.findById(id);
  }

  @Override
  public List<Product> findByName(String name) {
    return productRepository.findByName(name);
  }

  @Override
  public Product save(Product product) {
    return productRepository.save(product);
  }

  @Override
  public Optional<Image> uploadImage(Integer id, MultipartFile file) {
    return findById(id)
        .map(product -> {
          if (!storageService.isImage(file)) {
            throw new RuntimeException("The file is not an image");
          }

          List<Image> images = storageService.findImageByProductId(id);
          String url = storageService.uploadImage(file, "tgdd_product/" + product.getName() + "_" + images.size());

          if (url.equals("")) {
            throw new RuntimeException("Fail to upload image");
          }

          Image image = new Image("tgdd_product/" + product.getName() + "_" + images.size(), url, id, 0);
          return storageService.saveImage(image);
        });
  }

  @Override
  public boolean existsById(Integer id) {
    return productRepository.existsById(id);
  }

  @Override
  public void deleteById(Integer id) {
    productRepository.deleteById(id);
  }

  @Override
  public Product updateProduct(Product newProduct, int id) {
    return productRepository
        .findById(id)
        .map(
            product -> {
              product.setName(newProduct.getName());
              product.setCompanyId(newProduct.getCompanyId());
              product.setNationId(newProduct.getNationId());
              product.setPrice(newProduct.getPrice());
              product.setQuantity(newProduct.getQuantity());
              product.setDiscount(newProduct.getDiscount());
              product.setDescription(newProduct.getDescription());
              product.setKindId(newProduct.getKindId());
              product.setOs(newProduct.getOs());
              product.setRam(newProduct.getRam());
              product.setScreen(newProduct.getScreen());
              product.setMemory(newProduct.getMemory());
              product.setBattery(newProduct.getBattery());
              product.setChip(newProduct.getChip());
              product.setFrontCam(newProduct.getFrontCam());
              product.setBackCam(newProduct.getBackCam());
              product.setSim(newProduct.getSim());
              product.setSizeWeight(newProduct.getSizeWeight());
              product.setFeature(newProduct.getFeature());
              product.setScreenCard(newProduct.getScreenCard());
              product.setPort(newProduct.getPort());
              product.setDesign(newProduct.getDesign());
              product.setYear(newProduct.getYear());

              return productRepository.save(product);
            })
        .orElseGet(
            () -> productRepository.save(newProduct));
  }

  @Override
  public List<LaptopDTO> getAllLaptop(
      Integer pageNo, Integer pageSize, String sortBy, Integer kindId) {
    Pageable paging = PageRequest.of(pageNo, pageSize, Sort.by(sortBy));
    return productRepository.findAllByKindId(kindId, paging).stream()
        .map(product -> modelMapper.map(product, LaptopDTO.class))
        .collect(Collectors.toList());
  }

  @Override
  public List<PhoneDTO> getAllPhone(
      Integer pageNo, Integer pageSize, String sortBy, Integer kindId) {
    Pageable paging = PageRequest.of(pageNo, pageSize, Sort.by(sortBy));
    return productRepository.findAllByKindId(kindId, paging).stream()
        .map(product -> modelMapper.map(product, PhoneDTO.class))
        .collect(Collectors.toList());
  }

  @Override
  public List<TabletDTO> getAllTablet(
      Integer pageNo, Integer pageSize, String sortBy, Integer kindId) {
    Pageable paging = PageRequest.of(pageNo, pageSize, Sort.by(sortBy));
    return productRepository.findAllByKindId(kindId, paging).stream()
        .map(product -> modelMapper.map(product, TabletDTO.class))
        .collect(Collectors.toList());
  }

  @Override
  public List<SmartWatchDTO> getAllSmartWatch(
      Integer pageNo, Integer pageSize, String sortBy, Integer kindId) {
    Pageable paging = PageRequest.of(pageNo, pageSize, Sort.by(sortBy));
    return productRepository.findAllByKindId(kindId, paging).stream()
        .map(product -> modelMapper.map(product, SmartWatchDTO.class))
        .collect(Collectors.toList());
  }

  @Override
  public List<Product> filterByAllProducts(
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
      Integer maxPrice) {

    //Pageable paging = PageRequest.of(pageNo, pageSize);
    List<Product> productList = productRepository.findAll();

    int fromIndex = (pageNo) * pageSize;
    if(productList.isEmpty() || productList.size() <= fromIndex) {
      return Collections.emptyList();
    }
    
    if (companyId != 0) removeNotInCondition(productList, "company", companyId);
    if (nationId != 0) removeNotInCondition(productList, "nation", nationId);
    if (kindId != 0) removeNotInCondition(productList, "kind", kindId);
    if (!os.equals("null")) removeNotInCondition(productList, "os", os);
    if (!ram.equals("null")) removeNotInCondition(productList, "ram", ram);
    if (!screen.equals("null")) removeNotInCondition(productList, "screen", screen);
    if (!memory.equals("null")) removeNotInCondition(productList, "memory", memory);
    if (!battery.equals("null")) removeNotInCondition(productList, "battery", battery);
    if (minPrice != 0) removeNotInCondition(productList, "minPrice", minPrice);
    if (maxPrice != 0) removeNotInCondition(productList, "maxPrice", maxPrice);

    return productList.subList(fromIndex, Math.min(fromIndex + pageSize, productList.size()));
  }

  private void removeNotInCondition(List<Product> productList, String sortBy, int content) {
    int length = productList.size();
    for (int i = 0; i < length; i++) {
      Product p = productList.get(i);
      switch (sortBy) {
        case "company":
          {
            if (p.getCompanyId() != content) {
              productList.remove(p);
              i -= 1;
              length = productList.size();
            }
            break;
          }
        case "nation":
          {
            if (p.getNationId() != content) {
              productList.remove(p);
              i -= 1;
              length = productList.size();
            }
            break;
          }
        case "kind":
          {
            if (p.getKindId() != content) {
              productList.remove(p);
              i -= 1;
              length = productList.size();
            }
            break;
          }
        case "minPrice":
        {
          if (p.getPrice() < content) {
            productList.remove(p);
            i -= 1;
            length = productList.size();
          }
          break;
        }
        case "maxPrice":
        {
          if (p.getPrice() > content) {
            productList.remove(p);
            i -= 1;
            length = productList.size();
          }
          break;
        }
      }
    }
  }

  private void removeNotInCondition(List<Product> productList, String sortBy, String content) {
    int length = productList.size();
    for (int i = 0; i < length; i++) {
      Product p = productList.get(i);
      switch (sortBy) {
        case "os":
          {
            if (!p.getOs().equals(content)) {
              productList.remove(p);
              i -= 1;
              length = productList.size();
            }
            break;
          }
        case "ram":
          {
            if (!p.getRam().equals(content)) {
              productList.remove(p);
              i -= 1;
              length = productList.size();
            }
            break;
          }
        case "screen":
          {
            if (!p.getScreen().equals(content)) {
              productList.remove(p);
              i -= 1;
              length = productList.size();
            }
            break;
          }
        case "memory":
          {
            if (!p.getMemory().equals(content)) {
              productList.remove(p);
              i -= 1;
              length = productList.size();
            }
            break;
          }
        case "battery":
          {
            if (!p.getBattery().equals(content)) {
              productList.remove(p);
              i -= 1;
              length = productList.size();
            }
            break;
          }
      }
    }
  }


  // kindId v?? companyId truy???n v??o t??? product
  @Override
  public List<Product> findByKindIdAndCompanyId(int kindId, int companyId) {
    return productRepository.findByKindIdAndCompanyId(kindId, companyId);
  }

  @Override
  public List<Product> findByNameLike(String name) {
  	return productRepository.findByNameContainingIgnoreCase(name);
  }

  @Override
  public List<Product> findAllByDiscountGreaterThan(int discount){return productRepository.findAllByDiscountGreaterThan(discount);}

  @Override
  public void updateDiscountProduct(int productId,int discount) {
    productRepository.findById(productId)
        .map(product -> {
          product.setDiscount(discount);
          return productRepository.save(product);
        });
  }
}
