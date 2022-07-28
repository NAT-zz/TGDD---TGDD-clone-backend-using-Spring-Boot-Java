package hcmute.edu.tgdd.repositiories;

import hcmute.edu.tgdd.model.Nation;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface NationRepository extends JpaRepository<Nation, Integer> {
    List<Nation> findByName(String name);
}
