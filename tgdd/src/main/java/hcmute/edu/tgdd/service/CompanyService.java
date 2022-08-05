package hcmute.edu.tgdd.service;

import hcmute.edu.tgdd.model.Company;
import hcmute.edu.tgdd.repository.CompanyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CompanyService {
  @Autowired private CompanyRepository companyRepository;

  public CompanyRepository getRepository() {
    return companyRepository;
  }

  public void setRepository(CompanyRepository repository) {
    this.companyRepository = repository;
  }

  public CompanyService() {}

  public CompanyService(CompanyRepository repository) {
    this.companyRepository = repository;
  }

  public List<Company> getAllCompanies() {
    return companyRepository.findAll();
  }

  public List<Company> findByName(String name) {
    return companyRepository.findByName(name);
  }

  public Optional<Company> findById(int id) {
    return companyRepository.findById(id);
  }

  public Company save(Company company) {
    return companyRepository.save(company);
  }

  public boolean existsById(int id) {
    return companyRepository.existsById(id);
  }

  public void deleteById(int id) {
    companyRepository.deleteById(id);
  }
}
