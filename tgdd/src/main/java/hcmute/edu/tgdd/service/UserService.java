package hcmute.edu.tgdd.service;

import java.util.List;
import java.util.Optional;

import hcmute.edu.tgdd.model.User;

public interface UserService {
	List<User> getAllUser();
	Optional<User> findUserByPhone(String phone);
	
	User insertNewUser(User user);
	User updateUserByPhone(User newUser, String phone);
	
	void deleteUserByPhone(String phone);
}
	
