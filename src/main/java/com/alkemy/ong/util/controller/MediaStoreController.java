package com.alkemy.ong.util.controller;

import com.alkemy.ong.dto.MediaBasicDTO;
import com.alkemy.ong.service.IMediaStoreService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

@RestController
@RequestMapping("/store")
public class MediaStoreController {

    @Autowired
    private IMediaStoreService mediaStoreService;

    @PostMapping("/uploadFile")
    public ResponseEntity<MediaBasicDTO> uploadFile(@RequestPart(value = "file") MultipartFile file) {
        return ResponseEntity.ok(mediaStoreService.uploadFile(file));
    }

    @DeleteMapping("/deleteFile")
    public ResponseEntity<Void> deleteFile(@RequestPart(value = "url") String fileUrl) {
        mediaStoreService.deleteFile(fileUrl);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);

    }
}
