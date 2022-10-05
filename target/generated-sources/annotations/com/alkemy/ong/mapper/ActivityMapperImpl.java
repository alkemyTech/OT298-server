package com.alkemy.ong.mapper;

import com.alkemy.ong.dto.ActivityDTO;
import com.alkemy.ong.model.Activity;
import javax.annotation.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2022-10-05T11:49:18-0300",
    comments = "version: 1.4.2.Final, compiler: javac, environment: Java 11.0.16 (Ubuntu)"
)
@Component
public class ActivityMapperImpl implements ActivityMapper {

    @Override
    public ActivityDTO activityToActivityDTO(Activity entity) {
        if ( entity == null ) {
            return null;
        }

        ActivityDTO activityDTO = new ActivityDTO();

        activityDTO.setId( entity.getId() );
        activityDTO.setName( entity.getName() );
        activityDTO.setContent( entity.getContent() );
        activityDTO.setImage( entity.getImage() );

        return activityDTO;
    }

    @Override
    public Activity activityDTOToActivity(ActivityDTO dto) {
        if ( dto == null ) {
            return null;
        }

        Activity activity = new Activity();

        activity.setId( dto.getId() );
        activity.setName( dto.getName() );
        activity.setContent( dto.getContent() );
        activity.setImage( dto.getImage() );

        return activity;
    }
}
