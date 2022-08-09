package hcmute.edu.tgdd.service;

import java.util.List;
import java.util.Optional;

import hcmute.edu.tgdd.model.Status;

public interface StatusService {
	List<Status> getAllStatus();
	Optional<Status> findById(Integer id);
	List<Status> findByDescription(String description);
	Status save(Status Status);
	boolean existsById(Integer id);
	void deleteById(Integer id);
}
