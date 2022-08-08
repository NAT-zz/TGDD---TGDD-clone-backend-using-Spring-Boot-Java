package hcmute.edu.tgdd.service.impl;

import hcmute.edu.tgdd.model.Nation;
import hcmute.edu.tgdd.repository.NationRepository;
import hcmute.edu.tgdd.service.NationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class NationServiceImpl implements NationService {
    @Autowired
    private NationRepository nationRepository;

    @Override
    public List<Nation> getAllNations() {
        return nationRepository.findAll();
    }

    @Override
    public List<Nation> findByName(String name) {
        return nationRepository.findByName(name);
    }

    @Override
    public Optional<Nation> findById(int id) {
        return nationRepository.findById(id);
    }

    @Override
    public Nation save(Nation nation) {
        return nationRepository.save(nation);
    }

    @Override
    public boolean existsById(int id) {
        return nationRepository.existsById(id);
    }

    @Override
    public void deleteById(int id) {
        nationRepository.deleteById(id);
    }
}
