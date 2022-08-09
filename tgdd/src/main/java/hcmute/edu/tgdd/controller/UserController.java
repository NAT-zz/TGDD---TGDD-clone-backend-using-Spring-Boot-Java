package hcmute.edu.tgdd.controller;

import java.sql.SQLException;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
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
  public DataResponse getAll(){
		List<User> listAllUser = userService.getAllUser();
		return listAllUser.isEmpty() ?
				new DataResponse("400", "No user found", 400) :
			new DataResponse(listAllUser);
	}
	
// find user by phone/id , name (phone for now)
@GetMapping(value = {"/{phone}"})
public DataResponse findById(@PathVariable String phone) throws Exception{
	Optional<User> foundUser = userService.findUserByPhone(phone.trim());
	return foundUser.isPresent() ? 
		new DataResponse(foundUser) :
		new DataResponse("400", "User not found with phone = " + phone, 400);
	}

  // insert new user
  @PostMapping("/insert")
  DataResponse insertUser(@RequestBody @Validated User user, BindingResult result) {
      if(userService.userExistedByPhone(user.getPhone().trim())) {
          throw new RuntimeException("Phone already existed");
      }
      
	  if(!result.hasErrors())
		  return new DataResponse(userService.insertNewUser(user));
	  else
		  throw new RuntimeException(result.getFieldError().toString());
  }

	//update only
	@PutMapping("/{phone}")
	public DataResponse updateUser(@RequestBody @Validated User newUser, BindingResult result, @PathVariable String phone) {
		if(userService.userExistedByPhone(phone))
		{
			if(!result.hasErrors())	
				return new DataResponse(userService.updateUserByPhone(newUser, phone));
			return new DataResponse("400", "Data error", 200);
		}
		else
			throw new RuntimeException("User not found with phone: " + phone);
	}
	//delete
	@DeleteMapping("/{phone}")
	public DataResponse deleteUser(@PathVariable String phone) {
		if (userService.userExistedByPhone(phone)) {
			userService.deleteUserByPhone(phone);
			return new DataResponse("200", "User deleted", 200);
		}
		else throw new RuntimeException("User not found with phone: " + phone);
	}
}
