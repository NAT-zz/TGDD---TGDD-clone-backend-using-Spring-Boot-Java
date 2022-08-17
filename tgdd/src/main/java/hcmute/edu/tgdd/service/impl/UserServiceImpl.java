package hcmute.edu.tgdd.service.impl;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Optional;

import hcmute.edu.tgdd.SampleData;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import hcmute.edu.tgdd.model.User;
import hcmute.edu.tgdd.repository.UserRepository;
import hcmute.edu.tgdd.service.UserService;

@Service
public class UserServiceImpl implements UserService, UserDetailsService{
	private static final Logger logger = LoggerFactory.getLogger(SampleData.class);
	
	@Autowired
	private PasswordEncoder passwordEncoder;
	
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
	public User findByPhone(String phone) {
		return userRepository.findByPhone(phone);
	}

	@Override
	public User insertNewUser(User user) {
		user.setPassword(passwordEncoder.encode(user.getPassword()));
		return userRepository.save(user);
	}

	@Override
	public User updateUserByPhone(User newUser, String phone){
		return findUserByPhone(phone)
				.map(thisUser -> {
					thisUser.setFullname(newUser.getFullname());
					thisUser.setEmail(newUser.getEmail());
					thisUser.setPassword(newUser.getPassword());
					thisUser.setRole(newUser.getRole());
					thisUser.setAddress(newUser.getAddress());
					thisUser.setGender(newUser.isGender());

					return insertNewUser(thisUser);
				}).orElseThrow();
	}

	@Override
	public void deleteUserByPhone(String phone) {
		userRepository.deleteById(phone);
	}

	@Override
	public boolean userExistedByPhone(String phone) {
		return userRepository.existsById(phone);
	}

	@Override
	public UserDetails loadUserByUsername(String phone) throws UsernameNotFoundException {
		User user = userRepository.findByPhone(phone);
		if (user == null) {
			throw new UsernameNotFoundException("User not found in the database");
		} else {
			logger.info("User found in the database: {}", phone);
		}

		Collection<SimpleGrantedAuthority> authorities = new ArrayList<>();		
		authorities.add(new SimpleGrantedAuthority(user.getRole().name()));
		return new org.springframework.security.core.userdetails.User(user.getPhone(), user.getPassword(), authorities);
	}
}
