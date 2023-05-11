package org.electronicReferences.dto.UserDTOs;

import lombok.Data;

@Data
public class UserUpdateGetDTO {
    private String fullName;
    private String phoneNumber;
    private String email;
}
