package com.alkemy.ong.mapper;

import com.alkemy.ong.dto.OrganizationBasicDTO;
import com.alkemy.ong.dto.OrganizationFullDTO;
import com.alkemy.ong.model.Organization;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface OrganizationMapper {

    OrganizationBasicDTO organizationToOrganizationBasicDTO(Organization entity);

    OrganizationFullDTO organizationToOrganizationFullDTO (Organization entity);

    Organization organizationFullDTOToOrganization (OrganizationFullDTO dto);

}
