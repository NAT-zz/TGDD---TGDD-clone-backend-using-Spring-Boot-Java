package hcmute.edu.tgdd.service.impl;

import com.cloudinary.Cloudinary;
import com.cloudinary.utils.ObjectUtils;
import hcmute.edu.tgdd.service.StorageService;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.Arrays;
import java.util.Map;
import java.util.Objects;

@Service
public class StorageServiceImpl implements StorageService {
  // Kiểm tra type của file có phải là ảnh kiểu png, jpg, jpeg, bmp
  @Override
  public boolean isImageFile(MultipartFile file) {
    return Arrays.asList(new String[] {"image/png","image/jpg","image/jpeg","image/bmp"})
        .contains(Objects.requireNonNull(file.getContentType()).trim().toLowerCase());
  }

  // Thông tin kết nối cloudinary
  @Override
  public Cloudinary cloudinary(){
    Cloudinary cloudinary = new Cloudinary(ObjectUtils.asMap(
        "cloud_name", "drwc3s5id",
        "api_key", "932855992229293",
        "api_secret", "XvZJzKUrgbttxZepD5mR4oXvM-U"));
    return cloudinary;
  }

  // Up ảnh lên cloudinary
  @Override
  public String saveImage(MultipartFile file, String fileName){
    Map r;
    try {
    // "resource_type","auto"  : tự động xác định kiểu file được up
    // "public_id","tgdd_image/" + fileName  : file được đưa lên cloudinary với tên là fileName và nằm trong folder tgdd_image
      r = this.cloudinary().uploader().upload(file.getBytes(), ObjectUtils.asMap("resource_type","auto","public_id","tgdd_product/" + fileName));
    } catch (IOException e) {
      throw new RuntimeException(e);
    }
    // Trả về url của ảnh, dùng để lưu lên db
    return (String) r.get("secure_url");
  }
}
