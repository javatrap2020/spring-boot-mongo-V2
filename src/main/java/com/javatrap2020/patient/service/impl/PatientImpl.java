package com.javatrap2020.patient.service.impl;

import com.javatrap2020.patient.exeption.PatientAlreadyExistException;
import com.javatrap2020.patient.exeption.PatientNotFoundException;
import com.javatrap2020.patient.model.Patient;
import com.javatrap2020.patient.repository.PatientRepository;
import com.javatrap2020.patient.service.PatientService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.List;

@Slf4j
@Service
public class PatientImpl implements PatientService {

    @Autowired
    private PatientRepository patientRepository;

    @Override
    public List<Patient> getAllPatients() {
        return patientRepository.findAll();
    }

    @Override
    public Patient save(Patient patient) throws UnknownHostException {
        if (patientRepository.findByEmail(patient.getEmail()).isPresent()) {
            throw new PatientAlreadyExistException();
        }
        Patient patient1 = patientRepository.save(patient);
        log.info("Creating new patient {}", patient);
        InetAddress inetAddress = InetAddress.getLocalHost();
        log.info("Find patient by localhost {}" + inetAddress.getHostAddress());
        return patient1;
    }



    @Override
    public Patient update(Patient patient) {
        Patient patient1 = patientRepository.findByEmail(patient.getEmail()).orElseThrow(PatientNotFoundException::new);
        patient1.setName(patient.getName());
        patient1.setMessage(patient.getMessage());
        log.info("Updating patient {}", patient);
        return patientRepository.save(patient1);
    }

//    @Override
//    public void delete(String id) {
//        patientRepository.deleteById(id);
//        log.info("Deleting patient {}", id);
//    }

    @Override
    public void delete(String email) {
        patientRepository.deleteById(patientRepository.findByEmail(email).orElseThrow(PatientNotFoundException::new).getId());
    }
}
