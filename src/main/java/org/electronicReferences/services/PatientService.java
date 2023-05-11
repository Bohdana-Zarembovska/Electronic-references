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

    private static final String PATIENT_MESSAGE = "Patient with ID %d is not found";
    public PatientUpdateGetDTO addPatient(PatientCreateDTO patientCreateDTO) {
        Patient patient = patientMapper.toEntity(patientCreateDTO);
        Patient savedPatient = patientRepository.save(patient);
        return patientMapper.toDTO(savedPatient);
    }

    public PatientUpdateGetDTO updatePatient(Integer id, PatientUpdateGetDTO patientUpdateGetDTO) {
        Patient patient = patientRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException(String.format(PATIENT_MESSAGE, id)));

        patientMapper.updatePatientFromDTO(patientUpdateGetDTO, patient);
        return patientMapper.toDTO(patientRepository.save(patient));
    }

    public PatientUpdateGetDTO getPatientById(Integer patientId) {
        Patient patient = patientRepository.findById(patientId)
                .orElseThrow(() -> new EntityNotFoundException(String.format(PATIENT_MESSAGE, patientId)));
        return patientMapper.toDTO(patient);
    }

}
