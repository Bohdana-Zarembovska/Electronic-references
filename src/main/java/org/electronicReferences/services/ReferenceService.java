package org.electronicReferences.services;

import org.electronicReferences.models.Reference;
import org.electronicReferences.mappers.ReferenceMapper;
import org.electronicReferences.repositories.ReferenceRepository;
import org.electronicReferences.dto.ReferenceDTOs.ReferenceCreateDTO;
import org.electronicReferences.dto.ReferenceDTOs.ReferenceUpdateGetDTO;
import jakarta.persistence.EntityNotFoundException;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@AllArgsConstructor
@Service
public class ReferenceService {
    private final ReferenceRepository referenceRepository;
    private final ReferenceMapper referenceMapper;
    private final ReferenceCreateDTO referenceCreateDTO;
    private final ReferenceUpdateGetDTO referenceUpdateGetDTO;

    private static final String REFERENCE_MESSAGE = "Reference with ID %d is not found";
    public ReferenceUpdateGetDTO addReference(ReferenceCreateDTO referenceCreateDTO) {
        Reference reference = referenceMapper.toEntity(referenceCreateDTO);
        Reference savedReference = referenceRepository.save(reference);
        return referenceMapper.toDTO(savedReference);
    }

    public ReferenceUpdateGetDTO updateReference(Integer id, ReferenceUpdateGetDTO referenceUpdateGetDTO) {
        Reference reference = referenceRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException(String.format(REFERENCE_MESSAGE, id)));

        referenceMapper.updateReferenceFromDTO(referenceUpdateGetDTO,reference);
        return referenceMapper.toDTO(referenceRepository.save(reference));
    }

    public ReferenceUpdateGetDTO getReferenceById(Integer referenceId) {
        Reference reference = referenceRepository.findById(referenceId)
                .orElseThrow(() -> new EntityNotFoundException(String.format(REFERENCE_MESSAGE, referenceId)));
        return referenceMapper.toDTO(reference);
    }

    public void deleteReference(Integer id) {
        referenceRepository.deleteById(id);
    }
}