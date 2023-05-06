package org.electronicReferences.services;

import org.electronicReferences.dto.PatientDTO;
import org.electronicReferences.models.Patient;
import org.electronicReferences.mappers.PatientMapper;
import org.electronicReferences.repositories.PatientRepository;

import jakarta.persistence.EntityNotFoundException;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@AllArgsConstructor
@Service
public class PatientService {
    private final PatientRepository patientRepository;
    private final PatientMapper patientMapper;

    public PatientDTO addPatient(PatientDTO patientDTO) {
        Patient patient = patientMapper.toEntity(patientDTO);
        Patient savedPatient = patientRepository.save(patient);
        return patientMapper.toDTO(savedPatient);
    }

    public PatientDTO updatePatient(Integer id, PatientDTO patientDTO) {
        Patient patient = patientRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("patient with this id is not found"));

        patientMapper.updatePatientFromDTO(patientDTO, patient);
        return patientMapper.toDTO(patientRepository.save(patient));
    }

    public PatientDTO getPatientById(Integer patientId) {
        Patient patient = patientRepository.findById(patientId)
                .orElseThrow(() -> new EntityNotFoundException("patient with this id is not found"));
        return patientMapper.toDTO(patient);
    }

}

