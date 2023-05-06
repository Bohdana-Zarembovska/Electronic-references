package org.electronicReferences.services;

import org.electronicReferences.dto.DoctorDTO;
import org.electronicReferences.models.Doctor;
import org.electronicReferences.mappers.DoctorMapper;
import org.electronicReferences.repositories.DoctorRepository;

import jakarta.persistence.EntityNotFoundException;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@AllArgsConstructor
@Service
public class DoctorService {
    private final DoctorRepository doctorRepository;
    private final DoctorMapper doctorMapper;

    public DoctorDTO addDoctor (DoctorDTO doctorDTO) {
        Doctor doctor = doctorMapper.toEntity(doctorDTO);
        Doctor savedDoctor = doctorRepository.save(doctor);
        return doctorMapper.toDTO(savedDoctor);
    }

    public DoctorDTO updateDoctor(Integer id, DoctorDTO doctorDTO) {
        Doctor doctor = doctorRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("doctor with this id is not found"));

        doctorMapper.updateDoctorFromDTO(doctorDTO, doctor);
        return doctorMapper.toDTO(doctorRepository.save(doctor));
    }

    public DoctorDTO getDoctorById(Integer doctorId) {
        Doctor doctor = doctorRepository.findById(doctorId)
                .orElseThrow(() -> new EntityNotFoundException("doctor with this id is not found"));
        return doctorMapper.toDTO(doctor);
    }

}
