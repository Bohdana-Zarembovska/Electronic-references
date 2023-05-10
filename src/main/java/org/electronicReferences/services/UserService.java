package org.electronicReferences.services;

import org.electronicReferences.models.User;
import org.electronicReferences.mappers.UserMapper;
import org.electronicReferences.repositories.UserRepository;
import org.electronicReferences.dto.UserDTOs.UserCreateDTO;
import org.electronicReferences.dto.UserDTOs.UserUpdateGetDTO;
import org.electronicReferences.specification.UserSpecification;
import jakarta.persistence.EntityNotFoundException;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;


@AllArgsConstructor
@Service
public class UserService {
    private final UserRepository userRepository;
    private final UserMapper userMapper;
    private final UserCreateDTO userCreateDTO;
    private final UserUpdateGetDTO userUpdateGetDTO;

    public UserUpdateGetDTO addUser(UserCreateDTO userCreateDTO) {
        User user = userMapper.toEntity(userCreateDTO);
        User savedUser = userRepository.save(user);
        return userMapper.toDTO(savedUser);
    }

    public UserUpdateGetDTO updateUser(Integer id, UserUpdateGetDTO userUpdateGetDTO) {
        User user = userRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("user with this id is not found"));

        userMapper.updateUserFromDTO(userUpdateGetDTO, user);
        return userMapper.toDTO(userRepository.save(user));
    }

    public UserUpdateGetDTO getUserById(Integer userId) {
        User user = userRepository.findById(userId)
                .orElseThrow(() -> new EntityNotFoundException("user with this id is not found"));
        return userMapper.toDTO(user);
    }

    public Page<UserUpdateGetDTO> searchUserByName(String name, Pageable pageable) {
        Specification<User> specification = Specification.where(UserSpecification.hasName(name));
        Page<User> page = userRepository.findAll(specification, pageable);
        return page.map(userMapper::toDTO);
    }

}

