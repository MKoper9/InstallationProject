package com.example.application_service.repository;

import com.example.application_service.model.Producer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProducerRepistory extends JpaRepository<Producer, Long> {
}
