package com.example.application_service.model;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;

class RadiatorTest {

    @DisplayName("Radiator constructor should be return IllegalArgumentException")
    @Test
    void radiatorConstructorReturnException() {
        //given
        Radiator radiator;
        //when
        //then
        assertThrows(IllegalArgumentException.class, () -> new Radiator("CV11-90/1,0",-1000));
    }
}