package com.javatrap2020.patient.repository;

import com.javatrap2020.patient.model.Patient;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.repository.query.Param;

import java.util.Optional;

public interface PatientRepository  extends MongoRepository<Patient, Long> {
    Optional<Patient> finByEmail(@Param("email") String email);
}
