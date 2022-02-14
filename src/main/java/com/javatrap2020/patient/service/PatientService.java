package com.javatrap2020.patient.service;

import com.javatrap2020.patient.model.Patient;

import java.net.UnknownHostException;
import java.util.List;

public interface PatientService {

    List<Patient> getAllPatients();

    Patient save(Patient patient) throws UnknownHostException;

    Patient update(Patient patient);

}
