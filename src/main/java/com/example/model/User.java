package com.example.model;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import java.util.List;
import java.util.Set;

@Entity

@NoArgsConstructor
@Data
public class User {

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
    String password;

    private Set<Role> roles;

    private List<Radiator>radiators;



}
