package hcmute.edu.tgdd;

import hcmute.edu.tgdd.model.*;
import hcmute.edu.tgdd.repository.*;
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
          CustomerRepository customerRepository,
          AdminRepository adminRepository,
          KindRepository kindRepository,
          CartRepository cartRepository,
          CartDetailRepository cartDetailRepository,
          ProductRepository productRepository,
          StatusRepository statusRepository) {
    return new CommandLineRunner() {
      @Override
      public void run(String... args) throws Exception {
      /*  Company productA = new Company("SmartPhone");
        Company productB = new Company("TV");
        logger.info("insert data: " + companyRepository.save(productA));
        logger.info("insert data: " + companyRepository.save(productB));

        Nation naA = new Nation("nation1");
        Nation naB = new Nation("nation2");
        logger.info("insert data: " + nationRepository.save(naA));
        logger.info("insert data: " + nationRepository.save(naB));

        Customer cuA = new Customer("0123456", "A", "A", true);
        Customer cuB = new Customer("7891023", "B", "B", false);
        logger.info("insert data: " + customerRepository.save(cuA));
        logger.info("insert data: " + customerRepository.save(cuB));

        Admin adA = new Admin("admin a", "123", "nguyen van a", "012345", "HCM", "adminA@gmail.com");
        Admin adB = new Admin("admin b", "1234", "nguyen van b", "012354", "HN", "adminB@gmail.com");
        logger.info("insert data: " + adminRepository.save(adA));
        logger.info("insert data: " + adminRepository.save(adB));

        Kind kindA = new Kind("kind 01");
        Kind kindB = new Kind("kind 02");
        logger.info("insert data: " + kindRepository.save(kindA));
        logger.info("insert data: " + kindRepository.save(kindB));

        Cart cart1 = new Cart("0934033188", "giao nhanh", "Exxy3", 0);
        Cart cart2 = new Cart("0934099999", "giao nhanh 1", "REun6", 0);
        logger.info("insert data: " + cartRepository.save(cart1));
        logger.info("insert data: " + cartRepository.save(cart2));

        CartDetail cartDetail1 = new CartDetail(1, 5, 1);
        CartDetail cartDetail2 = new CartDetail(2, 2, 2);
        logger.info("insert data: " + cartDetailRepository.save(cartDetail1));
        logger.info("insert data: " + cartDetailRepository.save(cartDetail2));
        Product product1 = new Product("Iphone 13",1,1,1200,34,10,"iphone_13.png","iphone_13.mp4","Äáº¯t",1);
        Product product2 = new Product("Iphone 14",2,1,1200,34,10,"iphone_14.png","iphone_14.mp4","Äáº¯t",1);
        logger.info("insert data: " + productRepository.save(product1));
        logger.info("insert data: " + productRepository.save(product2));

        Status status1 = new Status("Chờ xác nhận");
        Status status2 = new Status("Đang giao");
        Status status3 = new Status("Đã nhận");
        Status status4 = new Status("Đã hủy");
        logger.info("insert data: " + statusRepository.save(status1));
        logger.info("insert data: " + statusRepository.save(status2));
        logger.info("insert data: " + statusRepository.save(status3));
        logger.info("insert data: " + statusRepository.save(status4));*/
      }
    };
  }
}
