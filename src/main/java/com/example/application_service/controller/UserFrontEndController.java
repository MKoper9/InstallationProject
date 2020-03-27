package com.example.application_service.controller;

import com.example.application_service.model.User;
import com.example.application_service.service.RadiatorService;
import com.example.application_service.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import javax.validation.Valid;

@Controller
public class UserFrontEndController {

    private UserService userService;
    private RadiatorService radiatorService;

    @Autowired
    public UserFrontEndController(UserService userService, RadiatorService radiatorService) {
        this.userService = userService;
        this.radiatorService = radiatorService;
    }

    @GetMapping("/login")
    public String login(Authentication auth, Model model) {
        model.addAttribute("isLogged", auth != null);
        model.addAttribute("loggedEmail", auth != null ? ((UserDetails) auth.getPrincipal()).getUsername() : "");
        return "login";
    }

    @GetMapping("/")
    public String index(Authentication auth, Model model) {
        model.addAttribute("isLogged", auth != null);
        model.addAttribute("radiator", radiatorService.getAllRadiatorsOrderByPublicationDateDesc());
        return "index";
    }

    @GetMapping("/registration")
    public String registration(Authentication auth, Model model) {
        model.addAttribute("isLogged", auth != null);
        model.addAttribute("user", new User()); // give to Thymeleaf resolver object User
        return "registration";
    }

    @PostMapping("/registration")
    public String registration(@ModelAttribute("user") @Valid User user, BindingResult bindingResult, Model model) {
        if (bindingResult.hasErrors()) {
            return "registration";
        }
        // save in database
        boolean isUniqueEmail = userService.register(user);
        if (!isUniqueEmail) {
            model.addAttribute("isUniqueEmail", "adres" + user.getEmail() + " już istnieje w bazie danych");
            return "registration";
        }
        return "index";
    }
}
