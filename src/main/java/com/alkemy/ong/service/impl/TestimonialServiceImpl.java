package com.alkemy.ong.service.impl;

import com.alkemy.ong.exception.ResourceNotFoundException;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;
import javax.transaction.Transactional;

import com.alkemy.ong.repository.TestimonialRepository;
import com.alkemy.ong.service.ITestimonialService;
import com.alkemy.ong.mapper.TestimonialMapper;
import com.alkemy.ong.model.Testimonial;
import com.alkemy.ong.dto.TestimonialDTO;

import java.util.Locale;
import java.util.Optional;

@Service
@Transactional
public class TestimonialServiceImpl implements ITestimonialService {

    @Autowired
    private MessageSource message;

    @Autowired
    private TestimonialRepository repository;

    @Autowired
    private TestimonialMapper mapper;

    public TestimonialDTO save(TestimonialDTO dto){
        Testimonial Testimonial = repository.save(mapper.toEntity(dto));
        return mapper.toDto(Testimonial);
    }

    @Override
    public void delete (Long id) {
        Optional<Testimonial> response = repository.findById(id);
        if(response.isPresent()) {
            repository.deleteById(id);
        }else{
            throw new ResourceNotFoundException(message.getMessage("object.notFound",null,Locale.US)+id);
        }
    }
}