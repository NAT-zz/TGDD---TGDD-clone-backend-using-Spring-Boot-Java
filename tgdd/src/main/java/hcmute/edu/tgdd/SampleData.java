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


        Company company1 = new Company("Iphone"); //USA
        Company company2 = new Company("SamSung"); //Korea
        Company company3 = new Company("Oppo"); //China
        Company company4 = new Company("Xiaomi"); //China
        Company company5 = new Company("Vivo"); //China
        Company company6 = new Company("Realme"); //China
        Company company7 = new Company("Nokia");  //Finland
        Company company8 = new Company("MacBook"); //USA
        Company company9 = new Company("Asus");  //Taiwan
        Company company10 = new Company("HP");   //USA
        Company company11 = new Company("Lenovo"); //China
        Company company12 = new Company("Acer"); //Taiwan
        Company company13 = new Company("Dell"); //USA
        Company company14 = new Company("MSI"); //Taiwan
        Company company16 = new Company("Ipad"); //USA
        Company company17 = new Company("Watch"); //USA
        Company company18 = new Company("Gramin"); //Sweden
        Company company19 = new Company("Befit"); //Vietnam
        Company company20 = new Company("Kidcare"); //China

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
        Nation na4 = new Nation("Finland");
        Nation na5 = new Nation("Taiwan");
        Nation na6 = new Nation("Sweden");
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

<<<<<<< HEAD
=======
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

