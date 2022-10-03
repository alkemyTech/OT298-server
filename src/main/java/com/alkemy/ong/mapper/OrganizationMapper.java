package com.alkemy.ong.mapper;

import com.alkemy.ong.dto.OrganizationBasicDTO;
import com.alkemy.ong.dto.OrganizationUpdateDTO;
import com.alkemy.ong.model.Organization;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface OrganizationMapper {

    OrganizationBasicDTO organizationToOrganizationBasicDTO(Organization entity);

    OrganizationUpdateDTO organizationToUpdateDTO(Organization organization);

    Organization updateDTOToOrganization(OrganizationUpdateDTO dto);

}
