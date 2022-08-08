package hcmute.edu.tgdd.service.impl;

import hcmute.edu.tgdd.model.Company;
import hcmute.edu.tgdd.repository.CompanyRepository;
import hcmute.edu.tgdd.service.CompanyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CompanyServiceImpl implements CompanyService {
    @Autowired
    private CompanyRepository companyRepository;

    @Override
    public List<Company> getAllCompanies() {
        return companyRepository.findAll();
    }

    @Override
    public List<Company> findByName(String name) {
        return companyRepository.findByName(name);
    }

    @Override
    public Optional<Company> findById(int id) {
        return companyRepository.findById(id);
    }

    @Override
    public Company save(Company company) {
        return companyRepository.save(company);
    }

    @Override
    public boolean existsById(int id) {
        return companyRepository.existsById(id);
    }

    @Override
    public void deleteById(int id) {
        companyRepository.deleteById(id);
    }
}
