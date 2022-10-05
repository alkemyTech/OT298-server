package com.alkemy.ong.service.impl;

import com.alkemy.ong.dto.OrganizationBasicDTO;
import com.alkemy.ong.dto.SlidesDTO;
import com.alkemy.ong.mapper.OrganizationMapper;
import com.alkemy.ong.mapper.SlidesMapper;
import com.alkemy.ong.model.Organization;
import com.alkemy.ong.repository.OrganizationRepository;
import com.alkemy.ong.repository.SlidesRepository;
import com.alkemy.ong.service.IOrganizationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrganizationServiceImpl implements IOrganizationService {

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
}
