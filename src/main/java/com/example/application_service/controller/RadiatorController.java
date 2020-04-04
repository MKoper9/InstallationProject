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
    public Boolean addRadiator(@RequestParam(defaultValue = "test") String radiatorName, @RequestParam(defaultValue = "") Integer heatingPower, Double height
            , Double lenght) {
        return radiatorService.addRadiator(new Radiator(radiatorName, heatingPower,height,lenght));
    }

    @GetMapping(path = "/radiators")
    public List<Radiator> getAllRadiators() {
        return radiatorService.getAllRadiators();
    }

    @DeleteMapping("/deleteRadiator")
    public Boolean deleteRadiatorById(@RequestParam Long radiatorId) {
        return radiatorService.deleteRadiatorById(radiatorId);
    }

    @PutMapping("/updateRadiator")
    public Boolean updateRadiator(@RequestParam Long radiatorId, String radiatorName, Integer heatingPower){
        return radiatorService.updateRadiator(radiatorId,radiatorName,heatingPower);
    }


}
