package org.electronicReferences.dto.PatientDTOs;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;
import java.util.Date;

@Data
public class PatientUpdateGetDTO {
    private String bloodType;
    private Date birthDate;
    private String sex;
    private String address;
}
