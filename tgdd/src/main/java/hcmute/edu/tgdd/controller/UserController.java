package hcmute.edu.tgdd.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import hcmute.edu.tgdd.model.DataResponse;
import hcmute.edu.tgdd.model.User;
import hcmute.edu.tgdd.service.UserService;

@RestController
@RequestMapping(path = "/api/user")
public class UserController {
  @Autowired private UserService userService;
  
  // get all user
  @GetMapping("/getAllUsers")
  public ResponseEntity<DataResponse> getAll(){
		List<User> listAllUser = userService.getAllUser();
		return listAllUser.isEmpty() ?
				ResponseEntity.status(HttpStatus.NOT_FOUND).body(
						new DataResponse("400", "No user found", 400)) :
				ResponseEntity.ok().body(
						new DataResponse(listAllUser));
	}

  // find user by phone/id , name (phone for now)
  @GetMapping(value = {"/{phone}", "/{name}"})
	public ResponseEntity<DataResponse> findById(@PathVariable String phone) {
		Optional<User> foundUser = userService.findUserByPhone(phone);
		return foundUser.isPresent() ? 
			ResponseEntity.status(HttpStatus.OK).body(new DataResponse(foundUser)) :
			ResponseEntity.status(HttpStatus.NOT_FOUND).body(new DataResponse("400", "User not found with phone = " + phone, 400));
	}

  // insert new user
  @PostMapping("/insert")
  DataResponse insertUser(@RequestBody @Validated User user) {
    return new DataResponse(userService.insertNewUser(user));
  }

//  @PutMapping("/{phone}")
//  ResponseObject updateCustomer(@RequestBody Customer newCustomer, @PathVariable String phone) {
//    // Check phone exists or not
//    // Optional<Customer> foundCustomers = customerRepository.findById(phone);
//    List<Customer> foundCustomer = customerService.findByPhone(phone.trim()); // adjust here
//    if (foundCustomer.size() == 0) {
//      return new ResponseObject(HttpStatus.NOT_FOUND.toString(), "Customer does not exist", "");
//    }
//
//    // Execute update customer name
//    Customer updatedCustomer =
//        customerService
//            .findById(phone)
//            .map(
//                customer -> {
//                  // customer.setPhone(newCustomer.getPhone());
//                  customer.setFullName(newCustomer.getFullName());
//                  customer.setAddress(newCustomer.getAddress());
//                  customer.setGender(newCustomer.isGender());
//                  return customerService.save(customer);
//                })
//            .orElseGet(
//                () -> {
//                  newCustomer.setPhone(phone);
//                  return customerService.save(newCustomer);
//                });
//    return new ResponseObject(
//        HttpStatus.OK.toString(), "Update customer successfully", updatedCustomer);
//  }
//
//  @DeleteMapping("/{phone}")
//  ResponseObject deleteCustomer(@PathVariable String phone) {
//    boolean exists = customerService.existsByPhone(phone);
//    if (exists) { // Check phone exists or not
//      customerService.deleteByPhone(phone);
//      return new ResponseObject(HttpStatus.OK.toString(), "Delete customer successfully", "");
//    }
//    return new ResponseObject(
//        HttpStatus.NOT_FOUND.toString(), "Cannot find customer to delete", "");
//  }
//  
//  //admin
//  
//	//update only
//	@PutMapping("/{id}")
//	public ResponseObject updateAdmin(@RequestBody Admin newAdmin, @PathVariable int id){
//		Admin updateAdmin = null;
//		try
//		{
//			//updateAdmin = adminService.updateAdminById(newAdmin, id);
//		}catch (Exception e) {
//			return new ResponseObject("404 Not Found", "Admin not found or duplicate data" + id, "");
//		}
//		return new ResponseObject("200 Ok", "Admin updated", updateAdmin);
//	}
//	//delete
//	@DeleteMapping("/{id}")
//	public ResponseEntity<ResponseObject> deleteAdmin(@PathVariable int id) {
//		if (adminService.adminExistedById(id)) {
//			try {
//				adminService.deleteAdminById(id);
//			}
//			catch (Exception e) {
//				return ResponseEntity.status(HttpStatus.NOT_IMPLEMENTED).body(
//						new ResponseObject("501 Not Implemented", "Something went wrong", ""));
//			}
//			return ResponseEntity.ok().body(
//					new ResponseObject("200 Ok", "Admin deleted", ""));
//		}
//		return ResponseEntity.status(HttpStatus.NOT_FOUND).body(
//				new ResponseObject("404 Not Found", "Admin not found", ""));
//	}
  
}
