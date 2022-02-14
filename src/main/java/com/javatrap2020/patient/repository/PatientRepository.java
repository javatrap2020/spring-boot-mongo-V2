package com.javatrap2020.patient.repository;

import com.javatrap2020.patient.model.Patient;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface PatientRepository  extends MongoRepository<Patient, Long> {
    Optional<Patient> findByEmail(@Param("email") String email);
}
