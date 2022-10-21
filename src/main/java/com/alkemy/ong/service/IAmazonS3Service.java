package com.alkemy.ong.service;

import com.alkemy.ong.dto.MediaBasicDTO;
import org.springframework.web.multipart.MultipartFile;

public interface IAmazonS3Service {
    MediaBasicDTO uploadFile(MultipartFile file);
    String uploadFile(String base64, String fileName) throws Exception;
    void deleteFile(String fileUrl);
}
