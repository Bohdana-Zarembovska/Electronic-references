package org.electronicReferences.mappers;

import org.electronicReferences.dto.DoctorDTOs.DoctorCreateDTO;
import org.electronicReferences.dto.DoctorDTOs.DoctorUpdateGetDTO;

import org.electronicReferences.models.Doctor;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;


@Mapper(componentModel = "spring")
public interface DoctorMapper {

    @Mapping(target = "id", ignore = true)
    Doctor toEntity(DoctorCreateDTO doctorCreateDTO);

    void updateDoctorFromDTO(DoctorUpdateGetDTO doctorUpdateGetDTO, @MappingTarget Doctor doctor);

    DoctorUpdateGetDTO toDoctorGetDTO(Doctor doctor);

    default DoctorUpdateGetDTO toDTO(Doctor doctor) {
        return toDoctorGetDTO(doctor);
    }

}
