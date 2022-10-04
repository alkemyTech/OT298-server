package com.alkemy.ong.mapper;

import com.alkemy.ong.dto.SlidesDTO;
import com.alkemy.ong.model.Slides;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface SlidesMapper {


    Slides slidesDTOToSlides(SlidesDTO slidesDTO);

    SlidesDTO slidesToSlidesDTO(Slides slides);
    List<SlidesDTO> listSlidesToDtos(List<Slides> slides);

}
