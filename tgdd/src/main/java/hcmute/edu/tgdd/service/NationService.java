package hcmute.edu.tgdd.service;

import hcmute.edu.tgdd.model.Customer;
import hcmute.edu.tgdd.model.Nation;
import hcmute.edu.tgdd.repository.NationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public interface NationService {
  List<Nation> getAllNations();
  List<Nation> findByName(String name);
  Optional<Nation> findById(int id);
  Nation save(Nation nation);
  boolean existsById(int id);
  void deleteById(int id);
}
