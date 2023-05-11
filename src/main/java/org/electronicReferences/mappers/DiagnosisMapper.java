package org.electronicReferences.mappers;

import org.electronicReferences.dto.DiagnosisDTOs.DiagnosisCreateDTO;
import org.electronicReferences.dto.DiagnosisDTOs.DiagnosisUpdateDTO;
import org.electronicReferences.dto.DiagnosisDTOs.DiagnosisGetDTO;
import org.electronicReferences.models.Diagnosis;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;


@Mapper(componentModel = "spring")
public interface DiagnosisMapper {

    @Mapping(target = "id", ignore = true)
    Diagnosis toEntity(DiagnosisCreateDTO diagnosisCreateDTO);

    void updateDiagnosisFromDTO(DiagnosisUpdateDTO diagnosisUpdateDTO, @MappingTarget Diagnosis diagnosis);

    DiagnosisGetDTO toDiagnosisGetDTO(Diagnosis diagnosis);

    default DiagnosisGetDTO toDTO(Diagnosis diagnosis) {
        return toDiagnosisGetDTO(diagnosis);
    }

}
