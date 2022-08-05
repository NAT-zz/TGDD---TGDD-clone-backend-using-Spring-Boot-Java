package hcmute.edu.tgdd.service;

import hcmute.edu.tgdd.model.Customer;
import hcmute.edu.tgdd.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CustomerService {
  @Autowired private CustomerRepository customerRepository;

  public CustomerRepository getCustomerRepository() {
    return customerRepository;
  }

  public void setCustomerRepository(CustomerRepository customerRepository) {
    this.customerRepository = customerRepository;
  }

  public CustomerService() {}

  public CustomerService(CustomerRepository customerRepository) {
    this.customerRepository = customerRepository;
  }

  public List<Customer> getAllCustomers() {
    return customerRepository.findAll();
  }

  public List<Customer> findByPhone(String phone) {
    return customerRepository.findByPhone(phone);
  }

  public Optional<Customer> findById(String phone) {
    return customerRepository.findById(phone);
  }

  public Customer save(Customer customer) {
    return customerRepository.save(customer);
  }

  public boolean existsByPhone(String phone) {
    return customerRepository.existsById(phone);
  }

  public void deleteByPhone(String phone) {
    customerRepository.deleteById(phone);
  }
}
