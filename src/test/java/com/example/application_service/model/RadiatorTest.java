package com.example.application_service.model;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertThrows;

class RadiatorTest {

    @DisplayName("Radiator constructor should be return IllegalArgumentException")
    @Test
    void radiatorConstructorReturnException() {
        //given
        //when
        //then
        assertAll(
                ()->assertThrows(IllegalArgumentException.class, () -> new Radiator("CV11-90/1,0",-1000,1.0,0.9)),
                ()->assertThrows(IllegalArgumentException.class, () -> new Radiator("CV11-90/1,0",1000,-1.0,0.9)),
                ()->assertThrows(IllegalArgumentException.class, () -> new Radiator("CV11-90/1,0",1000,1.0,-0.9))
        );
    }
}