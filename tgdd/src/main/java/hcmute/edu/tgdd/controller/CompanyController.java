package hcmute.edu.tgdd.controller;

import hcmute.edu.tgdd.model.Company;
import hcmute.edu.tgdd.model.ResponseObjectHttpStatus;
import hcmute.edu.tgdd.repository.CompanyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(path = "/api/Company")
public class CompanyController {
  @Autowired private CompanyRepository companyRepository;

  @GetMapping("/CompanyList")
  List<Company> getCompany() {
    return companyRepository.findAll();
  }

  @GetMapping("/{id}")
  ResponseObjectHttpStatus findById(@PathVariable int id) {
    Optional<Company> foundCompany = companyRepository.findById(id);
    if (foundCompany.isPresent()) {
      return new ResponseObjectHttpStatus(HttpStatus.OK, "Query company successfully", foundCompany);
    } else {
      return new ResponseObjectHttpStatus(HttpStatus.NOT_FOUND, "Cannot find product id with id = " + id, "");
    }
  }

  @PostMapping("/insert")
  ResponseObjectHttpStatus insertCompany(@RequestBody Company company) {
    // Check id exists or not
    // These codes are not working
    /* Optional<Company> check = companyRepository.findById(company.getId());
    if (!check.isPresent()) {
      return new ResponseObject(HttpStatus.NOT_IMPLEMENTED, "Company has already existed", "");
    }*/

    // Add data
    List<Company> foundCompanys = companyRepository.findByName(company.getName().trim());
    if (foundCompanys.size() > 0) { // Check if the company name is the same
      return new ResponseObjectHttpStatus(HttpStatus.NOT_IMPLEMENTED, "Company name already taken", "");
    }
    return new ResponseObjectHttpStatus(
        HttpStatus.OK, "Insert company successfully", companyRepository.save(company));
  }

  @PutMapping("/update/{id}")
  // Update name of Company
  ResponseObjectHttpStatus updateCompany(@RequestBody Company newCompany, @PathVariable int id) {
    // Check id exists or not
    Optional<Company> foundCompanys = companyRepository.findById(id);
    if (!foundCompanys.isPresent()) {
      return new ResponseObjectHttpStatus(HttpStatus.NOT_FOUND, "Company does not exist", "");
    }

    // Execute update company name
    Company updatedCompany =
        companyRepository
            .findById(id)
            .map(
                company -> {
                  company.setName(newCompany.getName());
                  return companyRepository.save(company);
                })
            .orElseGet(
                () -> {
                  newCompany.setId(id);
                  return companyRepository.save(newCompany);
                });
    return new ResponseObjectHttpStatus(HttpStatus.OK, "Update company successfully", updatedCompany);
  }

  @DeleteMapping("/delete/{id}")
  ResponseObjectHttpStatus deleteCompany(@PathVariable int id) {
    boolean exists = companyRepository.existsById(id);
    if (exists) { // Check id exists or not
      companyRepository.deleteById(id);
      return new ResponseObjectHttpStatus(HttpStatus.OK, "Delete company successfully", "");
    }
    return new ResponseObjectHttpStatus(HttpStatus.NOT_FOUND, "Cannot find company to delete", "");
  }
}
