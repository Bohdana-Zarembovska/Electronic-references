package org.electronicReferences.mappers;

import org.electronicReferences.dto.UserDTO;
import org.electronicReferences.models.User;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;

@Mapper(componentModel = "spring")
public interface UserMapper {

    @Mapping(target = "id", ignore = true)
    User toEntity(UserDTO userDTO);

    UserDTO toDTO(User user);

    @Mapping(target = "id", ignore = true)
    void updateUserFromDTO(UserDTO userDTO, @MappingTarget User user);

}
