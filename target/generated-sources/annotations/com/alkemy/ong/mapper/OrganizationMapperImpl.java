package com.alkemy.ong.mapper;

import com.alkemy.ong.dto.OrganizationBasicDTO;
import com.alkemy.ong.model.Organization;
import javax.annotation.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2022-10-05T11:49:18-0300",
    comments = "version: 1.4.2.Final, compiler: javac, environment: Java 11.0.16 (Ubuntu)"
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
        organizationBasicDTO.setUrlLinkedin( entity.getUrlLinkedin() );
        organizationBasicDTO.setUrlFacebook( entity.getUrlFacebook() );
        organizationBasicDTO.setUrlInstagram( entity.getUrlInstagram() );

        return organizationBasicDTO;
    }
}
