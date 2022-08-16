package hcmute.edu.tgdd.controller;

import java.io.IOException;
import java.util.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

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

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.interfaces.DecodedJWT;
import com.auth0.jwt.interfaces.JWTVerifier;
import com.fasterxml.jackson.core.exc.StreamWriteException;
import com.fasterxml.jackson.databind.DatabindException;
import com.fasterxml.jackson.databind.ObjectMapper;

import hcmute.edu.tgdd.model.DataResponse;
import hcmute.edu.tgdd.model.User;
import hcmute.edu.tgdd.service.UserService;

@RestController
@RequestMapping(path = "/api/user")
public class UserController {
  @Autowired
	private UserService userService;
  
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
		  throw new RuntimeException(Objects.requireNonNull(result.getFieldError()).toString());
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
	//get new token from refresh token
	@GetMapping("/token/refresh")
	public void refreshToken(HttpServletRequest request, HttpServletResponse response) throws StreamWriteException, DatabindException, IOException {
		String authorizationHeader = request.getHeader("Authorization");
		if(authorizationHeader!=null && authorizationHeader.startsWith("Bearer ")) {
				String refreshToken = authorizationHeader.substring("Bearer ".length());
				Algorithm algorithm = Algorithm.HMAC256("secret".getBytes());
				
				JWTVerifier verifier = JWT.require(algorithm).build();
				DecodedJWT decodedJWT = verifier.verify(refreshToken);
				String username = decodedJWT.getSubject();
				User user = userService.findByPhone(username);
				
				String accessToken = JWT.create()
						.withSubject(user.getPhone())
						.withExpiresAt(new Date(System.currentTimeMillis() + 2 * 60 * 1000))
						.withIssuer(request.getRequestURL().toString())
						.withClaim("roles", Collections.singletonList(user.getRole().toString()))
						.sign(algorithm);
				
				Map<String, String> tokens = new HashMap<>();
				tokens.put("access_token", accessToken);
				tokens.put("refresh_token", refreshToken);
				
				response.setContentType("application/json");
				new ObjectMapper().writeValue(response.getOutputStream(), tokens);
		}
		else {
			throw new RuntimeException("Refresh token is missing");
		}
	}
}
