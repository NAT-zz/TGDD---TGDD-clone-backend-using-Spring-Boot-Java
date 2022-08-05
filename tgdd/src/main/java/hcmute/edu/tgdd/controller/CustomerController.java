package hcmute.edu.tgdd.controller;

import hcmute.edu.tgdd.model.Customer;
import hcmute.edu.tgdd.model.ResponseObject;
import hcmute.edu.tgdd.repository.CustomerRepository;
import hcmute.edu.tgdd.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(path = "/api/Customer")
public class CustomerController {
  @Autowired private CustomerService customerService;

  @GetMapping("")
  List<Customer> getCustomer() {
    return customerService.getAllCustomers();
  } // adjust here

  @GetMapping("/{phone}")
  ResponseObject findById(@PathVariable String phone) {
    List<Customer> foundCustomer = customerService.findByPhone(phone.trim());
    if (foundCustomer.size() > 0) {
      return new ResponseObject(
          HttpStatus.OK.toString(), "Query customer successfully", foundCustomer);
    } else {
      return new ResponseObject(
          HttpStatus.NOT_FOUND.toString(), "Cannot find product phone with phone = " + phone, "");
    }
  }

  @PostMapping("/insert")
  ResponseObject insertCustomer(@RequestBody Customer customer) {
    // Check if phone number is null
    if (customer.getPhone() == null) {
      return new ResponseObject(
          HttpStatus.NOT_IMPLEMENTED.toString(), "Please enter your phone number", "");
    }

    // Check phone exists or not
    List<Customer> check = customerService.findByPhone(customer.getPhone().trim()); // adjust here
    if (check.size() > 0) {
      return new ResponseObject(
          HttpStatus.NOT_IMPLEMENTED.toString(), "Customer has already exist", "");
    }

    // Check length of phone number (max = 10)
    if (customer.getPhone().length() > 10)
      return new ResponseObject(
          HttpStatus.NOT_IMPLEMENTED.toString(), "Phone number is too long (max length = 10)", "");

    // Add data
    return new ResponseObject(
        HttpStatus.OK.toString(), "Insert customer successfully", customerService.save(customer));
  }

  @PutMapping("/{phone}")
  ResponseObject updateCustomer(@RequestBody Customer newCustomer, @PathVariable String phone) {
    // Check phone exists or not
    // Optional<Customer> foundCustomers = customerRepository.findById(phone);
    List<Customer> foundCustomer = customerService.findByPhone(phone.trim()); // adjust here
    if (foundCustomer.size() == 0) {
      return new ResponseObject(HttpStatus.NOT_FOUND.toString(), "Customer does not exist", "");
    }

    // Execute update customer name
    Customer updatedCustomer =
        customerService
            .findById(phone)
            .map(
                customer -> {
                  // customer.setPhone(newCustomer.getPhone());
                  customer.setFullName(newCustomer.getFullName());
                  customer.setAddress(newCustomer.getAddress());
                  customer.setGender(newCustomer.isGender());
                  return customerService.save(customer);
                })
            .orElseGet(
                () -> {
                  newCustomer.setPhone(phone);
                  return customerService.save(newCustomer);
                });
    return new ResponseObject(
        HttpStatus.OK.toString(), "Update customer successfully", updatedCustomer);
  }

  @DeleteMapping("/{phone}")
  ResponseObject deleteCustomer(@PathVariable String phone) {
    boolean exists = customerService.existsByPhone(phone);
    if (exists) { // Check phone exists or not
      customerService.deleteByPhone(phone);
      return new ResponseObject(HttpStatus.OK.toString(), "Delete customer successfully", "");
    }
    return new ResponseObject(
        HttpStatus.NOT_FOUND.toString(), "Cannot find customer to delete", "");
  }
}
