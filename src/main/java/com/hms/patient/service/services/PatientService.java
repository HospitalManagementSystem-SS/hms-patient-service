package com.hms.patient.service.services;

import com.hms.patient.service.model.Patient;
import com.hms.patient.service.repository.PatientRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PatientService {

    private final PatientRepository repository;

    public PatientService(PatientRepository repository) {
        this.repository = repository;
    }

    public Patient save(Patient p) {
        return repository.save(p);
    }

    public List<Patient> findAll() {
        return repository.findAll();
    }

    public Patient findById(Long id) {
        return repository.findById(id).orElse(null);
    }
}

