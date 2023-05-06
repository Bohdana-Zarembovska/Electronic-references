package org.electronicReferences.mappers;

import org.electronicReferences.dto.ReferenceDTO;
import org.electronicReferences.models.Reference;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;

@Mapper(componentModel = "spring")
public interface ReferenceMapper {

    @Mapping(target = "id", ignore = true)
    Reference toEntity(ReferenceDTO referenceDTO);

    ReferenceDTO toDTO(Reference reference);

    @Mapping(target = "id", ignore = true)
    void updateReferenceFromDTO(ReferenceDTO referenceDTO, @MappingTarget Reference reference);

}
