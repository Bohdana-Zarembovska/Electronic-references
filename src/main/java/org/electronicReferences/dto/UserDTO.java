package org.electronicReferences.dto;

import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Data
public class UserDTO {
    private Integer id;

    @NotBlank(message = "Blood type must be specified")
    private String fullName;

    @NotBlank(message = "Date of birth must be specified")
    private String phoneNumber;

    @NotBlank(message = "Sex must be specified")
    private String email;

    private Integer doctorId;

    private Integer patientId;

}
