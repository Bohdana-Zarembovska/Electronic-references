package org.electronicReferences.controllers;

import org.electronicReferences.dto.DiagnosisDTO;
import org.electronicReferences.services.DiagnosisService;
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
    public DiagnosisDTO addDiagnosis(@Valid @RequestBody DiagnosisDTO diagnosisDTO){
        return diagnosisService.addDiagnosis(diagnosisDTO);
    }

    @PutMapping("/{id}")
    public DiagnosisDTO updateDiagnosis(@PathVariable Integer id, @RequestBody DiagnosisDTO diagnosisDTO) {
        return diagnosisService.updateDiagnosis(id, diagnosisDTO);
    }

    @GetMapping("/{id}")
    public DiagnosisDTO getDiagnosisById(@PathVariable Integer id) {
        return diagnosisService.getDiagnosisById(id);
    }

    @DeleteMapping("/{id}")
    public void deleteDiagnosis(@PathVariable Integer id) {
        diagnosisService.deleteDiagnosisById(id);
    }
}
