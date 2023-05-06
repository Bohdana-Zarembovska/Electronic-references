package org.electronicReferences.mappers;

import org.electronicReferences.dto.DoctorDTO;
import org.electronicReferences.models.Doctor;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;

@Mapper(componentModel = "spring")
public interface DoctorMapper {

    @Mapping(target = "id", ignore = true)
    Doctor toEntity(DoctorDTO doctorDTO);

    DoctorDTO toDTO(Doctor doctor);

    @Mapping(target = "id", ignore = true)
    void updateDoctorFromDTO(DoctorDTO doctorDTO, @MappingTarget Doctor doctor);

}
