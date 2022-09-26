package com.alkemy.ong.service.impl;

import com.alkemy.ong.dto.OrganizationBasicDTO;
import com.alkemy.ong.mapper.OrganizationMapper;
import com.alkemy.ong.model.Organization;
import com.alkemy.ong.repository.OrganizationRepository;
import com.alkemy.ong.service.IOrganizationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class OrganizationServiceImpl implements IOrganizationService {

    @Autowired
    OrganizationMapper organizationMapper;

    @Autowired
    OrganizationRepository organizationRepository;

    @Override
    public OrganizationBasicDTO getOrganizationBasic() {
        Organization organization = organizationRepository.findFirstByOrderByCreationDateDesc();
        return organizationMapper.organizationToOrganizationBasicDTO(organization);
    }
}
