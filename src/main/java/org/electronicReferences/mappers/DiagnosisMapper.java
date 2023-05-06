package org.electronicReferences.mappers;

import org.electronicReferences.dto.DiagnosisDTO;
import org.electronicReferences.models.Diagnosis;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;

@Mapper(componentModel = "spring")
public interface DiagnosisMapper {

    @Mapping(target = "id", ignore = true)
    Diagnosis toEntity(DiagnosisDTO diagnosisDTO);

    DiagnosisDTO toDTO(Diagnosis diagnosis);

    @Mapping(target = "id", ignore = true)
    void updateDiagnosisFromDTO(DiagnosisDTO diagnosisDTO, @MappingTarget Diagnosis diagnosis);

}
