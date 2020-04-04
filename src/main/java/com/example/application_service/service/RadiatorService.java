package com.example.application_service.service;

import com.example.application_service.model.Radiator;
import com.example.application_service.repository.RadiatorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class RadiatorService {
    private RadiatorRepository radiatorRepository;

    @Autowired
    public RadiatorService(RadiatorRepository radiatorRepository) {
        this.radiatorRepository = radiatorRepository;
    }


    public List<Radiator> getAllRadiatorsOrderByPublicationDateDesc() {
        return radiatorRepository.findAll(Sort.by(Sort.Direction.DESC, "publicationDate"));
    }

    public Optional<Radiator> getRadiatorById(Long radiatorId) {
        return radiatorRepository.findById(radiatorId);
    }

    public Boolean addRadiator(Radiator radiator) {
        if (radiatorRepository.findAll().stream().anyMatch(r -> r.getRadiatorName().equals(radiator.getRadiatorName()))) {
            return false;
        }
        radiatorRepository.save(radiator);
        return true;
    }

    public List<Radiator> getAllRadiators() {
        return radiatorRepository.findAll();
    }

    public Boolean deleteRadiatorById(Long radiatorId) {
        if (radiatorRepository.findById(radiatorId).isPresent()) {
            radiatorRepository.deleteById(radiatorId);
            return true;
        }
        return false;
    }

    public Boolean deleteRadiatorByName(String radiatorName) {
        Radiator radiator = radiatorRepository.findRadiatorByRadiatorName(radiatorName);
        if (radiator != null) {
            radiatorRepository.delete(radiator);
            return true;
        }
        return false;
    }

    public Boolean updateRadiator(Long radiatorId, String radiatorName, Integer heatingPower) {
        Optional<Radiator> radiatorOpt = radiatorRepository.findById(radiatorId);
        if (radiatorOpt.isPresent()) {
            Radiator radiator = radiatorOpt.get();
            radiator.setRadiatorName(radiatorName != null ? radiatorName : radiator.getRadiatorName());
            radiator.setHeatingPower(heatingPower != null ? heatingPower : radiator.getHeatingPower());
            radiatorRepository.save(radiator);
        }
        return false;
    }


    public List<Radiator> findRadiatorByHeatingPower(Integer higherPower, Integer lowerPower) {
        List<Radiator> radiatorOpt = radiatorRepository.findRadiatorByHeatingPowerBetween(higherPower,lowerPower);
        return radiatorOpt;
    }
}
