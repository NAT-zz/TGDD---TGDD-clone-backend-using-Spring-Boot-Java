package hcmute.edu.tgdd.repository;
import hcmute.edu.tgdd.model.Status;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface StatusRepository extends JpaRepository<Status, Integer> {
    List<Status> findByDescription(String description);
}

