package org.electronicReferences.controllers;

import org.electronicReferences.services.ReferenceService;
import org.electronicReferences.dto.ReferenceDTOs.ReferenceCreateDTO;
import org.electronicReferences.dto.ReferenceDTOs.ReferenceUpdateGetDTO;
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
public class ReferenceController {
    private final ReferenceService referenceService;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public ReferenceUpdateGetDTO addReference(@Valid @RequestBody ReferenceCreateDTO referenceCreateDTO) {
        return referenceService.addReference(referenceCreateDTO);
    }

    @PutMapping("/{id}")
    public ReferenceUpdateGetDTO updateReference(@PathVariable Integer id, @RequestBody ReferenceUpdateGetDTO referenceUpdateGetDTO) {
        return referenceService.updateReference(id, referenceUpdateGetDTO);
    }

    @GetMapping("/{id}")
    public ReferenceUpdateGetDTO getReferenceById(@PathVariable Integer id) {
        return referenceService.getReferenceById(id);
    }

    @DeleteMapping("/{id}")
    public void deleteReference(@PathVariable Integer id) {
        referenceService.deleteReference(id);
    }
}
