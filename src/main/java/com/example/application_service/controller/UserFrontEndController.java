package com.example.application_service.controller;

import com.example.application_service.model.Radiator;
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
import java.util.ArrayList;
import java.util.List;

@Controller
public class UserFrontEndController {

    private UserService userService;
    private RadiatorService radiatorService;

    @Autowired
    public UserFrontEndController(UserService userService, RadiatorService radiatorService) {
        this.userService = userService;
        this.radiatorService = radiatorService;
    }

    /*
    "Model"
    Simply put, the model can supply attributes used for rendering views.
    To provide a view with usable data, we simply add this data to its Model object.
    Additionally, maps with attributes can be merged with Model instances:

    "Authentication"
    Represents the token for an authentication request or for an authenticated principal
    once the request has been processed by the AuthenticationManager.authenticate(Authentication) method.
     */
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
        model.addAttribute("isAdmin", userService.hasRole(auth, "ROLE_ADMIN"));
        model.addAttribute("isCompany", userService.hasRole(auth, "ROLE_COMPANY"));
        model.addAttribute("loggedEmail", auth != null ? ((UserDetails) auth.getPrincipal()).getUsername() : "");

        return "index";
    }

    @GetMapping("/registration")
    public String registration(Authentication auth, Model model) {
        model.addAttribute("isLogged", auth != null);
        model.addAttribute("user", new User()); // give to Thymeleaf resolver object User
        return "registration";
    }

    /*
    "BindingResult"
    General interface that represents binding results.
    Extends the interface for error registration capabilities, allowing for
    a Validator to be applied, and adds binding-specific analysis and model building.
     */
    @PostMapping("/registration")
    public String registration(@ModelAttribute("user") @Valid User user, BindingResult bindingResult, Model model, Authentication auth)
    {
        if (bindingResult.hasErrors()) {
            return "registration";
        }
        // save in database
        boolean isUniqueEmail = userService.register(user);
        if (!isUniqueEmail) {
            model.addAttribute("isUniqueEmail", "adres" + user.getEmail() + " już istnieje w bazie danych");
            return "registration";
        }
        model.addAttribute("loggedEmail",auth!=null? ((UserDetails)auth.getPrincipal()).getUsername() : "");
        model.addAttribute("isLogged", auth!=null);
        model.addAttribute("radiators", radiatorService.getAllRadiatorsOrderByPublicationDateDesc());
        model.addAttribute("isAdmin", userService.hasRole(auth,"ROLE_ADMIN"));
        model.addAttribute("isCompany", userService.hasRole(auth,"ROLE_COMPANY"));
        model.addAttribute("loggedEmail", auth != null ? ((UserDetails)auth.getPrincipal()).getUsername() : "");
        return "index";
    }

    @GetMapping("/userProfile")
    public String userProfile(Authentication auth, Model model){
        model.addAttribute("loggedEmail", auth != null ? ((UserDetails)auth.getPrincipal()).getUsername() : "");    // do sprawdzenia właściciela zadania
        model.addAttribute("isLogged", auth != null);
        model.addAttribute("radiators", radiatorService.getAllRadiatorsOrderByPublicationDateDesc());
        model.addAttribute("isAdmin", userService.hasRole(auth, "ROLE_ADMIN"));         // do sprawdzania uprawnień R_A
        model.addAttribute("isCompany", userService.hasRole(auth, "ROLE_COMPANY"));     // do sprawdzania uprawnień R_C
        model.addAttribute("loggedEmail", auth != null ? ((UserDetails)auth.getPrincipal()).getUsername() : "");
        model.addAttribute("user", auth != null ? userService.getUserByEmail(((UserDetails)auth.getPrincipal()).getUsername()) : "");
        model.addAttribute("roleList",
                auth != null ?
                        new ArrayList<>(userService.getUserByEmail(((UserDetails)auth.getPrincipal()).getUsername()).getRoles()) :
                        new ArrayList<>());
                return "userProfile";
    }


@GetMapping("/radiatorsList")
    public String radiators(Model model){

        model.addAttribute("radiator", radiatorService.getAllRadiators());
        return "radiatorsList";
}



}
