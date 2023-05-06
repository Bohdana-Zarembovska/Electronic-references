package org.electronicReferences.dto;

import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Data
public class DoctorDTO {
    private Integer id;

    @NotBlank(message = "Specification type must be specified")
    private String specification;

    @NotBlank(message = "Hospital name of birth must be specified")
    private String hospitalName;

}
