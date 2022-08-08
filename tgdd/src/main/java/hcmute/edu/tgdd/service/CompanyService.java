package hcmute.edu.tgdd.service;

import hcmute.edu.tgdd.model.Company;
import hcmute.edu.tgdd.repository.CompanyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public interface CompanyService {
    List<Company> getAllCompanies();
    List<Company> findByName(String name);
    Optional<Company> findById(int id);
    Company save(Company company);
    boolean existsById(int id);
    void deleteById(int id);
}
