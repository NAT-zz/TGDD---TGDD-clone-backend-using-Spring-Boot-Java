package hcmute.edu.tgdd.repository;

import hcmute.edu.tgdd.model.Video;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface VideoRepository extends JpaRepository<Video, Integer> {
  List<Video> findByProductId(Integer id);
}
