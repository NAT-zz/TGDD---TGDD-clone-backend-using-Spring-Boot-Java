package hcmute.edu.tgdd.repository;

import hcmute.edu.tgdd.model.Image;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface ImageRepository extends JpaRepository<Image, Integer> {
  List<Image> findByProductId(Integer id);
  List<Image> findByCommentId(Integer id);
  Optional<Image> findByFilePath(String filePath);
}
