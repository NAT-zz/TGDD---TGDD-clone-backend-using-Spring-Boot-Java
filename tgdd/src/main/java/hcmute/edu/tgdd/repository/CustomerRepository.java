package hcmute.edu.tgdd.repository;

import hcmute.edu.tgdd.model.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CustomerRepository extends JpaRepository<Customer, String> {
    List<Customer> findByPhone(String phone);
}
