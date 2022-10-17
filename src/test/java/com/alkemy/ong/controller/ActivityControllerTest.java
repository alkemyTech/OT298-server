package com.alkemy.ong.controller;

import com.alkemy.ong.dto.ActivityDTO;
import com.alkemy.ong.exception.ResourceNotFoundException;
import com.alkemy.ong.security.service.impl.UserServiceImpl;
import com.alkemy.ong.service.impl.ActivityServiceImpl;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoSettings;
import org.mockito.quality.Strictness;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.security.test.context.support.WithMockUser;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;


import static com.alkemy.ong.util.Constants.ROLE_ADMIN;
import static com.alkemy.ong.util.Constants.ROLE_USER;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.put;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@MockitoSettings(strictness = Strictness.LENIENT)
@AutoConfigureMockMvc
public class ActivityControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private UserServiceImpl service;

    ObjectMapper objectMapper = new ObjectMapper();
    ObjectWriter objectWriter = objectMapper.writer();

    @Mock
    private ActivityServiceImpl activityService;

    @Test
    @DisplayName("Cannot access /activities without credentials")
    public void activityCreationWithoutAuthorizationIsForbidden() throws Exception {
        mockMvc.perform(post("/activities")
                .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isForbidden())
                .andDo(print());
    }

    @Test
    @DisplayName("An admin user can create an activity")
    @WithMockUser(username = "user", authorities = ROLE_ADMIN)
    public void activityCreationWithAuthenticationIsSuccessful() throws Exception {
        ActivityDTO activity = new ActivityDTO(1L,
                "activity name",
                "activity content",
                "activity.jpg");

        Mockito.when(activityService.save(activity)).thenReturn(activity);

        String content = objectWriter.writeValueAsString(activity);

        MockHttpServletRequestBuilder mockRequest = MockMvcRequestBuilders.post("/activities")
                .contentType(MediaType.APPLICATION_JSON)
                .accept(MediaType.APPLICATION_JSON)
                .content(content);

        mockMvc.perform(mockRequest)
                .andExpect(status().isCreated()).andDo(print());
    }

    @Test
    @DisplayName("A regular user cannot create an activity")
    @WithMockUser(username = "user", authorities = ROLE_USER)
    public void activityCreationWithoutAuthoritiesIsForbidden() throws Exception {
        mockMvc.perform(post("/activities"))
                .andExpect(status().isForbidden()).andDo(print());
    }

    @Test
    @DisplayName("An invalid activity is not created")
    @WithMockUser(username = "user", authorities = ROLE_ADMIN)
    public void anInvalidActivityIsNotCreated() throws Exception {
        ActivityDTO activity = new ActivityDTO();

        Mockito.when(activityService.save(activity)).thenReturn(activity);

        String content = objectWriter.writeValueAsString(activity);

        MockHttpServletRequestBuilder mockRequest = MockMvcRequestBuilders.post("/activities")
                .contentType(MediaType.APPLICATION_JSON)
                .accept(MediaType.APPLICATION_JSON)
                .content(content);

        mockMvc.perform(mockRequest)
                .andExpect(status().isBadRequest()).andDo(print());
    }


    @Test
    @DisplayName("Cannot access /activities/{id} without credentials")
    public void activityUpdateWithoutAuthorizationIsForbidden() throws Exception {
        mockMvc.perform(put("/activities/1")
                .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isForbidden())
                .andDo(print());
    }

    @Test
    @DisplayName("A non existent activity cannot be updated")
    @WithMockUser(username = "user", authorities = ROLE_ADMIN)
    public void aNonExistentActivityCannotBeUpdated() throws Exception {
        ActivityDTO activity = new ActivityDTO();

        Mockito.when(activityService.update(1L, activity)).thenThrow(ResourceNotFoundException.class);

        String content = objectWriter.writeValueAsString(activity);

        MockHttpServletRequestBuilder mockRequest = put("/activities/1")
                .contentType(MediaType.APPLICATION_JSON)
                .accept(MediaType.APPLICATION_JSON)
                .content(content);

        mockMvc.perform(mockRequest)
                .andExpect(status().isBadRequest()).andDo(print());
    }

    @Test
    @DisplayName("A existent activity can be updated")
    @WithMockUser(username = "user", authorities = ROLE_ADMIN)
    public void anExistentActivityCanBeUpdated() throws Exception {
        ActivityDTO activity = new ActivityDTO(1L,
                "the name 3",
                "the content",
                "the image.jpg");

        Mockito.when(activityService.update(1L, activity)).thenReturn(activity);

        String content = objectWriter.writeValueAsString(activity);

        MockHttpServletRequestBuilder mockRequest = put("/activities/1")
                .contentType(MediaType.APPLICATION_JSON)
                .accept(MediaType.APPLICATION_JSON)
                .content(content);

        mockMvc.perform(mockRequest)
                .andExpect(status().isOk()).andDo(print());
    }

}