package org.electronicReferences.mappers;

import org.electronicReferences.dto.ReferenceDTOs.ReferenceCreateDTO;
import org.electronicReferences.dto.ReferenceDTOs.ReferenceUpdateGetDTO;
import org.electronicReferences.models.Reference;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;


@Mapper(componentModel = "spring")
public interface ReferenceMapper {

    @Mapping(target = "id", ignore = true)
    Reference toEntity(ReferenceCreateDTO referenceCreateDTO);

    void updateReferenceFromDTO(ReferenceUpdateGetDTO referenceUpdateDTO, @MappingTarget Reference reference);

    ReferenceUpdateGetDTO toReferenceUpdateGetDTO(Reference reference);

    default ReferenceUpdateGetDTO toDTO(Reference reference) {
        return toReferenceUpdateGetDTO(reference);
    }

}

