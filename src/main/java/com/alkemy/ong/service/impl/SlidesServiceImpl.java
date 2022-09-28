package com.alkemy.ong.service.impl;

import com.alkemy.ong.dto.SlidesDTO;
import com.alkemy.ong.mapper.SlidesMapper;
import com.alkemy.ong.model.Slides;
import com.alkemy.ong.repository.SlidesRepository;
import com.alkemy.ong.service.ISlidesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SlidesServiceImpl implements ISlidesService {

    @Autowired
    SlidesRepository slidesRepository;

    @Autowired
    SlidesMapper slidesMapper;

    @Override
    public SlidesDTO save(SlidesDTO slidesDTO) {

        Slides slides = slidesMapper.slidesDTO2Slides(slidesDTO);
        Slides slideSave = slidesRepository.save(slides);
        SlidesDTO result = slidesMapper.slides2SlidesDTO(slideSave);
        return result;

    }


}
