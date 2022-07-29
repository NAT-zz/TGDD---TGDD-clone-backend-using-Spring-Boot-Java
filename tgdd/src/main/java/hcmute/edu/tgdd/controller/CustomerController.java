package hcmute.edu.tgdd.controller;

import hcmute.edu.tgdd.model.Customer;
import hcmute.edu.tgdd.model.ResponseObjectHttpStatus;
import hcmute.edu.tgdd.repository.CustomerRepository;
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
    @Autowired private CustomerRepository customerRepository;

    @GetMapping("/CustomerList")
    List<Customer> getCustomer() {
        return customerRepository.findAll();
    }

    @GetMapping("/{phone}")
    ResponseObjectHttpStatus findById(@PathVariable String phone) {
        Optional<Customer> foundCustomer = customerRepository.findById(phone.trim());
        if (foundCustomer.isPresent()) {
            return new ResponseObjectHttpStatus(HttpStatus.OK, "Query customer successfully", foundCustomer);
        } else {
            return new ResponseObjectHttpStatus(HttpStatus.NOT_FOUND, "Cannot find product phone with phone = " + phone, "");
        }
    }

    @PostMapping("/insert")
    ResponseObjectHttpStatus insertCustomer(@RequestBody Customer customer) {
        // Check if phone number is null
        if(customer.getPhone() == null){
            return new ResponseObjectHttpStatus(HttpStatus.NOT_IMPLEMENTED, "Please enter your phone number", "");
        }

        // Check phone exists or not
        List<Customer> check = customerRepository.findByPhone(customer.getPhone().trim());
        if (check.size() > 0) {
            return new ResponseObjectHttpStatus(HttpStatus.NOT_IMPLEMENTED, "Customer has already exist", "");
        }

        // Check length of phone number (max = 10)
        if(customer.getPhone().length() > 10)
            return new ResponseObjectHttpStatus(HttpStatus.NOT_IMPLEMENTED, "Phone number is too long (max length = 10)", "");

        // Add data
        return new ResponseObjectHttpStatus(
                HttpStatus.OK, "Insert customer successfully", customerRepository.save(customer));
    }

    @PutMapping("/update/{phone}")
    ResponseObjectHttpStatus updateCustomer(@RequestBody Customer newCustomer, @PathVariable String phone) {
        // Check phone exists or not
        Optional<Customer> foundCustomers = customerRepository.findById(phone);
        if (!foundCustomers.isPresent()) {
            return new ResponseObjectHttpStatus(HttpStatus.NOT_FOUND, "Customer does not exist", "");
        }

        // Execute update customer name
        Customer updatedCustomer =
                customerRepository
                        .findById(phone)
                        .map(
                                customer -> {
                                    //customer.setPhone(newCustomer.getPhone());
                                    customer.setFullName(newCustomer.getFullName());
                                    customer.setAddress(newCustomer.getAddress());
                                    customer.setGender(newCustomer.isGender());
                                    return customerRepository.save(customer);
                                })
                        .orElseGet(
                                () -> {
                                    newCustomer.setPhone(phone);
                                    return customerRepository.save(newCustomer);
                                });
        return new ResponseObjectHttpStatus(HttpStatus.OK, "Update customer successfully", updatedCustomer);
    }

    @DeleteMapping("/delete/{phone}")
    ResponseObjectHttpStatus deleteCustomer(@PathVariable String phone) {
        boolean exists = customerRepository.existsById(phone);
        if (exists) { // Check phone exists or not
            customerRepository.deleteById(phone);
            return new ResponseObjectHttpStatus(HttpStatus.OK, "Delete customer successfully", "");
        }
        return new ResponseObjectHttpStatus(HttpStatus.NOT_FOUND, "Cannot find customer to delete", "");
    }
}
