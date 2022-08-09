package hcmute.edu.tgdd.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import hcmute.edu.tgdd.model.Nation;

@Service
public interface NationService {
  List<Nation> getAllNations();
  List<Nation> findByName(String name);
  Optional<Nation> findById(int id);
  Nation save(Nation nation);
  boolean existsById(int id);
  void deleteById(int id);
}
