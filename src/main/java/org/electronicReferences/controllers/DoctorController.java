package org.electronicReferences.controllers;

import org.electronicReferences.services.DoctorService;
import org.electronicReferences.dto.DoctorDTOs.DoctorCreateDTO;
import org.electronicReferences.dto.DoctorDTOs.DoctorUpdateGetDTO;
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
    public DoctorUpdateGetDTO addDoctor(@Valid @RequestBody DoctorCreateDTO doctorCreateDTO) {
        return doctorService.addDoctor(doctorCreateDTO);
    }

    @PutMapping("/{id}")
    public DoctorUpdateGetDTO updateDoctor(@PathVariable Integer id, @RequestBody DoctorUpdateGetDTO doctorUpdateDTO) {
        return doctorService.updateDoctor(id, doctorUpdateDTO);
    }

    @GetMapping("/{id}")
    public DoctorUpdateGetDTO getDoctorById(@PathVariable Integer id) {

        return doctorService.getDoctorById(id);
    }

}
