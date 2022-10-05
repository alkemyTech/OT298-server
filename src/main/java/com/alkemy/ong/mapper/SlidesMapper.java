package com.alkemy.ong.mapper;

import com.alkemy.ong.dto.SlidesDto;
import com.alkemy.ong.model.Slides;
import org.mapstruct.BeanMapping;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;
import org.mapstruct.NullValuePropertyMappingStrategy;

import java.util.List;

@Mapper(componentModel = "spring")
public interface SlidesMapper {


    Slides slidesDtoToSlides(SlidesDto slidesDto);

    SlidesDto slidesToSlidesDto(Slides slides);

    List<SlidesDto> listSlidesToDtos(List<Slides> slides);

    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    Slides updateSlidesFromSlidesDto(SlidesDto slidesDto, @MappingTarget Slides slides);
}
