package com.alkemy.ong.mapper;

import com.alkemy.ong.dto.OrganizationBasicDTO;
import com.alkemy.ong.model.Organization;
import javax.annotation.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
<<<<<<< HEAD
    date = "2022-10-05T11:36:31-0300",
    comments = "version: 1.4.2.Final, compiler: javac, environment: Java 11.0.16 (Ubuntu)"
=======
    date = "2022-10-03T22:34:45-0300",
    comments = "version: 1.4.2.Final, compiler: javac, environment: Java 11.0.15 (Private Build)"
>>>>>>> b4fef73cb7eea0a5d2a5b2fc4a78cf5d02acef65
)
@Component
public class OrganizationMapperImpl implements OrganizationMapper {

    @Override
    public OrganizationBasicDTO organizationToOrganizationBasicDTO(Organization entity) {
        if ( entity == null ) {
            return null;
        }

        OrganizationBasicDTO organizationBasicDTO = new OrganizationBasicDTO();

        organizationBasicDTO.setName( entity.getName() );
        organizationBasicDTO.setPhone( entity.getPhone() );
        organizationBasicDTO.setAddress( entity.getAddress() );
        organizationBasicDTO.setImage( entity.getImage() );

        return organizationBasicDTO;
    }
}