>>>>>>> f0e5680ffb92b385bc636e0c721b87aff8f31f9e
        //Phone
        Product phone1 = new Product("Iphone 11",1,1,14_990_000,30,23,"Apple đã chính thức trình làng bộ 3 siêu phẩm iPhone 11, trong đó phiên bản iPhone 11 64GB có mức giá rẻ nhất nhưng vẫn được nâng cấp mạnh mẽ như iPhone Xr ra mắt trước đó.",1, "IOS 15", "4 GB", "IPS LCD6.1\"Liquid Retina", "64 GB", "3110 mAh, 18 W", "Apple A13 Bionic", "12 MP", "2 camera 12 MP", "1 Nano SIM & 1 eSIMHỗ trợ 4G", null, null, null, null, null, 2021);
        Product phone2 = new Product("Iphone 13 Pro Max",1,1,33_990_000,50,13,"Điện thoại iPhone 13 Pro Max 128 GB - siêu phẩm được mong chờ nhất ở nửa cuối năm 2021 đến từ Apple. Máy có thiết kế không mấy đột phá khi so với người tiền nhiệm, bên trong đây vẫn là một sản phẩm có màn hình siêu đẹp, tần số quét được nâng cấp lên 120 Hz mượt mà, cảm biến camera có kích thước lớn hơn, cùng hiệu năng mạnh mẽ với sức mạnh đến từ Apple A15 Bionic, sẵn sàng cùng bạn chinh phục mọi thử thách.",1, "IOS 15", "6 GB", "OLED6.7\"Super Retina XDR", "128 GB", "4352 mAh20 W", "Apple A15 Bionic", "12 MP", "3 camera 12 MP", "1 Nano SIM & 1 eSIMHỗ trợ 5G", null, null, null, null, null, 2022);
				Product phone3 = new Product("Samsung Galaxy S22 Ultra",2,2,30_990_000,34,16,"Galaxy S22 Ultra 5G chiếc smartphone cao cấp nhất trong bộ 3 Galaxy S22 series mà Samsung đã cho ra mắt. Tích hợp bút S Pen hoàn hảo trong thân máy, trang bị vi xử lý mạnh mẽ cho các tác vụ sử dụng vô cùng mượt mà và nổi bật hơn với cụm camera không viền độc đáo mang đậm dấu ấn riêng",1, "Android 12", "8 GB", "Dynamic AMOLED 2X6.8 inch, Quad HD+ (2K+)", "128 GB", "5000 mAh, 45 W", "Snapdragon 8 Gen 1", "40 MP", "Main 108 MP & Secondary 12 MP, 10 MP, 10 MP", "2 Nano SIM or 1 Nano SIM + 1 eSIM, support 5G", null, null, null, null, null, 2021);
				Product phone4 = new Product("Samsung Galaxy A13",2,2,4_690_000,35,10,"Nhằm mang trải nghiệm tốt hơn trên dòng sản phẩm giá rẻ, Samsung cho ra mắt Galaxy A13 4G với một hiệu năng ổn định, camera chụp ảnh sắc nét và viên pin khủng đáp ứng nhu cầu sử dụng cả ngày cho bạn cùng một mức giá trang bị cực kỳ phải chăng.",1, "Android 12", "4 GB", "PLS TFT LCD6.6\"Full HD+", "128 GB", "5000 mAh15 W", "Exynos 850", "8 MP", "Chính 50 MP & Phụ 5 MP, 2 MP, 2 MP", "2 Nano SIMHỗ trợ 4G", null, null, null, null, null, 2021);
				Product phone5 = new Product("OPPO Reno7 series",3,3,9_990_000,70,0,"OPPO đã trình làng mẫu Reno7 Z 5G với thiết kế OPPO Glow độc quyền, camera mang hiệu ứng như máy DSLR chuyên nghiệp cùng viền sáng kép, máy có một cấu hình mạnh mẽ và đạt chứng nhận xếp hạng A về độ mượt.",1, "Android 11", "8 GB", "AMOLED6.43\"Full HD+", "128 GB", "4500 mAh33 W", "Snapdragon 695 5G", "16 MP", "Chính 64 MP & Phụ 2 MP, 2 MP", "2 Nano SIM (SIM 2 chung khe thẻ nhớ)Hỗ trợ 5G", null, null, null, null, null, 2021);
				Product phone6 = new Product("OPPO A55",3,3,4_190_000,60,6,"OPPO cho ra mắt OPPO A55 4G chiếc smartphone giá rẻ tầm trung có thiết kế đẹp mắt, cấu hình khá ổn, cụm camera chất lượng và dung lượng pin ấn tượng, mang đến một lựa chọn trải nghiệm thú vị vừa túi tiền cho người tiêu dùng.",1, "Android 11", "8 GB", "IPS LCD6.5\"HD+", "64 GB", "5000 mAh18 W", "MediaTek Helio G35", "16 MP", "Chính 50 MP & Phụ 2 MP, 2 MP", "2 Nano SIMHỗ trợ 4G", null, null, null, null, null, 2021);
				Product phone7 = new Product("Xiaomi Redmi Note 11",4,3,4_690_000,63,6,"Điện thoại Redmi được mệnh danh là dòng sản phẩm quốc dân ngon - bổ  - rẻ của Xiaomi và Redmi Note 11 (4GB/64GB) cũng không phải ngoại lệ, máy sở hữu một hiệu năng ổn định, màn hình 90 Hz mượt mà, cụm camera AI đến 50 MP cùng một mức giá vô cùng tốt.",1, "Android 11", "4 GB", "AMOLED6.43\"Full HD+", "64 GB", "5000 mAh33 W", "Snapdragon 680 8 nhân", "13 MP", "Chính 50 MP & Phụ 8 MP, 2 MP, 2 MP", "2 Nano SIMHỗ trợ 4G", null, null, null, null, null, 2021);
				Product phone8 = new Product("Xiaomi Redmi Note 11S 5G",4,3,6_490_000,89,0,"Tại sự kiện ra mắt sản phẩm mới diễn ra hôm 29/3, điện thoại Xiaomi đã ra mắt Redmi Note 11S 5G toàn cầu. Thiết bị là một bản nâng cấp đáng giá so với Redmi Note 11S 4G, cùng xem máy có gì đặc biệt thôi nào.",1, "Android 11", "6 GB", "IPS LCD6.6\"Full HD+", "128 GB", "5000 mAh33 W", "MediaTek Dimensity 810 5G", "13 MP", "Chính 50 MP & Phụ 8 MP, 2 MP", "2 Nano SIM (SIM 2 chung khe thẻ nhớ)Hỗ trợ 5G", null, null, null, null, null, 2021);
				Product phone9 = new Product("Vivo Y15s",5,3,3_490_000,89,0,"Vivo vừa mang một chiến binh mới đến phân khúc tầm trung giá rẻ có tên Vivo Y15s, một sản phẩm sở hữu khá nhiều ưu điểm như thiết kế đẹp, màn hình lớn, camera kép, pin cực trâu và còn rất nhiều điều thú vị khác đang chờ đón bạn.",1, "Android 11 (Go Edition)", "3 GB", "IPS LCD6.51\"HD+", "32 GB", "5000 mAh10 W", "MediaTek Helio P35", "8 MP", "Chính 13 MP & Phụ 2 MP", "2 Nano SIMHỗ trợ 4G", null, null, null, null, null, 2022);
				Product phone10 = new Product("Vivo X80",5,3,19_990_000,89,0,"Vivo X80 được xem là thiết bị hướng đến đối tượng người dùng chuyên nhiếp ảnh trên điện thoại, bằng việc hợp tác cùng nhà sản xuất ống kính nổi tiếng mang thương hiệu ZEISS. Với những tính năng mới mẻ hay chế độ quay - chụp độc đáo, X80 hứa hẹn mang đến cho bạn những trải nghiệm đầy mới lạ và chất lượng.",1, "Android 12", "12 GB", "AMOLED6.78\"Full HD+", "256 GB", "4500 mAh80 W", "MediaTek Dimensity 9000 8 nhân", "32 MP", "Chính 50 MP & Phụ 12 MP, 12 MP", "2 Nano SIMHỗ trợ 5G", null, null, null, null, null, 2018);
				Product phone11 = new Product("Realme C35",6,3,4_290_000,42,0,"Điện thoại Realme C35 thuộc phân khúc giá rẻ được nhà Realme cho ra mắt với thiết kế trẻ trung, dung lượng pin lớn cùng camera hỗ trợ nhiều tính năng. Đây sẽ là thiết bị liên lạc, giải trí và làm việc ổn định,… cho các nhu cầu sử dụng của bạn.",1, "Android 11", "4 GB", "IPS LCD6.6\"Full HD+", "64 GB", "5000 mAh18 W", "Unisoc T616", "8 MP", "Chính 50 MP & Phụ 2 MP, 0.3 MP", "2 Nano SIMHỗ trợ 4G", null, null, null, null, null, 2022);
				Product phone12 = new Product("Realme 9 Pro 5G ",6,3,7_990_000,40,0,"Realme 9 Pro - chiếc điện thoại tầm trung được Realme giới thiệu với thiết kế phản quang hoàn toàn mới, máy có một vẻ ngoài năng động, hiệu năng mạnh mẽ, cụm camera AI 64 MP và một tốc độ sạc ổn định.",1, "Android 12", "8 GB", "IPS LCD6.6\"Full HD+", "128 GB", "5000 mAh33 W", "Snapdragon 695 5G 8 nhân", "16 MP", "Chính 64 MP & Phụ 8 MP, 2 MP", "2 Nano SIM (SIM 2 chung khe thẻ nhớ)Hỗ trợ 5G", null, null, null, null, null, 2019);
				Product phone13 = new Product("Nokia G21 ",7,4,4_290_000,50,9,"Nokia G21 là thế hệ tiếp theo thuộc G series do Nokia sản xuất với những cải tiến nổi bật như màn hình kích thước lớn, hiệu năng ổn định mang đến trải nghiệm mượt mà trên các tác vụ hằng ngày cùng thời gian sử dụng lâu dài nhờ viên pin khủng được tích hợp trên điện thoại.",1, "Android 11", "4 GB", "TFT LCD6.5\"HD+", "128 GB", "5050 mAh18 W", "Unisoc T606", "8 MP", "Chính 50 MP & Phụ 2 MP, 2 MP", "2 Nano SIMHỗ trợ 4G", null, null, null, null, null, 2010);
				Product phone14 = new Product("Nokia G11 ",7,4,3_890_000,50,17,"Nokia G11 được hãng cho ra mắt với hiệu năng ổn định, màn hình kích thước lớn mang đến những trải nghiệm giải trí tuyệt vời cùng thời gian sử dụng lâu dài với viên pin cực khủng.",1, "Android 11", "4 GB", "TFT LCD6.5\"HD+", "64 GB", "5050 mAh18 W", "Unisoc T606", "8 MP", "Chính 13 MP & Phụ 2 MP, 2 MP", "2 Nano SIMHỗ trợ 4G", null, null, null, null, null, 2010);
				Product phone15 = new Product("Iphone 13 Pro",1,1,30_990_000,10,12,"Mỗi lần ra mắt phiên bản mới là mỗi lần iPhone chiếm sóng trên khắp các mặt trận và lần này cái tên khiến vô số người \"sục sôi\" là iPhone 13 Pro, chiếc điện thoại thông minh vẫn giữ nguyên thiết kế cao cấp, cụm 3 camera được nâng cấp, cấu hình mạnh mẽ cùng thời lượng pin lớn ấn tượng. ",1, "IOS 15", "6 GB", "OLED6.1\"Super Retina XDR", "128 GB", "3095 mAh20 W", "Apple A15 Bionic", "12 MP", "3 camera 12 MP", "1 Nano SIM & 1 eSIMHỗ trợ 5G", null, null, null, null, null, 2021);
        Product phone16 = new Product("Iphone 13",1,1,24_990_000,10,15,"Trong khi sức hút đến từ bộ 4 phiên bản iPhone 12 vẫn chưa nguội đi, thì hãng điện thoại Apple đã mang đến cho người dùng một siêu phẩm mới iPhone 13 với nhiều cải tiến thú vị sẽ mang lại những trải nghiệm hấp dẫn nhất cho người dùng.",1, "IOS 15", "4 GB", "OLED6.1\"Super Retina XDR", "128 GB", "3240 mAh20 W", "Apple A15 Bionic", "12 MP", "2 camera 12 MP", "1 Nano SIM & 1 eSIMHỗ trợ 5G", null, null, null, null, null, 2021);
        Product phone17 = new Product("Iphone 13 mini",1,1,21_990_000,17,13,"iPhone 13 mini được Apple ra mắt với hàng loạt nâng cấp về cấu hình và các tính năng hữu ích, lại có thiết kế vừa vặn. Chiếc điện thoại này hứa hẹn là một thiết bị hoàn hảo hướng tới những khách hàng thích sự nhỏ gọn nhưng vẫn giữ được sự mạnh mẽ bên trong.",1, "IOS 15", "4 GB", "OLED5.4\"Super Retina XDR", "128 GB", "3240 mAh20 W", "Apple A15 Bionic", "12 MP", "2 camera 12 MP", "1 Nano SIM & 1 eSIMHỗ trợ 5G", null, null, null, null, null, 2021);
        Product phone18 = new Product("Iphone 12",1,1,19_990_000,25,12,"Trong những tháng cuối năm 2020, Apple đã chính thức giới thiệu đến người dùng cũng như iFan thế hệ iPhone 12 series mới với hàng loạt tính năng bứt phá, thiết kế được lột xác hoàn toàn, hiệu năng đầy mạnh mẽ và một trong số đó chính là iPhone 12 64GB.",1, "IOS 15", "4 GB", "OLED6.1\"Super Retina XDR", "64 GB", "2815 mAh20 W", "Apple A14 Bionic", "12 MP", "2 camera 12 MP", "1 Nano SIM & 1 eSIMHỗ trợ 5G", null, null, null, null, null, 2021);
        Product phone19 = new Product("Iphone 12 mini",1,1,20_990_000,26,28,"Apple tiếp tục khẳng định vị thế của mình khi cho ra mắt mẫu iPhone 12 series với nhiều điểm được tối ưu hơn, nâng cấp mạnh hơn. Trong đó, điện thoại iPhone 12 mini 128 GB được ví như là phiên bản thu nhỏ hơn là bản rút gọn với cấu hình không khác gì mấy anh lớn có mức giá hấp dẫn hơn.",1, "IOS 15", "4 GB", "OLED5.4\"Super Retina XDR", "128 GB", "2815 mAh20 W", "Apple A14 Bionic", "12 MP", "2 camera 12 MP", "1 Nano SIM & 1 eSIMHỗ trợ 5G", null, null, null, null, null, 2021);
        Product phone20 = new Product("Iphone SE",1,1,13_490_000,11,11,"Như vậy là sau bao ngày chờ đợi thì iPhone SE 64 GB (2022) cũng đã được giới thiệu tại sự kiện Apple Peek Performance. Thiết bị nổi bật với cấu hình mạnh mẽ, chạy chip hiện đại nhất của Apple hiện tại nhưng giá bán lại rất phải chăng.",1, "IOS 15", "4 GB", "IPS LCD4.7\"Retina HD", "64 GB", "2018 mAh20 W", "Apple A15 Bionic", "7 MP", "12 MP", "1 Nano SIM & 1 eSIMHỗ trợ 5G", null, null, null, null, null, 2021);
        
        logger.info("insert data: " + productRepository.save(phone1));
        logger.info("insert data: " + productRepository.save(phone2));
        logger.info("insert data: " + productRepository.save(phone3));
        logger.info("insert data: " + productRepository.save(phone4));
        logger.info("insert data: " + productRepository.save(phone5));
        logger.info("insert data: " + productRepository.save(phone6));
        logger.info("insert data: " + productRepository.save(phone7));
        logger.info("insert data: " + productRepository.save(phone8));
        logger.info("insert data: " + productRepository.save(phone9));
        logger.info("insert data: " + productRepository.save(phone10));
        logger.info("insert data: " + productRepository.save(phone11));
        logger.info("insert data: " + productRepository.save(phone12));
        logger.info("insert data: " + productRepository.save(phone13));
        logger.info("insert data: " + productRepository.save(phone14));
        logger.info("insert data: " + productRepository.save(phone15));
        logger.info("insert data: " + productRepository.save(phone16));
        logger.info("insert data: " + productRepository.save(phone17));
        logger.info("insert data: " + productRepository.save(phone18));
        logger.info("insert data: " + productRepository.save(phone19));
        logger.info("insert data: " + productRepository.save(phone20));
        //Tablet
        Product tablet1 = new Product("iPad Pro M1 11 inch",1,1,46_990_000,30,10,"Trải nghiệm khung hình sống động cùng cảm giác chạm vuốt cực mượt",3, "iPadOS 15", "16 GB", "11\"Liquid Retina", "1 TB", "28.65 Wh (~ 7538 mAh)20 W", "Apple M1", "12 MP", "Chính 12 MP & Phụ 10 MP, TOF 3D LiDAR", "1 Nano SIM hoặc 1 eSIM", "Dài 247.6 mm - Ngang 178.5 mm - Dày 5.9 mm - Nặng 470 g", "\r\n"
        		+ "4 loa\r\n"
        		+ "\r\n"
        		+ "Dolby Vision\r\n"
        		+ "\r\n"
        		+ "Kết nối Apple Pencil 2\r\n"
        		+ "\r\n"
        		+ "Mở khóa bằng khuôn mặt (Face ID)\r\n"
        		+ "\r\n"
        		+ "Âm thanh Dolby Atmos", null, null, null, 2021);
        Product tablet2 = new Product("iPad Pro M1 12.9 inch",1,1,34_990_000,20,16,"Bạn có đang mong chờ những sản phẩm chất lượng đến từ Apple? Sau hàng loạt các sản phẩm đình đám như iPhone 12 series thì hãng đã tung ra chiếc iPad Pro M1 12.9 inch Wifi Cellular 128GB (2021) trang bị những tính năng ngày càng vượt trội và thời thượng.",3, "iPadOS 15", "8 GB", "12.9\"Liquid Retina XDR", "128 GB", "28.65 Wh (~ 7538 mAh)20 W", "Apple M1", "12 MP", "Chính 12 MP & Phụ 10 MP, TOF 3D LiDAR", "1 Nano SIM hoặc 1 eSIM", "\r\n"
        		+ "Dài 280.6 mm - Ngang 214.9 mm - Dày 6.4 mm - Nặng 685 g", "\r\n"
        		+ "4 loa\r\n"
        		+ "\r\n"
        		+ "Dolby Vision\r\n"
        		+ "\r\n"
        		+ "Kết nối Apple Pencil 2\r\n"
        		+ "\r\n"
        		+ "Mở khóa bằng khuôn mặt (Face ID)\r\n"
        		+ "\r\n"
        		+ "Âm thanh Dolby Atmos", null, null, null, 2021);
        Product tablet3 = new Product("iPad Air 5 M1",1,1,20_990_000,16,0,"So với chiếc iPad Air 5 M1 Wifi 64GB thì chiếc iPad Air 5 M1 Wifi Cellular 64GB đã có một điểm khác biệt đáng kể đó là phương thức kết nối khi bạn vừa có thể sử dụng Wifi và vừa sử dụng mạng di động một cách bình thường nhưng vẫn cho một trải nghiệm rất tuyệt vời.",3, "iPadOS 15", "8 GB", "10.9\"Retina IPS LCD", "64 GB", "28.6 Wh (~ 7587 mAh)20 W", "Apple M1", "12 MP", "12 MP", "1 Nano SIM hoặc 1 eSIM", "Dài 247.6 mm - Ngang 178.5 mm - Dày 6.1 mm - Nặng 462 g", "\r\n"
        		+ "Dolby Vision\r\n"
        		+ "\r\n"
        		+ "Kết nối Apple Pencil 2\r\n"
        		+ "\r\n"
        		+ "Kết nối bàn phím rời\r\n"
        		+ "\r\n"
        		+ "Micro kép\r\n"
        		+ "\r\n"
        		+ "Mở khóa bằng vân tay\r\n"
        		+ "\r\n"
        		+ "Nam châm & sạc cho Apple Pencil\r\n"
        		+ "\r\n"
        		+ "Âm thanh Dolby Atmos", null, null, null, 2021);
        Product tablet4 = new Product("iPad Air 4 ",1,1,20_990_000,16,9,"Chấn động giới công nghệ toàn cầu, khi một tablet lần đầu được tích hợp một trong những chipset hàng đầu 2020, iPad Air 4 Wifi Cellular 256GB (2020) sở hữu con chip A14 Bionic với hiệu năng vô cùng mạnh mẽ, kết nối 4G tiện dụng cùng bộ nhớ cực khủng lên đến 256 GB.",3, "iPadOS 15", "4 GB", "10.86\"Liquid Retina", "256 GB", "28.65 Wh (~ 7600 mAh)20 W", "Apple A11 Bionic", "7 MP", "12 MP", "1 Nano SIM hoặc 1 eSIM", "Dài 247.6 mm - Ngang 178.5 mm - Dày 6.1 mm - Nặng 460 g", "\r\n"
        		+ "Mở khóa bằng vân tay", null, null, null, 2021);
        Product tablet5 = new Product("iPad 9 ",1,1,9_990_000,16,10,"Sau thành công của iPad 8, Apple cho đã cho ra mắt máy tính bảng iPad 9 WiFi 64GB - phiên bản tiếp theo của dòng iPad 10.2 inch, về cơ bản nó kế thừa những điểm mạnh từ các phiên bản trước đó và được cải tiến thêm hiệu suất, trải nghiệm người dùng nhằm giúp nhu cầu sử dụng giải trí và làm việc tiện lợi, linh hoạt hơn.",3, "iPadOS 15", "8 GB", "10.2\"Retina IPS LCD", "128 GB", "32.65 Wh (~ 7600 mAh)20 W", "Apple A13 Bionic", "7 MP", "12 MP", "1 Nano SIM hoặc 1 eSIM", "Dài 250.6 mm - Ngang 174.1 mm - Dày 7.5 mm - Nặng 487 g", "Mở khóa bằng vân tayKết nối Apple Pencil", null, null, null, 2021);
        Product tablet6 = new Product("Samsung Galaxy Tab S8 ",2,2,20_990_000,15,0,"Samsung Galaxy Tab S8 ra mắt và vẫn giữ được đặc trưng của dòng máy tính bảng Galaxy Tab S với cấu hình mạnh mẽ, màn hình hiển thị ổn cùng khả năng hỗ trợ bút S Pen hỗ trợ học tập làm việc tốt hơn.\r\n"
        		+ "",3, "Android 12", "8 GB", "11\"LTPS", "128 GB", "32.65 Wh (~ 7600 mAh)20 W", "Snapdragon 8 Gen 1", "12 MP", "\r\n"
        				+ "Chính 13 MP & Phụ 6 MP", "1 Nano SIM", "\r\n"
        						+ "Dài 253.8 mm - Ngang 165.3 mm - Dày 6.3 mm - Nặng 507 g", "4 loa\r\n"
        								+ "\r\n"
        								+ "Chạm 2 lần mở màn hình\r\n"
        								+ "\r\n"
        								+ "Chế độ trẻ em (Samsung Kids)\r\n"
        								+ "\r\n"
        								+ "Ghi âm cuộc gọi\r\n"
        								+ "\r\n"
        								+ "Không gian thứ hai (Thư mục bảo mật)\r\n"
        								+ "\r\n"
        								+ "Kết nối bàn phím rời\r\n"
        								+ "\r\n"
        								+ "Kết nối bút S Pen\r\n"
        								+ "\r\n"
        								+ "Mở khóa bằng khuôn mặt\r\n"
        								+ "\r\n"
        								+ "Mở khóa bằng vân tay\r\n"
        								+ "\r\n"
        								+ "Samsung DeX (Giao diện tương tự PC)\r\n"
        								+ "\r\n"
        								+ "Âm thanh AKG\r\n"
        								+ "\r\n"
        								+ "Âm thanh Dolby Atmos\r\n"
        								+ "\r\n"
        								+ "Ứng dụng kép (Dual Messenger)", null, null, null, 2021);
        Product tablet7 = new Product("Samsung Galaxy Tab A7 Lite",2,2,4_990_000,15,11,"Máy tính bảng Samsung Galaxy Tab A7 Lite là phiên bản rút gọn của dòng tablet \"ăn khách\" Galaxy Tab A7 thuộc thương hiệu Samsung, đáp ứng nhu cầu giải trí của khách hàng thuộc phân khúc bình dân với màn hình lớn nhưng vẫn gọn nhẹ hợp túi tiền."
        		+ "",3, "Android 12", "3 GB", "11\"LTPS", "32 GB", "32.65 Wh (~ 7600 mAh)20 W", "MediaTek MT8768T", "12 MP", "\r\n"
        				+ "Chính 13 MP & Phụ 6 MP", "1 Nano SIM", "\r\n"
        						+ "Dài 253.8 mm - Ngang 165.3 mm - Dày 6.3 mm - Nặng 507 g", "Chế độ trẻ em (Samsung Kids)\r\n"
        								+ "\r\n"
        								+ "Thu nhỏ màn hình sử dụng một tay\r\n"
        								+ "\r\n"
        								+ "Âm thanh Dolby Atmos", null, null, null, 2021);
       
        Product tablet8 = new Product("Samsung Galaxy Tab S8 Ultra",2,2,30_990_000,15,11,"Samsung Galaxy Tab S8 Ultra ra mắt với kích thước màn hình siêu to cùng một cấu hình mạnh mẽ, được xem là thiết bị phù hợp đối với những ai thường xuyên làm các công việc thiết kế hay trên trình duyệt web, bên cạnh đó Tab S8 Ultra còn mang đến những trải nghiệm tương tự một chiếc laptop khi sử dụng kèm với bàn phím."
        		+ "",3, "Android 12", "8 GB", "11\"LTPS", "128 GB", "32.65 Wh (~ 7600 mAh)20 W", "Snapdragon 8 Gen 1", "2 Camera 12 MP", "\r\n"
        				+ "Chính 13 MP & Phụ 6 MP", "1 Nano SIM", "\r\n"
        						+ "Dài 326.4 mm - Ngang 208.6 mm - Dày 5.5 mm - Nặng 728 g", "Chạm 2 lần mở màn hình\r\n"
        								+ "\r\n"
        								+ "Chế độ trẻ em (Samsung Kids)\r\n"
        								+ "\r\n"
        								+ "Ghi âm cuộc gọi\r\n"
        								+ "\r\n"
        								+ "Không gian thứ hai (Thư mục bảo mật)\r\n"
        								+ "\r\n"
        								+ "Kết nối bàn phím rời\r\n"
        								+ "\r\n"
        								+ "Kết nối bút S Pen\r\n"
        								+ "\r\n"
        								+ "Mở khoá vân tay dưới màn hình\r\n"
        								+ "\r\n"
        								+ "Mở khóa bằng khuôn mặt\r\n"
        								+ "\r\n"
        								+ "Mở khóa bằng vân tay\r\n"
        								+ "\r\n"
        								+ "Samsung DeX (Giao diện tương tự PC)\r\n"
        								+ "\r\n"
        								+ "Âm thanh AKG\r\n"
        								+ "\r\n"
        								+ "Âm thanh Dolby Atmos\r\n"
        								+ "\r\n"
        								+ "Ứng dụng kép (Dual Messenger)", null, null, null, 2021);
        Product tablet9 = new Product("Samsung Galaxy Tab S8+",2,2,25_990_000,15,11,"Trong sự kiện Galaxy Unpacked 2022 Samsung đã chính thức cho ra mắt Samsung Galaxy Tab S8+ mẫu máy tính bảng được giới công nghệ chú ý đến với những nâng cấp sáng giá với thế hệ tiền nhiệm. Vậy chiếc máy này có gì đặc biệt, cùng mình vào bài đánh giá chi tiết sau nhé!"
        		+ "",3, "Android 12", "8 GB", "11\"LTPS", "128 GB", "32.65 Wh (~ 7600 mAh)20 W", "Snapdragon 8 Gen 1", "2 Camera 12 MP", "\r\n"
        				+ "Chính 13 MP & Phụ 6 MP", "1 Nano SIM", "\r\n"
        						+ "Dài 326.4 mm - Ngang 208.6 mm - Dày 5.5 mm - Nặng 728 g", "Chạm 2 lần mở màn hình\r\n"
        								+ "\r\n"
        								+ "Chế độ trẻ em (Samsung Kids)\r\n"
        								+ "\r\n"
        								+ "Ghi âm cuộc gọi\r\n"
        								+ "\r\n"
        								+ "Không gian thứ hai (Thư mục bảo mật)\r\n"
        								+ "\r\n"
        								+ "Kết nối bàn phím rời\r\n"
        								+ "\r\n"
        								+ "Kết nối bút S Pen\r\n"
        								+ "\r\n"
        								+ "Mở khoá vân tay dưới màn hình\r\n"
        								+ "\r\n"
        								+ "Mở khóa bằng khuôn mặt\r\n"
        								+ "\r\n"
        								+ "Mở khóa bằng vân tay\r\n"
        								+ "\r\n"
        								+ "Samsung DeX (Giao diện tương tự PC)\r\n"
        								+ "\r\n"
        								+ "Âm thanh AKG\r\n"
        								+ "\r\n"
        								+ "Âm thanh Dolby Atmos\r\n"
        								+ "\r\n"
        								+ "Ứng dụng kép (Dual Messenger)", null, null, null, 2021);
        Product tablet10 = new Product("Samsung Galaxy Tab S7 FE WiFi",2,2,12_990_000,0,0,"Samsung Galaxy Tab S7 FE WiFi - được Samsung cho ra mắt với vô vàn tính năng cùng nhiều ưu điểm nổi bật so hơn với các đối thủ trong tầm giá, tablet hỗ trợ bút S Pen nhằm phục vụ các công việc của bạn trở nên dễ dàng hay hiệu suất mạnh mẽ trên một con chip gaming đến từ nhà Qualcomm, khiến nó trở thành một sự lựa chọn không thể bỏ qua đối với người dùng."
        		+ "",3, "Android 11", "4 GB", "12.4\"TFT LCD", "64 GB", "32.65 Wh (~ 7600 mAh)20 W", "Snapdragon 778G", "8 MP", "\r\n"
        				+ "5 MP", "1 Nano SIM", "\r\n"
        						+ "\r\n"
        						+ "Dài 284.8 mm - Ngang 185 mm - Dày 6.3 mm - Nặng 610 g", "Chế độ trẻ em (Samsung Kids)\r\n"
        								+ "\r\n"
        								+ "Kết nối bút S Pen\r\n"
        								+ "\r\n"
        								+ "Mở khóa bằng khuôn mặt\r\n"
        								+ "\r\n"
        								+ "Samsung DeX (Giao diện tương tự PC)\r\n"
        								+ "\r\n"
        								+ "Âm thanh AKG\r\n"
        								+ "\r\n"
        								+ "Âm thanh Dolby Atmos", null, null, null, 2021);
        Product tablet11 = new Product("Lenovo Yoga Tab 11",11,3,46_990_000,30,10,"Trải nghiệm khung hình sống động cùng cảm giác chạm vuốt cực mượt",3, "iPadOS 15", "16 GB", "11\"Liquid Retina", "1 TB", "28.65 Wh (~ 7538 mAh)20 W", "Apple M1", "12 MP", "Chính 12 MP & Phụ 10 MP, TOF 3D LiDAR", "1 Nano SIM hoặc 1 eSIM", "Dài 247.6 mm - Ngang 178.5 mm - Dày 5.9 mm - Nặng 470 g", "\r\n"
        		+ "4 loa\r\n"
        		+ "\r\n"
        		+ "Dolby Vision\r\n"
        		+ "\r\n"
        		+ "Kết nối Apple Pencil 2\r\n"
        		+ "\r\n"
        		+ "Mở khóa bằng khuôn mặt (Face ID)\r\n"
        		+ "\r\n"
        		+ "Âm thanh Dolby Atmos", null, null, null, 2021);
        Product tablet12 = new Product("Lenovo Yoga Tab 11 Plus",11,3,34_990_000,20,16,"Bạn có đang mong chờ những sản phẩm chất lượng đến từ Apple? Sau hàng loạt các sản phẩm đình đám như iPhone 12 series thì hãng đã tung ra chiếc iPad Pro M1 12.9 inch Wifi Cellular 128GB (2021) trang bị những tính năng ngày càng vượt trội và thời thượng.",3, "iPadOS 15", "8 GB", "12.9\"Liquid Retina XDR", "128 GB", "28.65 Wh (~ 7538 mAh)20 W", "Apple M1", "12 MP", "Chính 12 MP & Phụ 10 MP, TOF 3D LiDAR", "1 Nano SIM hoặc 1 eSIM", "\r\n"
        		+ "Dài 280.6 mm - Ngang 214.9 mm - Dày 6.4 mm - Nặng 685 g", "\r\n"
        		+ "4 loa\r\n"
        		+ "\r\n"
        		+ "Dolby Vision\r\n"
        		+ "\r\n"
        		+ "Kết nối Apple Pencil 2\r\n"
        		+ "\r\n"
        		+ "Mở khóa bằng khuôn mặt (Face ID)\r\n"
        		+ "\r\n"
        		+ "Âm thanh Dolby Atmos", null, null, null, 2021);
        Product tablet13 = new Product("Lenovo Tab M10 (Gen 3)",11,3,20_990_000,16,0,"So với chiếc iPad Air 5 M1 Wifi 64GB thì chiếc iPad Air 5 M1 Wifi Cellular 64GB đã có một điểm khác biệt đáng kể đó là phương thức kết nối khi bạn vừa có thể sử dụng Wifi và vừa sử dụng mạng di động một cách bình thường nhưng vẫn cho một trải nghiệm rất tuyệt vời.",3, "iPadOS 15", "8 GB", "10.9\"Retina IPS LCD", "64 GB", "28.6 Wh (~ 7587 mAh)20 W", "Apple M1", "12 MP", "12 MP", "1 Nano SIM hoặc 1 eSIM", "Dài 247.6 mm - Ngang 178.5 mm - Dày 6.1 mm - Nặng 462 g", "\r\n"
        		+ "Dolby Vision\r\n"
        		+ "\r\n"
        		+ "Kết nối Apple Pencil 2\r\n"
        		+ "\r\n"
        		+ "Kết nối bàn phím rời\r\n"
        		+ "\r\n"
        		+ "Micro kép\r\n"
        		+ "\r\n"
        		+ "Mở khóa bằng vân tay\r\n"
        		+ "\r\n"
        		+ "Nam châm & sạc cho Apple Pencil\r\n"
        		+ "\r\n"
        		+ "Âm thanh Dolby Atmos", null, null, null, 2021);
        Product tablet14 = new Product("Lenovo Tab M10 (FHD+)",11,3,20_990_000,16,9,"Chấn động giới công nghệ toàn cầu, khi một tablet lần đầu được tích hợp một trong những chipset hàng đầu 2020, iPad Air 4 Wifi Cellular 256GB (2020) sở hữu con chip A14 Bionic với hiệu năng vô cùng mạnh mẽ, kết nối 4G tiện dụng cùng bộ nhớ cực khủng lên đến 256 GB.",3, "iPadOS 15", "4 GB", "10.86\"Liquid Retina", "256 GB", "28.65 Wh (~ 7600 mAh)20 W", "Apple A11 Bionic", "7 MP", "12 MP", "1 Nano SIM hoặc 1 eSIM", "Dài 247.6 mm - Ngang 178.5 mm - Dày 6.1 mm - Nặng 460 g", "\r\n"
        		+ "Mở khóa bằng vân tay", null, null, null, 2021);
        Product tablet15 = new Product("Lenovo Tab M10 (Gen 2)",11,3,9_990_000,16,10,"Sau thành công của iPad 8, Apple cho đã cho ra mắt máy tính bảng iPad 9 WiFi 64GB - phiên bản tiếp theo của dòng iPad 10.2 inch, về cơ bản nó kế thừa những điểm mạnh từ các phiên bản trước đó và được cải tiến thêm hiệu suất, trải nghiệm người dùng nhằm giúp nhu cầu sử dụng giải trí và làm việc tiện lợi, linh hoạt hơn.",3, "iPadOS 15", "8 GB", "10.2\"Retina IPS LCD", "128 GB", "32.65 Wh (~ 7600 mAh)20 W", "Apple A13 Bionic", "7 MP", "12 MP", "1 Nano SIM hoặc 1 eSIM", "Dài 250.6 mm - Ngang 174.1 mm - Dày 7.5 mm - Nặng 487 g", "Mở khóa bằng vân tayKết nối Apple Pencil", null, null, null, 2021);
        Product tablet16 = new Product("iPad 9 4G",1,1,20_990_000,15,0,"Samsung Galaxy Tab S8 ra mắt và vẫn giữ được đặc trưng của dòng máy tính bảng Galaxy Tab S với cấu hình mạnh mẽ, màn hình hiển thị ổn cùng khả năng hỗ trợ bút S Pen hỗ trợ học tập làm việc tốt hơn.\r\n"
        		+ "",3, "Android 12", "8 GB", "11\"LTPS", "128 GB", "32.65 Wh (~ 7600 mAh)20 W", "Snapdragon 8 Gen 1", "12 MP", "\r\n"
        				+ "Chính 13 MP & Phụ 6 MP", "1 Nano SIM", "\r\n"
        						+ "Dài 253.8 mm - Ngang 165.3 mm - Dày 6.3 mm - Nặng 507 g", "4 loa\r\n"
        								+ "\r\n"
        								+ "Chạm 2 lần mở màn hình\r\n"
        								+ "\r\n"
        								+ "Chế độ trẻ em (Samsung Kids)\r\n"
        								+ "\r\n"
        								+ "Ghi âm cuộc gọi\r\n"
        								+ "\r\n"
        								+ "Không gian thứ hai (Thư mục bảo mật)\r\n"
        								+ "\r\n"
        								+ "Kết nối bàn phím rời\r\n"
        								+ "\r\n"
        								+ "Kết nối bút S Pen\r\n"
        								+ "\r\n"
        								+ "Mở khóa bằng khuôn mặt\r\n"
        								+ "\r\n"
        								+ "Mở khóa bằng vân tay\r\n"
        								+ "\r\n"
        								+ "Samsung DeX (Giao diện tương tự PC)\r\n"
        								+ "\r\n"
        								+ "Âm thanh AKG\r\n"
        								+ "\r\n"
        								+ "Âm thanh Dolby Atmos\r\n"
        								+ "\r\n"
        								+ "Ứng dụng kép (Dual Messenger)", null, null, null, 2021);
        Product tablet17 = new Product("Samsung Galaxy Tab A8 (2019)",2,2,4_990_000,15,11,"Máy tính bảng Samsung Galaxy Tab A7 Lite là phiên bản rút gọn của dòng tablet \"ăn khách\" Galaxy Tab A7 thuộc thương hiệu Samsung, đáp ứng nhu cầu giải trí của khách hàng thuộc phân khúc bình dân với màn hình lớn nhưng vẫn gọn nhẹ hợp túi tiền."
        		+ "",3, "Android 12", "3 GB", "11\"LTPS", "32 GB", "32.65 Wh (~ 7600 mAh)20 W", "MediaTek MT8768T", "12 MP", "\r\n"
        				+ "Chính 13 MP & Phụ 6 MP", "1 Nano SIM", "\r\n"
        						+ "Dài 253.8 mm - Ngang 165.3 mm - Dày 6.3 mm - Nặng 507 g", "Chế độ trẻ em (Samsung Kids)\r\n"
        								+ "\r\n"
        								+ "Thu nhỏ màn hình sử dụng một tay\r\n"
        								+ "\r\n"
        								+ "Âm thanh Dolby Atmos", null, null, null, 2021);
       
        Product tablet18 = new Product("Samsung Galaxy Tab S6 Lite",2,2,30_990_000,15,11,"Samsung Galaxy Tab S8 Ultra ra mắt với kích thước màn hình siêu to cùng một cấu hình mạnh mẽ, được xem là thiết bị phù hợp đối với những ai thường xuyên làm các công việc thiết kế hay trên trình duyệt web, bên cạnh đó Tab S8 Ultra còn mang đến những trải nghiệm tương tự một chiếc laptop khi sử dụng kèm với bàn phím."
        		+ "",3, "Android 12", "8 GB", "11\"LTPS", "128 GB", "32.65 Wh (~ 7600 mAh)20 W", "Snapdragon 8 Gen 1", "2 Camera 12 MP", "\r\n"
        				+ "Chính 13 MP & Phụ 6 MP", "1 Nano SIM", "\r\n"
        						+ "Dài 326.4 mm - Ngang 208.6 mm - Dày 5.5 mm - Nặng 728 g", "Chạm 2 lần mở màn hình\r\n"
        								+ "\r\n"
        								+ "Chế độ trẻ em (Samsung Kids)\r\n"
        								+ "\r\n"
        								+ "Ghi âm cuộc gọi\r\n"
        								+ "\r\n"
        								+ "Không gian thứ hai (Thư mục bảo mật)\r\n"
        								+ "\r\n"
        								+ "Kết nối bàn phím rời\r\n"
        								+ "\r\n"
        								+ "Kết nối bút S Pen\r\n"
        								+ "\r\n"
        								+ "Mở khoá vân tay dưới màn hình\r\n"
        								+ "\r\n"
        								+ "Mở khóa bằng khuôn mặt\r\n"
        								+ "\r\n"
        								+ "Mở khóa bằng vân tay\r\n"
        								+ "\r\n"
        								+ "Samsung DeX (Giao diện tương tự PC)\r\n"
        								+ "\r\n"
        								+ "Âm thanh AKG\r\n"
        								+ "\r\n"
        								+ "Âm thanh Dolby Atmos\r\n"
        								+ "\r\n"
        								+ "Ứng dụng kép (Dual Messenger)", null, null, null, 2021);
        Product tablet19 = new Product("Lenovo Tab M8",11,3,25_990_000,15,11,"Trong sự kiện Galaxy Unpacked 2022 Samsung đã chính thức cho ra mắt Samsung Galaxy Tab S8+ mẫu máy tính bảng được giới công nghệ chú ý đến với những nâng cấp sáng giá với thế hệ tiền nhiệm. Vậy chiếc máy này có gì đặc biệt, cùng mình vào bài đánh giá chi tiết sau nhé!"
        		+ "",3, "Android 12", "8 GB", "11\"LTPS", "128 GB", "32.65 Wh (~ 7600 mAh)20 W", "Snapdragon 8 Gen 1", "2 Camera 12 MP", "\r\n"
        				+ "Chính 13 MP & Phụ 6 MP", "1 Nano SIM", "\r\n"
        						+ "Dài 326.4 mm - Ngang 208.6 mm - Dày 5.5 mm - Nặng 728 g", "Chạm 2 lần mở màn hình\r\n"
        								+ "\r\n"
        								+ "Chế độ trẻ em (Samsung Kids)\r\n"
        								+ "\r\n"
        								+ "Ghi âm cuộc gọi\r\n"
        								+ "\r\n"
        								+ "Không gian thứ hai (Thư mục bảo mật)\r\n"
        								+ "\r\n"
        								+ "Kết nối bàn phím rời\r\n"
        								+ "\r\n"
        								+ "Kết nối bút S Pen\r\n"
        								+ "\r\n"
        								+ "Mở khoá vân tay dưới màn hình\r\n"
        								+ "\r\n"
        								+ "Mở khóa bằng khuôn mặt\r\n"
        								+ "\r\n"
        								+ "Mở khóa bằng vân tay\r\n"
        								+ "\r\n"
        								+ "Samsung DeX (Giao diện tương tự PC)\r\n"
        								+ "\r\n"
        								+ "Âm thanh AKG\r\n"
        								+ "\r\n"
        								+ "Âm thanh Dolby Atmos\r\n"
        								+ "\r\n"
        								+ "Ứng dụng kép (Dual Messenger)", null, null, null, 2021);
        Product tablet20 = new Product("Lenovo Tab M11 (Gen 3)",11,3,12_990_000,0,0,"Samsung Galaxy Tab S7 FE WiFi - được Samsung cho ra mắt với vô vàn tính năng cùng nhiều ưu điểm nổi bật so hơn với các đối thủ trong tầm giá, tablet hỗ trợ bút S Pen nhằm phục vụ các công việc của bạn trở nên dễ dàng hay hiệu suất mạnh mẽ trên một con chip gaming đến từ nhà Qualcomm, khiến nó trở thành một sự lựa chọn không thể bỏ qua đối với người dùng."
        		+ "",3, "Android 11", "4 GB", "12.4\"TFT LCD", "64 GB", "32.65 Wh (~ 7600 mAh)20 W", "Snapdragon 778G", "8 MP", "\r\n"
        				+ "5 MP", "1 Nano SIM", "\r\n"
        						+ "\r\n"
        						+ "Dài 284.8 mm - Ngang 185 mm - Dày 6.3 mm - Nặng 610 g", "Chế độ trẻ em (Samsung Kids)\r\n"
        								+ "\r\n"
        								+ "Kết nối bút S Pen\r\n"
        								+ "\r\n"
        								+ "Mở khóa bằng khuôn mặt\r\n"
        								+ "\r\n"
        								+ "Samsung DeX (Giao diện tương tự PC)\r\n"
        								+ "\r\n"
        								+ "Âm thanh AKG\r\n"
        								+ "\r\n"
        								+ "Âm thanh Dolby Atmos", null, null, null, 2021);
        
        logger.info("insert data: " + productRepository.save(tablet1));
        logger.info("insert data: " + productRepository.save(tablet2));
        logger.info("insert data: " + productRepository.save(tablet3));
        logger.info("insert data: " + productRepository.save(tablet4));
        logger.info("insert data: " + productRepository.save(tablet5));
        logger.info("insert data: " + productRepository.save(tablet6));
        logger.info("insert data: " + productRepository.save(tablet7));
        logger.info("insert data: " + productRepository.save(tablet8));
        logger.info("insert data: " + productRepository.save(tablet9));
        logger.info("insert data: " + productRepository.save(tablet10));
        logger.info("insert data: " + productRepository.save(tablet11));
        logger.info("insert data: " + productRepository.save(tablet12));
        logger.info("insert data: " + productRepository.save(tablet13));
        logger.info("insert data: " + productRepository.save(tablet14));
        logger.info("insert data: " + productRepository.save(tablet15));
        logger.info("insert data: " + productRepository.save(tablet16));
        logger.info("insert data: " + productRepository.save(tablet17));
        logger.info("insert data: " + productRepository.save(tablet18));
        logger.info("insert data: " + productRepository.save(tablet19));
        logger.info("insert data: " + productRepository.save(tablet20));

				//laptop
				Product laptop1 = new Product("Asus TUF Gaming FX506LHB",9,5,19_490_000,100,15,"Nếu bạn đang tìm kiếm một chiếc laptop gaming nhưng vẫn sở hữu một mức giá phải chăng thì laptop Asus TUF Gaming FX506LHB i5 (HN188W) sẽ là sự lựa chọn đáng cân nhắc với card đồ họa rời NVIDIA GeForce GTX mạnh mẽ cùng phong cách thiết kế cứng cáp, độc đáo.",2, "Windows 11 Home SL", "8 GB", "15.6 inch, Full HD (1920 x 1080), 144Hz", "512 GB SSD", null, "i5, 10300H, 2.5GHz", null, null, null, "Dài 359 mm - Rộng 256 mm - Dày 24.9 mm - Nặng 2.3 kg", "Có đèn bàn phím", "Card rời, GTX 1650 4GB", "1x USB 3.2 Gen 2 Type-C support DisplayPort / power delivery / G-SYNC2 x USB 3.2HDMIJack tai nghe 3.5 mmLAN (RJ45)USB 2.0", "Vỏ nhựa", 2021);
				Product laptop2 = new Product("Asus ZenBook UX425EA",9,5,22_490_000,100,7,"Với những thông số kỹ thuật ấn tượng cùng phong cách thiết kế của một chiếc laptop mỏng nhẹ - thời trang, laptop Asus ZenBook UX425EA (KI839W) sẽ là một người bạn đồng hành hoàn hảo cùng người dùng trong mọi tác vụ.",2, "Windows 11 Home SL", "8 GB", "14 inch, Full HD (1920 x 1080)", "512 GB SSD", null, "i5, 1135G7, 2.4GHz", null, null, null, "Dài 319 mm - Rộng 208 mm - Dày 13.9 mm - Nặng 1.17 kg", "Có đèn bàn phím", "Card tích hợp, Intel Iris Xe", "1 x USB 3.2, 2 x Thunderbolt 4 USB-C, HDMI", "Vỏ kim loại nguyên khối", 2021);
				Product laptop3 = new Product("Asus TUF Gaming FX507ZC",9,5,31_490_000,100,16,"Laptop Asus TUF Gaming FX507ZC i7 (HN124W) cực chất cùng hiệu năng mạnh mẽ từ CPU Intel thế hệ 12, thiết kế thời thượng sẵn sàng thách thức chinh phục ở mọi đấu trường ảo.",2, "Windows 11 Home SL", "8 GB", "15.6 inch, Full HD (1920 x 1080), 144Hz", "512 GB SSD", null, "i7, 12700H, 2.30 GHz", null, null, null, "Dài 354 mm - Rộng 251 mm - Dày 24.9 mm - Nặng 2.2 kg", "Có đèn bàn phím", "Card rời, RTX 3050 4GB", "1x USB 3.2 Gen 2 Type-C support DisplayPort / power delivery / G-SYNC, 2 x USB 3.2, HDMI, Jack tai nghe 3.5 mm, LAN (RJ45), Thunderbolt 4", "Vỏ nhựa", 2022);
				Product laptop4 = new Product("Asus ZenBook UX425E",9,5,28_990_000,100,6,"Laptop Asus ZenBook UX425E i7 (KI843W) là phiên bản laptop cao cấp - sang trọng kèm nhiều tính năng thông minh được trang bị, công nghệ màn hình ấn tượng, hiệu năng vượt trội là sản phẩm hoàn hảo dành cho sinh viên, nhân viên văn phòng hay doanh nhân.",2, "Windows 11 Home SL", "16 GB", "14 inch, Full HD (1920 x 1080)", "512 GB SSD", null, "i7, 1165G7, 2.8 GHz", null, null, null, "Dài 319 mm - Rộng 208 mm - Dày 13.9 mm - Nặng 1.17 kg", "Có đèn bàn phím", "Card tích hợp, Intel Iris Xe", " 1 x USB 3.2, 2 x Thunderbolt 4 USB-C, HDMI", "Vỏ kim loại nguyên khối", 2021);
				Product laptop5 = new Product("Apple MacBook Air M1 2020",8,1,33_990_000,100,8,"Laptop Apple Air M1 2020 có thiết kế đẹp, sang trọng với CPU M1 độc quyền từ Apple cho hiệu năng đồ họa cao, màn hình Retina hiển thị siêu nét cùng với hệ thống bảo mật tối ưu.",2, "Mac OS", "16 GB", "13.3 inch, Retina (2560 x 1600)", "256 GB SSD", null, "Apple M1", null, null, null, "Dài 304.1 mm - Rộng 212.4 mm - Dày 4.1 mm đến 16.1 mm - Nặng 1.29 kg", "Có đèn bàn phím", "Card tích hợp, 7 nhân GPU", "2 x Thunderbolt 3 (USB-C), Jack tai nghe 3.5 mm", "Vỏ kim loại nguyên khối", 2020);
				Product laptop6 = new Product("Apple MacBook Pro M2 2022",8,1,33_990_000,100,5,"Thiết kế thanh lịch, sang trọng cùng hiệu năng vượt trội đến từ vi xử lý tân tiến Apple M2 có trong Macbook Pro M2, hứa hẹn sẽ mang lại nhiều giá trị cho người dùng sáng tạo, phục vụ tốt nhu cầu thiết kế đồ hoạ nâng cao.",2, "Mac OS", "8 GB", "13.3 inch, Retina (2560 x 1600)", "256 GB SSD", null, "Apple M2, 100GB/s", null, null, null, "Dài 304.1 mm - Rộng 212.4 mm - Dày 15.6 mm - Nặng 1.4 kg", "Có đèn bàn phím", "Card tích hợp, 10 nhân GPU", "2 x Thunderbolt , Jack tai nghe 3.5 mm", "Vỏ kim loại", 2022);
				Product laptop7 = new Product("Apple MacBook Pro 16 M1 Max 2021",8,1,90_990_000,100,0,"Thật ấn tượng với Apple MacBook Pro 16 M1 Max 2021 mang trên mình bộ áo mới độc đáo, cuốn hút mọi ánh nhìn cùng màn hình tai thỏ lần đầu tiên xuất hiện ở dòng Mac và ẩn bên trong là bộ cấu hình mạnh mẽ tuyệt vời đến từ con chip M1 Max tân tiến.",2, "Mac OS", "32 GB", "16.2 inch, Liquid Retina XDR display (3456 x 2234), 120Hz", "1 TB SSD", null, "Apple M1 Max, 400GB/s memory bandwidth", null, null, null, "Dài 355.7 mm - Rộng 248.1 mm - Dày 16.8 mm - Nặng 2.2 kg", "Có đèn bàn phím", "Card tích hợp, 32 nhân GPU", "3 x Thunderbolt 4 USB-C, HDMI, Jack tai nghe 3.5 mm", "Vỏ kim loại nguyên khối", 2021);
				Product laptop8 = new Product("MacBook Pro 14 M1 Max 2021",8,1,79_900_000,100,0,"Khoác lên mình vẻ ngoài mới lạ so với các dòng Mac trước đó, thiết kế màn hình tai thỏ ấn tượng, bắt mắt cùng bộ hiệu năng đỉnh cao M1 Max mạnh mẽ, MacBook Pro 14 inch M1 Max 2021 xứng tầm là chiếc laptop cao cấp chuyên dụng dành cho dân kỹ thuật - đồ họa, sáng tạo nội dung.",2, "Mac OS", "32 GB", "14.2 inch, Liquid Retina XDR display (3456 x 2234), 120Hz", "512 GB SSD", null, "Apple M1 Max, 400GB/s memory bandwidth", null, null, null, "Dài 312.6 mm - Rộng 221.2 mm - Dày 15.5 mm - Nặng 1.6 kg", "Có đèn bàn phím", "Card tích hợp, 24 nhân GPU", "3 x Thunderbolt 4 USB-C, HDMI, Jack tai nghe 3.5 mm", "Vỏ kim loại nguyên khối", 2021);
				Product laptop9 = new Product("Acer TravelMate B3 TMB311 31",12,5,9_990_000,100,50,"Laptop Acer TravelMate B3 TMB311 31 C2HB (NX.VNFSV.006) nhắm đến phân khúc laptop học tập - văn phòng, phục vụ cho các nhu cầu cơ bản trên laptop, với kích thước nhỏ gọn và hiệu năng đủ dùng, là sự lựa chọn tốt cho học sinh, sinh viên.",2, "Windows 11 Home SL", "4 GB", "11.6 inch, HD (1366 x 768)", "128 GB SSD", null, "Celeron, N4020, 1.1GHz", null, null, null, "Dài 295 mm - Rộng 215 mm - Dày 20.99 mm - Nặng 1.4 kg", null, "Card tích hợp, Intel UHD 600", "2 x USB 3.2, HDMI, Jack tai nghe 3.5 mm, LAN (RJ45), USB Type-C", "Vỏ nhựa", 2021);
				Product laptop10 = new Product("Acer Nitro 5 Gaming AN515 45",12,5,22_490_000,100,14,"Phá cách với diện mạo mạnh mẽ đến từ laptop Acer Nitro 5 Gaming AN515 45 R6EV R5 5600H (NH.QBMSV.006) mang đến cho người dùng hiệu năng ổn định, hỗ trợ bạn trong mọi tác vụ hằng ngày hay chiến những trận game cực căng một cách mượt mà.",2, "Windows 11 Home SL", "8 GB", "15.6 inch, Full HD (1920 x 1080), 144Hz", "512 GB SSD", null, "Ryzen 5, 5600H, 3.3GHz", null, null, null, "Dài 363.4 mm - Rộng 255 mm - Dày 23.9 mm - Nặng 2.2 kg", "Có đèn bàn phím", "Card rời, GTX 1650 4GB", "3 x USB 3.2, HDMI, Jack tai nghe 3.5 mm, LAN (RJ45), USB Type-C", "Vỏ nhựa", 2021);
				Product laptop11 = new Product("Acer Nitro 5 Gaming AN515 57",12,5,26_490_000,100,22,"Laptop Acer Nitro 5 Gaming AN515 57 54MV i5 (NH.QENSV.003) mang trên mình sức mạnh từ con chip Intel thế hệ 11, card rời cho khả năng tối ưu hoá mọi tác vụ từ đồ hoạ đến game, hứa hẹn sẽ mang đến những trải nghiệm tuyệt vời khó quên cho người dùng.",2, "Windows 11 Home SL", "8 GB", "15.6 inch, Full HD (1920 x 1080), 144Hz", "512 GB SSD", null, "i5, 11400H, 2.7GHz", null, null, null, "Dài 363.4 mm - Rộng 255 mm - Dày 23.9 mm - Nặng 2.2 kg", "Có đèn bàn phím", "Card rời, GTX 3050 4GB", "3 x USB 3.2, HDMI, Jack tai nghe 3.5 mm, LAN (RJ45), USB Type-C", "Vỏ nhựa", 2021);
				Product laptop12 = new Product("Acer Nitro 5 Tiger AN515 58",12,5,27_990_000,100,10,"Một bước tiến cấu hình vượt bật được Acer ưu ái trên chiếc laptop Acer Nitro 5 Tiger AN515 58 52SP i5 (NH.QFHSV.001) khi trang bị bộ vi xử lý Intel Gen 12 đầy mạnh mẽ cùng phong cách thiết kế đậm chất mãnh hổ, khơi nguồn sức mạnh tiềm ẩn bên trong mỗi game thủ trên mọi chiến trường ảo.",2, "Windows 11 Home SL", "8 GB", "15.6 inch, Full HD (1920 x 1080), 144Hz", "512 GB SSD", null, "i5, 12500H, 2.5GHz", null, null, null, "Dài 360.4 mm - Rộng 271.09 mm - Dày 25.9 mm - Nặng 2.5 kg", "Có đèn bàn phím", "Card rời, GTX 3050 4GB", "3 x USB 3.2, HDMI, Jack tai nghe 3.5 mm, LAN (RJ45), USB Type-C", "Vỏ nhựa", 2022);
				Product laptop13 = new Product("Dell Gaming G15 5511",13,1,27_690_000,100,15,"Không những mang đến cho người dùng hiệu năng ấn tượng nhờ con chip Intel thế hệ 11 tân tiến, laptop Dell Gaming G15 5511 i5 11400H (70266676) còn sở hữu thiết kế thời thượng, lôi cuốn, hứa hẹn sẽ là người cộng sự lý tưởng cùng bạn chinh phục mọi chiến trường.",2, "Windows 11 Home SL", "8 GB", "15.6 inch, Full HD (1920 x 1080), 120Hz", "512 GB SSD", null, "i5, 11400H, 2.7GHz", null, null, null, "Dài 357 mm - Rộng 272 mm - Dày 25 mm - Nặng 2.81 kg", "Có đèn bàn phím", "Card rời, GTX 3050 4GB", "3 x USB 3.2, HDMI, Jack tai nghe 3.5 mm, LAN (RJ45), USB Type-C", "Vỏ nhựa", 2021);
				Product laptop14 = new Product("Dell Gaming Alienware m15 R6",13,1,66_490_000,100,17,"Với phong cách thiết kế độc đáo cùng cấu hình vượt trội, laptop Dell Gaming Alienware m15 R6 i7 11800H (70272633) sẵn sàng đáp ứng hoàn hảo mọi tác vụ của một chiếc laptop đồ họa - kỹ thuật như thiết kế hay chiến game.",2, "Windows 11 Home SL", "32 GB", "15.6 inch, QHD (2560 x 1440), 240Hz", "1 TB SSD", null, "i7, 11800H, 2.30 GHz", null, null, null, "Dài 356 mm - Rộng 272 mm - Dày 19 mm - Nặng 2.69 kg", "Có đèn bàn phím", "Card rời, GTX 3070 8GB", "3 x USB 3.2, HDMI, Jack tai nghe 3.5 mm, LAN (RJ45), USB Type-C", "Vỏ nhựa", 2021);
				Product laptop15 = new Product("Dell Gaming G15 5515",13,1,25_990_000,100,0,"Bộ hiệu năng gây ấn tượng đến từ con chip AMD mạnh mẽ cùng thiết kế cá tính, nổi bật, laptop Dell Gaming G15 5515 R5 (P105F004DGR) sẽ đáp ứng tối ưu mọi nhu cầu từ các tác vụ văn phòng cơ bản đến những ứng dụng đồ họa, chơi game giải trí chuyên nghiệp.",2, "Windows 11 Home SL", "16 GB", "15.6 inch, Full HD (1920 x 1080), 120Hz", "512 GB SSD", null, "Ryzen 5, 5600H, 3.3GHz", null, null, null, "Dài 357.26 mm - Rộng 272.11 mm - Dày 26.9 mm - Nặng 2.8 kg", "Có đèn bàn phím", "Card rời, GTX 3050 4GB", "1 x USB 3.2, 2 x USB 2.0, HDMI, Jack tai nghe 3.5 mm, LAN (RJ45), USB Type-C", "Vỏ nhựa", 2021);
				Product laptop16 = new Product("Dell Gaming Alienware m15 R6",13,1,61_990_000,100,0,"Nhắc đến dòng laptop gaming, nhà Dell cũng đã sở hữu cho mình một siêu phẩm không thể bỏ qua là chiếc laptop Dell Alienware m15 R6 i7 (P109F001DBL) với card đồ hoạ RTX 3060 6 GB mạnh mẽ sẵn sàng cùng bạn chinh phục mọi thử thách chiến game.",2, "Windows 11 Home SL", "32 GB", "15.6 inch, Full HD (1920 x 1080), 165Hz", "1 TB SSD", null, "i7, 11800H, 2.30 GHz", null, null, null, "Dài 356.2 mm - Rộng 272.5 mm - Dày 19.2 mm - Nặng 2.69 kg", "Có đèn bàn phím", "Card rời, GTX 3060 6GB", "3 x USB 3.2, HDMI, Jack tai nghe 3.5 mm, LAN (RJ45), Thunderbolt 4 USB-C", "Vỏ kim loại", 2021);
				Product laptop17 = new Product("Lenovo Ideapad 1 11IGL05",11,3,8_990_000,100,30,"Laptop Lenovo Ideapad 1 11IGL05 N5030 (81VT006FVN) là chiếc laptop mỏng nhẹ và một mức giá lý tưởng mà phụ huynh có thể mua cho học sinh, con em. Đáp ứng tốt các tác vụ học tập trên các phần mềm Office, học trực tuyến hay giải trí cơ bản.",2, "Windows 11 Home SL", "4 GB", "11.6 inch, HD (1366 x 768)", "256 GB SSD", null, "Pentium, N5030, 1.1GHz", null, null, null, "Dài 288 mm - Rộng 200 mm - Dày 17.9 mm - Nặng 1.2 kg", null, "Card tích hợp, Intel UHD 605", "2 x USB 3.2, HDMI, Jack tai nghe 3.5 mm", "Vỏ nhựa", 2021);
				Product laptop18 = new Product("Lenovo IdeaPad Gaming 3 15IHU6",11,3,20_990_000,100,16,"Laptop Lenovo IdeaPad Gaming 3 15IHU6 i5 (82K10178VN) thật sự làm mình hài lòng khi với mức giá chưa đầy 20 triệu mà vẫn có thể cân được mọi tác vụ từ học tập, văn phòng đến chiến game giải trí nhờ con chip Intel Gen 11 kết hợp cùng card đồ họa NVIDIA GeForce GTX mạnh mẽ.",2, "Windows 11 Home SL", "8 GB", "15.6 inch, Full HD (1920 x 1080), 120Hz", "512 GB SSD", null, "i5, 11300H, 3.1GHz", null, null, null, "Dài 359.6 mm - Rộng 251.9 mm - Dày 24.2 mm - Nặng 2.25 kg", "Có đèn bàn phím", "Card rời, GTX 1650 4GB", "2 x USB 3.2, HDMI, Jack tai nghe 3.5 mm, LAN (RJ45), USB Type-C", "Vỏ nhựa", 2021);
				Product laptop19 = new Product("Lenovo IdeaPad 3 15IML05",11,3,12_590_000,100,26,"Thiết kế hiện đại, thanh lịch cùng những thông số kỹ thuật ổn định sẽ là các ưu điểm mà laptop Lenovo IdeaPad 3 15IML05 i3 (81WB01DYVN) sở hữu nhằm đáp ứng tốt mọi tác vụ học tập - văn phòng cơ bản cho học sinh, sinh viên hay nhân viên văn phòng. ",2, "Windows 11 Home SL", "4 GB", "15.6 inch, Full HD (1920 x 1080)", "256 GB SSD", null, "i3, 10110U, 2.1GHz", null, null, null, "Dài 362.2 mm - Rộng 253.4 mm - Dày 19.9 mm - Nặng 1.7 kg", null, "Card tích hợp, Intel UHD", "1 x USB 2.0, 2 x USB 3.2, HDMI, Jack tai nghe 3.5 mm", "Vỏ nhựa", 2022);
				Product laptop20 = new Product("Lenovo Ideapad 3 15ITL6",11,3,16_590_000,100,10,"Laptop Lenovo Ideapad 3 15ITL6 i5 (82H801P9VN) sở hữu thiết kế mỏng nhẹ cùng hiệu năng mạnh mẽ đến từ CPU Intel thế hệ thứ 11 là người bạn đồng hành lý tưởng cho học sinh, sinh viên hay nhân viên văn phòng.",2, "Windows 11 Home SL", "8 GB", "15.6 inch, Full HD (1920 x 1080)", "512 GB SSD", null, "i5, 1135G7, 2.4GHz", null, null, null, "Dài 359.2 mm - Rộng 236.5 mm - Dày 19.9 mm - Nặng 1.65 kg", null, "Card tích hợp, Intel Iris Xe", "1 x USB 2.0, 2 x USB 3.2, HDMI, Jack tai nghe 3.5 mm", "Vỏ nhựa", 2021);

				logger.info("insert data: " + productRepository.save(laptop1));
				logger.info("insert data: " + productRepository.save(laptop2));
				logger.info("insert data: " + productRepository.save(laptop3));
				logger.info("insert data: " + productRepository.save(laptop4));
				logger.info("insert data: " + productRepository.save(laptop5));
				logger.info("insert data: " + productRepository.save(laptop6));
				logger.info("insert data: " + productRepository.save(laptop7));
				logger.info("insert data: " + productRepository.save(laptop8));
				logger.info("insert data: " + productRepository.save(laptop9));
				logger.info("insert data: " + productRepository.save(laptop10));
				logger.info("insert data: " + productRepository.save(laptop11));
				logger.info("insert data: " + productRepository.save(laptop12));
				logger.info("insert data: " + productRepository.save(laptop13));
				logger.info("insert data: " + productRepository.save(laptop14));
				logger.info("insert data: " + productRepository.save(laptop15));
				logger.info("insert data: " + productRepository.save(laptop16));
				logger.info("insert data: " + productRepository.save(laptop17));
				logger.info("insert data: " + productRepository.save(laptop18));
				logger.info("insert data: " + productRepository.save(laptop19));
				logger.info("insert data: " + productRepository.save(laptop20));

				//smartwatch
				Product watch1 = new Product("Apple Watch SE 40mm viền nhôm dây silicone",16,1,8_990_000,101,20,"Apple Watch SE 40mm viền nhôm dây silicone hồng có thiết kế bo tròn 4 góc giúp thao tác vuốt chạm thoải mái hơn. Mặt kính cường lực Ion-X strengthened glass với kích thước 1.57 inch, hiển thị rõ ràng. Khung viền nhôm chắc chắn cùng dây đeo silicone có độ đàn hồi cao, êm ái, tạo cảm giác thoải mái khi đeo.",4, "WatchOS 7", null, "OLED, 1.57 inch",  "32GB", "Khoảng 1.5 ngày", "Apple S7", null, null, null, "Dài 40 mm - Ngang 34 mm - Dày 10.7 mm - Nặng 30.49g", "Chế độ luyện tập, Theo dõi giấc ngủ, Tính lượng calories tiêu thụ, Tính quãng đường chạy, Đo nhịp tim, Đếm số bước chân", null, null, null, 2020);
				Product watch2 = new Product("Apple Watch Series 7 GPS 41mm",16,1,11_990_000,101,10,"Thiết kế của Apple Watch S7 GPS 41 mm thừa hưởng nhiều nét tương đồng với người anh Apple Watch S6 nhưng các góc cạnh được vát tròn mềm mại hơn mang đến cho người đeo cảm giác thanh lịch nhưng không kém phần năng động. Chiếc smartwatch thế hệ thứ 7 được nhà Táo trang bị màn hình OLED 1.61 inch với viền màn hình mỏng hơn 40%, nâng diện tích màn hình lên 20% và nội dung hiển thị trên màn hình cũng nhiều hơn 50% so với thế hệ cũ.",4, "WatchOS 7", null, "OLED, 1.61 inch",  "32GB", "Khoảng 1.5 ngày", "Apple S7", null, null, null, "Dài 41 mm - Ngang 35 mm - Dày 10.7 mm - Nặng 32g", "Chế độ luyện tập, Theo dõi giấc ngủ, Tính lượng calories tiêu thụ, Tính quãng đường chạy, Điện tâm đồ, Đo nhịp tim, Đo nồng độ oxy (SpO2), Đếm số bước chân", null, null, null, 2021);
				Product watch3 = new Product("Apple Watch Series 7 LTE 41mm",16,1,14_990_000,101,13,"Apple Watch S7 LTE 41 mm viền nhôm dây silicone có thiết kế được nâng cấp hơn so với phiên bản tiền nhiệm. Sở hữu vẻ ngoài sang trọng và hiện đại, Apple Watch S7 được thiết kế các góc bo tròn mềm mại với mặt đồng hồ được vác cong tạo cảm giác liền mạch hơn với khung viền.",4, "WatchOS 7", null, "OLED, 1.61 inch", "32GB", "Khoảng 1.5 ngày", "Apple S7", null, null, null, "Dài 41 mm - Ngang 35 mm - Dày 10.7 mm - Nặng 32g", "Chế độ luyện tập, Theo dõi giấc ngủ, Tính lượng calories tiêu thụ, Tính quãng đường chạy, Điện tâm đồ, Đo nhịp tim, Đo nồng độ oxy (SpO2), Đếm số bước chân", null, null, null, 2021);
				Product watch4 = new Product("Apple Watch SE 44mm viền nhôm dây silicone ",16,1,9_990_000,101,20,"Apple Watch SE 44mm viền nhôm dây silicone có màn hình Retina 1.78 inch cùng độ phân giải 448 x 368 pixels giúp hiển thị thông tin và hình ảnh được rõ ràng và sắc nét. Dây đeo silicone có độ đàn hồi cao, tạo cảm giác thoải mái cho cổ tay khi làm việc và tập luyện thể thao. Thiết kế hình vuông bo tròn 4 góc, khá giống với phiên bản Series 5, mặt kính cong 2.5D tạo cảm giác vuốt và chạm mượt mà.",4, "WatchOS 7", null, "OLED, 1.78 inch", "32GB", "Khoảng 1.5 ngày", "Apple S5 64 bit", null, null, null, "Dài 44 mm - Ngang 38 mm - Dày 10.4 mm - Nặng 36.2g", "Chế độ luyện tập, Theo dõi giấc ngủ, Tính lượng calories tiêu thụ, Tính quãng đường chạy, Đo nhịp tim, Đếm số bước chân", null, null, null, 2020);
				Product watch5 = new Product("Samsung Galaxy Watch 4 40mm ",2,2,6_490_000,101,15,"Phiên bản đồng hồ Samsung Galaxy Watch 4 này được thiết kế đơn giản với mặt đồng hồ dạng tròn có đường kính 40 mm thường thấy ở đồng hồ thông minh tạo nên phong cách năng động, cuốn hút. Khung viền đồng hồ được làm từ chất liệu nhôm bền chắc, trọng lượng nhẹ. ",4, "One UI Watch", null, "SUPER AMOLED, 1.2 inch", "16GB", "Khoảng 1.5 ngày", "Exynos W920", null, null, null, "Dài 40.4 mm - Ngang 39.3 mm - Dày 9.8 mm - Nặng 26g", "Chế độ luyện tập, Theo dõi giấc ngủ, Tính lượng calories tiêu thụ, Tính quãng đường chạy, Điện tâm đồ, Đo nhịp tim, Đo nồng độ oxy (SpO2), Đếm số bước chân", null, null, null, 2020);
				Product watch6 = new Product("Samsung Galaxy Watch 4 Classic 42mm ",2,2,8_490_000,101,11,"Đồng hồ Samsung Galaxy Watch 4 Classic 42mm sở hữu khung viền làm từ thép không gỉ bền chắc và được chứng nhận độ bền MIL-STD-810G, cho khả năng chống ăn mòn tốt hơn trong những điều kiện thời tiết khác nhau. Chiếc đồng hồ điều hướng linh hoạt với vòng xoay bezel độc đáo tạo nên vẻ đẹp sang trọng vượt thời gian",4, "One UI Watch", null, "SUPER AMOLED, 1.2 inch", "16GB", "Khoảng 1.5 ngày", "Exynos W920", null, null, null, "Dài 41.5 mm - Ngang 41.5 mm - Dày 11.2 mm - Nặng 47 g", "Chế độ luyện tập, Theo dõi giấc ngủ, Tính lượng calories tiêu thụ, Tính quãng đường chạy, Điện tâm đồ, Đo nhịp tim, Đo nồng độ oxy (SpO2), Đếm số bước chân", null, null, null, 2021);
				Product watch7 = new Product("Samsung Galaxy Watch 4 LTE Classic 46mm",2,2,9_990_000,101,10,"Samsung Galaxy Watch 4 LTE Classic 46mm mang nét sang trọng, hiện đại cùng với bộ khung viền thép không gỉ cứng cáp, màn hình SUPER AMOLED được bao bọc bởi lớp kính cường lực Gorrilla Glass Dx+ bền bỉ, chịu lực tốt. Dây đeo silicone êm nhẹ, độ đàn hồi cao, không thấm nước, thiết kế đục lỗ cho người dùng sự thông thoáng khi mang.",4, "One UI Watch", null, "SUPER AMOLED, 1.4 inch", "16GB", "Khoảng 1.5 ngày", "Exynos W920", null, null, null,"Dài 45.5 mm - Ngang 45.5 mm - Dày 11 mm - Nặng 52g", "Chế độ luyện tập, Theo dõi giấc ngủ, Tính lượng calories tiêu thụ, Tính quãng đường chạy, Điện tâm đồ, Đo nhịp tim, Đo nồng độ oxy (SpO2), Đếm số bước chân", null, null, null, 2021);
				Product watch8 = new Product("Samsung Galaxy Watch Active 2 44mm viền thép dây da",2,2,9_990_000,101,0,"Đồng hồ thông minh Samsung Galaxy Watch Active 2 44mm là phiên bản có sự cải tiến về công nghệ để mang đến những trải nghiệm tốt nhất cho người dùng với nhiều tính năng chăm sóc sức khỏe, nhận cuộc gọi trực tiếp cũng như nhiều tính năng tiện ích khác.",4, "OS TIZEN", null, "SUPER AMOLED, 1.4 inch", "4 GB", "Khoảng 1.5 ngày", "Exynos 9110", null, null, null, "Dài 44 mm - Ngang 44 mm - Dày 10.9 mm - Nặng 42g", "Chế độ luyện tập, Theo dõi giấc ngủ, Tính lượng calories tiêu thụ, Tính quãng đường chạy, Điện tâm đồ, Đo nhịp tim, Đo nồng độ oxy (SpO2), Đếm số bước chân", null, null, null, 2021);
				Product watch9 = new Product("Đồng hồ thông minh Garmin Swim 2 dây silicone",17,6,5_990_000,101,0,"Đồng hồ thông minh Garmin Swim 2 dây silicone trắng với thiết kế mặt tròn đặc trưng, thể hiện sự năng động đầy trẻ trung. Dây đeo màu trắng tinh tế, tương phản với mặt đồng hồ, sử dụng chất liệu silicone mềm mại, ôm tay tốt và chống thấm nước nên đem lại sự thoải mái khi vận động, đặc biệt là các bộ môn thể thao dưới nước.",4, "Hãng không công bố", null, "MIP, 1.04 inch", "Hãng không công bố", "Khoảng 13 giờ khi sử dụng GPS,Khoảng 7 ngày", "Hãng không công bố", null, null, null, "Dài 42 mm - Ngang 42 mm - Dày 11.4 mm - Nặng 36g", "Các chỉ số khi bơi hồ, nguồn nước tự nhiên, Nhận dạng kiểu bơi, Theo dõi giấc ngủ, Theo dõi mức độ stress, Theo dõi sức khỏe và thể chất, Tính lượng calories tiêu thụ, Tính năng chạy bộ, đạp xe, Tính quãng đường chạy, Tính tuổi thể chất, Đo hiệu quả bơi (SWOLF), Đo nhịp tim cổ tay dưới nước, Đo tốc độ bơi, Đếm số bước chân", null, null, null, 2020);
				Product watch10 = new Product("Đồng hồ thông minh Garmin Forerunner 955 Solar dây silicone",17,6,15_290_000,101,0,"Garmin Forerunner 955 Solar sở hữu tất cả những tính năng phục vụ thể thao chuyên nghiệp cùng với việc được nâng cấp màn hình cảm ứng, chip GPS đa băng tần,... tích hợp sạc năng lượng mặt trời, hứa hẹn sẽ là một nâng cấp đáng giá cho người dùng.",4, "Hãng không công bố", null, "MIP, 1.2 inch", "32GB", "Khoảng 15 ngày (ở chế độ đồng hồ thông minh), Khoảng 42 giờ (Chế độ chỉ có GPS không có nhạc)", "Hãng không công bố", null, null, null, "Dài 46.5 mm - Ngang 46.5 mm - Dày 14.4 mm - Nặng 53g", "Nhắc nhở nhịp tim cao, thấp, Theo dõi chu kì kinh nguyệt, Theo dõi giấc ngủ, Theo dõi mức độ stress, Tính quãng đường chạy, Tính tuổi thể chất, Đa dạng hình thức luyện tập, Đo chỉ số năng lượng cơ thể, Đo lượng tiêu thụ oxy tối đa (VO2 max), Đo nhịp tim, Đo nồng độ oxy (SpO2), Đánh giá chỉ số trẻ hóa của cơ thể (Fitness Age), Đếm số bước chân", null, null, null, 2020);
				Product watch11 = new Product("Đồng hồ thông minh Garmin Venu SQ Music dây silicone",17,6,6_190_000,101,0,"Đồng hồ thông minh Garmin Venu SQ Music với kiểu dáng thời thượng, thiết kế sang trọng đầy hiện đại, phù hợp với mọi lứa tuổi và giới tính, từ sinh viên đến nhân viên văn phòng. Nhờ có khung polyme viền nhôm chịu lực tốt, công nghệ màn hình LCD hiện đại và lớp kính cường lực chắc chắn, bền bỉ.",4, "Hãng không công bố", null, "LCD, 1.3 inch", "Lưu trữ hơn 500 bài hát", "Khoảng 6 giờ khi sử dụng GPS, Khoảng 6 ngày", "Hãng không công bố", null, null, null, "Dài 40.6 mm - Ngang 37 mm - Dày 11.5 mm - Nặng 37.6g", "Nhắc nhở nhịp tim cao, thấp, Theo dõi chu kì kinh nguyệt, Theo dõi giấc ngủ, Theo dõi mức độ stress, Tính quãng đường chạy, Tính tuổi thể chất, Đa dạng hình thức luyện tập, Đo chỉ số năng lượng cơ thể, Đo lượng tiêu thụ oxy tối đa (VO2 max), Đo nhịp tim, Đo nồng độ oxy (SpO2), Đánh giá chỉ số trẻ hóa của cơ thể (Fitness Age), Đếm số bước chân", null, null, null, 2020);
				Product watch12 = new Product("Garmin MARQ Golfer dây Nylon xanh",17,6,49_990_000,101,0,"Đồng hồ thông minh Garmin MARQ Golfer dây Nylon xanh sở hữu kiểu dáng trẻ trung, năng động cùng khung viền titanium cứng cáp, sang trọng, bền bỉ dưới nhiều thời tiết khắc nghiệt. Dây đeo bằng chất liệu nylon dệt đem đến sự cá tính, năng động, cho cảm giác nhẹ nhàng, thông thoáng khi đeo.",4, "Hãng không công bố", null, "MIP, 1.2 inch", "32 GB", "Khoảng 12 ngày (ở chế độ đồng hồ thông minh), Khoảng 28 giờ khi sử dụng GPS", "Hãng không công bố", null, null, null, "Dài 46 mm - Ngang 46 mm - Dày 14.7 mm - Nặng 88g", "Nhắc nhở nhịp tim cao, thấp, Theo dõi chu kì kinh nguyệt, Theo dõi giấc ngủ, Theo dõi mức độ stress, Tính quãng đường chạy, Tính tuổi thể chất, Đa dạng hình thức luyện tập, Đo chỉ số năng lượng cơ thể, Đo lượng tiêu thụ oxy tối đa (VO2 max), Đo nhịp tim, Đo nồng độ oxy (SpO2), Đánh giá chỉ số trẻ hóa của cơ thể (Fitness Age), Đếm số bước chân", null, null, null, 2020);
				Product watch13 = new Product("Đồng hồ thông minh BeFit B4",18,7,890_000,101,0,"BeFit B4 đen là thế hệ đồng hồ thông minh mang ngôn ngữ thiết kế thời thượng, trang bị nhiều tính năng hữu ích, đây sẽ là một sản phẩm phù hợp cho người dùng muốn trải nghiệm những tính năng của một chiếc smartwatch với mức giá vô cùng hợp lý.",4, "Hãng không công bố", null, "TFT, 1.69 inch","Hãng không công bố", "Khoảng 7 ngày", "Hãng không công bố", null, null, null, "Dài 45 mm - Ngang 38.5 mm - Dày 8.9 mm - Nặng 38g", "Chế độ luyện tập, Nhiệt độ trên da, Nhắc nhở uống nước, Nhắc nhở ít vận động, Theo dõi giấc ngủ, Theo dõi nhịp tim 24h, Đo huyết áp, Đo nồng độ oxy (SpO2), Đếm số bước chân", null, null, null, 2022);
				Product watch14 = new Product("Đồng hồ thông minh BeFit BeU B3",18,7,1_190_000,101,0,"BeFit BeU B3 là thế hệ đồng hồ thông minh mới nhất được nhà BeU trình làng trong năm 2022. Mang ngôn ngữ thiết kế thời thượng cùng việc trang bị nhiều tính năng hữu ích, đây sẽ là một sản phẩm phù hợp cho người dùng muốn trải nghiệm những tính năng của một chiếc smartwatch với mức giá vô cùng hợp lý.",4, "Hãng không công bố", null, "TFT, 1.69 inch", "256 KB", "Khoảng 10 ngày (sử dụng trong điều kiện tiêu chuẩn)", "GOODIX5515", null, null, null, "Dài 45 mm - Ngang 38.5 mm - Dày 8.9 mm - Nặng 38g", "Chế độ luyện tập, Theo dõi giấc ngủ, Theo dõi nhịp thở, Đo huyết áp, Đo nhịp tim, Đo nồng độ oxy (SpO2)", null, null, null, 2022);
				Product watch15 = new Product("Đồng hồ thông minh BeU B1",18,7,690_000,101,0,"Đồng hồ thông minh BeU B1 Đen mang thiết kế trẻ trung phù hợp với những bạn trẻ theo đuổi phong cách đơn giản. Đồng hồ được trang bị màn hình 1.3 inch với độ phân giải 240 x 240 pixels giúp việc quan sát trở nên dễ dàng hơn.",4, "Hãng không công bố", null, "IPS, 1.3 inch", "256 KB", "Khoảng 7 ngày", "NRF52832", null, null, null, "Dài 39 mm - Ngang 33 mm - Dày 8 mm - Nặng 50g","Chế độ luyện tập, Theo dõi giấc ngủ, Theo dõi nhịp thở, Đo huyết áp, Đo nhịp tim, Đo nồng độ oxy (SpO2)",  null, null, null, 2022);
				Product watch16 = new Product("Đồng hồ thông minh BeU PT1 Hồng",18,7,990_000,101,10,"Đồng hồ thông minh BeU PT1 Hồng mang thiết kế sang trọng với mặt tròn cá tính. Bên cạnh đó, dây đeo silicone mềm nhẹ cùng thiết kế rãnh cho bạn cảm giác thông thoáng, dễ chịu khi mang suốt ngày dài.",4, "Hãng không công bố", null, "IPS, 1.3 inch", "8 MB", "Khoảng 5 ngày", "RTL8762C", null, null, null, "Dài 54 mm - Ngang 50 mm - Dày 6.8 mm - Nặng 48g","Chế độ luyện tập, Theo dõi giấc ngủ, Theo dõi nhịp thở, Đo huyết áp, Đo nhịp tim, Đo nồng độ oxy (SpO2)",  null, null, null, 2022);
				Product watch17 = new Product("Vòng đeo tay thông minh Mi Band 7",4,3,1_190_000,101,7,"Tháng 5/2022, Xiaomi đã cho ra mắt thế hệ smartband tiếp theo của mình mang tên Xiaomi Smart Band 7. Với những nâng cấp nhẹ về màn hình, tính năng sức khoẻ cũng như thêm nhiều chế độ luyện tập, đây là một sản phẩm đáng sở hữu dành cho những người dùng yêu thích sự nhỏ gọn của một thiết bị đeo tay thông minh nhưng vẫn có những tiện ích cơ bản, đủ dùng.",4, "Hãng không công bố", null, "AMOLED, 1.62 inch","Hãng không công bố", "Khoảng 14 ngày (ở chế độ cơ bản), Khoảng 7 ngày", "Hãng không công bố", null, null, null, "Dài 46.5 mm - Ngang 20.7 mm - Dày 12.25 mm - Nặng 13.5 g", "Chế độ luyện tập, Nhiệt độ trên da, Nhắc nhở uống nước, Theo dõi mức độ stress, Theo dõi giấc ngủ, Theo dõi nhịp tim 24h, Đo huyết áp, Đo nồng độ oxy (SpO2), Đếm số bước chân", null, null, null, 2022);
				Product watch18 = new Product("Đồng hồ thông minh Xiaomi Watch S1",4,3,5_990_000,101,8,"Xiaomi Watch S1 là chiếc smartwatch mới nhất được nhà Xiaomi cho ra mắt, với diện mạo vô cùng thanh lịch được nâng cấp về mặt thiết kế cũng như tính năng so với thế hệ trước.",4, "MIUI For Watch" ,null, "AMOLED, 1.43 inch","4 GB", "Khoảng 12 ngày", "BES2500BP", null, null, null,"Dài 46.5 mm - Ngang 46.5 mm - Dày 11 mm - Nặng 52g", "Chế độ luyện tập, Theo dõi chu kì kinh nguyệt, Theo dõi giấc ngủ, Theo dõi nhịp tim 24h, Đo huyết áp, Đo nồng độ oxy (SpO2), Đếm số bước chân", null, null, null, 2022);
				Product watch19 = new Product("Đồng hồ thông minh Xiaomi Watch S1 Active",4,3,4_490_000,101,5,"Vẫn mang một phong cách thiết kế năng động đậm chất thể thao nhưng được trang bị một màn hình có kích thước lớn hơn cùng việc hỗ trợ tần số quét 60 Hz, hệ điều hành MIUI được tuỳ biến riêng cho smartwatch, Xiaomi Watch S1 Active sẽ mang lại cho người dùng những trải nghiệm sử dụng mới mẻ hơn so với thế hệ tiền nhiệm.",4, "MIUI For Watch" ,null, "AMOLED, 1.43 inch","4 GB", "Khoảng 12 ngày", "BES2500BP", null, null, null,"Dài 47.3 mm - Ngang 46.5 mm - Dày 11 mm - Nặng 36g", "Chế độ luyện tập, Theo dõi chu kì kinh nguyệt, Theo dõi giấc ngủ, Theo dõi nhịp tim 24h, Đo huyết áp, Đo nồng độ oxy (SpO2), Đếm số bước chân", null, null, null, 2022);
				Product watch20 = new Product("Redmi Watch 2 Lite",4,3,1_490_000,101,10,"Redmi Watch 2 Lite sở hữu thiết kế màn hình lớn với kích thước 1.55 inch, tăng 10% diện tích so với bản tiền nhiệm Mi Watch Lite là 1.4 inch, được trang bị công nghệ màn hình TFT cùng độ phân giải 320 x 360 pixels hiển thị đa dạng màu sắc, hình ảnh rõ ràng, thoả mãn thị giác của bạn. Đồng thời, bạn có thể thay đổi giữa hơn 100 giao diện được thiết kế trong mặt đồng hồ tạo nên sự linh hoạt và đa dạng để phù hợp với trang phục hoặc tâm trạng mỗi ngày của bạn.",4, "Hãng không công bố" ,null, "TFT, 1.55 inch","Hãng không công bố", "Khoảng 10 ngày (sử dụng trong điều kiện tiêu chuẩn)", "Apollo 3.5", null, null, null,"Dài 41.2 mm - Ngang 35.3 mm - Dày 10.7 mm - Nặng 35 g", "Chế độ luyện tập, Theo dõi chu kì kinh nguyệt, Theo dõi giấc ngủ, Theo dõi nhịp tim 24h, Đo huyết áp, Đo nồng độ oxy (SpO2), Đếm số bước chân", null, null, null, 2021);

				logger.info("insert data: " + productRepository.save(watch1));
				logger.info("insert data: " + productRepository.save(watch2));
				logger.info("insert data: " + productRepository.save(watch3));
				logger.info("insert data: " + productRepository.save(watch4));
				logger.info("insert data: " + productRepository.save(watch5));
				logger.info("insert data: " + productRepository.save(watch6));
				logger.info("insert data: " + productRepository.save(watch7));
				logger.info("insert data: " + productRepository.save(watch8));
				logger.info("insert data: " + productRepository.save(watch9));
				logger.info("insert data: " + productRepository.save(watch10));
				logger.info("insert data: " + productRepository.save(watch11));
				logger.info("insert data: " + productRepository.save(watch12));
				logger.info("insert data: " + productRepository.save(watch13));
				logger.info("insert data: " + productRepository.save(watch14));
				logger.info("insert data: " + productRepository.save(watch15));
				logger.info("insert data: " + productRepository.save(watch16));
				logger.info("insert data: " + productRepository.save(watch17));
				logger.info("insert data: " + productRepository.save(watch18));
				logger.info("insert data: " + productRepository.save(watch19));
				logger.info("insert data: " + productRepository.save(watch20));

