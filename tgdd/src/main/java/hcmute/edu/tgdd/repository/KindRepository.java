package hcmute.edu.tgdd.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import hcmute.edu.tgdd.model.Kind;

public interface KindRepository extends JpaRepository<Kind, Integer>{
	List<Kind> findByNameIgnoreCase(String name);
}
