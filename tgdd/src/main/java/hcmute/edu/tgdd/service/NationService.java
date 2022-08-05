package hcmute.edu.tgdd.service;

import hcmute.edu.tgdd.model.Customer;
import hcmute.edu.tgdd.model.Nation;
import hcmute.edu.tgdd.repository.NationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class NationService {
  @Autowired private NationRepository nationRepository;

  public NationRepository getRepository() {
    return nationRepository;
  }

  public void setRepository(NationRepository repository) {
    this.nationRepository = repository;
  }

  public NationService() {}

  public NationService(NationRepository repository) {
    this.nationRepository = repository;
  }

  public List<Nation> getAllNations() {
    return nationRepository.findAll();
  }

  public List<Nation> findByName(String name) {
    return nationRepository.findByName(name);
  }

  public Optional<Nation> findById(int id) {
    return nationRepository.findById(id);
  }

  public Nation save(Nation nation) {
    return nationRepository.save(nation);
  }

  public boolean existsById(int id) {
    return nationRepository.existsById(id);
  }

  public void deleteById(int id) {
    nationRepository.deleteById(id);
  }
}
