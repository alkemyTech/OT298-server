package com.alkemy.ong.service.impl;

import com.alkemy.ong.dto.MediaBasicDTO;
import com.alkemy.ong.dto.SlidesDTO;
import com.alkemy.ong.mapper.SlidesMapper;
import com.alkemy.ong.model.Slides;
import com.alkemy.ong.repository.SlidesRepository;
import com.alkemy.ong.service.ISlidesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.util.Base64;



@Service
public class SlidesServiceImpl implements ISlidesService {

    @Autowired
    private SlidesRepository slidesRepository;

    @Autowired
    private SlidesMapper slidesMapper;

    @Autowired
    private AmazonS3ServiceImpl amazonS3Service;

    @Autowired
    private MediaBasicDTO mediaBasicDTO;

    @Override
    public SlidesDTO save(SlidesDTO slidesDTO) {

        Slides slides = slidesMapper.slidesDTO2Slides(slidesDTO);

        String imageString = slides.getImage();
        byte[] decodeImg = Base64.getDecoder().decode(imageString);

        File file = new File(String.valueOf(decodeImg));
        amazonS3Service.uploadFile((MultipartFile) file);

        slides.setImage(mediaBasicDTO.getUrl());

        Slides slideSave = slidesRepository.save(slides);

        SlidesDTO result = slidesMapper.slides2SlidesDTO(slideSave);

        return result;

    }


}
