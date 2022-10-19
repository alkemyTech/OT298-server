package com.alkemy.ong.controller;

import com.alkemy.ong.dto.OrganizationBasicDTO;
import com.alkemy.ong.dto.OrganizationUpdateDTO;
import com.alkemy.ong.dto.SlidesDTO;
import com.alkemy.ong.exception.ResourceNotFoundException;
import com.alkemy.ong.security.service.impl.UserServiceImpl;
import com.alkemy.ong.service.IOrganizationService;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.context.MessageSource;
import org.springframework.http.MediaType;
import org.springframework.security.test.context.support.WithMockUser;
import org.springframework.test.web.servlet.MockMvc;

import java.util.ArrayList;
import java.util.List;

import static com.alkemy.ong.util.Constants.Endpoints.ORGANIZATION;
import static com.alkemy.ong.util.Constants.ROLE_ADMIN;
import static org.mockito.Mockito.when;
import static org.springframework.http.MediaType.APPLICATION_JSON;
import static org.springframework.security.test.web.servlet.request.SecurityMockMvcRequestPostProcessors.csrf;
import static org.springframework.security.test.web.servlet.request.SecurityMockMvcRequestPostProcessors.user;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.patch;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
class OrganizationControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private UserServiceImpl userService;

    @Mock
    private IOrganizationService organizationService;

    private OrganizationUpdateDTO organizationUpdateDTO;

    private OrganizationBasicDTO organizationBasicDTO;

    private List<SlidesDTO> slidesDTOList;

    @Autowired
    private ObjectMapper objectMapper;

    @BeforeEach
    void setUp() {
        organizationUpdateDTO = new OrganizationUpdateDTO("SomosMas",
                12345678, "address",
                "ong.png",
                "welcome",
                "ong",
                "https://www.facebook.com/somosmas",
                "https://www.linkedin.com/profile/somosmas",
                "https://www.instagram.com/somosmas",
                "somosmas@ong.com"
                );

        slidesDTOList = new ArrayList<>();
        slidesDTOList.add(new SlidesDTO(1L, "slide1.jpg", "text1", 1));
        organizationBasicDTO = new OrganizationBasicDTO("SomosMas",
                12345678,
                "address",
                "ong.png",
                slidesDTOList,
                "facebook.com/somosmas",
                "linkedin.com/somosmas",
                "instagram.com/somosmas");
    }
    @Test
    @WithMockUser(username = "admin", authorities = ROLE_ADMIN)
    void updateOrganizationByAdmin() throws Exception {
        when(organizationService.updateOrganization(1L, organizationUpdateDTO)).
                thenReturn(organizationUpdateDTO);
        mockMvc.perform(patch("/organization/public/" + 1L)
                        .contentType(APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(organizationUpdateDTO))
                        .with(user("admin").roles("ADMIN"))
                        .with(csrf()))
                .andExpect(status().isAccepted());
    }

    @Test
    @WithMockUser(username = "admin", authorities = ROLE_ADMIN)
    void updateNonExistingOrganizationFailed() throws Exception{
        Long idOrgNotExist = 3L;
        when(organizationService.updateOrganization(idOrgNotExist, organizationUpdateDTO)).
                thenThrow(ResourceNotFoundException.class);
        mockMvc.perform(patch("/organization/public/" + idOrgNotExist)
                        .contentType(APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(organizationUpdateDTO))
                        .with(user("admin").roles("ADMIN"))
                        .with(csrf()))
                .andExpect(status().isNotFound());
    }

    @Test
    void updateOrganizationForbidden() throws Exception {
        mockMvc.perform(patch(ORGANIZATION + 1L)
                        .contentType(MediaType.APPLICATION_JSON_VALUE)
                        .with(csrf()))
                .andExpect(status().isForbidden());
    }
    @Test
    void getOrganizationForbidden() throws Exception {

        mockMvc.perform(get(ORGANIZATION)
                    .contentType(MediaType.APPLICATION_JSON_VALUE)
                    .with(csrf()))
                .andExpect(status().isForbidden());

    }

}