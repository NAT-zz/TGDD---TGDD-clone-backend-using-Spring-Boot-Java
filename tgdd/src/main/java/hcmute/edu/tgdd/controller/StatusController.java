package hcmute.edu.tgdd.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import hcmute.edu.tgdd.model.DataResponse;
import hcmute.edu.tgdd.model.Status;
import hcmute.edu.tgdd.service.StatusService;

@RestController
@RequestMapping(path = "/api/Status")
public class StatusController {
    @Autowired
    private StatusService statusService;


    @GetMapping("")
        //    List<Status> getAllStatus() { return statusService.getAllStatus(); }
    DataResponse getAllStatus()
    {
        List<Status> listStatus = statusService.getAllStatus();
        //return new ResponseObject("0k","Get all status successfully",listStatus);
        return new DataResponse(listStatus);
    }

    @GetMapping("/{id}")
    DataResponse findById(@PathVariable Integer id) {
        Optional<Status> foundStatus = statusService.findById(id);
        if (foundStatus.isPresent())
            return new DataResponse(foundStatus);
        else
            throw new RuntimeException("Cannot find status with id = " + id);

    }
    @PostMapping("/insert")
    DataResponse insertStatus(@RequestBody Status status){
        List<Status> listStatus = statusService.findByDescription(status.getDescription().trim());
        if(listStatus.size() > 0){
            throw new RuntimeException("Status description already taken");
        }
        return new DataResponse(statusService.save(status));
    }

    @PutMapping("/{id}")
    DataResponse updateStatus(@RequestBody Status newStatus, @PathVariable Integer id){
        Status updateStatus = statusService.findById(id)
                .map(status -> {
                    status.setDescription(newStatus.getDescription());
                    return statusService.save(status);
                }).orElseGet(() -> {
                    newStatus.setId(id);
                    return statusService.save(newStatus);
                });
        return new DataResponse(updateStatus);
    }
    @DeleteMapping("/{id}")
    DataResponse deleteStatus(@PathVariable Integer id){
        boolean exists = statusService.existsById(id);
        if (exists) {
            statusService.deleteById(id);
            return new DataResponse("");

        }
        throw  new RuntimeException("Cannot find status to delete");
    }
}
