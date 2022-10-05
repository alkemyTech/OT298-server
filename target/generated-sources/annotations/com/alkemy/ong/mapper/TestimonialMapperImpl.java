package com.alkemy.ong.mapper;

import com.alkemy.ong.dto.TestimonialDTO;
import com.alkemy.ong.model.Testimonial;
import javax.annotation.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2022-10-05T11:49:18-0300",
    comments = "version: 1.4.2.Final, compiler: javac, environment: Java 11.0.16 (Ubuntu)"
)
@Component
public class TestimonialMapperImpl implements TestimonialMapper {

    @Override
    public TestimonialDTO toDto(Testimonial entity) {
        if ( entity == null ) {
            return null;
        }

        TestimonialDTO testimonialDTO = new TestimonialDTO();

        testimonialDTO.setName( entity.getName() );
        testimonialDTO.setImage( entity.getImage() );
        testimonialDTO.setContent( entity.getContent() );

        return testimonialDTO;
    }

    @Override
    public Testimonial toEntity(TestimonialDTO dto) {
        if ( dto == null ) {
            return null;
        }

        Testimonial testimonial = new Testimonial();

        testimonial.setName( dto.getName() );
        testimonial.setImage( dto.getImage() );
        testimonial.setContent( dto.getContent() );

        return testimonial;
    }
}
