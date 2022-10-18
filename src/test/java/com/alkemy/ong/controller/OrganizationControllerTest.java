package com.alkemy.ong.controller;

import com.alkemy.ong.security.service.IUserService;
import com.alkemy.ong.security.service.impl.UserServiceImpl;
import com.alkemy.ong.service.IOrganizationService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import static com.alkemy.ong.util.Constants.Endpoints.ORGANIZATION;
import static org.springframework.security.test.web.servlet.request.SecurityMockMvcRequestPostProcessors.csrf;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.junit.jupiter.api.Assertions.*;
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

    @BeforeEach
    void setUp() {
    }

    @Test
    void getOrganizationForbidden() throws Exception {

        mockMvc.perform(get(ORGANIZATION)
                    .contentType(MediaType.APPLICATION_JSON_VALUE)
                    .with(csrf()))
                .andExpect(status().isForbidden());

    }

}