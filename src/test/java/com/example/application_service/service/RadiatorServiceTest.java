package com.example.application_service.service;

import com.example.application_service.model.Radiator;
import com.example.application_service.repository.RadiatorRepository;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class RadiatorServiceTest {

    @InjectMocks
    private RadiatorService radiatorService;

    @Mock
    RadiatorRepository radiatorRepository;

    @Test
    void getAllRadiatorsOrderByPublicationDateDesc() {
    }

    @Test
    void getRadiatorById() {
    }

    @Test
    void addRadiator() {
//        //givn
//        Radiator radiator = new Radiator("radiator", 1000);
//        //when
//        //then
//        assertTrue(radiatorService.addRadiator(radiator));
    }

    @Test
    void getAllRadiators() {
    }

    @Test
    void deleteRadiatorById() {
    }

    @Test
    void deleteRadiatorByName() {
    }
}