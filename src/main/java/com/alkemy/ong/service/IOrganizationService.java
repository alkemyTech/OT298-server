package com.alkemy.ong.service;

import com.alkemy.ong.dto.OrganizationBasicDTO;

public interface IOrganizationService {
    OrganizationBasicDTO getOrganizationBasic();
    OrganizationBasicDTO save(OrganizationBasicDTO dto);
}
