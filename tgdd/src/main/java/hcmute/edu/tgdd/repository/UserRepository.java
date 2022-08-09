package hcmute.edu.tgdd.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import hcmute.edu.tgdd.model.User;

public interface UserRepository extends JpaRepository<User, String>{
	 List<User> findByPhone(String phone);
}
