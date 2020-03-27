package com.example.application_service.controller;

import com.example.application_service.model.Radiator;
import com.example.application_service.service.RadiatorService;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.SneakyThrows;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import java.net.URI;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.hasSize;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.web.servlet.function.RequestPredicates.contentType;

@SpringBootTest
@AutoConfigureMockMvc
class RadiatorControllerTest {

    public static final String ADDRADIATOR = "/addRadiator";
    URI addURI = URI.create(ADDRADIATOR);
    @MockBean
    RadiatorService radiatorService;
    @Autowired
    RadiatorController radiatorController;

    ObjectMapper objectMapper = new ObjectMapper();

    @Autowired
    private MockMvc mockMvc;

    @SneakyThrows
    @DisplayName("It should add new Radiator")
    @Test
    void addRadiator() {

    }

    @SneakyThrows
    @Test
    void getAllRadiators() {
    }

    @Test
    void deleteRadiatorById() {
    }
}