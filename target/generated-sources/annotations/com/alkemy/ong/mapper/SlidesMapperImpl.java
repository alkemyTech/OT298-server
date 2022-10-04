package com.alkemy.ong.mapper;

import com.alkemy.ong.dto.SlidesDTO;
import com.alkemy.ong.model.Slides;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import javax.annotation.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2022-10-03T23:50:12-0300",
    comments = "version: 1.4.2.Final, compiler: javac, environment: Java 11.0.15 (Private Build)"
)
@Component
public class SlidesMapperImpl implements SlidesMapper {

    @Override
    public Slides slidesDTOToSlides(SlidesDTO slidesDTO) {
        if ( slidesDTO == null ) {
            return null;
        }

        Slides slides = new Slides();

        slides.setId( slidesDTO.getId() );
        slides.setImage( slidesDTO.getImage() );
        slides.setText( slidesDTO.getText() );
        slides.setPosition( slidesDTO.getPosition() );

        return slides;
    }

    @Override
    public SlidesDTO slidesToSlidesDTO(Slides slides) {
        if ( slides == null ) {
            return null;
        }

        SlidesDTO slidesDTO = new SlidesDTO();

        slidesDTO.setId( slides.getId() );
        slidesDTO.setImage( slides.getImage() );
        slidesDTO.setText( slides.getText() );
        slidesDTO.setPosition( slides.getPosition() );

        return slidesDTO;
    }

    @Override
    public List<SlidesDTO> listSlidesToDtos(List<Slides> slides) {
        if ( slides == null ) {
            return null;
        }

        List<SlidesDTO> list = new ArrayList<SlidesDTO>( slides.size() );
        for ( Slides slides1 : slides ) {
            list.add( slidesToSlidesDTO( slides1 ) );
        }

        return list;
    }

    @Override
    public LinkedList<SlidesDTO> listSlide2listSlideDTO(LinkedList<Slides> slidesList) {
        if ( slidesList == null ) {
            return null;
        }

        LinkedList<SlidesDTO> linkedList = new LinkedList<SlidesDTO>();
        for ( Slides slides : slidesList ) {
            linkedList.add( slidesToSlidesDTO( slides ) );
        }

        return linkedList;
    }
}