<<<<<<< HEAD
        Image image1 = new Image("tgdd_product/Iphone 11_0", "https://res.cloudinary.com/drwc3s5id/image/upload/v1660641583/tgdd_product/Iphone%2011_0.jpg", 1);
        Image image2 = new Image("tgdd_product/Iphone 11_1", "https://res.cloudinary.com/drwc3s5id/image/upload/v1660641621/tgdd_product/Iphone%2011_1.jpg", 1);
        Image image3 = new Image("tgdd_product/Iphone 11_2", "https://res.cloudinary.com/drwc3s5id/image/upload/v1660641662/tgdd_product/Iphone%2011_2.jpg", 1);
        Image image4 = new Image("tgdd_product/Iphone 13 Pro Max_0", "https://res.cloudinary.com/drwc3s5id/image/upload/v1660642510/tgdd_product/Iphone%2013%20Pro%20Max_0.jpg", 2);
        Image image5 = new Image("tgdd_product/Iphone 13 Pro Max_1", "https://res.cloudinary.com/drwc3s5id/image/upload/v1660642555/tgdd_product/Iphone%2013%20Pro%20Max_1.jpg", 2);
        Image image6 = new Image("tgdd_product/Iphone 13 Pro Max_2", "https://res.cloudinary.com/drwc3s5id/image/upload/v1660642597/tgdd_product/Iphone%2013%20Pro%20Max_2.jpg", 2);
				Image image7 = new Image("tgdd_product/Samsung Galaxy S22 Ultra_0", "https://res.cloudinary.com/drwc3s5id/image/upload/v1660642717/tgdd_product/Samsung%20Galaxy%20S22%20Ultra_0.jpg", 3);
				Image image8 = new Image("tgdd_product/Samsung Galaxy S22 Ultra_1", "https://res.cloudinary.com/drwc3s5id/image/upload/v1660642828/tgdd_product/Samsung%20Galaxy%20S22%20Ultra_1.jpg", 3);
				Image image9 = new Image("tgdd_product/Samsung Galaxy S22 Ultra_2", "https://res.cloudinary.com/drwc3s5id/image/upload/v1660642868/tgdd_product/Samsung%20Galaxy%20S22%20Ultra_2.jpg", 3);
				Image image10 = new Image("tgdd_product/iPad Pro M1 11 inch_0", "https://res.cloudinary.com/drwc3s5id/image/upload/v1660642963/tgdd_product/iPad%20Pro%20M1%2011%20inch_0.jpg", 21);
				Image image11 = new Image("tgdd_product/iPad Pro M1 11 inch_1", "https://res.cloudinary.com/drwc3s5id/image/upload/v1660643002/tgdd_product/iPad%20Pro%20M1%2011%20inch_1.jpg", 21);
				Image image12 = new Image("tgdd_product/iPad Pro M1 11 inch_2", "https://res.cloudinary.com/drwc3s5id/image/upload/v1660643043/tgdd_product/iPad%20Pro%20M1%2011%20inch_2.jpg", 21);
				Image image13 = new Image("tgdd_product/iPad Pro M1 12.9 inch_0", "https://res.cloudinary.com/drwc3s5id/image/upload/v1660643257/tgdd_product/iPad%20Pro%20M1%2012.9%20inch_0.jpg", 22);
				Image image14 = new Image("tgdd_product/iPad Pro M1 12.9 inch_1", "https://res.cloudinary.com/drwc3s5id/image/upload/v1660643302/tgdd_product/iPad%20Pro%20M1%2012.9%20inch_1.jpg", 22);
				Image image15 = new Image("tgdd_product/iPad Pro M1 12.9 inch_2", "https://res.cloudinary.com/drwc3s5id/image/upload/v1660643326/tgdd_product/iPad%20Pro%20M1%2012.9%20inch_2.jpg", 22);
				Image image16 = new Image("tgdd_product/iPad Air 5 M1_0", "https://res.cloudinary.com/drwc3s5id/image/upload/v1660643451/tgdd_product/iPad%20Air%205%20M1_0.jpg", 23);
				Image image17 = new Image("tgdd_product/iPad Air 5 M1_1", "https://res.cloudinary.com/drwc3s5id/image/upload/v1660643480/tgdd_product/iPad%20Air%205%20M1_1.jpg", 23);
				Image image18 = new Image("tgdd_product/iPad Air 5 M1_2", "https://res.cloudinary.com/drwc3s5id/image/upload/v1660643510/tgdd_product/iPad%20Air%205%20M1_2.jpg", 23);
				Image image19 = new Image("tgdd_product/Asus TUF Gaming FX506LHB_0", "https://res.cloudinary.com/drwc3s5id/image/upload/v1660643603/tgdd_product/Asus%20TUF%20Gaming%20FX506LHB_0.jpg", 41);
				Image image20 = new Image("tgdd_product/Asus TUF Gaming FX506LHB_1", "https://res.cloudinary.com/drwc3s5id/image/upload/v1660643652/tgdd_product/Asus%20TUF%20Gaming%20FX506LHB_1.jpg", 41);
				Image image21 = new Image("tgdd_product/Asus TUF Gaming FX506LHB_2", "https://res.cloudinary.com/drwc3s5id/image/upload/v1660643686/tgdd_product/Asus%20TUF%20Gaming%20FX506LHB_2.jpg", 41);
				Image image22 = new Image("tgdd_product/Asus ZenBook UX425EA_0", "https://res.cloudinary.com/drwc3s5id/image/upload/v1660643782/tgdd_product/Asus%20ZenBook%20UX425EA_0.jpg", 42);
				Image image23 = new Image("tgdd_product/Asus ZenBook UX425EA_1", "https://res.cloudinary.com/drwc3s5id/image/upload/v1660643811/tgdd_product/Asus%20ZenBook%20UX425EA_1.jpg", 42);
				Image image24 = new Image("tgdd_product/Asus ZenBook UX425EA_2", "https://res.cloudinary.com/drwc3s5id/image/upload/v1660643963/tgdd_product/Asus%20ZenBook%20UX425EA_2.jpg", 42);
				Image image25 = new Image("tgdd_product/Asus ZenBook UX425E_0", "https://res.cloudinary.com/drwc3s5id/image/upload/v1660644174/tgdd_product/Asus%20ZenBook%20UX425E_0.jpg", 44);
				Image image26 = new Image("tgdd_product/Asus ZenBook UX425E_1", "https://res.cloudinary.com/drwc3s5id/image/upload/v1660644204/tgdd_product/Asus%20ZenBook%20UX425E_1.jpg", 44);
				Image image27 = new Image("tgdd_product/Asus ZenBook UX425E_2", "https://res.cloudinary.com/drwc3s5id/image/upload/v1660644230/tgdd_product/Asus%20ZenBook%20UX425E_2.jpg", 44);
				Image image28 = new Image("tgdd_product/Apple Watch SE 40mm viền nhôm dây silicone_0", "https://res.cloudinary.com/drwc3s5id/image/upload/v1660644353/tgdd_product/Apple%20Watch%20SE%2040mm%20vi%E1%BB%81n%20nh%C3%B4m%20d%C3%A2y%20silicone_0.jpg", 61);
				Image image29 = new Image("tgdd_product/Apple Watch SE 40mm viền nhôm dây silicone_1", "https://res.cloudinary.com/drwc3s5id/image/upload/v1660644479/tgdd_product/Apple%20Watch%20SE%2040mm%20vi%E1%BB%81n%20nh%C3%B4m%20d%C3%A2y%20silicone_1.jpg", 61);
				Image image30 = new Image("tgdd_product/Apple Watch SE 40mm viền nhôm dây silicone_2", "https://res.cloudinary.com/drwc3s5id/image/upload/v1660644521/tgdd_product/Apple%20Watch%20SE%2040mm%20vi%E1%BB%81n%20nh%C3%B4m%20d%C3%A2y%20silicone_2.jpg", 61);
				Image image31 = new Image("tgdd_product/Apple Watch Series 7 GPS 41mm_0", "https://res.cloudinary.com/drwc3s5id/image/upload/v1660644586/tgdd_product/Apple%20Watch%20Series%207%20GPS%2041mm_0.jpg", 62);
				Image image32 = new Image("tgdd_product/Apple Watch Series 7 GPS 41mm_1", "https://res.cloudinary.com/drwc3s5id/image/upload/v1660644706/tgdd_product/Apple%20Watch%20Series%207%20GPS%2041mm_1.jpg", 62);
				Image image33 = new Image("tgdd_product/Apple Watch Series 7 GPS 41mm_2", "https://res.cloudinary.com/drwc3s5id/image/upload/v1660644737/tgdd_product/Apple%20Watch%20Series%207%20GPS%2041mm_2.jpg", 62);
				Image image34 = new Image("tgdd_product/Apple Watch Series 7 LTE 41mm_0", "https://res.cloudinary.com/drwc3s5id/image/upload/v1660644828/tgdd_product/Apple%20Watch%20Series%207%20LTE%2041mm_0.jpg", 63);
				Image image35 = new Image("tgdd_product/Apple Watch Series 7 LTE 41mm_1", "https://res.cloudinary.com/drwc3s5id/image/upload/v1660644873/tgdd_product/Apple%20Watch%20Series%207%20LTE%2041mm_1.jpg", 63);
				Image image36 = new Image("tgdd_product/Apple Watch Series 7 LTE 41mm_2", "https://res.cloudinary.com/drwc3s5id/image/upload/v1660644901/tgdd_product/Apple%20Watch%20Series%207%20LTE%2041mm_2.jpg", 63);
