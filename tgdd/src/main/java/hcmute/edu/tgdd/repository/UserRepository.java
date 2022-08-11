package hcmute.edu.tgdd.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import hcmute.edu.tgdd.model.User;

public interface UserRepository extends JpaRepository<User, String>{
	 User findByPhone(String phone);
}
