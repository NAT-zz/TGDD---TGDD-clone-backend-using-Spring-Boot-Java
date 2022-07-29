package hcmute.edu.tgdd.controllers;

import hcmute.edu.tgdd.model.Nation;
import hcmute.edu.tgdd.model.ResponseObjectHttpStatus;
import hcmute.edu.tgdd.repositiories.NationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(path = "/api/Nation")
public class NationController {
  @Autowired private NationRepository nationRepository;

  @GetMapping("/NationList")
  List<Nation> getNation() {
    return nationRepository.findAll();
  }

  @GetMapping("/{id}")
  ResponseObjectHttpStatus findById(@PathVariable int id) {
    Optional<Nation> foundNation = nationRepository.findById(id);
    if (foundNation.isPresent()) {
      return new ResponseObjectHttpStatus(HttpStatus.OK, "Query nation successfully", foundNation);
    } else {
      return new ResponseObjectHttpStatus(HttpStatus.NOT_FOUND, "Cannot find product id with id = " + id, "");
    }
  }

  @PostMapping("/insert")
  ResponseObjectHttpStatus insertNation(@RequestBody Nation nation) {
    // Check id exists or not
    // These codes are not working
    /*Optional<Nation> check = nationRepository.findById(nation.getId());
    if (!check.isPresent()) {
        return new ResponseObject(HttpStatus.NOT_IMPLEMENTED, "Nation has already existed", "");
    }*/

    // Add data
    List<Nation> foundNations = nationRepository.findByName(nation.getName().trim());
    if (foundNations.size() > 0) { // Check if the nation name is the same
      return new ResponseObjectHttpStatus(HttpStatus.NOT_IMPLEMENTED, "Nation name already taken", "");
    }
    return new ResponseObjectHttpStatus(
        HttpStatus.OK, "Insert nation successfully", nationRepository.save(nation));
  }

  @PutMapping("/update/{id}")
  // Update name of Nation
  ResponseObjectHttpStatus updateNation(@RequestBody Nation newNation, @PathVariable int id) {
    // Check id exists or not
    Optional<Nation> foundNations = nationRepository.findById(id);
    if (!foundNations.isPresent()) {
      return new ResponseObjectHttpStatus(HttpStatus.NOT_FOUND, "Nation does not exist", "");
    }

    // Execute update nation name
    Nation updatedNation =
        nationRepository
            .findById(id)
            .map(
                nation -> {
                  nation.setName(newNation.getName());
                  return nationRepository.save(nation);
                })
            .orElseGet(
                () -> {
                  newNation.setId(id);
                  return nationRepository.save(newNation);
                });
    return new ResponseObjectHttpStatus(HttpStatus.OK, "Update nation successfully", updatedNation);
  }

  @DeleteMapping("/delete/{id}")
  ResponseObjectHttpStatus deleteNation(@PathVariable int id) {
    boolean exists = nationRepository.existsById(id);
    if (exists) { // Check id exists or not
      nationRepository.deleteById(id);
      return new ResponseObjectHttpStatus(HttpStatus.OK, "Delete nation successfully", "");
    }
    return new ResponseObjectHttpStatus(HttpStatus.NOT_FOUND, "Cannot find nation to delete", "");
  }
}
