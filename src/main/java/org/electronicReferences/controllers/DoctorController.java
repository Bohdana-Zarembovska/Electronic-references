package org.electronicReferences.controllers;

import org.electronicReferences.dto.DoctorDTO;
import org.electronicReferences.services.DoctorService;
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
@RequestMapping("/doctors")
public class DoctorController {
    private final DoctorService doctorService;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public DoctorDTO addDoctor(@Valid @RequestBody DoctorDTO doctorDTO){
        return doctorService.addDoctor(doctorDTO);
    }

    @PutMapping("/{id}")
    public DoctorDTO updateDoctor(@PathVariable Integer id, @RequestBody DoctorDTO doctorDTO) {
        return doctorService.updateDoctor(id, doctorDTO);
    }

    @GetMapping("/{id}")
    public DoctorDTO getDoctorById(@PathVariable Integer id) {
        return doctorService.getDoctorById(id);
    }
}
