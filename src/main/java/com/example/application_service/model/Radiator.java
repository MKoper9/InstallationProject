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
    @Column(name="height")
    private Double height;
    @Column(name = "lenght")
    private Double lenght;

    public Radiator(String radiatorName, Integer heatingPower, Double height, Double lenght) {
        this.radiatorName = radiatorName;
        if(height>0){
            this.height=height;
        }else {
            throw new IllegalArgumentException("height must be over than 0");
        }
        if(lenght>0){
            this.height=height;
        }else {
            throw new IllegalArgumentException("lenght must be over than 0");
        }
        if(heatingPower>0){
            this.heatingPower = heatingPower;
        }else {
            throw new IllegalArgumentException("heating power must be over than 0");
        }
    }
}
