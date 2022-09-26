package com.alkemy.ong.mapper;

import com.alkemy.ong.dto.ActivityDTO;
import com.alkemy.ong.model.Activity;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface ActivityMapper {

    ActivityDTO activityToActivityDTO (Activity entity);

    Activity activityDTOToActivity (ActivityDTO dto);
}
