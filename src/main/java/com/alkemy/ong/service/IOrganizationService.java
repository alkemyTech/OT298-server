package com.alkemy.ong.service;

import com.alkemy.ong.dto.OrganizationBasicDTO;
import com.alkemy.ong.dto.OrganizationFullDTO;
import com.alkemy.ong.dto.OrganizationUpdateDTO;

public interface IOrganizationService {
    OrganizationBasicDTO getOrganizationBasic();
    OrganizationFullDTO update (Long id, OrganizationFullDTO dto);

    OrganizationUpdateDTO updateOrganization(Long id, OrganizationUpdateDTO updateDTO);

}
