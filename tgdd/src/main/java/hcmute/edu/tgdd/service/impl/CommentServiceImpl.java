package hcmute.edu.tgdd.service.impl;

import hcmute.edu.tgdd.model.Comment;
import hcmute.edu.tgdd.model.Image;
import hcmute.edu.tgdd.repository.CommentRepository;
import hcmute.edu.tgdd.service.CommentService;
import hcmute.edu.tgdd.service.StorageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@Service
public class CommentServiceImpl implements CommentService{
  @Autowired
  private CommentRepository commentRepository;
  @Autowired
  private StorageService storageService;

  @Override
  public List<Comment> getAllComment() {
    return  commentRepository.findAll();
  }

  @Override
  public List<Comment> getCommentByProduct(Integer productId) {
    return commentRepository.findAllByProductId(productId);
  }

  @Override
  public Comment saveComment(Comment comment) {
    return commentRepository.save(comment);
  }

  @Override
  public Image uploadImage(Integer id, MultipartFile file) {
    if (!storageService.isImage(file)) {
      throw new RuntimeException("The file is not an image");
    }

    List<Image> images = storageService.findImageByCommentId(id);
    String url = storageService.uploadImage(file, "tgdd_comment/" + id + "_" + images.size());

    if (url.equals("")) {
      throw new RuntimeException("Fail to upload image");
    }

    Image image = new Image("tgdd_comment/" + id + "_" + images.size(), url, 0, id);
    return storageService.saveImage(image);
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
