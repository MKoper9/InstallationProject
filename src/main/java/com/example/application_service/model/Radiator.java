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
    @Column(name = "radiator_name")
    private String radiatorName;
    @Column(name = "heating_power")
    private Integer heatingPower;

    public Radiator(String radiatorName, Integer heatingPower) {
        if(heatingPower>0){
        this.radiatorName = radiatorName;
        this.heatingPower = heatingPower;
        }else {
            throw new IllegalArgumentException("heating power must over than 0");
        }
    }
}
