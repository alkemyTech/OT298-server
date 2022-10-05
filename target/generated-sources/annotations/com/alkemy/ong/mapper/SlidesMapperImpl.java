package com.alkemy.ong.mapper;

import com.alkemy.ong.dto.SlidesDTO;
import com.alkemy.ong.model.Slides;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2022-10-05T11:36:31-0300",
    comments = "version: 1.4.2.Final, compiler: javac, environment: Java 11.0.16 (Ubuntu)"
)
@Component
public class SlidesMapperImpl implements SlidesMapper {

    @Override
    public Slides slidesDtoToSlides(SlidesDTO slidesDto) {
        if ( slidesDto == null ) {
            return null;
        }

        Slides slides = new Slides();

        slides.setImage( slidesDto.getImage() );
        slides.setText( slidesDto.getText() );
        slides.setOrders( slidesDto.getOrders() );

        return slides;
    }

    @Override
    public SlidesDTO slidesToSlidesDto(Slides slides) {
        if ( slides == null ) {
            return null;
        }

        SlidesDTO slidesDTO = new SlidesDTO();

        slidesDTO.setImage( slides.getImage() );
        slidesDTO.setText( slides.getText() );
        slidesDTO.setOrders( slides.getOrders() );

        return slidesDTO;
    }

    @Override
    public List<SlidesDTO> listSlidesToDtos(List<Slides> slides) {
        if ( slides == null ) {
            return null;
        }

        List<SlidesDTO> list = new ArrayList<SlidesDTO>( slides.size() );
        for ( Slides slides1 : slides ) {
            list.add( slidesToSlidesDto( slides1 ) );
        }

        return list;
    }

    @Override
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
    }
}
