package com.example.application_service.repository;

import com.example.application_service.model.Radiator;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RadiatorRepository extends JpaRepository<Radiator, Long> {
    Radiator findRadiatorByRadiatorName(String radiatorName);
}
