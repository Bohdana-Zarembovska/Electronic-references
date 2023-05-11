package org.electronicReferences.controllers;

import org.electronicReferences.services.PatientService;
import org.electronicReferences.dto.PatientDTOs.PatientCreateDTO;
import org.electronicReferences.dto.PatientDTOs.PatientUpdateGetDTO;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RestController
@RequestMapping("/patients")
public class PatientController {
    private final PatientService patientService;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public PatientUpdateGetDTO addPatient(@Valid @RequestBody PatientCreateDTO patientCreateDTO) {
        return patientService.addPatient(patientCreateDTO);
    }

    @PutMapping("/{id}")
    public PatientUpdateGetDTO updatePatient(@PathVariable Integer id, @RequestBody PatientUpdateGetDTO patientUpdateDTO) {
        return patientService.updatePatient(id, patientUpdateDTO);
    }

    @GetMapping("/{id}")
    public PatientUpdateGetDTO getPatientById(@PathVariable Integer id) {
        return patientService.getPatientById(id);
    }

}