=======

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
>>>>>>> f0e5680ffb92b385bc636e0c721b87aff8f31f9e
        logger.info("insert data: " + imageRepository.save(image1));
        logger.info("insert data: " + imageRepository.save(image2));
        logger.info("insert data: " + imageRepository.save(image3));
        logger.info("insert data: " + imageRepository.save(image4));
        logger.info("insert data: " + imageRepository.save(image5));
        logger.info("insert data: " + imageRepository.save(image6));
				logger.info("insert data: " + imageRepository.save(image7));
				logger.info("insert data: " + imageRepository.save(image8));
				logger.info("insert data: " + imageRepository.save(image9));
				logger.info("insert data: " + imageRepository.save(image10));
				logger.info("insert data: " + imageRepository.save(image11));
				logger.info("insert data: " + imageRepository.save(image12));
				logger.info("insert data: " + imageRepository.save(image13));
				logger.info("insert data: " + imageRepository.save(image14));
				logger.info("insert data: " + imageRepository.save(image15));
				logger.info("insert data: " + imageRepository.save(image16));
				logger.info("insert data: " + imageRepository.save(image17));
				logger.info("insert data: " + imageRepository.save(image18));
				logger.info("insert data: " + imageRepository.save(image19));
				logger.info("insert data: " + imageRepository.save(image20));
				logger.info("insert data: " + imageRepository.save(image21));
				logger.info("insert data: " + imageRepository.save(image22));
				logger.info("insert data: " + imageRepository.save(image23));
				logger.info("insert data: " + imageRepository.save(image24));
				logger.info("insert data: " + imageRepository.save(image25));
				logger.info("insert data: " + imageRepository.save(image26));
				logger.info("insert data: " + imageRepository.save(image27));
				logger.info("insert data: " + imageRepository.save(image28));
				logger.info("insert data: " + imageRepository.save(image29));
				logger.info("insert data: " + imageRepository.save(image30));
				logger.info("insert data: " + imageRepository.save(image31));
				logger.info("insert data: " + imageRepository.save(image32));
				logger.info("insert data: " + imageRepository.save(image33));
				logger.info("insert data: " + imageRepository.save(image34));
				logger.info("insert data: " + imageRepository.save(image35));
				logger.info("insert data: " + imageRepository.save(image36));

        Video video1 = new Video("https://youtu.be/jtMHyn8uFDI", 2);
				Video video2 = new Video("https://youtu.be/XQMh9vPKTpg", 3);
				Video video3 = new Video("https://youtu.be/kd3Glk5qcgo", 23);
				Video video4 = new Video("https://youtu.be/oKRZYbG8Wes", 42);
				Video video5 = new Video("https://youtu.be/5QrPadPrDEw", 62);
				Video video6 = new Video("https://youtu.be/5QrPadPrDEw", 63);
        logger.info("insert data: " + videoRepository.save(video1));
				logger.info("insert data: " + videoRepository.save(video2));
				logger.info("insert data: " + videoRepository.save(video3));
				logger.info("insert data: " + videoRepository.save(video4));
				logger.info("insert data: " + videoRepository.save(video5));
				logger.info("insert data: " + videoRepository.save(video6));
				
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
