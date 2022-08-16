package hcmute.edu.tgdd.controller;

import hcmute.edu.tgdd.model.Company;
import hcmute.edu.tgdd.model.DataResponse;
import hcmute.edu.tgdd.service.CompanyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(path = "/api/Company")
public class CompanyController {
  @Autowired private CompanyService companyService;

  @GetMapping("")
  List<Company> getCompany() {
    return companyService.getAllCompanies();
  }

  @GetMapping("/{id}")
  DataResponse findById(@PathVariable int id) {
    Optional<Company> foundCompany = companyService.findById(id);
    if (foundCompany.isPresent()) {
      return new DataResponse(foundCompany);
    } else {
      throw new RuntimeException("Cannot find product id with id = " + id);
    }
  }

  @PostMapping("/insert")
  DataResponse insertCompany(@RequestBody Company company) {
    // Add data
    List<Company> foundCompanies = companyService.findByName(company.getName().trim());
    if (foundCompanies.size() > 0) { // Check if the company name is the same
      throw new RuntimeException("Company name already taken");
    }
    return new DataResponse(companyService.save(company));
  }

  @PutMapping("/{id}")
  // Update name of Company
  DataResponse updateCompany(@RequestBody Company newCompany, @PathVariable int id) {
    // Check id exists or not
    Optional<Company> foundCompanies = companyService.findById(id);
    if (!foundCompanies.isPresent()) {
      throw new RuntimeException("Company does not exist");
    }

    // Execute update company name
    Company updatedCompany =
        companyService
            .findById(id)
            .map(
                company -> {
                  company.setName(newCompany.getName());
                  return companyService.save(company);
                })
            .orElseGet(
                () -> {
                  newCompany.setId(id);
                  return companyService.save(newCompany);
                });
    return new DataResponse(updatedCompany);
  }

  @DeleteMapping("/{id}")
  DataResponse deleteCompany(@PathVariable int id) {
    boolean exists = companyService.existsById(id);
    if (exists) { // Check id exists or not
      companyService.deleteById(id);
      return new DataResponse("");
    }
    throw new RuntimeException("Cannot find company to delete");
  }
}
