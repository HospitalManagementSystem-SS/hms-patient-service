package com.hms.patient.service.controller;

import com.hms.patient.service.model.Patient;
import com.hms.patient.service.services.PatientService;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/patients")
public class PatientController {

    private final PatientService service;

    public PatientController(PatientService service) {
        this.service = service;
    }

    @PostMapping
    public Patient create(@Valid @RequestBody Patient patient) {
        return service.save(patient);
    }

    @GetMapping
    public List<Patient> list() {
        return service.findAll();
    }

    @GetMapping("/{id}")
    public Patient get(@PathVariable Long id) {
        return service.findById(id);
    }
}

