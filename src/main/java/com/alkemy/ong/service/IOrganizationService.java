package com.alkemy.ong.service;

import com.alkemy.ong.dto.OrganizationBasicDTO;
import com.alkemy.ong.dto.OrganizationFullDTO;

public interface IOrganizationService {
    OrganizationBasicDTO getOrganizationBasic();
    OrganizationFullDTO update (Long id, OrganizationFullDTO dto);
}
