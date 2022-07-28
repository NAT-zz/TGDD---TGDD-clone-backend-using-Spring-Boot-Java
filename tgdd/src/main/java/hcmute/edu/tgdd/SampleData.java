package hcmute.edu.tgdd;

import hcmute.edu.tgdd.model.Company;
import hcmute.edu.tgdd.model.Customer;
import hcmute.edu.tgdd.model.Nation;
import hcmute.edu.tgdd.repositiories.CompanyRepository;
import hcmute.edu.tgdd.repositiories.CustomerRepository;
import hcmute.edu.tgdd.repositiories.NationRepository;
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
      CustomerRepository customerRepository) {
    return new CommandLineRunner() {
      @Override
      public void run(String... args) throws Exception {
        Company productA = new Company("SmartPhone");
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
      }
    };
  }
}
