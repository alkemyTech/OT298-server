package com.alkemy.ong.mapper;

import com.alkemy.ong.dto.SlidesDTO;
import com.alkemy.ong.model.Slides;
import org.mapstruct.Mapper;

import java.util.LinkedList;
import java.util.List;

@Mapper(componentModel = "spring")
public interface SlidesMapper {

    Slides slidesDTO2Slides(SlidesDTO slidesDTO);

    SlidesDTO slides2SlidesDTO(Slides slides);

    LinkedList<SlidesDTO> listSlide2listSlideDTO(LinkedList<Slides> slidesList);
    LinkedList<Slides> listSlideDTO2listSlide(LinkedList<SlidesDTO> slidesListDTO);
}
