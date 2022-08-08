package hcmute.edu.tgdd.controller;

import hcmute.edu.tgdd.model.Company;
import hcmute.edu.tgdd.model.ResponseObject;
import hcmute.edu.tgdd.service.impl.CompanyServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(path = "/api/Company")
public class CompanyController {
  @Autowired private CompanyServiceImpl companyService;

  @GetMapping("")
  List<Company> getCompany() {
    return companyService.getAllCompanies();
  }

  @GetMapping("/{id}")
  ResponseObject findById(@PathVariable int id) {
    Optional<Company> foundCompany = companyService.findById(id);
    if (foundCompany.isPresent()) {
      return new ResponseObject(
          HttpStatus.OK.toString(), "Query company successfully", foundCompany);
    } else {
      return new ResponseObject(
          HttpStatus.NOT_FOUND.toString(), "Cannot find product id with id = " + id, "");
    }
  }

  @PostMapping("/insert")
  ResponseObject insertCompany(@RequestBody Company company) {
    // Check id exists or not
    // These codes are not working
    /* Optional<Company> check = companyService.findById(company.getId());
    if (!check.isPresent()) {
      return new ResponseObject(HttpStatus.NOT_IMPLEMENTED, "Company has already existed", "");
    }*/

    // Add data
    List<Company> foundCompanies = companyService.findByName(company.getName().trim());
    if (foundCompanies.size() > 0) { // Check if the company name is the same
      return new ResponseObject(
          HttpStatus.NOT_IMPLEMENTED.toString(), "Company name already taken", "");
    }
    return new ResponseObject(
        HttpStatus.OK.toString(), "Insert company successfully", companyService.save(company));
  }

  @PutMapping("/{id}")
  // Update name of Company
  ResponseObject updateCompany(@RequestBody Company newCompany, @PathVariable int id) {
    // Check id exists or not
    Optional<Company> foundCompanies = companyService.findById(id);
    if (!foundCompanies.isPresent()) {
      return new ResponseObject(HttpStatus.NOT_FOUND.toString(), "Company does not exist", "");
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
    return new ResponseObject(
        HttpStatus.OK.toString(), "Update company successfully", updatedCompany);
  }

  @DeleteMapping("/{id}")
  ResponseObject deleteCompany(@PathVariable int id) {
    boolean exists = companyService.existsById(id);
    if (exists) { // Check id exists or not
      companyService.deleteById(id);
      return new ResponseObject(HttpStatus.OK.toString(), "Delete company successfully", "");
    }
    return new ResponseObject(HttpStatus.NOT_FOUND.toString(), "Cannot find company to delete", "");
  }
}
