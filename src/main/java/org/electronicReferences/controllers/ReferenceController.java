package org.electronicReferences.controllers;

import org.electronicReferences.dto.ReferenceDTO;
import org.electronicReferences.services.ReferenceService;
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
@RequestMapping("/references")
public class ReferenceController {
    private final ReferenceService referenceService;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public ReferenceDTO addReference(@Valid @RequestBody ReferenceDTO referenceDTO){
        return referenceService.addReference(referenceDTO);
    }

    @PutMapping("/{id}")
    public ReferenceDTO updateReference(@PathVariable Integer id, @RequestBody ReferenceDTO referenceDTO) {
        return referenceService.updateReference(id, referenceDTO);
    }

    @GetMapping("/{id}")
    public ReferenceDTO getReferenceById(@PathVariable Integer id) {
        return referenceService.getReferenceById(id);
    }

    @DeleteMapping("/{id}")
    public void deleteReference(@PathVariable Integer id) {
        referenceService.deleteReferenceById(id);
    }
}

