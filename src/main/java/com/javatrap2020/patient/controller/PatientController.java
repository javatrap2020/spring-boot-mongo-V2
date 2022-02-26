package com.javatrap2020.patient.controller;

import com.javatrap2020.patient.model.Patient;
import com.javatrap2020.patient.service.PatientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.net.UnknownHostException;
import java.util.List;

@RestController
@RequestMapping("/patient")
public class PatientController {

    @Autowired
    private PatientService patientService;

    @GetMapping("/patients")
    public ResponseEntity<List<Patient>> getAllPatients() {
        List<Patient> list = patientService.getAllPatients();
        return ResponseEntity.ok().body(list);
    }

    @PostMapping
    public Patient save(@RequestBody Patient patient) throws UnknownHostException {
        return patientService.save(patient);
    }

    @PutMapping
    public Patient update(@RequestBody Patient patient) {
        return patientService.update(patient);
    }

    @DeleteMapping("/{email}")
    public void delete(@PathVariable("email") String email) {
        patientService.delete(email);
    }


}
