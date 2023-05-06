package org.electronicReferences.services;

import org.electronicReferences.dto.UserDTO;
import org.electronicReferences.models.User;
import org.electronicReferences.mappers.UserMapper;
import org.electronicReferences.specification.UserSpecification;
import org.electronicReferences.repositories.UserRepository;

import jakarta.persistence.EntityNotFoundException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@AllArgsConstructor
@Service
public class UserService {
    private final UserRepository userRepository;
    private final UserMapper userMapper;
    private final UserSpecification userSpecification;

    public UserDTO addUser(UserDTO userDTO) {
        User user = userMapper.toEntity(userDTO);
        User savedUser = userRepository.save(user);
        return userMapper.toDTO(savedUser);
    }

    public UserDTO updateUser(Integer id, UserDTO userDTO) {
        User user = userRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("user with this id is not found"));

        userMapper.updateUserFromDTO(userDTO, user);

        return userMapper.toDTO(userRepository.save(user));
    }

    public Page<UserDTO> searchUserByName(String name, Pageable pageable) {
        Specification<User> specification = Specification.where(UserSpecification.hasName(name));
        Page<User> page = userRepository.findAll(specification, pageable);
        return page.map(userMapper::toDTO);
    }

    public UserDTO getUserById(Integer userId) {
        User user = userRepository.findById(userId)
                .orElseThrow(() -> new EntityNotFoundException("User with id " + userId + " not found"));
        return userMapper.toDTO(user);
    }
}
