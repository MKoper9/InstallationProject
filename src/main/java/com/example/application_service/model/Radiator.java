package com.example.application_service.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
public class Radiator {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long radiatorId;
    private String name;
    private Double heatingPower;
    private Material material;
    private Producer producer;


}
