package com.example.application_service.service;

import com.example.application_service.model.User;
import com.example.application_service.repository.UserRepository;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Optional;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.hasSize;
import static org.hamcrest.Matchers.sameInstance;


class UserServiceTest {

    @Mock
    UserRepository userRepository;
    @InjectMocks
    UserService userService;

    User user = new User("name", "lastName", "email", "password", LocalDateTime.now(), true, new ArrayList<>());
    User user1 = new User("name1", "lastName1", "email1", "password1", LocalDateTime.now(), true, new ArrayList<>());


    @Test
    void getAllUsers() {
        //given

        user.setUserId(1L);
        user.setUserId(2L);
        //when
        userRepository.save(user); //NullpointerException
        userRepository.save(user1);
        //then
        assertThat(userService.getAllUsers(), hasSize(2));
    }

    @Test
    void getUserById() {
        Optional<User> user3 = userService.getUserById(1L); //NullpointerException
        assertThat(user, sameInstance(user1));
    }

    @Test
    void register() {
    }

    @Test
    void deleteUser() {
    }

    @Test
    void updateStatus() {
    }

    @Test
    void updatePassword() {
    }

    @Test
    void updateUserById() {
    }

    @Test
    void getUserByEmail() {
    }
}