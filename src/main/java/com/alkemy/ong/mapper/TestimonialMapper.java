package com.alkemy.ong.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import com.alkemy.ong.model.Testimonial;
import com.alkemy.ong.dto.TestimonialDTO;

@Mapper(componentModel = "spring")
public interface TestimonialMapper {
    TestimonialDTO toDto(Testimonial entity);
    Testimonial toEntity(TestimonialDTO dto);
}