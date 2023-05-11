package org.electronicReferences.services;

import org.electronicReferences.models.Doctor;
import org.electronicReferences.mappers.DoctorMapper;
import org.electronicReferences.repositories.DoctorRepository;
import org.electronicReferences.dto.DoctorDTOs.DoctorCreateDTO;
import org.electronicReferences.dto.DoctorDTOs.DoctorUpdateGetDTO;
import jakarta.persistence.EntityNotFoundException;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@AllArgsConstructor
@Service
public class DoctorService {
    private final DoctorRepository doctorRepository;
    private final DoctorMapper doctorMapper;
    private final DoctorCreateDTO doctorCreateDTO;
    private final DoctorUpdateGetDTO doctorUpdateGetDTO;

    private static final String DOCTOR_MESSAGE = "Doctor with ID %d is not found";
    public DoctorUpdateGetDTO addDoctor(DoctorCreateDTO doctorCreateDTO) {
        Doctor doctor = doctorMapper.toEntity(doctorCreateDTO);
        Doctor savedDoctor = doctorRepository.save(doctor);
        return doctorMapper.toDTO(savedDoctor);
    }

    public DoctorUpdateGetDTO updateDoctor(Integer id, DoctorUpdateGetDTO doctorUpdateGetDTO) {
        Doctor doctor = doctorRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException(String.format(DOCTOR_MESSAGE, id)));

        doctorMapper.updateDoctorFromDTO(doctorUpdateGetDTO, doctor);
        return doctorMapper.toDTO(doctorRepository.save(doctor));
    }

    public DoctorUpdateGetDTO getDoctorById(Integer doctorId) {
        Doctor doctor = doctorRepository.findById(doctorId)
                .orElseThrow(() -> new EntityNotFoundException(String.format(DOCTOR_MESSAGE, doctorId)));
        return doctorMapper.toDTO(doctor);
    }

}
