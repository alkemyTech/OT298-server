package com.alkemy.ong.service;

import com.alkemy.ong.dto.TestimonialDTO;

public interface ITestimonialService {
    TestimonialDTO save(TestimonialDTO dto);

    void delete(Long id);
}
