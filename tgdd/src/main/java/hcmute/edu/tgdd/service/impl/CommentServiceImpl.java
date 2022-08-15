package hcmute.edu.tgdd.service.impl;

import hcmute.edu.tgdd.model.Comment;
import hcmute.edu.tgdd.repository.CommentRepository;
import hcmute.edu.tgdd.service.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CommentServiceImpl implements CommentService{

  @Autowired
  private CommentRepository commentRepository;

  @Override
  public List<Comment> getAllComment(){ return  commentRepository.findAll();}

  @Override
  public List<Comment> getCommentByProduct(Integer productId){ return  commentRepository.findAll();}

  @Override
  public Comment saveComment (Comment comment){
    return commentRepository.save(comment);
  }
  @Override
  public boolean existsById(Integer id) {
      return commentRepository.existsById(id);
  }
  @Override
  public void deleteById(Integer id) {
    commentRepository.deleteById(id);
  }
}
