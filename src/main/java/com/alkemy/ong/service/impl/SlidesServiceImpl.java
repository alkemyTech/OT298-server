package com.alkemy.ong.service.impl;

import com.alkemy.ong.dto.SlidesDto;
import com.alkemy.ong.exception.ThereAreNoSlides;
import com.alkemy.ong.mapper.SlidesMapper;
import com.alkemy.ong.model.Slides;
import com.alkemy.ong.repository.SlidesRepository;
import com.alkemy.ong.service.ISlidesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SlidesServiceImpl implements ISlidesService {

    @Autowired
    private SlidesRepository slidesRepository;
    @Autowired
    private SlidesMapper slidesMapper;

    public List<SlidesDto> getAllSlides(){
        List<Slides> slides = slidesRepository.findAll();
        if(slides.isEmpty()){
            throw new ThereAreNoSlides("{slides.empty}");
        }
        List<SlidesDto> dtos = slidesMapper.listSlidesToDtos(slides);
        return dtos;
    }
}
