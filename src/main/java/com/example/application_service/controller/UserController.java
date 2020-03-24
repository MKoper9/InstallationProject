package com.example.application_service.controller;

import com.example.application_service.model.User;
import com.example.application_service.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@RestController
public class UserController {
    private UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }
    @GetMapping("/users")
    public List<User>getAllUsers(){return userService.getAllUsers();}
    @GetMapping("/users/id{user_id}")
    public User getUserById(@PathVariable("user_id")Long userId){
        Optional<User> userOpt=userService.getUserById(userId);
        return userOpt.orElseGet(User::new);
    }


    @DeleteMapping(path = "/delete")
    public Boolean deleteUserByEmail(@RequestParam String userEmail){return userService.deleteUser(userEmail);}

    @PutMapping(path = "/updateUserStatus")
    public Boolean updateStatus(@PathVariable Long userId, @PathVariable Boolean status){
        return userService.updateStatus(userId,status);
    }

    @PostMapping(path = "/register")
    public Boolean register(@RequestParam String name, @RequestParam String lastName, @RequestParam String email,
                            @RequestParam String password, String companyName, String companyAddress, String nip){
        if(nip == null){
            return userService.register(
                    new User(name, lastName, email, password, LocalDateTime.now(), true)
            );
        }
        return userService.register(
                new User(name, lastName, email, password, companyName,companyAddress,nip,true,LocalDateTime.now() )
        );
    }

}
