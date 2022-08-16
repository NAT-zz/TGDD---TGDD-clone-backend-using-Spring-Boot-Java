package hcmute.edu.tgdd.service;


import hcmute.edu.tgdd.model.Comment;

import java.util.List;

public interface CommentService {
  List<Comment> getAllComment();

  List<Comment> getCommentByProduct(Integer productId);

  Comment saveComment(Comment comment);

  boolean existsById(Integer id);

  void deleteById(Integer id);
}
