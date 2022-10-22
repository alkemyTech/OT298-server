package com.alkemy.ong.service.impl;

import com.alkemy.ong.dto.SlidesDTO;
import com.alkemy.ong.exception.ThereAreNoSlides;
import com.alkemy.ong.dto.MediaBasicDTO;
import com.alkemy.ong.mapper.SlidesMapper;
import com.alkemy.ong.model.Slides;
import com.alkemy.ong.repository.SlidesRepository;
import com.alkemy.ong.service.ISlidesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.*;

import com.alkemy.ong.exception.ResourceNotFoundException;
import org.springframework.context.MessageSource;


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
    @Autowired
    private MessageSource message;

    public List<SlidesDTO> getAllSlides() {
        List<Slides> slides = slidesRepository.findAll();
        if (slides.isEmpty()) {
            throw new ThereAreNoSlides("{slides.empty}");
        }
        List<SlidesDTO> dtos = slidesMapper.listSlidesToDtos(slides);
        return dtos;
    }

    @Override
    public SlidesDTO save(SlidesDTO slidesDTO) throws Exception {

        Slides slides = slidesMapper.slidesDtoToSlides(slidesDTO);

        if (slides.getPosition()==null) {
            slides.setPosition(slidesRepository.orderPosition(slides.getOrganizationId().getId())+1);
        }

        slides.setImage(amazonS3Service.uploadFile(slides.getImage(), slides.getText()));

        slides = slidesRepository.save(slides);

        SlidesDTO result = slidesMapper.slidesToSlidesDto(slides);

        return result;

    }


    @Override
    public SlidesDTO getById(Long id) {
        Optional slides = slidesRepository.findById(id);
        if (!slides.isPresent()) {
            throw new ResourceNotFoundException(message.getMessage("slides.notFound", null, Locale.US));
        }
        return slidesMapper.slidesToSlidesDto((Slides) slides.get());
    }


    @Override
    public SlidesDTO delete(Long id) {
        if (!slidesRepository.existsById(id)) {
            throw new ResourceNotFoundException(message.getMessage("id.invalid", null, Locale.US));
        }
        SlidesDTO dto = slidesMapper.slidesToSlidesDto(slidesRepository.findById(id).get());

        slidesRepository.deleteById(id);

        return dto;
    }

    @Override
    public SlidesDTO update(Long id, SlidesDTO slides) {

        Optional currentSlides = slidesRepository.findById(id);
        if (!currentSlides.isPresent()) {
            throw new ResourceNotFoundException(message.getMessage("slides.notFound", null, Locale.US));
        }

        Slides slidesToUpdate = slidesMapper.updateSlidesFromSlidesDto(slides, (Slides) currentSlides.get());
        
        return slidesMapper.slidesToSlidesDto(slidesRepository.save(slidesToUpdate));

    }
}

