package org.electronicReferences.services;

import org.electronicReferences.models.Patient;
import org.electronicReferences.mappers.PatientMapper;
import org.electronicReferences.repositories.PatientRepository;
import org.electronicReferences.dto.PatientDTOs.PatientCreateDTO;
import org.electronicReferences.dto.PatientDTOs.PatientUpdateGetDTO;
import jakarta.persistence.EntityNotFoundException;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@AllArgsConstructor
@Service
public class PatientService {
    private final PatientRepository patientRepository;
    private final PatientMapper patientMapper;
    private final PatientCreateDTO patientCreateDTO;
    private final PatientUpdateGetDTO patientUpdateGetDTO;

    public PatientUpdateGetDTO addPatient(PatientCreateDTO patientCreateDTO) {
        Patient patient = patientMapper.toEntity(patientCreateDTO);
        Patient savedPatient = patientRepository.save(patient);
        return patientMapper.toDTO(savedPatient);
    }

    public PatientUpdateGetDTO updatePatient(Integer id, PatientUpdateGetDTO patientUpdateGetDTO) {
        Patient patient = patientRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("patient with this id is not found"));

        patientMapper.updatePatientFromDTO(patientUpdateGetDTO, patient);
        return patientMapper.toDTO(patientRepository.save(patient));
    }

    public PatientUpdateGetDTO getPatientById(Integer patientId) {
        Patient patient = patientRepository.findById(patientId)
                .orElseThrow(() -> new EntityNotFoundException("patient with this id is not found"));
        return patientMapper.toDTO(patient);
    }

}
