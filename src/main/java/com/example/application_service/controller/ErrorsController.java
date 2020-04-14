package com.example.application_service.controller;

import com.example.application_service.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.servlet.error.ErrorController;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ErrorsController implements ErrorController {
    private UserService userService;

    @Autowired
    public ErrorsController(UserService userService) {
        this.userService = userService;
    }

    @Override
    public String getErrorPath() {
        return "error-page";
    }

    @GetMapping("/login-error")
    public String loginErrorPage(Model model, Authentication auth) {
        model.addAttribute("loggedEmail", auth != null ? ((UserDetails) auth.getPrincipal()).getUsername() : "");
        model.addAttribute("isLogged", auth != null);
        model.addAttribute("isAdmin", userService.hasRole(auth, "ROLE_ADMIN")); // check Admin permit
        model.addAttribute("isCompany", userService.hasRole(auth, "ROLE_COMPANY")); // check Company permit
        model.addAttribute("info", "Błąd logowania");
        return "error-page";
    }
}
