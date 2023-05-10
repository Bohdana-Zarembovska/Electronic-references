package org.electronicReferences.controllers;


import org.electronicReferences.dto.UserDTOs.UserCreateDTO;
import org.electronicReferences.dto.UserDTOs.UserUpdateGetDTO;
import org.electronicReferences.services.UserService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RestController
@RequestMapping("/users")
public class UserController {
    private final UserService userService;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public UserUpdateGetDTO addUser(@Valid @RequestBody UserCreateDTO userCreateDTO) {
        return userService.addUser(userCreateDTO);
    }

    @PutMapping("/{id}")
    public UserUpdateGetDTO updateUser(@PathVariable Integer id, @RequestBody UserUpdateGetDTO userUpdateDTO) {
        return userService.updateUser(id, userUpdateDTO);
    }

    @GetMapping
    public Page<UserUpdateGetDTO> searchUserByName(
            @RequestParam(value = "name", required = false) String name,
            @PageableDefault Pageable pageable
    ){
        return userService.searchUserByName(name, pageable);
    }

    @GetMapping("/{id}")
    public UserUpdateGetDTO getUserById(@PathVariable Integer id) {

        return userService.getUserById(id);
    }

}
