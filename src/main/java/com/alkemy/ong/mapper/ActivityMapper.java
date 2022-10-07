package com.alkemy.ong.mapper;

import com.alkemy.ong.dto.ActivityDTO;
import com.alkemy.ong.model.Activity;
import org.mapstruct.BeanMapping;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;
import org.mapstruct.NullValuePropertyMappingStrategy;

@Mapper(componentModel = "spring")
public interface ActivityMapper {

    ActivityDTO activityToActivityDTO (Activity entity);

    Activity activityDTOToActivity (ActivityDTO dto);

    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    Activity updateActivityToDTO(ActivityDTO dto, @MappingTarget Activity activity);
<<<<<<< HEAD

=======
>>>>>>> 67dd049ad8eb1e48236022154ba401827a39e6f9
}
