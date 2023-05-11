package org.electronicReferences.mappers;

import org.electronicReferences.dto.UserDTOs.UserCreateDTO;
import org.electronicReferences.dto.UserDTOs.UserUpdateGetDTO;

import org.electronicReferences.models.User;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;


@Mapper(componentModel = "spring")
public interface UserMapper {

    @Mapping(target = "id", ignore = true)
    User toEntity(UserCreateDTO userCreateDTO);

    void updateUserFromDTO(UserUpdateGetDTO userUpdateGetDTO, @MappingTarget User user);

    UserUpdateGetDTO toUserGetDTO(User user);

    default UserUpdateGetDTO toDTO(User user) {
        return toUserGetDTO(user);
    }

}
