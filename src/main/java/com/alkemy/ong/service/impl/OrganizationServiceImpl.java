package com.alkemy.ong.service.impl;

import com.alkemy.ong.dto.OrganizationBasicDTO;
import com.alkemy.ong.dto.OrganizationFullDTO;
import com.alkemy.ong.dto.SlidesDTO;
import com.alkemy.ong.exception.ResourceNotFoundException;
import com.alkemy.ong.dto.OrganizationUpdateDTO;
import com.alkemy.ong.exception.ParameterNotFound;
import com.alkemy.ong.mapper.OrganizationMapper;
import com.alkemy.ong.mapper.SlidesMapper;
import com.alkemy.ong.model.Organization;
import com.alkemy.ong.repository.OrganizationRepository;
import com.alkemy.ong.repository.SlidesRepository;
import com.alkemy.ong.service.IOrganizationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.Locale;
import java.util.Optional;

import java.util.List;

@Service
public class OrganizationServiceImpl implements IOrganizationService {

    @Autowired
    private MessageSource message;

    @Autowired
    private OrganizationMapper organizationMapper;

    @Autowired
    private OrganizationRepository organizationRepository;

    @Autowired
    private SlidesRepository slidesRepository;

    @Autowired
    private SlidesMapper slidesMapper;

    @Override
    public OrganizationBasicDTO getOrganizationBasic() {
        Organization organization = organizationRepository.findFirstByOrderByCreationDateDesc();
        List<SlidesDTO> slides = slidesMapper
                .listSlidesToDtos(slidesRepository.findAllByOrganization(organization.getId()));
        OrganizationBasicDTO organizationBasicDTO = organizationMapper
                .organizationToOrganizationBasicDTO(organization);
        organizationBasicDTO.setSlides(slides);
        return organizationBasicDTO;
    }

    @Override
    public OrganizationFullDTO update (Long id, OrganizationFullDTO dto) {
        if (organizationRepository.existsById(id)) {
            Organization organization = organizationRepository.getById(id);
            Organization updatedOrganization = organizationMapper.updateOrganizationFromDto(dto, organization);
            Organization savedOrganization = organizationRepository.save(updatedOrganization);
            return organizationMapper.organizationToOrganizationFullDTO(savedOrganization);
        } else {
            throw new ResourceNotFoundException(message.getMessage("{organization.notFound}", null, Locale.US));
        }
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
