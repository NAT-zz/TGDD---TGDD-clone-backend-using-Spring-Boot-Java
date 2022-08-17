package hcmute.edu.tgdd.service;


import hcmute.edu.tgdd.model.Comment;
import hcmute.edu.tgdd.model.Image;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

public interface CommentService {
  List<Comment> getAllComment();

  List<Comment> getCommentByProduct(Integer productId);

  Comment saveComment(Comment comment);

  Image uploadImage(Integer id, MultipartFile file);

  boolean existsById(Integer id);

  void deleteById(Integer id);
}
