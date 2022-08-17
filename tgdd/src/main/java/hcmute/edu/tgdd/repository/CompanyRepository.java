package hcmute.edu.tgdd.repository;

import hcmute.edu.tgdd.model.Company;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CompanyRepository extends JpaRepository<Company, Integer> {
    List<Company> findByName(String name);
}
