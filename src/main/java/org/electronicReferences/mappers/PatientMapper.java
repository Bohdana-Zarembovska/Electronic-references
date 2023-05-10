package org.electronicReferences.mappers;

import org.electronicReferences.dto.PatientDTOs.PatientCreateDTO;
import org.electronicReferences.dto.PatientDTOs.PatientUpdateGetDTO;

import org.electronicReferences.models.Patient;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;


@Mapper(componentModel = "spring")
public interface PatientMapper {

    @Mapping(target = "id", ignore = true)
    Patient toEntity(PatientCreateDTO patientCreateDTO);

    void updatePatientFromDTO(PatientUpdateGetDTO patientUpdateGetDTO, @MappingTarget Patient patient);

    PatientUpdateGetDTO toPatientGetDTO(Patient patient);

    default PatientUpdateGetDTO toDTO(Patient patient) {
        return toPatientGetDTO(patient);
    }

}
