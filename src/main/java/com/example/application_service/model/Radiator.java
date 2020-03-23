package com.example.application_service.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Entity
@Table(name = "radiator")
public class Radiator {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "radiator_id")
    private Long radiatorId;
    private String radiatorName;
    private Double heatingPower;
}
