package com.alkemy.ong.service;

import com.alkemy.ong.dto.TestimonialDTO;
import com.alkemy.ong.model.Testimonial;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;
import java.util.Map;
import java.util.Optional;

public interface ITestimonialService {

    TestimonialDTO save(TestimonialDTO dto);

    TestimonialDTO update(Long id, TestimonialDTO dto);

    Optional<Testimonial> findById(Long id);

    void delete(Long id);

    Page<Testimonial> getTestimonialPage(Integer numberPage, Pageable pageable);

    Map<String, Object> responseTestimonialPage(Integer numberPage, Pageable pageable);

}
