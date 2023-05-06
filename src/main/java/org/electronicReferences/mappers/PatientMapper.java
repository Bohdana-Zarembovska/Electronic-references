package org.electronicReferences.mappers;

import org.electronicReferences.dto.PatientDTO;
import org.electronicReferences.models.Patient;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;

@Mapper(componentModel = "spring")
public interface PatientMapper {

    @Mapping(target = "id", ignore = true)
    Patient toEntity(PatientDTO patientDTO);

    PatientDTO toDTO(Patient patient);

    @Mapping(target = "id", ignore = true)
    void updatePatientFromDTO(PatientDTO patientDTO, @MappingTarget Patient patient);

}
