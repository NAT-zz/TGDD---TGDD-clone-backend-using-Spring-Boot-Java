package hcmute.edu.tgdd.controller;

import hcmute.edu.tgdd.model.Comment;
import hcmute.edu.tgdd.model.DataResponse;
import hcmute.edu.tgdd.service.impl.CommentServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Objects;

@RestController
@RequestMapping(path = "api/Comment")
public class CommentController {

  @Autowired
  private CommentServiceImpl commentService;


  @GetMapping()
  DataResponse getAllComment() {
    List<Comment> foundListComment = commentService.getAllComment();
    if (foundListComment.size() > 0) {
      return new DataResponse(foundListComment);
    }
    throw new RuntimeException("No Comment found");
  }
  @GetMapping("/product")
  DataResponse getCommentByProduct(@RequestParam Integer productId ){
    List<Comment> foundListComment = commentService.getCommentByProduct(productId);
    if (foundListComment.size() > 0) {
      return new DataResponse(foundListComment);
    }
    throw new RuntimeException("No Comment found");
  }
  @PostMapping("/insert")
  DataResponse insertStatus(@RequestBody @Validated Comment comment, BindingResult result){
    if(!result.hasErrors()){
      return new DataResponse(commentService.saveComment(comment));
    }
    else
      throw new RuntimeException(Objects.requireNonNull(result.getFieldError()).toString());
  }
  @DeleteMapping("/{id}")
  DataResponse deleteStatus(@PathVariable Integer id){
    boolean exists = commentService.existsById(id);
    if (exists) {
      commentService.deleteById(id);
      return new DataResponse("");

    }
    throw  new RuntimeException("Cannot find status to delete");
  }



}
