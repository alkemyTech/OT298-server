package com.alkemy.ong.service.impl;

import com.alkemy.ong.dto.OrganizationBasicDTO;
import com.alkemy.ong.dto.OrganizationUpdateDTO;
import com.alkemy.ong.exception.ParameterNotFound;
import com.alkemy.ong.exception.ResourceNotFoundException;
import com.alkemy.ong.mapper.OrganizationMapper;
import com.alkemy.ong.model.Organization;
import com.alkemy.ong.repository.OrganizationRepository;
import com.alkemy.ong.service.IOrganizationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.Locale;
import java.util.Optional;

@Service
public class OrganizationServiceImpl implements IOrganizationService {

    @Autowired
    OrganizationMapper organizationMapper;

    @Autowired
    OrganizationRepository organizationRepository;

    @Autowired
    private MessageSource message;

    @Override
    public OrganizationBasicDTO getOrganizationBasic() {
        Organization organization = organizationRepository.findFirstByOrderByCreationDateDesc();
        return organizationMapper.organizationToOrganizationBasicDTO(organization);
    }

    @Transactional
    @Override
    public OrganizationUpdateDTO updateOrganization(Long id, OrganizationUpdateDTO updateDTO) {
        Optional<Organization> organization = organizationRepository.findById(id);
        if(!organization.isPresent()){
            throw new ResourceNotFoundException(message.getMessage("org.not.found", null, Locale.US));
        }
        organizationMapper.organizationToUpdateDTO(organization.get());
        Organization updated = organizationMapper.updateDTOToOrganization(updateDTO);
        return organizationMapper.organizationToUpdateDTO(organizationRepository.save(updated));
    }
}
