package org.electronicReferences.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;
import java.util.Date;

@Data
public class PatientDTO {
    private Integer id;

    @NotBlank(message = "Blood type must be specified")
    private String bloodType;

    @NotNull(message = "Date of birth must be specified")
    private Date birthDate;

    @NotBlank(message = "Sex must be specified")
    private String sex;

    @NotBlank(message = "Address must be specified")
    private String address;
}
