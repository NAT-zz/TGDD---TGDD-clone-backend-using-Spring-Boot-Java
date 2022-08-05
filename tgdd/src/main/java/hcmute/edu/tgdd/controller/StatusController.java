package hcmute.edu.tgdd.controller;

import hcmute.edu.tgdd.model.DataResponse;
import hcmute.edu.tgdd.model.Status;
import hcmute.edu.tgdd.model.ResponseObject;
import hcmute.edu.tgdd.service.StatusService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

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
    ResponseObject insertStatus(@RequestBody Status status){
        List<Status> listStatus = statusService.findByDescription(status.getDescription().trim());
        if(listStatus.size() > 0){
            return new ResponseObject("Failed","Status description already taken ","");
        }
        return new ResponseObject("Ok","Insert status successfully",statusService.save(status));
    }

    @PutMapping("/{id}")
    ResponseObject updateStatus(@RequestBody Status newStatus, @PathVariable Integer id){
        Status updateStatus = statusService.findById(id)
                .map(status -> {
                    status.setDescription(newStatus.getDescription());
                    return statusService.save(status);
                }).orElseGet(() -> {
                    newStatus.setId(id);
                    return statusService.save(newStatus);
                });
        return new ResponseObject("Ok","Update status successfully",updateStatus);
    }
    @DeleteMapping("/{id}")
    ResponseObject deleteStatus(@PathVariable Integer id){
        boolean exists = statusService.existsById(id);
        if (exists) {
            statusService.deleteById(id);
            return new ResponseObject("Ok","Delete Status successfully","");

        }
        return new ResponseObject("Failed","Cannot find status to delete","");
    }
}
