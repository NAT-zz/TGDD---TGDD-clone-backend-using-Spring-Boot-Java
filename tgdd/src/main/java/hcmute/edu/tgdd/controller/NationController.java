package hcmute.edu.tgdd.controller;

import hcmute.edu.tgdd.model.DataResponse;
import hcmute.edu.tgdd.model.Nation;
import hcmute.edu.tgdd.service.NationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(path = "/api/Nation")
public class NationController {
  @Autowired
  private NationService nationService;

  @GetMapping("")
  List<Nation> getNation() {
    return nationService.getAllNations();
  }

  @GetMapping("/{id}")
  DataResponse findById(@PathVariable int id) {
    Optional<Nation> foundNation = nationService.findById(id);
    if (foundNation.isPresent()) {
      return new DataResponse(foundNation);
    } else {
      throw new RuntimeException("Cannot find product id with id = " + id);
    }
  }

  @PostMapping("/insert")
  DataResponse insertNation(@RequestBody Nation nation) {
    // Add data
    List<Nation> foundNations = nationService.findByName(nation.getName().trim());
    if (foundNations.size() > 0) { // Check if the nation name is the same
      throw new RuntimeException("Nation name already taken");
    }
    return new DataResponse(nationService.save(nation));
  }

  @PutMapping("/{id}")
  // Update name of Nation
  DataResponse updateNation(@RequestBody Nation newNation, @PathVariable int id) {
    // Check id exists or not
    Optional<Nation> foundNations = nationService.findById(id);
    if (!foundNations.isPresent()) {
      throw new RuntimeException("Nation does not exist");
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
    return new DataResponse(updatedNation);
  }

  @DeleteMapping("/{id}")
  DataResponse deleteNation(@PathVariable int id) {
    boolean exists = nationService.existsById(id);
    if (exists) { // Check id exists or not
      nationService.deleteById(id);
      return new DataResponse("");
    }
    throw new RuntimeException("Cannot find nation to delete");
  }
}
