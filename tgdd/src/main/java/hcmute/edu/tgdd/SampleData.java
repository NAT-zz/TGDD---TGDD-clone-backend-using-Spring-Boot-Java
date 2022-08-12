package hcmute.edu.tgdd;

import hcmute.edu.tgdd.model.*;
import hcmute.edu.tgdd.model.User.Role;
import hcmute.edu.tgdd.repository.*;
import hcmute.edu.tgdd.service.UserService;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author Gia Hung
 */
@Configuration
public class SampleData {
  private static final Logger logger = LoggerFactory.getLogger(SampleData.class);

  @Bean
  CommandLineRunner initDatabase(
          CompanyRepository companyRepository,
          NationRepository nationRepository,
          UserRepository userRepository,
          UserService userService,
          KindRepository kindRepository,
          CartRepository cartRepository,
          CartDetailRepository cartDetailRepository,
          ProductRepository productRepository,
          StatusRepository statusRepository) {
    return new CommandLineRunner() {
      @Override
      public void run(String... args) throws Exception {
        Company productA = new Company("SamSung");
        Company productB = new Company("Apple");
        logger.info("insert data: " + companyRepository.save(productA));
        logger.info("insert data: " + companyRepository.save(productB));

        Nation naA = new Nation("USA");
        Nation naB = new Nation("Japan");
        Nation naC = new Nation("China");
        logger.info("insert data: " + nationRepository.save(naA));
        logger.info("insert data: " + nationRepository.save(naB));
        logger.info("insert data: " + nationRepository.save(naC));


        User cuA = new User("0333912381", "123", "Nguyen Tran Tuan", "HCM", "tuantran@gmail.com", true, Role.ROLE_CUSTOMER);
        User cuB = new User("0333912382", "123", "Nguyen Anh Tuan", "HCM", "tuan@gmail.com", true, Role.ROLE_ADMIN);
        logger.info("insert data: " + userService.insertNewUser(cuA));
        logger.info("insert data: " + userService.insertNewUser(cuB));
        
        Kind kindB = new Kind("Laptop");
        Kind kindA = new Kind("Phone");
        Kind kindC = new Kind("Tablet");
        Kind kindD = new Kind("SmartWatch");
        logger.info("insert data: " + kindRepository.save(kindA));
        logger.info("insert data: " + kindRepository.save(kindB));
        logger.info("insert data: " + kindRepository.save(kindC));
        logger.info("insert data: " + kindRepository.save(kindD));

        Cart cart1 = new Cart("0934033188", "giao nhanh", "Exxy3", 0);
        Cart cart2 = new Cart("0934099999", "giao nhanh 1", "REun6", 0);
        logger.info("insert data: " + cartRepository.save(cart1));
        logger.info("insert data: " + cartRepository.save(cart2));

        CartDetail cartDetail1 = new CartDetail(1, 5, 1);
        CartDetail cartDetail2 = new CartDetail(2, 2, 2);
        logger.info("insert data: " + cartDetailRepository.save(cartDetail1));
        logger.info("insert data: " + cartDetailRepository.save(cartDetail2));

        Product product1 = new Product("Samsung Galaxy S22 Ultra",1,1,25_990_000,34,16, "https://res.cloudinary.com/drwc3s5id/image/upload/v1660290951/tgdd_product/Samsung%20Galaxy%20S22%20Ultra_0.jpg https://res.cloudinary.com/drwc3s5id/image/upload/v1660290963/tgdd_product/Samsung%20Galaxy%20S22%20Ultra_1.jpg https://res.cloudinary.com/drwc3s5id/image/upload/v1660290970/tgdd_product/Samsung%20Galaxy%20S22%20Ultra_2.jpg", null,"mo ta",1, "Android 12", "8 GB", "Dynamic AMOLED 2X6.8 inch, Quad HD+ (2K+)", "128 GB", "5000 mAh, 45 W", "Snapdragon 8 Gen 1", "40 MP", "Main 108 MP & Secondary 12 MP, 10 MP, 10 MP", "2 Nano SIM or 1 Nano SIM + 1 eSIM, support 5G", null, null, null, null, null, 2021);
        Product product2 = new Product("Laptop Asus TUF Gaming FX506LHB",1,1,16_490_000,30,17,"https://res.cloudinary.com/drwc3s5id/image/upload/v1660291509/tgdd_product/Laptop%20Asus%20TUF%20Gaming%20FX506LHB_0.jpg https://res.cloudinary.com/drwc3s5id/image/upload/v1660291527/tgdd_product/Laptop%20Asus%20TUF%20Gaming%20FX506LHB_1.jpg https://res.cloudinary.com/drwc3s5id/image/upload/v1660291534/tgdd_product/Laptop%20Asus%20TUF%20Gaming%20FX506LHB_2.jpg", null,"mo ta 2",2, "Windows 11 Home SL", "8 GB", "15.6 inch, Full HD (1920 x 1080), 144Hz", "512 GB SSD", null, "i5, 10300H, 2.5GHz", null, null, null, "359 mm long - 256 mm wide - 24.9 mm thick - 2.3 kg", "Has keyboard light", "GTX 1650 4GB", "1x USB 3.2 Gen 2 Type-C support DisplayPort / power delivery / G-SYNC, 2 x USB 3.2, HDMI, Headphone jack 3.5 mm, LAN (RJ45), USB 2.0", "Plastic cover", 2021);        Product product3 = new Product("Laptop Asus TUF Gaming FX517ZC",2,2,23_790_000,100,16,"laptop_asus_tuf_gaming_fx517zc.png","laptop_asus_tuf_gaming_fxfx517zc.mp4","mo ta 3",2, "Windows 11 Home SL", "8 GB", "15.6 inch, Full HD (1920 x 1080), 144Hz", "512 GB SSD", null, "i5, 12450H, 2GHz", null, null, null, "354 mm long - 251 mm wide - 20.7 mm thick - 2 kg", "Has keyboard light", "RTX 3050 4GB", "1x USB 3.2 Gen 2 Type-C support DisplayPort / power delivery / G-SYNC2 x USB 3.2, HDMI, Headphone jack 3.5 mmLAN (RJ45)Thunderbolt 4", "Plastic cover", 2022);
        Product product4 = new Product("Tablet Samsung Galaxy Tab S8 ",2,1,20_990_000,34,15,"tablet_samsung_galaxy_tab_s8.png","tablet_samsung_galaxy_tab_s8.mp4","mo ta",3, "Android 12", "8 GB", "11 inch, LTPS", "128 GB", "8000 mAh, 45 W", "Snapdragon 8 Gen 1", "12 MP", "Main 13 MP & Secondary 6 MP", "1 Nano SIM", null, null, null, null, null, 2021);
        Product product5 = new Product("Apple Watch SE 40mm",2,1,6_990_000,101,22,"Apple_Watch_SE_40mm.png","Apple_Watch_SE_40mm.mp4","mo ta",4, "IOS", null, "OLED1.57 inch", null, null, null, null, null, null, null, null, null, null, null, 2021);
        logger.info("insert data: " + productRepository.save(product1));
        logger.info("insert data: " + productRepository.save(product2));
        logger.info("insert data: " + productRepository.save(product3));
        logger.info("insert data: " + productRepository.save(product4));
        logger.info("insert data: " + productRepository.save(product5));

        Status status1 = new Status("Chờ xác nhận");
        Status status2 = new Status("Đang giao");
        Status status3 = new Status("Đã nhận");
        Status status4 = new Status("Đã hủy");
        logger.info("insert data: " + statusRepository.save(status1));
        logger.info("insert data: " + statusRepository.save(status2));
        logger.info("insert data: " + statusRepository.save(status3));
        logger.info("insert data: " + statusRepository.save(status4));
      }
    };
  }
}
