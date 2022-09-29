package com.alkemy.ong.service.impl;

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
    SlidesRepository slidesRepository;

    @Autowired
    SlidesMapper slidesMapper;

    @Autowired
    MediaStoreServiceImpl mediaStoreService;


    @Override
    public SlidesDTO save(SlidesDTO slidesDTO) {

        Slides slides = slidesMapper.slidesDTO2Slides(slidesDTO);
        Slides slideSave = slidesRepository.save(slides);


        String imageString = slides.getImage();
        byte[] decodeImg = Base64.getDecoder().decode(imageString);

        File file = new File(String.valueOf(decodeImg));
        mediaStoreService.uploadFile((MultipartFile) file);


        SlidesDTO result = slidesMapper.slides2SlidesDTO(slideSave);
        return result;

    }


}
