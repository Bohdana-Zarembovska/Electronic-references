package org.electronicReferences.services;

import org.electronicReferences.models.Diagnosis;
import org.electronicReferences.mappers.DiagnosisMapper;
import org.electronicReferences.repositories.DiagnosisRepository;
import org.electronicReferences.dto.DiagnosisDTOs.DiagnosisCreateDTO;
import org.electronicReferences.dto.DiagnosisDTOs.DiagnosisUpdateDTO;
import org.electronicReferences.dto.DiagnosisDTOs.DiagnosisGetDTO;
import jakarta.persistence.EntityNotFoundException;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@AllArgsConstructor
@Service
public class DiagnosisService {
    private final DiagnosisRepository diagnosisRepository;
    private final DiagnosisMapper diagnosisMapper;
    private final DiagnosisCreateDTO diagnosisCreateDTO;
    private final DiagnosisUpdateDTO diagnosisUpdateDTO;
    private final DiagnosisGetDTO diagnosisGetDTO;

    public DiagnosisGetDTO addDiagnosis(DiagnosisCreateDTO diagnosisCreateDTO) {
        Diagnosis diagnosis = diagnosisMapper.toEntity(diagnosisCreateDTO);
        Diagnosis savedDiagnosis = diagnosisRepository.save(diagnosis);
        return diagnosisMapper.toDTO(savedDiagnosis);
    }

    public DiagnosisGetDTO updateDiagnosis(Integer id, DiagnosisUpdateDTO diagnosisUpdateDTO) {
        Diagnosis diagnosis = diagnosisRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("diagnosis with this id is not found"));

        diagnosisMapper.updateDiagnosisFromDTO(diagnosisUpdateDTO, diagnosis);
        return diagnosisMapper.toDTO(diagnosisRepository.save(diagnosis));
    }

    public DiagnosisGetDTO getDiagnosisById(Integer diagnosisId) {
        Diagnosis diagnosis = diagnosisRepository.findById(diagnosisId)
                .orElseThrow(() -> new EntityNotFoundException("diagnosis with this id is not found"));
        return diagnosisMapper.toDTO(diagnosis);
    }

    public void deleteDiagnosis(Integer id) {
        diagnosisRepository.deleteById(id);
    }
}
