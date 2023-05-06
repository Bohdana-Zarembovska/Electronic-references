package org.electronicReferences.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
public class DiagnosisDTO {
    private Integer id;

    @NotNull(message = "Doctor id must be specified")
    private Integer doctorId;

    @NotBlank(message = "Diagnosis code must be specified")
    private String diagnosisCode;

    @NotNull(message = "Patient id must be specified")
    private Integer patientId;

}
