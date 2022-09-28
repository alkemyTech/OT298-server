package com.alkemy.ong.mapper;

import com.alkemy.ong.dto.SlidesDTO;
import com.alkemy.ong.model.Slides;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface SlidesMapper {

    Slides slidesDTO2Slides(SlidesDTO slidesDTO);

    SlidesDTO slides2SlidesDTO(Slides slides);

}
