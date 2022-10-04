package com.alkemy.ong.service.impl;

import com.alkemy.ong.service.ISlidesService;
import com.alkemy.ong.repository.SlidesRepository;
import com.alkemy.ong.dto.SlidesDTO;
import com.alkemy.ong.exception.ResourceNotFoundException;
import com.alkemy.ong.mapper.SlidesMapper;
import java.util.Locale;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Service;

@Service
public class SlidesServiceImpl implements ISlidesService {
    @Autowired
    private SlidesRepository slidesRepository;
    @Autowired
    private MessageSource message;
    @Autowired
    private SlidesMapper slidesMapper;
    @Override
    public SlidesDTO delete(Long id){
        if(!slidesRepository.existsById(id)){
            throw new ResourceNotFoundException(message.getMessage("id.invalid", null, Locale.US));
        }
        SlidesDTO dto = slidesMapper.slidesToSlidesDTO(slidesRepository.findById(id).get());

        slidesRepository.deleteById(id);

        return dto;
    }
}