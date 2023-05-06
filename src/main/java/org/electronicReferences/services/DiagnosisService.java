package org.electronicReferences.services;

import org.electronicReferences.dto.DiagnosisDTO;
import org.electronicReferences.models.Diagnosis;
import org.electronicReferences.mappers.DiagnosisMapper;
import org.electronicReferences.repositories.DiagnosisRepository;

import jakarta.persistence.EntityNotFoundException;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@AllArgsConstructor
@Service
public class DiagnosisService {
    private final DiagnosisRepository diagnosisRepository;
    private final DiagnosisMapper diagnosisMapper;

    public DiagnosisDTO addDiagnosis(DiagnosisDTO diagnosisDTO) {
        Diagnosis diagnosis = diagnosisMapper.toEntity(diagnosisDTO);
        Diagnosis savedDiagnosis = diagnosisRepository.save(diagnosis);
        return diagnosisMapper.toDTO(savedDiagnosis);
    }

    public DiagnosisDTO updateDiagnosis(Integer id, DiagnosisDTO diagnosisDTO) {
        Diagnosis diagnosis = diagnosisRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("diagnosis with this id is not found"));

        diagnosisMapper.updateDiagnosisFromDTO(diagnosisDTO, diagnosis);
        return diagnosisMapper.toDTO(diagnosisRepository.save(diagnosis));
    }

    public DiagnosisDTO getDiagnosisById(Integer diagnosisId) {
        Diagnosis diagnosis = diagnosisRepository.findById(diagnosisId)
                .orElseThrow(() -> new EntityNotFoundException("diagnosis with this id is not found"));
        return diagnosisMapper.toDTO(diagnosis);
    }

    public void deleteDiagnosisById(Integer diagnosisId) {
        Diagnosis diagnosis = diagnosisRepository.findById(diagnosisId)
                .orElseThrow(() -> new EntityNotFoundException("diagnosis with this id is not found"));
        diagnosisRepository.deleteById(diagnosisId);
    }
}
