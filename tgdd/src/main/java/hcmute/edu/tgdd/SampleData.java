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

        Product product1 = new Product("Samsung Galaxy S22 Ultra",1,1,25_990_000,34,16,"mo ta",1, "Android 12", "8 GB", "Dynamic AMOLED 2X6.8 inch, Quad HD+ (2K+)", "128 GB", "5000 mAh, 45 W", "Snapdragon 8 Gen 1", "40 MP", "Main 108 MP & Secondary 12 MP, 10 MP, 10 MP", "2 Nano SIM or 1 Nano SIM + 1 eSIM, support 5G", null, null, null, null, null, 2021);
        Product product2 = new Product("Laptop Asus TUF Gaming FX506LHB",1,1,16_490_000,30,17,"mo ta 2",2, "Windows 11 Home SL", "8 GB", "15.6 inch, Full HD (1920 x 1080), 144Hz", "512 GB SSD", null, "i5, 10300H, 2.5GHz", null, null, null, "359 mm long - 256 mm wide - 24.9 mm thick - 2.3 kg", "Has keyboard light", "GTX 1650 4GB", "1x USB 3.2 Gen 2 Type-C support DisplayPort / power delivery / G-SYNC, 2 x USB 3.2, HDMI, Headphone jack 3.5 mm, LAN (RJ45), USB 2.0", "Plastic cover", 2021);
        Product product3 = new Product("Laptop Asus TUF Gaming FX517ZC",2,2,23_790_000,100,16,"mo ta 3",2, "Windows 11 Home SL", "8 GB", "15.6 inch, Full HD (1920 x 1080), 144Hz", "512 GB SSD", null, "i5, 12450H, 2GHz", null, null, null, "354 mm long - 251 mm wide - 20.7 mm thick - 2 kg", "Has keyboard light", "RTX 3050 4GB", "1x USB 3.2 Gen 2 Type-C support DisplayPort / power delivery / G-SYNC2 x USB 3.2, HDMI, Headphone jack 3.5 mmLAN (RJ45)Thunderbolt 4", "Plastic cover", 2022);
        Product product4 = new Product("Tablet Samsung Galaxy Tab S8",2,1,20_990_000,34,15,"mo ta",3, "Android 12", "8 GB", "11 inch, LTPS", "128 GB", "8000 mAh, 45 W", "Snapdragon 8 Gen 1", "12 MP", "Main 13 MP & Secondary 6 MP", "1 Nano SIM", null, null, null, null, null, 2021);
        Product product5 = new Product("Apple Watch SE 40mm",2,2,6_990_000,101,22,"mo ta",4, "IOS", null, "OLED1.57 inch", null, null, null, null, null, null, null, null, null, null, null, 2021);
        
        //Phone
        Product phone1 = new Product("Iphone 11",1,1,14_990_000,30,23,"Apple đã chính thức trình làng bộ 3 siêu phẩm iPhone 11, trong đó phiên bản iPhone 11 64GB có mức giá rẻ nhất nhưng vẫn được nâng cấp mạnh mẽ như iPhone Xr ra mắt trước đó.",1, "IOS 15", "4 GB", "IPS LCD6.1\"Liquid Retina", "64 GB", "3110 mAh, 18 W", "Apple A13 Bionic", "12 MP", "2 camera 12 MP", "1 Nano SIM & 1 eSIMHỗ trợ 4G", null, null, null, null, null, 2021);
        Product phone2 = new Product("Iphone 13 Pro Max",1,1,33_990_000,50,13,"Điện thoại iPhone 13 Pro Max 128 GB - siêu phẩm được mong chờ nhất ở nửa cuối năm 2021 đến từ Apple. Máy có thiết kế không mấy đột phá khi so với người tiền nhiệm, bên trong đây vẫn là một sản phẩm có màn hình siêu đẹp, tần số quét được nâng cấp lên 120 Hz mượt mà, cảm biến camera có kích thước lớn hơn, cùng hiệu năng mạnh mẽ với sức mạnh đến từ Apple A15 Bionic, sẵn sàng cùng bạn chinh phục mọi thử thách.",1, "IOS 15", "6 GB", "OLED6.7\"Super Retina XDR", "128 GB", "4352 mAh20 W", "Apple A15 Bionic", "12 MP", "3 camera 12 MP", "1 Nano SIM & 1 eSIMHỗ trợ 5G", null, null, null, null, null, 2022);
        Product phone15 = new Product("Iphone 13 Pro",1,1,30_990_000,10,12,"Mỗi lần ra mắt phiên bản mới là mỗi lần iPhone chiếm sóng trên khắp các mặt trận và lần này cái tên khiến vô số người \"sục sôi\" là iPhone 13 Pro, chiếc điện thoại thông minh vẫn giữ nguyên thiết kế cao cấp, cụm 3 camera được nâng cấp, cấu hình mạnh mẽ cùng thời lượng pin lớn ấn tượng. ",1, "IOS 15", "6 GB", "OLED6.1\"Super Retina XDR", "128 GB", "3095 mAh20 W", "Apple A15 Bionic", "12 MP", "3 camera 12 MP", "1 Nano SIM & 1 eSIMHỗ trợ 5G", null, null, null, null, null, 2021);
        Product phone16 = new Product("Iphone 13",1,1,24_990_000,10,15,"Trong khi sức hút đến từ bộ 4 phiên bản iPhone 12 vẫn chưa nguội đi, thì hãng điện thoại Apple đã mang đến cho người dùng một siêu phẩm mới iPhone 13 với nhiều cải tiến thú vị sẽ mang lại những trải nghiệm hấp dẫn nhất cho người dùng.",1, "IOS 15", "4 GB", "OLED6.1\"Super Retina XDR", "128 GB", "3240 mAh20 W", "Apple A15 Bionic", "12 MP", "2 camera 12 MP", "1 Nano SIM & 1 eSIMHỗ trợ 5G", null, null, null, null, null, 2021);
        Product phone17 = new Product("Iphone 13 mini",1,1,21_990_000,17,13,"iPhone 13 mini được Apple ra mắt với hàng loạt nâng cấp về cấu hình và các tính năng hữu ích, lại có thiết kế vừa vặn. Chiếc điện thoại này hứa hẹn là một thiết bị hoàn hảo hướng tới những khách hàng thích sự nhỏ gọn nhưng vẫn giữ được sự mạnh mẽ bên trong.",1, "IOS 15", "4 GB", "OLED5.4\"Super Retina XDR", "128 GB", "3240 mAh20 W", "Apple A15 Bionic", "12 MP", "2 camera 12 MP", "1 Nano SIM & 1 eSIMHỗ trợ 5G", null, null, null, null, null, 2021);
        Product phone18 = new Product("Iphone 12",1,1,19_990_000,25,12,"Trong những tháng cuối năm 2020, Apple đã chính thức giới thiệu đến người dùng cũng như iFan thế hệ iPhone 12 series mới với hàng loạt tính năng bứt phá, thiết kế được lột xác hoàn toàn, hiệu năng đầy mạnh mẽ và một trong số đó chính là iPhone 12 64GB.",1, "IOS 15", "4 GB", "OLED6.1\"Super Retina XDR", "64 GB", "2815 mAh20 W", "Apple A14 Bionic", "12 MP", "2 camera 12 MP", "1 Nano SIM & 1 eSIMHỗ trợ 5G", null, null, null, null, null, 2021);
        Product phone19 = new Product("Iphone 12 mini",1,1,20_990_000,26,28,"Apple tiếp tục khẳng định vị thế của mình khi cho ra mắt mẫu iPhone 12 series với nhiều điểm được tối ưu hơn, nâng cấp mạnh hơn. Trong đó, điện thoại iPhone 12 mini 128 GB được ví như là phiên bản thu nhỏ hơn là bản rút gọn với cấu hình không khác gì mấy anh lớn có mức giá hấp dẫn hơn.",1, "IOS 15", "4 GB", "OLED5.4\"Super Retina XDR", "128 GB", "2815 mAh20 W", "Apple A14 Bionic", "12 MP", "2 camera 12 MP", "1 Nano SIM & 1 eSIMHỗ trợ 5G", null, null, null, null, null, 2021);
        Product phone20 = new Product("Iphone SE",1,1,13_490_000,11,11,"Như vậy là sau bao ngày chờ đợi thì iPhone SE 64 GB (2022) cũng đã được giới thiệu tại sự kiện Apple Peek Performance. Thiết bị nổi bật với cấu hình mạnh mẽ, chạy chip hiện đại nhất của Apple hiện tại nhưng giá bán lại rất phải chăng.",1, "IOS 15", "4 GB", "IPS LCD4.7\"Retina HD", "64 GB", "2018 mAh20 W", "Apple A15 Bionic", "7 MP", "12 MP", "1 Nano SIM & 1 eSIMHỗ trợ 5G", null, null, null, null, null, 2021);
        
        Product phone3 = new Product("Samsung Galaxy S22 Ultra",2,2,25_990_000,34,16,"Galaxy S22 Ultra 5G chiếc smartphone cao cấp nhất trong bộ 3 Galaxy S22 series mà Samsung đã cho ra mắt. Tích hợp bút S Pen hoàn hảo trong thân máy, trang bị vi xử lý mạnh mẽ cho các tác vụ sử dụng vô cùng mượt mà và nổi bật hơn với cụm camera không viền độc đáo mang đậm dấu ấn riêng",1, "Android 12", "8 GB", "Dynamic AMOLED 2X6.8 inch, Quad HD+ (2K+)", "128 GB", "5000 mAh, 45 W", "Snapdragon 8 Gen 1", "40 MP", "Main 108 MP & Secondary 12 MP, 10 MP, 10 MP", "2 Nano SIM or 1 Nano SIM + 1 eSIM, support 5G", null, null, null, null, null, 2021);
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
        
        logger.info("insert data: " + productRepository.save(product1));
        logger.info("insert data: " + productRepository.save(product2));
        logger.info("insert data: " + productRepository.save(product3));
        logger.info("insert data: " + productRepository.save(product4));
        logger.info("insert data: " + productRepository.save(product5));

        Image image1 = new Image("tgdd_product/Samsung Galaxy S22 Ultra_0", "https://res.cloudinary.com/drwc3s5id/image/upload/v1660361517/tgdd_product/Samsung%20Galaxy%20S22%20Ultra_0.jpg", 1);
        Image image2 = new Image("tgdd_product/Samsung Galaxy S22 Ultra_1", "https://res.cloudinary.com/drwc3s5id/image/upload/v1660361613/tgdd_product/Samsung%20Galaxy%20S22%20Ultra_1.jpg", 1);
        Image image3 = new Image("tgdd_product/Samsung Galaxy S22 Ultra_2", "https://res.cloudinary.com/drwc3s5id/image/upload/v1660361622/tgdd_product/Samsung%20Galaxy%20S22%20Ultra_2.jpg", 1);
        Image image4 = new Image("tgdd_product/Laptop Asus TUF Gaming FX506LHB_0", "https://res.cloudinary.com/drwc3s5id/image/upload/v1660361632/tgdd_product/Laptop%20Asus%20TUF%20Gaming%20FX506LHB_0.jpg", 2);
        Image image5 = new Image("tgdd_product/Laptop Asus TUF Gaming FX506LHB_1", "https://res.cloudinary.com/drwc3s5id/image/upload/v1660361640/tgdd_product/Laptop%20Asus%20TUF%20Gaming%20FX506LHB_1.jpg", 2);
        Image image6 = new Image("tgdd_product/Laptop Asus TUF Gaming FX506LHB_2", "https://res.cloudinary.com/drwc3s5id/image/upload/v1660361648/tgdd_product/Laptop%20Asus%20TUF%20Gaming%20FX506LHB_2.jpg", 2);
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

        Comment comment1 = new Comment(1,"0869792657","Tạm được",3,"comment1.png");
        Comment comment2 = new Comment(2,"0869792657","Tạm được",4,"comment2.png");
        logger.info("insert data: " + commentRepository.save(comment1));
        logger.info("insert data: " + commentRepository.save(comment2));
      }
    };
  }
}
