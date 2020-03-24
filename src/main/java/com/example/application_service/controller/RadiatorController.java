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
    public Boolean addRadiator(@RequestParam(defaultValue = "test") String radiatorName, @RequestParam(defaultValue = "") Double heatingPower){
        return radiatorService.addRadiator(new Radiator(radiatorName,heatingPower));
    }
    @GetMapping(path = "/radiators")
    public List<Radiator> getAllRadiators(){
        return radiatorService.getAllRadiators();
    }
    @DeleteMapping("/deleteradiator/id{radiator_id}")
    public Boolean deleteRadiatorById(@PathVariable("radiator_id") Long radiatorId){
        return radiatorService.deleteRadiatorById(radiatorId);
    }

}
