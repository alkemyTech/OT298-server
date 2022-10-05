package com.alkemy.ong.mapper;

import com.alkemy.ong.dto.SlidesDTO;
import com.alkemy.ong.model.Slides;
import java.util.ArrayList;
<<<<<<< HEAD
=======
import java.util.LinkedList;
>>>>>>> b4fef73cb7eea0a5d2a5b2fc4a78cf5d02acef65
import java.util.List;
import javax.annotation.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
<<<<<<< HEAD
    date = "2022-10-05T11:36:31-0300",
    comments = "version: 1.4.2.Final, compiler: javac, environment: Java 11.0.16 (Ubuntu)"
=======
    date = "2022-10-03T23:50:12-0300",
    comments = "version: 1.4.2.Final, compiler: javac, environment: Java 11.0.15 (Private Build)"
>>>>>>> b4fef73cb7eea0a5d2a5b2fc4a78cf5d02acef65
)
@Component
public class SlidesMapperImpl implements SlidesMapper {

    @Override
<<<<<<< HEAD
    public Slides slidesDtoToSlides(SlidesDTO slidesDto) {
        if ( slidesDto == null ) {
=======
    public Slides slidesDTOToSlides(SlidesDTO slidesDTO) {
        if ( slidesDTO == null ) {
>>>>>>> b4fef73cb7eea0a5d2a5b2fc4a78cf5d02acef65
            return null;
        }

        Slides slides = new Slides();

<<<<<<< HEAD
        slides.setImage( slidesDto.getImage() );
        slides.setText( slidesDto.getText() );
        slides.setOrders( slidesDto.getOrders() );
=======
        slides.setId( slidesDTO.getId() );
        slides.setImage( slidesDTO.getImage() );
        slides.setText( slidesDTO.getText() );
        slides.setPosition( slidesDTO.getPosition() );
>>>>>>> b4fef73cb7eea0a5d2a5b2fc4a78cf5d02acef65

        return slides;
    }

    @Override
<<<<<<< HEAD
    public SlidesDTO slidesToSlidesDto(Slides slides) {
=======
    public SlidesDTO slidesToSlidesDTO(Slides slides) {
>>>>>>> b4fef73cb7eea0a5d2a5b2fc4a78cf5d02acef65
        if ( slides == null ) {
            return null;
        }

        SlidesDTO slidesDTO = new SlidesDTO();

<<<<<<< HEAD
        slidesDTO.setImage( slides.getImage() );
        slidesDTO.setText( slides.getText() );
        slidesDTO.setOrders( slides.getOrders() );
=======
        slidesDTO.setId( slides.getId() );
        slidesDTO.setImage( slides.getImage() );
        slidesDTO.setText( slides.getText() );
        slidesDTO.setPosition( slides.getPosition() );
>>>>>>> b4fef73cb7eea0a5d2a5b2fc4a78cf5d02acef65

        return slidesDTO;
    }

    @Override
    public List<SlidesDTO> listSlidesToDtos(List<Slides> slides) {
        if ( slides == null ) {
            return null;
        }

        List<SlidesDTO> list = new ArrayList<SlidesDTO>( slides.size() );
        for ( Slides slides1 : slides ) {
<<<<<<< HEAD
            list.add( slidesToSlidesDto( slides1 ) );
=======
            list.add( slidesToSlidesDTO( slides1 ) );
>>>>>>> b4fef73cb7eea0a5d2a5b2fc4a78cf5d02acef65
        }

        return list;
    }

    @Override
<<<<<<< HEAD
    public Slides updateSlidesFromSlidesDto(SlidesDTO slidesDto, Slides slides) {
        if ( slidesDto == null ) {
            return null;
        }

        if ( slidesDto.getImage() != null ) {
            slides.setImage( slidesDto.getImage() );
        }
        if ( slidesDto.getText() != null ) {
            slides.setText( slidesDto.getText() );
        }
        slides.setOrders( slidesDto.getOrders() );

        return slides;
=======
    public LinkedList<SlidesDTO> listSlide2listSlideDTO(LinkedList<Slides> slidesList) {
        if ( slidesList == null ) {
            return null;
        }

        LinkedList<SlidesDTO> linkedList = new LinkedList<SlidesDTO>();
        for ( Slides slides : slidesList ) {
            linkedList.add( slidesToSlidesDTO( slides ) );
        }

        return linkedList;
>>>>>>> b4fef73cb7eea0a5d2a5b2fc4a78cf5d02acef65
    }
}
