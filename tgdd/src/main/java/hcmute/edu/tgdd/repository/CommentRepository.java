package hcmute.edu.tgdd.repository;

import hcmute.edu.tgdd.model.Comment;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CommentRepository extends JpaRepository<Comment, Integer> {
  List<Comment> findAllByProductId(Integer productId);
}
