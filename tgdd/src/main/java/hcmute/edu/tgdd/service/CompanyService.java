package hcmute.edu.tgdd.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import hcmute.edu.tgdd.model.Company;

@Service
public interface CompanyService {
    List<Company> getAllCompanies();

    List<Company> findByName(String name);

    Optional<Company> findById(int id);

    Company save(Company company);

    boolean existsById(int id);

    void deleteById(int id);
}
