package com.alkemy.ong.service.impl;

import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;
import javax.transaction.Transactional;

import com.alkemy.ong.repository.TestimonialRepository;
import com.alkemy.ong.service.ITestimonialService;
import com.alkemy.ong.mapper.TestimonialMapper;
import com.alkemy.ong.model.Testimonial;
import com.alkemy.ong.dto.TestimonialDTO;

@Service
@Transactional
public class TestimonialServiceImpl implements ITestimonialService {
    @Autowired
    private TestimonialRepository repo;

    @Autowired
    private TestimonialMapper mapper;

    public TestimonialDTO save(TestimonialDTO dto){
        Testimonial Testimonial = repo.save(mapper.toEntity(dto));
        return mapper.toDto(Testimonial);
    }
}