package hcmute.edu.tgdd.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import hcmute.edu.tgdd.model.User;
import hcmute.edu.tgdd.repository.UserRepository;
import hcmute.edu.tgdd.service.UserService;

@Service
public class UserServiceImpl implements UserService{
	@Autowired
	private UserRepository userRepository;
	
	@Override
	public List<User> getAllUser() {
		return userRepository.findAll();
	}
	@Override
	public Optional<User> findUserByPhone(String phone) {
		return userRepository.findById(phone);
	}
	@Override
	public User insertNewUser(User user) {
		return userRepository.save(user);
	}
	@Override
	public User updateUserByPhone(User newUser, String phone) {
		User updatedUser = findUserByPhone(phone)
				.map(thisUser -> {
					thisUser.setFullname(newUser.getFullname());
					thisUser.setEmail(newUser.getEmail());
					thisUser.setPassword(newUser.getPassword());
					thisUser.setRole(newUser.getRole());
					thisUser.setAddress(newUser.getAddress());

					return insertNewUser(thisUser);
				}).orElseThrow();
		return updatedUser;
		return null;
	}
	@Override
	public void deleteUserByPhone(String phone) {
		userRepository.deleteById(phone);
	}
}
