package org.electronicReferences.controllers;

import org.electronicReferences.services.DiagnosisService;
import org.electronicReferences.dto.DiagnosisDTOs.DiagnosisCreateDTO;
import org.electronicReferences.dto.DiagnosisDTOs.DiagnosisUpdateDTO;
import org.electronicReferences.dto.DiagnosisDTOs.DiagnosisGetDTO;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
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
@RequestMapping("/diagnoses")
public class DiagnosisController {
    private final DiagnosisService diagnosisService;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public DiagnosisGetDTO addDiagnosis(@Valid @RequestBody DiagnosisCreateDTO diagnosisCreateDTO) {
        return diagnosisService.addDiagnosis(diagnosisCreateDTO);
    }

    @PutMapping("/{id}")
    public DiagnosisGetDTO updateDiagnosis(@PathVariable Integer id, @RequestBody DiagnosisUpdateDTO diagnosisUpdateDTO) {
        return diagnosisService.updateDiagnosis(id, diagnosisUpdateDTO);
    }

    @GetMapping("/{id}")
    public DiagnosisGetDTO getDiagnosisById(@PathVariable Integer id) {
        return diagnosisService.getDiagnosisById(id);
    }

    @DeleteMapping("/{id}")
    public void deleteDiagnosis(@PathVariable Integer id) {
        diagnosisService.deleteDiagnosis(id);
    }
}
