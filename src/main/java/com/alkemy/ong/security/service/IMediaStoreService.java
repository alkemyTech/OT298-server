package com.alkemy.ong.security.service;

import com.alkemy.ong.dto.MediaBasicDTO;
import org.springframework.web.multipart.MultipartFile;

public interface IMediaStoreService {
    MediaBasicDTO uploadFile(MultipartFile file);

    void deleteFile(String fileUrl);
}
