package org.electronicReferences.controllers;

import org.electronicReferences.dto.PatientDTO;
import org.electronicReferences.services.PatientService;
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
    public PatientDTO addPatient(@Valid @RequestBody PatientDTO patientDTO){
        return patientService.addPatient(patientDTO);
    }

    @PutMapping("/{id}")
    public PatientDTO updatePatient(@PathVariable Integer id, @RequestBody PatientDTO patientDTO) {
        return patientService.updatePatient(id, patientDTO);
    }

    @GetMapping("/{id}")
    public PatientDTO getPatientById(@PathVariable Integer id) {
        return patientService.getPatientById(id);
    }
}
