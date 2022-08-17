package hcmute.edu.tgdd.service;

import com.cloudinary.Cloudinary;
import hcmute.edu.tgdd.model.Image;
import hcmute.edu.tgdd.model.Video;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;
import java.util.Optional;

public interface StorageService {
  Cloudinary cloudinary();

  Image saveImage(Image image);

  List<Image> findImageByProductId(Integer id);

  List<Image> findImageByCommentId(Integer id);

  Optional<Image> findImageByFilePath(String filePath);

  boolean isImage(MultipartFile file);

  String uploadImage(MultipartFile file, String filePath);

  boolean deleteImage(String filePath);

  Video saveVideo(Video video);

  List<Video> findVideoByProductId(Integer id);
}
