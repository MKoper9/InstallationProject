package com.example.application_service.controller;

import com.example.application_service.model.Radiator;
import com.example.application_service.service.RadiatorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class RadiatorController {

    private RadiatorService radiatorService;

    @Autowired
    public RadiatorController(RadiatorService radiatorService) {
        this.radiatorService = radiatorService;
    }

    @PostMapping(path = "/addRadiator")
    public Boolean addRadiator(@RequestParam String radiatorName, @RequestParam Double heatingPower){
        return radiatorService.addRadiator(new Radiator(radiatorName,heatingPower));
    }

    @GetMapping(path = "/radiators")
    public List<Radiator> getAllRadiators(){
        return radiatorService.getAllRadiators();
    }
}
