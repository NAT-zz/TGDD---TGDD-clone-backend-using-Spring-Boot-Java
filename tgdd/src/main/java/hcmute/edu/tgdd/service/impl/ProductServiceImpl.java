package hcmute.edu.tgdd.service.impl;

import hcmute.edu.tgdd.dto.LaptopDTO;
import hcmute.edu.tgdd.dto.PhoneDTO;
import hcmute.edu.tgdd.dto.SmartWatchDTO;
import hcmute.edu.tgdd.dto.TabletDTO;
import hcmute.edu.tgdd.model.Product;
import hcmute.edu.tgdd.repository.ProductRepository;
import hcmute.edu.tgdd.service.ProductService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class ProductServiceImpl implements ProductService {

    @Autowired
    private ModelMapper modelMapper;
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

    public Product updateProduct(Product newProduct,int id){
        return productRepository.findById(id)
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
                }).orElseGet(() -> {
                    return productRepository.save(newProduct);
                });
    }

    @Override
    public List<LaptopDTO> getAllLaptop(Integer pageNo, Integer pageSize, String sortBy,Integer kindId){
        Pageable paging = PageRequest.of(pageNo, pageSize, Sort.by(sortBy));
        return  productRepository.findAllByKindId(kindId,paging).stream().map(product -> modelMapper.map(product, LaptopDTO.class))
                .collect(Collectors.toList());
    }

    @Override
    public List<PhoneDTO> getAllPhone(Integer pageNo, Integer pageSize, String sortBy, Integer kindId) {
        Pageable paging = PageRequest.of(pageNo, pageSize, Sort.by(sortBy));
        return  productRepository.findAllByKindId(kindId,paging).stream().map(product -> modelMapper.map(product, PhoneDTO.class))
                .collect(Collectors.toList());
    }

    @Override
    public List<TabletDTO> getAllTablet(Integer pageNo, Integer pageSize, String sortBy, Integer kindId) {
        Pageable paging = PageRequest.of(pageNo, pageSize, Sort.by(sortBy));
        return  productRepository.findAllByKindId(kindId,paging).stream().map(product -> modelMapper.map(product, TabletDTO.class))
                .collect(Collectors.toList());
    }

    @Override
    public List<SmartWatchDTO> getAllSmartWatch(Integer pageNo, Integer pageSize, String sortBy, Integer kindId) {
        Pageable paging = PageRequest.of(pageNo, pageSize, Sort.by(sortBy));
        return  productRepository.findAllByKindId(kindId,paging).stream().map(product -> modelMapper.map(product, SmartWatchDTO.class))
                .collect(Collectors.toList());
    }

}
