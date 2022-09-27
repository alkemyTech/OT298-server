package com.alkemy.ong.security.service.impl;

import com.alkemy.ong.dto.MediaBasicDTO;
import com.alkemy.ong.security.service.IMediaStoreService;
import com.alkemy.ong.util.FileUtil;
import com.amazonaws.auth.AWSCredentials;
import com.amazonaws.auth.AWSStaticCredentialsProvider;
import com.amazonaws.auth.BasicAWSCredentials;
import com.amazonaws.services.s3.AmazonS3;
import com.amazonaws.services.s3.AmazonS3ClientBuilder;
import com.amazonaws.services.s3.model.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;


@Service
public class MediaStoreServiceImpl implements IMediaStoreService {

    @Value("${amazonProperties.bucketName}")
    private String bucketName;

    @Value("${amazonProperties.accessKey}")
    private String accessKey;

    @Value("${amazonProperties.secretKey}")
    private String secretKey;

    @Value("${amazonProperties.region}")
    private String region;

    @Autowired
    private AmazonS3 s3Client;

    public MediaBasicDTO uploadFile(MultipartFile file) {
        String fileName = FileUtil.createFileName(file);
        File fileObj = FileUtil.convertMultipartFileToFile(file);
        s3Client.putObject(new PutObjectRequest(bucketName, fileName, fileObj));
        String fileUrl = s3Client.getUrl(bucketName, fileName).toString();
        fileObj.delete();
        MediaBasicDTO dto = new MediaBasicDTO(fileName, fileUrl);
        return dto;
    }

    public void deleteFile(String fileUrl) {
        String fileName = fileUrl.substring(fileUrl.lastIndexOf("/") + 1);
        s3Client.deleteObject(new DeleteObjectRequest(bucketName, fileName));
        s3Client.deleteObject(bucketName, fileName);
    }

    @Bean
    public AmazonS3 s3Client() {
        AWSCredentials credentials = new BasicAWSCredentials(accessKey, secretKey);
        return AmazonS3ClientBuilder.standard().withCredentials(new AWSStaticCredentialsProvider(credentials)).withRegion(region).build();
    }
}
