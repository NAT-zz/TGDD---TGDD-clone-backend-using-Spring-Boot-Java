package hcmute.edu.tgdd;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;

import hcmute.edu.tgdd.model.*;
import hcmute.edu.tgdd.model.User.Role;
import hcmute.edu.tgdd.repository.*;
import hcmute.edu.tgdd.service.UserService;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

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
      StatusRepository statusRepository,
      CommentRepository commentRepository,
      ImageRepository imageRepository,
      VideoRepository videoRepository) {
    return new CommandLineRunner() {
      @Override
      public void run(String... args) throws Exception {
        Company company1 = new Company("Iphone"); // USA
        Company company2 = new Company("SamSung"); // Korea
        Company company3 = new Company("Oppo"); // China
        Company company4 = new Company("Xiaomi"); // China
        Company company5 = new Company("Vivo"); // China
        Company company6 = new Company("Realme"); // China
        Company company7 = new Company("Nokia"); // Filand
        Company company8 = new Company("MacBook"); // USA
        Company company9 = new Company("Asus"); // Taiwan
        Company company10 = new Company("HP"); // USA
        Company company11 = new Company("Lenovo"); // China
        Company company12 = new Company("Acer"); // Taiwan
        Company company13 = new Company("Dell"); // USA
        Company company14 = new Company("MSI"); // Taiwan
        Company company16 = new Company("Ipad"); // USA
        Company company17 = new Company("Watch"); // USA
        Company company18 = new Company("Gramin"); // Swiss
        Company company19 = new Company("Befit"); // Vietnam
        Company company20 = new Company("Kidcare"); // China
        logger.info("insert data: " + companyRepository.save(company1));
        logger.info("insert data: " + companyRepository.save(company2));
        logger.info("insert data: " + companyRepository.save(company3));
        logger.info("insert data: " + companyRepository.save(company4));
        logger.info("insert data: " + companyRepository.save(company5));
        logger.info("insert data: " + companyRepository.save(company6));
        logger.info("insert data: " + companyRepository.save(company7));
        logger.info("insert data: " + companyRepository.save(company8));
        logger.info("insert data: " + companyRepository.save(company9));
        logger.info("insert data: " + companyRepository.save(company10));
        logger.info("insert data: " + companyRepository.save(company11));
        logger.info("insert data: " + companyRepository.save(company12));
        logger.info("insert data: " + companyRepository.save(company13));
        logger.info("insert data: " + companyRepository.save(company14));
        logger.info("insert data: " + companyRepository.save(company16));
        logger.info("insert data: " + companyRepository.save(company17));
        logger.info("insert data: " + companyRepository.save(company18));
        logger.info("insert data: " + companyRepository.save(company19));
        logger.info("insert data: " + companyRepository.save(company20));

        Nation na1 = new Nation("USA");
        Nation na2 = new Nation("Korea");
        Nation na3 = new Nation("China");
        Nation na4 = new Nation("Filand");
        Nation na5 = new Nation("Taiwan");
        Nation na6 = new Nation("Swiss");
        Nation na7 = new Nation("Vietnam");
        logger.info("insert data: " + nationRepository.save(na1));
        logger.info("insert data: " + nationRepository.save(na2));
        logger.info("insert data: " + nationRepository.save(na3));
        logger.info("insert data: " + nationRepository.save(na4));
        logger.info("insert data: " + nationRepository.save(na5));
        logger.info("insert data: " + nationRepository.save(na6));
        logger.info("insert data: " + nationRepository.save(na7));

        User cuA =
            new User(
                "0333912381",
                "123",
                "Nguyen Tran Tuan",
                "HCM",
                "tuantran@gmail.com",
                true,
                Role.ROLE_CUSTOMER);
        User cuB =
            new User(
                "0333912382",
                "123",
                "Nguyen Anh Tuan",
                "HCM",
                "tuan@gmail.com",
                true,
                Role.ROLE_ADMIN);
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

        Cart cart1 = new Cart("0934033188", "giao nhanh", "Exxy3", 1);
        Cart cart2 = new Cart("0934099999", "giao nhanh 1", "REun6", 1);
        Cart cart3 = new Cart("0934033188", "", "", 2);
        Cart cart4 = new Cart("0934099999", "", "", 2);
        Cart cart5 = new Cart("0934033188", "", "", 3);
        Cart cart6 = new Cart("0934099999", "", "", 4);
        logger.info("insert data: " + cartRepository.save(cart1));
        logger.info("insert data: " + cartRepository.save(cart2));
        logger.info("insert data: " + cartRepository.save(cart3));
        logger.info("insert data: " + cartRepository.save(cart4));
        logger.info("insert data: " + cartRepository.save(cart5));
        logger.info("insert data: " + cartRepository.save(cart6));

        CartDetail cartDetail1 = new CartDetail(1, 5, 1);
        CartDetail cartDetail2 = new CartDetail(3, 2, 2);
        CartDetail cartDetail3 = new CartDetail(2, 3, 1);
        CartDetail cartDetail4 = new CartDetail(4, 1, 2);
        CartDetail cartDetail5 = new CartDetail(5, 1, 3);
        CartDetail cartDetail6 = new CartDetail(6, 1, 4);
        CartDetail cartDetail7 = new CartDetail(7, 2, 5);
        CartDetail cartDetail8 = new CartDetail(8, 3, 6);
        CartDetail cartDetail9 = new CartDetail(10, 4, 3);
        CartDetail cartDetail10 = new CartDetail(2, 10, 4);
        logger.info("insert data: " + cartDetailRepository.save(cartDetail1));
        logger.info("insert data: " + cartDetailRepository.save(cartDetail2));
        logger.info("insert data: " + cartDetailRepository.save(cartDetail3));
        logger.info("insert data: " + cartDetailRepository.save(cartDetail4));
        logger.info("insert data: " + cartDetailRepository.save(cartDetail5));
        logger.info("insert data: " + cartDetailRepository.save(cartDetail6));
        logger.info("insert data: " + cartDetailRepository.save(cartDetail7));
        logger.info("insert data: " + cartDetailRepository.save(cartDetail8));
        logger.info("insert data: " + cartDetailRepository.save(cartDetail9));
        logger.info("insert data: " + cartDetailRepository.save(cartDetail10));

        Product product1 =
            new Product(
                "Samsung Galaxy S22 Ultra",
                1,
                1,
                25_990_000,
                34,
                16,
                "mo ta",
                1,
                "Android 12",
                "8 GB",
                "Dynamic AMOLED 2X6.8 inch, Quad HD+ (2K+)",
                "128 GB",
                "5000 mAh, 45 W",
                "Snapdragon 8 Gen 1",
                "40 MP",
                "Main 108 MP & Secondary 12 MP, 10 MP, 10 MP",
                "2 Nano SIM or 1 Nano SIM + 1 eSIM, support 5G",
                null,
                null,
                null,
                null,
                null,
                2021);
        Product product2 =
            new Product(
                "Laptop Asus TUF Gaming FX506LHB",
                1,
                1,
                16_490_000,
                30,
                17,
                "mo ta 2",
                2,
                "Windows 11 Home SL",
                "8 GB",
                "15.6 inch, Full HD (1920 x 1080), 144Hz",
                "512 GB SSD",
                null,
                "i5, 10300H, 2.5GHz",
                null,
                null,
                null,
                "359 mm long - 256 mm wide - 24.9 mm thick - 2.3 kg",
                "Has keyboard light",
                "GTX 1650 4GB",
                "1x USB 3.2 Gen 2 Type-C support DisplayPort / power delivery / G-SYNC, 2 x USB 3.2, HDMI, Headphone jack 3.5 mm, LAN (RJ45), USB 2.0",
                "Plastic cover",
                2021);
        Product product3 =
            new Product(
                "Laptop Asus TUF Gaming FX517ZC",
                2,
                2,
                23_790_000,
                100,
                16,
                "mo ta 3",
                2,
                "Windows 11 Home SL",
                "8 GB",
                "15.6 inch, Full HD (1920 x 1080), 144Hz",
                "512 GB SSD",
                null,
                "i5, 12450H, 2GHz",
                null,
                null,
                null,
                "354 mm long - 251 mm wide - 20.7 mm thick - 2 kg",
                "Has keyboard light",
                "RTX 3050 4GB",
                "1x USB 3.2 Gen 2 Type-C support DisplayPort / power delivery / G-SYNC2 x USB 3.2, HDMI, Headphone jack 3.5 mmLAN (RJ45)Thunderbolt 4",
                "Plastic cover",
                2022);
        Product product4 =
            new Product(
                "Tablet Samsung Galaxy Tab S8",
                2,
                1,
                20_990_000,
                34,
                15,
                "mo ta",
                3,
                "Android 12",
                "8 GB",
                "11 inch, LTPS",
                "128 GB",
                "8000 mAh, 45 W",
                "Snapdragon 8 Gen 1",
                "12 MP",
                "Main 13 MP & Secondary 6 MP",
                "1 Nano SIM",
                null,
                null,
                null,
                null,
                null,
                2021);
        Product product5 =
            new Product(
                "Apple Watch SE 40mm",
                2,
                1,
                6_990_000,
                101,
                22,
                "mo ta",
                4,
                "IOS",
                null,
                "OLED1.57 inch",
                null,
                null,
                null,
                null,
                null,
                null,
                null,
                null,
                null,
                null,
                null,
                2021);
        logger.info("insert data: " + productRepository.save(product1));
        logger.info("insert data: " + productRepository.save(product2));
        logger.info("insert data: " + productRepository.save(product3));
        logger.info("insert data: " + productRepository.save(product4));
        logger.info("insert data: " + productRepository.save(product5));

        Image image1 =
            new Image(
                "tgdd_product/Samsung Galaxy S22 Ultra_0",
                "https://res.cloudinary.com/drwc3s5id/image/upload/v1660361517/tgdd_product/Samsung%20Galaxy%20S22%20Ultra_0.jpg",
                1);
        Image image2 =
            new Image(
                "tgdd_product/Samsung Galaxy S22 Ultra_1",
                "https://res.cloudinary.com/drwc3s5id/image/upload/v1660361613/tgdd_product/Samsung%20Galaxy%20S22%20Ultra_1.jpg",
                1);
        Image image3 =
            new Image(
                "tgdd_product/Samsung Galaxy S22 Ultra_2",
                "https://res.cloudinary.com/drwc3s5id/image/upload/v1660361622/tgdd_product/Samsung%20Galaxy%20S22%20Ultra_2.jpg",
                1);
        Image image4 =
            new Image(
                "tgdd_product/Laptop Asus TUF Gaming FX506LHB_0",
                "https://res.cloudinary.com/drwc3s5id/image/upload/v1660361632/tgdd_product/Laptop%20Asus%20TUF%20Gaming%20FX506LHB_0.jpg",
                2);
        Image image5 =
            new Image(
                "tgdd_product/Laptop Asus TUF Gaming FX506LHB_1",
                "https://res.cloudinary.com/drwc3s5id/image/upload/v1660361640/tgdd_product/Laptop%20Asus%20TUF%20Gaming%20FX506LHB_1.jpg",
                2);
        Image image6 =
            new Image(
                "tgdd_product/Laptop Asus TUF Gaming FX506LHB_2",
                "https://res.cloudinary.com/drwc3s5id/image/upload/v1660361648/tgdd_product/Laptop%20Asus%20TUF%20Gaming%20FX506LHB_2.jpg",
                2);
        logger.info("insert data: " + imageRepository.save(image1));
        logger.info("insert data: " + imageRepository.save(image2));
        logger.info("insert data: " + imageRepository.save(image3));
        logger.info("insert data: " + imageRepository.save(image4));
        logger.info("insert data: " + imageRepository.save(image5));
        logger.info("insert data: " + imageRepository.save(image6));

        Video video1 = new Video("https://youtu.be/XQMh9vPKTpg", 1);
        logger.info("insert data: " + videoRepository.save(video1));

        Status status0 = new Status("Chưa đăt hàng");
        Status status1 = new Status("Chờ xác nhận");
        Status status2 = new Status("Đang giao");
        Status status3 = new Status("Đã nhận");
        Status status4 = new Status("Đã hủy");
        logger.info("insert data: " + statusRepository.save(status0));
        logger.info("insert data: " + statusRepository.save(status1));
        logger.info("insert data: " + statusRepository.save(status2));
        logger.info("insert data: " + statusRepository.save(status3));
        logger.info("insert data: " + statusRepository.save(status4));

        Comment comment1 = new Comment(1, "0869792657", "Tạm được", 3, "comment1.png");
        Comment comment2 = new Comment(2, "0869792657", "Tạm được", 4, "comment2.png");
        logger.info("insert data: " + commentRepository.save(comment1));
        logger.info("insert data: " + commentRepository.save(comment2));
      }
    };
  }
}
