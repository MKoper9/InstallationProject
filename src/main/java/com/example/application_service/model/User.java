package com.example.application_service.model;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Set;

@Data
public class User {

    @Column(name = "user_id")
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long userId;
    @NotBlank(message = "pole obowiązkowe")
    @Size(min = 3, max = 255, message = "imię musi zawierać się od {min} do {max} znaków")
    private String name;
    @NotBlank(message = "pole obowiązkowe")
    @Size(min = 3, max = 255, message = "nazwoisko musi zawierać się od {min} do {max} znaków")
    private String lastName;
    @NotBlank(message = "pole obowiązkowe")
    @Email(message = "niepoprawny email")
    private String email;
    @NotBlank(message = "pole obowiązkowe")
    @Size(min = 6, max = 255, message = "hasło musi zawierać się od {min} do {max} znaków")
    private String password;

    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(
            name = "user_role",
            joinColumns = @JoinColumn(name = "user_id"),
            inverseJoinColumns = @JoinColumn(name = "role_id")
    )
    private Set<Role> roles;

    private List<Radiator>radiators;
    private LocalDateTime registrationDate;
    private Boolean status;
    private String companyNip;
    private String companyName;
    private String companyAddress;

    //constructor user
    public User(String name, String lastName,  String email,
                String password, Set<Role> roles, List<Radiator> radiators,
                LocalDateTime registrationDate, Boolean status) {
        this.name = name;
        this.lastName = lastName;
        this.email = email;
        this.password = password;
        this.roles = roles;
        this.radiators = radiators;
        this.registrationDate = registrationDate;
        this.status = status;
    }

    //constructor company
    public User(String name, String lastName, String email,
                String password, Set<Role> roles, List<Radiator> radiators,
                LocalDateTime registrationDate, Boolean status, String companyNip,
                String companyName, String companyAddress) {
        this.name = name;
        this.lastName = lastName;
        this.email = email;
        this.password = password;
        this.roles = roles;
        this.radiators = radiators;
        this.registrationDate = registrationDate;
        this.status = status;
        this.companyNip = companyNip;
        this.companyName = companyName;
        this.companyAddress = companyAddress;
    }
}
