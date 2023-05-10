package org.electronicReferences.dto.UserDTOs;

import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Data
public class UserCreateDTO {
    private Integer id;

    @NotBlank(message = "Full name must be specified")
    private String fullName;

    @NotBlank(message = "Phone number must be specified")
    private String phoneNumber;

    @NotBlank(message = "Email must be specified")
    private String email;

    private Integer doctorId;

    private Integer patientId;

}
