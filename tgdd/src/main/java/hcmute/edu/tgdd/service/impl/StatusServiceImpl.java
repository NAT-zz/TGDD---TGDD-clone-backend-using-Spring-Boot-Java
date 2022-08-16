package hcmute.edu.tgdd.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import hcmute.edu.tgdd.model.Status;
import hcmute.edu.tgdd.repository.StatusRepository;
import hcmute.edu.tgdd.service.StatusService;

@Service
public class StatusServiceImpl implements StatusService{
	@Autowired
	private StatusRepository statusRepository;

	@Override
	public List<Status> getAllStatus() {
			return statusRepository.findAll();
	}

	@Override
	public Optional<Status> findById(Integer id){
			return statusRepository.findById(id);
	}

	@Override
	public List<Status> findByDescription(String description)
	{
			return statusRepository.findByDescription(description);
	}

	@Override
	public Status save(Status Status){
			return statusRepository.save(Status);
	}

	@Override
	public boolean existsById(Integer id){
			return statusRepository.existsById(id);
	}

	@Override
	public void deleteById(Integer id){
			statusRepository.deleteById(id);
	}
}
