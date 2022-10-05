package com.alkemy.ong.mapper;

import org.mapstruct.BeanMapping;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;
import org.mapstruct.NullValuePropertyMappingStrategy;

import com.alkemy.ong.model.Testimonial;
import com.alkemy.ong.dto.TestimonialDTO;

@Mapper(componentModel = "spring")
public interface TestimonialMapper {
    TestimonialDTO toDto(Testimonial entity);
    Testimonial toEntity(TestimonialDTO dto);

    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    Testimonial updateTestimonialFromDto(TestimonialDTO dto, @MappingTarget Testimonial testimonial);
}