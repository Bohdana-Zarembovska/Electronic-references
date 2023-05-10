package org.electronicReferences.dto.ReferenceDTOs;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

import java.time.LocalDate;

@Data
public class ReferenceCreateDTO {
    private Integer id;

    @NotBlank(message = "Medicine must be specified")
    private String medicine;

    @NotNull(message = "Diagnosis id must be specified")
    private Integer diagnosisId;

    @NotNull(message = "Reference date must be specified")
    private LocalDate referenceDate;

}
