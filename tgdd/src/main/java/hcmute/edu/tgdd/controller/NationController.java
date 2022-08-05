package hcmute.edu.tgdd.controller;

import hcmute.edu.tgdd.model.Nation;
import hcmute.edu.tgdd.model.ResponseObject;
import hcmute.edu.tgdd.repository.NationRepository;
import hcmute.edu.tgdd.service.NationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(path = "/api/Nation")
public class NationController {
  @Autowired private NationService nationService;

  @GetMapping("")
  List<Nation> getNation() {
    return nationService.getAllNations();
  }

  @GetMapping("/{id}")
  ResponseObject findById(@PathVariable int id) {
    Optional<Nation> foundNation = nationService.findById(id);
    if (foundNation.isPresent()) {
      return new ResponseObject(HttpStatus.OK.toString(), "Query nation successfully", foundNation);
    } else {
      return new ResponseObject(
          HttpStatus.NOT_FOUND.toString(), "Cannot find product id with id = " + id, "");
    }
  }

  @PostMapping("/insert")
  ResponseObject insertNation(@RequestBody Nation nation) {
    // Check id exists or not
    // These codes are not working
    /*Optional<Nation> check = nationRepository.findById(nation.getId());
    if (!check.isPresent()) {
        return new ResponseObject(HttpStatus.NOT_IMPLEMENTED, "Nation has already existed", "");
    }*/

    // Add data
    List<Nation> foundNations = nationService.findByName(nation.getName().trim());
    if (foundNations.size() > 0) { // Check if the nation name is the same
      return new ResponseObject(
          HttpStatus.NOT_IMPLEMENTED.toString(), "Nation name already taken", "");
    }
    return new ResponseObject(
        HttpStatus.OK.toString(), "Insert nation successfully", nationService.save(nation));
  }

  @PutMapping("/{id}")
  // Update name of Nation
  ResponseObject updateNation(@RequestBody Nation newNation, @PathVariable int id) {
    // Check id exists or not
    Optional<Nation> foundNations = nationService.findById(id);
    if (!foundNations.isPresent()) {
      return new ResponseObject(HttpStatus.NOT_FOUND.toString(), "Nation does not exist", "");
    }

    // Execute update nation name
    Nation updatedNation =
        nationService
            .findById(id)
            .map(
                nation -> {
                  nation.setName(newNation.getName());
                  return nationService.save(nation);
                })
            .orElseGet(
                () -> {
                  newNation.setId(id);
                  return nationService.save(newNation);
                });
    return new ResponseObject(
        HttpStatus.OK.toString(), "Update nation successfully", updatedNation);
  }

  @DeleteMapping("/{id}")
  ResponseObject deleteNation(@PathVariable int id) {
    boolean exists = nationService.existsById(id);
    if (exists) { // Check id exists or not
      nationService.deleteById(id);
      return new ResponseObject(HttpStatus.OK.toString(), "Delete nation successfully", "");
    }
    return new ResponseObject(HttpStatus.NOT_FOUND.toString(), "Cannot find nation to delete", "");
  }
}
