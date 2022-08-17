package hcmute.edu.tgdd.service.impl;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.cloudinary.Cloudinary;
import com.cloudinary.utils.ObjectUtils;

import hcmute.edu.tgdd.model.Image;
import hcmute.edu.tgdd.model.Video;
import hcmute.edu.tgdd.repository.ImageRepository;
import hcmute.edu.tgdd.repository.VideoRepository;
import hcmute.edu.tgdd.service.StorageService;

@Service
public class StorageServiceImpl implements StorageService {
  @Autowired
  private ImageRepository imageRepository;
  @Autowired
  private VideoRepository videoRepository;

  // Info to connect to cloudinary
  @Override
  public Cloudinary cloudinary() {
    Cloudinary cloudinary = new Cloudinary(ObjectUtils.asMap(
        "cloud_name", "drwc3s5id",
        "api_key", "932855992229293",
        "api_secret", "XvZJzKUrgbttxZepD5mR4oXvM-U"));
    return cloudinary;
  }

  @Override
  public Image saveImage(Image image) {
    return imageRepository.save(image);
  }

  @Override
  public List<Image> findImageByProductId(Integer id) {
    return imageRepository.findByProductId(id);
  }

  @Override
  public List<Image> findImageByCommentId(Integer id) {
    return imageRepository.findByCommentId(id);
  }

  @Override
  public Optional<Image> findImageByFilePath(String filePath) {
    return imageRepository.findByFilePath(filePath);
  }

  // Check file type: image png, jpg, jpeg, bmp
  @Override
  public boolean isImage(MultipartFile file) {
    return Arrays.asList(new String[] {"image/png","image/jpg","image/jpeg","image/bmp"})
        .contains(Objects.requireNonNull(file.getContentType()).trim().toLowerCase());
  }

  // Upload image to cloudinary
  @Override
  public String uploadImage(MultipartFile file, String filePath) {
    Map r;
    try {
      // "resource_type","auto"  : auto define upload file type
      // "public_id",filePath  : file path of image
      r = this.cloudinary().uploader().upload(file.getBytes(), ObjectUtils.asMap("resource_type","auto","public_id",filePath));
    } catch (IOException e) {
      throw new RuntimeException(e);
    }
    // Return image url
    return (String) r.get("secure_url");
  }

  @Override
  public boolean deleteImage(String filePath) {
    return findImageByFilePath(filePath)
        .map(image -> {
          // delete image on cloudinary
          try {
            this.cloudinary().uploader().destroy(filePath, ObjectUtils.emptyMap());
          } catch (IOException e) {
            throw new RuntimeException(e);
          }

          // delete image on database
          imageRepository.deleteById(image.getId());
          return true;
        }).orElse(false);
  }

  @Override
  public Video saveVideo(Video video) {
    return videoRepository.save(video);
  }

  @Override
  public List<Video> findVideoByProductId(Integer id) {
    return videoRepository.findByProductId(id);
  }
}
