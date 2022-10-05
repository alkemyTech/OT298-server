package com.alkemy.ong.service;

import com.alkemy.ong.dto.TestimonialDTO;
import com.alkemy.ong.model.Testimonial;

import java.util.Optional;

public interface ITestimonialService {
    TestimonialDTO save(TestimonialDTO dto);

    TestimonialDTO update(Long id, TestimonialDTO dto);

    Optional<Testimonial> findById(Long id);
}
