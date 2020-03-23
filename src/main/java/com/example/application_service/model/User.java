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

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
@Table(name = "user")
public class User {

    @Column(name = "user_id")
    @Id
    @GeneratedValue
    private Long userId;
    @NotBlank(message = "pole obowiązkowe")
    @Size(min = 3, max = 255, message = "imię musi zawierać od {min} do {max} znaków")
    private String name;
    @NotBlank(message = "pole obowiązkowe")
    @Size(min = 3, max = 255, message = "nazwisko musi zawierać od {min} do {max} znaków")
    private String lastName;
    @NotBlank(message = "pole obowiązkowe")
    @Email(message = "niepoprawny adres e-mail")
    private String email;
    @NotBlank(message = "pole obowiązkowe")
    @Size(min = 6, max = 255, message = "hasło musi zawierać od {min} do {max} znaków")
    private String password;
    private String companyName;
    private String companyAddress;
    @Size(min = 10, max = 10, message = "nip musi zawierać {min} znaków")
    private String companyNip;
    private Boolean status;
    private LocalDateTime registrationDate;
    private List<Radiator> radiators;


    //user
    public User(String name, String lastName, String email,
                String password, LocalDateTime registrationDate,Boolean status, List<Radiator> radiators) {
        this.name = name;
        this.lastName = lastName;
        this.email = email;
        this.password = password;
        this.status = status;
        this.radiators = radiators;
        this.registrationDate=registrationDate;
    }
//company
    public User(String name, String lastName, String email,
                String password, String companyName, String companyAddress, String companyNip, Boolean status, LocalDateTime registrationDate, List<Radiator> radiators) {
        this.name = name;
        this.lastName = lastName;
        this.email = email;
        this.password = password;
        this.companyName = companyName;
        this.companyAddress = companyAddress;
        this.companyNip = companyNip;
        this.status = status;
        this.registrationDate = registrationDate;
        this.radiators = radiators;
    }
}
