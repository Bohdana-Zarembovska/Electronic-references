package org.electronicReferences.services;

import org.electronicReferences.dto.ReferenceDTO;
import org.electronicReferences.models.Reference;
import org.electronicReferences.mappers.ReferenceMapper;
import org.electronicReferences.repositories.ReferenceRepository;

import jakarta.persistence.EntityNotFoundException;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@AllArgsConstructor
@Service
public class ReferenceService {
    private final ReferenceRepository referenceRepository;
    private final ReferenceMapper referenceMapper;

    public ReferenceDTO addReference(ReferenceDTO referenceDTO) {
        Reference reference = referenceMapper.toEntity(referenceDTO);
        Reference savedReference = referenceRepository.save(reference);
        return referenceMapper.toDTO(savedReference);
    }

    public ReferenceDTO updateReference(Integer id, ReferenceDTO referenceDTO) {
        Reference reference = referenceRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("reference with this id is not found"));

        referenceMapper.updateReferenceFromDTO(referenceDTO, reference);
        return referenceMapper.toDTO(referenceRepository.save(reference));
    }

    public ReferenceDTO getReferenceById(Integer referenceId) {
        Reference reference = referenceRepository.findById(referenceId)
                .orElseThrow(() -> new EntityNotFoundException("reference with this id is not found"));
        return referenceMapper.toDTO(reference);
    }

    public void deleteReferenceById(Integer referenceId) {
        Reference reference = referenceRepository.findById(referenceId)
                .orElseThrow(() -> new EntityNotFoundException("reference with this id is not found"));
        referenceRepository.deleteById(referenceId);
    }
}
