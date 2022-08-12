package hcmute.edu.tgdd.service;

import com.cloudinary.Cloudinary;
import org.springframework.web.multipart.MultipartFile;

public interface StorageService {
  boolean isImageFile(MultipartFile file);
  Cloudinary cloudinary();

  // Up ảnh lên cloudinary
  String saveImage(MultipartFile file, String fileName);
}
