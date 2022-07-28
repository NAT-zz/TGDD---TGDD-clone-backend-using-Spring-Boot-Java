package hcmute.edu.tgdd.service;

import hcmute.edu.tgdd.model.Status;
import hcmute.edu.tgdd.repository.StatusRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class StatusService {
    @Autowired
    private StatusRepository statusRepository;

    public StatusService() {
    }

    public StatusRepository getStatusRepository() {
        return statusRepository;
    }

    public void setStatusRepository(StatusRepository StatusRepository) {
        this.statusRepository = StatusRepository;
    }

    public List<Status> getAllStatus() {
        return statusRepository.findAll();
    }
    public Optional<Status> findById(Integer id){
        return statusRepository.findById(id);
    }
    public List<Status> findByDescription(String description)
    {
        return statusRepository.findByDescription(description);
    }
    public Status save(Status Status){
        return statusRepository.save(Status);
    }
    public boolean existsById(Integer id){
        return statusRepository.existsById(id);
    }
    public void deleteById(Integer id){
        statusRepository.deleteById(id);
    }

}
