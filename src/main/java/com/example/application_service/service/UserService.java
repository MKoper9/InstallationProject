package com.example.application_service.service;

import com.example.application_service.model.User;
import com.example.application_service.repository.RadiatorRepository;
import com.example.application_service.repository.RoleRepository;
import com.example.application_service.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;

@Service
public class UserService {

    private UserRepository userRepository;
    private RoleRepository roleRepository;
    private RadiatorRepository radiatorRepository;

    @Autowired
    public UserService(UserRepository userRepository, RoleRepository roleRepository, RadiatorRepository radiatorRepository) {
        this.userRepository = userRepository;
        this.roleRepository = roleRepository;
        this.radiatorRepository = radiatorRepository;
    }

    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    public User getUserById(Long user_id) {
        return userRepository.findAllById(user_id);
    }

    public Boolean register(User user) {
        if (userRepository.findAll().stream().anyMatch(u -> u.getEmail().equals(user.getEmail()))) {
            return false;
        } else {
            user.setRegistrationDate(LocalDateTime.now());
            user.setStatus(true);
            if(user.getCompanyName().equals("")){
                user.setRoles(new HashSet<>(Arrays.asList(roleRepository.findFirstByRoleName("ROLE_USER"))));
            }else {
                user.setRoles(new HashSet<>(Arrays.asList(roleRepository.findFirstByRoleName("ROLE_COMPANY"))));
            }
            return true;
        }
    }

}
